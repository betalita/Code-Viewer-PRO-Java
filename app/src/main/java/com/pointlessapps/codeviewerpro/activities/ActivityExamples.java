package com.pointlessapps.codeviewerpro.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.pointlessapps.codeviewerpro.databinding.ActivityExamplesBinding;
import com.pointlessapps.codeviewerpro.utils.Utils;
import com.pointlessapps.codeviewerpro.viewModels.ViewModelExamples;

public class ActivityExamples extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityExamplesBinding binding = ActivityExamplesBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());

		ViewModelExamples viewModel = new ViewModelProvider(this, Utils.getViewModelFactory(this, binding))
				.get(ViewModelExamples.class);

		viewModel.prepareExamplesList();
		viewModel.setOnShowExampleListener(e -> startActivity(
				(new Intent(this, ActivityExample.class))
						.putExtra(ActivityExample.KEY_EXAMPLE, e)
		));
	}
}
