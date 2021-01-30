package com.pointlessapps.codeviewerpro.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.pointlessapps.codeviewerpro.utils.Utils;

public class CodeView extends AppCompatTextView {

	private final float lineNumberPadding = 15f;
	private final float minVisibleNumbers = 2;
	private final float minTextSize = Utils.spToPx(getContext(), 14f);
	private final float maxTextSize = Utils.spToPx(getContext(), 32f);
	private final TextPaint lineNumberPaint;

	public CodeView(@NonNull Context context) {
		this(context, null);
	}

	public CodeView(@NonNull Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public CodeView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		lineNumberPaint = new TextPaint();
		lineNumberPaint.set(getPaint());
		lineNumberPaint.setColor(Color.GRAY);

		calculatePadding();
		setTextIsSelectable(true);
	}

	private void calculatePadding() {
		Rect rect = new Rect();
		lineNumberPaint.getTextBounds("0", 0, 1, rect);
		float numberWidth = rect.width();
		setPadding(
				(int) (lineNumberPadding * 2 + minVisibleNumbers * numberWidth),
				getPaddingTop(),
				getPaddingRight(),
				getPaddingBottom()
		);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		for (int i = 0; i < getLineCount(); i++) {
			canvas.drawText(
					String.valueOf(i + 1),
					lineNumberPadding,
					getLineHeight() * (i + 1) + getPaddingTop(),
					lineNumberPaint
			);
		}
		super.onDraw(canvas);
	}

	@Override
	public boolean canScrollVertically(int direction) {
		return false;
	}

	@Override
	public boolean isTextSelectable() {
		return true;
	}

	@Override
	public void setTextSize(float size) {
		float textSize = Math.max(Math.min(maxTextSize, size), minTextSize);
		setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
		lineNumberPaint.setTextSize(textSize);
		calculatePadding();
	}
}
