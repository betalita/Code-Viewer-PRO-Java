package com.pointlessapps.codeviewerpro.viewModels;

import android.app.Activity;

import androidx.lifecycle.AndroidViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pointlessapps.codeviewerpro.adapters.AdapterExampleSnippets;
import com.pointlessapps.codeviewerpro.databinding.ActivityExampleBinding;
import com.pointlessapps.codeviewerpro.models.Example;

public class ViewModelExample extends AndroidViewModel {

	private final ActivityExampleBinding binding;
	private final Example example;
	private OnShowSnippetListener onShowSnippetListener;

	public ViewModelExample(Activity activity, ActivityExampleBinding binding, Example example) {
		super(activity.getApplication());
		this.binding = binding;
		this.example = example;
	}

	public void prepareSnippetsList() {
		binding.listSnippets.setLayoutManager(new LinearLayoutManager(getApplication().getApplicationContext(), RecyclerView.VERTICAL, false));
		AdapterExampleSnippets adapter = new AdapterExampleSnippets(example.getCodeSnippets());
		adapter.setOnClickListener(i -> onShowSnippetListener.invoke(example.getCodeSnippets().get(i)));
		binding.listSnippets.setAdapter(adapter);
		binding.listSnippets.setItemViewCacheSize(example.getCodeSnippets().size());
	}

	public void setOnShowSnippetListener(OnShowSnippetListener onShowSnippetListener) {
		this.onShowSnippetListener = onShowSnippetListener;
	}

	public interface OnShowSnippetListener {
		void invoke(Example.CodeSnippet codeSnippet);
	}
}
