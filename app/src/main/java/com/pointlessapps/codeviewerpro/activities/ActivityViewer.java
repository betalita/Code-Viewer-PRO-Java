package com.pointlessapps.codeviewerpro.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.pointlessapps.codeviewerpro.databinding.ActivityViewerBinding;
import com.pointlessapps.codeviewerpro.utils.Utils;
import com.pointlessapps.codeviewerpro.viewModels.ViewModelViewer;

public class ActivityViewer extends AppCompatActivity {

	public static final String KEY_FILENAME = "filename";
	public static final String KEY_SOURCE_CODE = "sourceCode";
	public static final String KEY_EXTENSION = "extension";

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityViewerBinding binding = ActivityViewerBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());

		String filename = getIntent().getStringExtra(KEY_FILENAME);
		String source = getIntent().getStringExtra(KEY_SOURCE_CODE);
		String extension = getIntent().getStringExtra(KEY_EXTENSION);

		if (Intent.ACTION_VIEW.equals(getIntent().getAction())) {
			Uri data = getIntent().getData();
			assert data != null;
			String path = Utils.getPath(this, data);
			Log.d("LOG!", "path: " + path);
			if (path != null) {
				filename = Utils.getFilename(this, data);
				source = Utils.getFileContentFromPath(path);
				extension = Utils.getExtension(path);
				Log.d("LOG!", "filename: " + filename + " source: " + source + " extension: " + extension);
			}
		}

		ViewModelViewer viewModel = new ViewModelProvider(this, Utils.getViewModelFactory(this, binding))
				.get(ViewModelViewer.class);

		viewModel.setFilename(filename);
		viewModel.setSourceCode(source, extension);
	}
}
