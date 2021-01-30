package com.pointlessapps.codeviewerpro.viewModels;

import android.app.Activity;

import androidx.lifecycle.AndroidViewModel;

import com.pointlessapps.codeviewerpro.databinding.ActivityViewerBinding;

public class ViewModelViewer extends AndroidViewModel {

	private final ActivityViewerBinding binding;

	public ViewModelViewer(Activity activity, ActivityViewerBinding binding) {
		super(activity.getApplication());
		this.binding = binding;
	}

	public void setFilename(String filename) {
		binding.textFilename.setText(filename);
	}

	public void setSourceCode(String source, String extension) {
		binding.textSourceCode.setSource(source, extension);
	}
}
