package com.pointlessapps.codeviewerpro.viewModels;

import android.annotation.SuppressLint;
import android.app.Activity;

import androidx.lifecycle.AndroidViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pointlessapps.codeviewerpro.adapters.AdapterExampleSnippets;
import com.pointlessapps.codeviewerpro.databinding.ActivityExampleBinding;
import com.pointlessapps.codeviewerpro.models.Example;

public class ViewModelExample extends AndroidViewModel {

	@SuppressLint("StaticFieldLeak")
	private final Activity activity;
	private final ActivityExampleBinding binding;
	private final Example example;

	public ViewModelExample(Activity activity, ActivityExampleBinding binding, Example example) {
		super(activity.getApplication());
		this.activity = activity;
		this.binding = binding;
		this.example = example;
	}

	public void prepareSnippetsList() {
		binding.listSnippets.setLayoutManager(new LinearLayoutManager(activity, RecyclerView.VERTICAL, false));
		binding.listSnippets.setAdapter(new AdapterExampleSnippets(example.getCodeSnippets()));
		binding.listSnippets.setItemViewCacheSize(example.getCodeSnippets().size());
	}
}
