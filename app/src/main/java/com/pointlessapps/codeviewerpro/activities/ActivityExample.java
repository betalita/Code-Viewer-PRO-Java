package com.pointlessapps.codeviewerpro.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.pointlessapps.codeviewerpro.databinding.ActivityExampleBinding;
import com.pointlessapps.codeviewerpro.models.Example;
import com.pointlessapps.codeviewerpro.utils.Utils;
import com.pointlessapps.codeviewerpro.viewModels.ViewModelExample;

public class ActivityExample extends AppCompatActivity {

	public static final String KEY_EXAMPLE = "example";

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityExampleBinding binding = ActivityExampleBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());

		Example example = getIntent().getParcelableExtra(KEY_EXAMPLE);
		if (example == null) {
			return;
		}

		ViewModelExample viewModel = new ViewModelProvider(this, Utils.getViewModelFactory(this, binding, example))
				.get(ViewModelExample.class);

		viewModel.prepareSnippetsList();
		viewModel.setOnShowSnippetListener(codeSnippet -> startActivity(
				new Intent(this, ActivityViewer.class)
						.putExtra(ActivityViewer.KEY_SOURCE_CODE, codeSnippet.getSource())
						.putExtra(ActivityViewer.KEY_FILENAME, codeSnippet.getFilename())
						.putExtra(ActivityViewer.KEY_EXTENSION, codeSnippet.getExtension())
		));
	}
}
