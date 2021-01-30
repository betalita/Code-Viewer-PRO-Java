package com.pointlessapps.codeviewerpro.activities;

import android.os.Bundle;

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

		ViewModelViewer viewModel = new ViewModelProvider(this, Utils.getViewModelFactory(this, binding))
				.get(ViewModelViewer.class);

		viewModel.setFilename(getIntent().getStringExtra(KEY_FILENAME));
		viewModel.setSourceCode(
				getIntent().getStringExtra(KEY_SOURCE_CODE),
				getIntent().getStringExtra(KEY_EXTENSION)
		);
	}
}
