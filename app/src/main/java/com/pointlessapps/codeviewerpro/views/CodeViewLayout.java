package com.pointlessapps.codeviewerpro.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

import com.pointlessapps.codeviewerpro.databinding.ViewCodeLayoutBinding;

import java.util.concurrent.Executors;

import io.github.kbiakov.codeview.highlight.CodeHighlighter;
import io.github.kbiakov.codeview.highlight.CodeHighlighterKt;
import io.github.kbiakov.codeview.highlight.ColorTheme;

public class CodeViewLayout extends NestedScrollView {

	private final ViewCodeLayoutBinding binding;
	private final ScaleGestureDetector scaleGestureDetector;

	public CodeViewLayout(@NonNull Context context) {
		this(context, null);
	}

	public CodeViewLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public CodeViewLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		binding = ViewCodeLayoutBinding.inflate(LayoutInflater.from(context), this, true);
		scaleGestureDetector = new ScaleGestureDetector(context, new ScaleGestureDetector.OnScaleGestureListener() {
			@Override public boolean onScaleBegin(ScaleGestureDetector detector) { return true; }
			@Override public void onScaleEnd(ScaleGestureDetector detector) {}
			@Override public boolean onScale(ScaleGestureDetector detector) {
				binding.codeView.setTextSize(binding.codeView.getTextSize() * detector.getScaleFactor());
				return true;
			}
		});
	}

	@Override
	@SuppressLint("ClickableViewAccessibility")
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getPointerCount() > 1) {
			return scaleGestureDetector.onTouchEvent(event);
		}

		return super.onTouchEvent(event);
	}

	public void setSource(String source, String language) {
		binding.progressView.setVisibility(View.VISIBLE);
		binding.codeView.setVisibility(View.GONE);
		Executors.newSingleThreadExecutor().execute(() -> {
			String highlightText = CodeHighlighter.INSTANCE.highlight(
					language,
					source,
					ColorTheme.MONOKAI.theme()
			)
					.replaceAll("\n", "<br/>")
					.replaceAll("[ ]{2}", "&nbsp; ");

			(new Handler(Looper.getMainLooper())).post(() -> {
				binding.progressView.setVisibility(View.GONE);
				binding.codeView.setVisibility(View.VISIBLE);
				if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
					binding.codeView.setText(Html.fromHtml(
							highlightText,
							Html.FROM_HTML_MODE_COMPACT
					));
				} else {
					binding.codeView.setText(Html.fromHtml(highlightText));
				}
			});
		});
	}
}
