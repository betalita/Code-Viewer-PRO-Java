package com.pointlessapps.codeviewerpro.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.pointlessapps.codeviewerpro.databinding.ActivityMainBinding;
import com.pointlessapps.codeviewerpro.utils.Utils;
import com.pointlessapps.codeviewerpro.viewModels.ViewModelMain;

public class ActivityMain extends AppCompatActivity {

	private ViewModelMain viewModel;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());

		viewModel = new ViewModelProvider(this, Utils.getViewModelFactory(this, binding))
				.get(ViewModelMain.class);

		viewModel.prepareClickListeners();
		viewModel.setOnFileChosenListener((content, filename, extension) -> startActivity(
				new Intent(this, ActivityViewer.class)
						.putExtra(ActivityViewer.KEY_SOURCE_CODE, content)
						.putExtra(ActivityViewer.KEY_FILENAME, filename)
						.putExtra(ActivityViewer.KEY_EXTENSION, extension)
		));
		viewModel.setOnShowExamplesListener(() -> startActivity(new Intent(this, ActivityExamples.class)));
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		if (!viewModel.onActivityResult(requestCode, resultCode, data)) {
			super.onActivityResult(requestCode, resultCode, data);
		}
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		if (!viewModel.onRequestPermissionResult(requestCode, permissions, grantResults)) {
			super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		}
	}
}
