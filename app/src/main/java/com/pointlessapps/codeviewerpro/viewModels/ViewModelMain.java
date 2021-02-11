package com.pointlessapps.codeviewerpro.viewModels;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.lifecycle.AndroidViewModel;

import com.pointlessapps.codeviewerpro.databinding.ActivityMainBinding;
import com.pointlessapps.codeviewerpro.utils.Utils;

public class ViewModelMain extends AndroidViewModel {

	public static final int PICK_FILE_REQUEST_CODE = 1;
	public static final int PERMISSION_REQUEST_CODE = 2;

	@SuppressLint("StaticFieldLeak")
	private final Activity activity;
	private final ActivityMainBinding binding;
	private OnFileChosenListener onFileChosenListener;
	private OnShowExamplesListener onShowExamplesListener;

	public ViewModelMain(Activity activity, ActivityMainBinding binding) {
		super(activity.getApplication());
		this.activity = activity;
		this.binding = binding;
	}

	public void prepareClickListeners() {
		binding.buttonOpenFile.setOnClickListener(v -> clickedOpenFile());
		binding.buttonShowExamples.setOnClickListener(v -> clickedShowExamples());
	}

	public void setOnFileChosenListener(OnFileChosenListener onFileChosenListener) {
		this.onFileChosenListener = onFileChosenListener;
	}

	public void setOnShowExamplesListener(OnShowExamplesListener onShowExamplesListener) {
		this.onShowExamplesListener = onShowExamplesListener;
	}

	public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == PICK_FILE_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
			if (data.getData() == null) {
				return false;
			}

			String path = Utils.getPath(activity, data.getData());
			String filename = Utils.getFilename(activity, data.getData());
			if (path == null || filename == null) {
				return false;
			}

			onFileChosenListener.invoke(
					Utils.getFileContentFromPath(path),
					filename,
					Utils.getExtension(path)
			);

			return true;
		}

		return false;
	}

	public boolean onRequestPermissionResult(int requestCode, String[] permissions, int[] grantResults) {
		if (requestCode == PERMISSION_REQUEST_CODE && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
			performOpenFile();

			return true;
		}

		return false;
	}

	private void clickedOpenFile() {
		if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
			ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);

			return;
		}

		performOpenFile();
	}

	private void performOpenFile() {
		Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
		intent.addCategory(Intent.CATEGORY_OPENABLE);
		intent.setType("*/*");
		activity.startActivityForResult(
				Intent.createChooser(intent, "Choose a file"),
				PICK_FILE_REQUEST_CODE
		);
	}

	private void clickedShowExamples() {
		onShowExamplesListener.invoke();
	}

	public interface OnFileChosenListener {
		void invoke(String content, String filename, String extension);
	}

	public interface OnShowExamplesListener {
		void invoke();
	}
}
