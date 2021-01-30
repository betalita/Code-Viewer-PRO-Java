package com.pointlessapps.codeviewerpro.adapters;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pointlessapps.codeviewerpro.databinding.ItemExampleBinding;
import com.pointlessapps.codeviewerpro.models.Example;

import java.util.List;

public class AdapterExample extends AdapterBase<Example, ItemExampleBinding> {

	public AdapterExample(List<Example> list) {
		super(list, ItemExampleBinding.class);
	}

	@Override
	void onBind(ItemExampleBinding root, int position) {
		root.textExample.setText(list.get(position).getTitle());
		root.listLanguages.setLayoutManager(new LinearLayoutManager(root.getRoot().getContext(), RecyclerView.HORIZONTAL, false));
		root.listLanguages.setAdapter(new AdapterExampleLanguages(list.get(position).getLanguages()));
	}
}
