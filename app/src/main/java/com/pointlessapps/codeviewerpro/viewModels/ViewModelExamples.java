package com.pointlessapps.codeviewerpro.viewModels;

import android.annotation.SuppressLint;
import android.app.Activity;

import androidx.lifecycle.AndroidViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pointlessapps.codeviewerpro.adapters.AdapterExample;
import com.pointlessapps.codeviewerpro.databinding.ActivityExamplesBinding;
import com.pointlessapps.codeviewerpro.models.Example;
import com.pointlessapps.codeviewerpro.utils.ExamplesData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressLint("StaticFieldLeak")
public class ViewModelExamples extends AndroidViewModel {

	private final Activity activity;
	private final ActivityExamplesBinding binding;
	private List<Example> data;
	private OnShowExampleListener onShowExampleListener;

	public ViewModelExamples(Activity activity, ActivityExamplesBinding binding) {
		super(activity.getApplication());
		this.activity = activity;
		this.binding = binding;

		try {
			data = ExamplesData.get(activity);
		} catch (IOException exception) {
			data = new ArrayList<>();
		}
	}

	public void prepareExamplesList() {
		binding.listExamples.setLayoutManager(new LinearLayoutManager(activity, RecyclerView.VERTICAL, false));
		AdapterExample adapter = new AdapterExample(data);
		adapter.setOnClickListener(i -> onShowExampleListener.invoke(data.get(i)));
		binding.listExamples.setAdapter(adapter);
	}

	public void setOnShowExampleListener(OnShowExampleListener onShowExampleListener) {
		this.onShowExampleListener = onShowExampleListener;
	}

	public interface OnShowExampleListener {
		void invoke(Example example);
	}
}
