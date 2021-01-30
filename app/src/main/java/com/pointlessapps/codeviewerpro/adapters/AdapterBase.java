package com.pointlessapps.codeviewerpro.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public abstract class AdapterBase<T, Binding extends ViewBinding> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

	protected final List<T> list;
	private final Class<Binding> bindingClass;
	private Binding binding;
	private OnClickListener onClickListener;

	AdapterBase(List<T> list, Class<Binding> bindingClass) {
		this.list = list;
		this.bindingClass = bindingClass;

		setHasStableIds(true);
	}

	abstract void onBind(Binding root, int position);

	@NonNull
	@Override
	@SuppressWarnings("unchecked")
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		try {
			binding = (Binding) bindingClass.getMethod(
					"inflate",
					LayoutInflater.class,
					ViewGroup.class,
					boolean.class
			).invoke(null, LayoutInflater.from(parent.getContext()), parent, false);

			if (binding == null) {
				return null;
			}

			return new RecyclerView.ViewHolder(binding.getRoot()) {
			};

		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			return null;
		}
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
		onBind(binding, position);
		binding.getRoot().setOnClickListener(v -> onClickListener.invoke(position));
	}

	@Override
	public long getItemId(int position) {
		return list.get(position).hashCode();
	}

	@Override
	public int getItemCount() {
		return list.size();
	}

	public void setOnClickListener(OnClickListener onClickListener) {
		this.onClickListener = onClickListener;
	}

	public interface OnClickListener {
		void invoke(int position);
	}
}
