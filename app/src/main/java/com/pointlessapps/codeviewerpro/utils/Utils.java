package com.pointlessapps.codeviewerpro.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.OpenableColumns;
import android.util.TypedValue;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Utils {

	@SuppressWarnings("unchecked")
	public static ViewModelProvider.Factory getViewModelFactory(AppCompatActivity activity, Object... args) {
		return new ViewModelProvider.Factory() {
			@NonNull
			@Override
			public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
				try {
					List<Object> initArgs = new ArrayList<>();
					initArgs.add(activity);
					initArgs.addAll(Arrays.asList(args));
					return (T) modelClass.getConstructors()[0].newInstance(initArgs.toArray());
				} catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
					e.printStackTrace();
				}

				return null;
			}
		};
	}

	public static String getPath(Context context, Uri uri) {
		String scheme = uri.getScheme().toLowerCase(Locale.getDefault());
		switch (scheme) {
			case "content":
				Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
				if (query != null) {
					int index = query.getColumnIndex("_data");
					if (index != -1 && query.moveToFirst()) {
						return query.getString(index);
					}

					query.close();
				}
				break;
			case "file":
				return uri.getPath();
		}

		return null;
	}

	public static String getExtension(String path) {
		int startIndex = path.lastIndexOf(".");
		if (startIndex == -1) {
			return path;
		}

		return path.substring(startIndex + 1);
	}

	public static String getFilename(Context context, Uri uri) {
		Cursor query = context.getContentResolver().query(uri, new String[]{OpenableColumns.DISPLAY_NAME}, null, null, null);
		int index = query.getColumnIndex(OpenableColumns.DISPLAY_NAME);
		if (index != -1 && query.moveToFirst()) {
			return query.getString(index);
		}
		query.close();

		return null;
	}

	public static String getFileContentFromPath(String path) {
		File file = new File(path);
		StringBuilder builder = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
				builder.append('\n');
			}
			reader.close();
		} catch (IOException ignored) {
		}

		return builder.toString();
	}

	@ColorInt
	public static int getLanguageColor(Context context, String language) {
		int id = context.getResources().getIdentifier("color_" + language, "color", context.getPackageName());
		if (id != 0) {
			return ContextCompat.getColor(context, id);
		}

		return 0;
	}

	public static float spToPx(Context context, float number) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, number, context.getResources().getDisplayMetrics());
	}

	public static float dpToPx(Context context, float number) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, number, context.getResources().getDisplayMetrics());
	}
}
