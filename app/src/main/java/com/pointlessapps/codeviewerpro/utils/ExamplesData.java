package com.pointlessapps.codeviewerpro.utils;

import android.content.Context;

import com.pointlessapps.codeviewerpro.models.Example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExamplesData {

	private static final String BASE_PATH = "codeSnippets";

	public static List<Example> get(Context context) throws IOException {
		String[] folders = context.getAssets().list(BASE_PATH);
		List<Example> examples = new ArrayList<>();
		for (String folderName : folders) {
			String[] files = context.getAssets().list(BASE_PATH + "/" + folderName);
			List<Example.CodeSnippet> codeSnippets = new ArrayList<>();
			Set<String> languages = new HashSet<>();
			for (String file : files) {
				InputStream inputStream = context.getAssets().open(BASE_PATH + "/" + folderName + "/" + file);
				String extension = Utils.getExtension(file);
				languages.add(extension);

				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				StringBuilder total = new StringBuilder();
				for (String line; (line = bufferedReader.readLine()) != null; ) {
					total.append(line).append('\n');
				}

				codeSnippets.add(
						new Example.CodeSnippet(
								file,
								total.toString(),
								extension
						)
				);
				inputStream.close();
			}
			List<Example.Language> languagesList = new ArrayList<>();
			for (String language : languages) {
				languagesList.add(new Example.Language(language, Utils.getLanguageColor(context, language)));
			}
			examples.add(
					new Example(
							folderName,
							languagesList,
							codeSnippets
					)
			);
		}

		return examples;
	}
}
