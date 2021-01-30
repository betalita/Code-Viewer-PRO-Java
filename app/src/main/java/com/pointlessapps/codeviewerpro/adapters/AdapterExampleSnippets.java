package com.pointlessapps.codeviewerpro.adapters;

import com.pointlessapps.codeviewerpro.databinding.ItemExampleSnippetBinding;
import com.pointlessapps.codeviewerpro.models.Example;

import java.util.List;

public class AdapterExampleSnippets extends AdapterBase<Example.CodeSnippet, ItemExampleSnippetBinding> {

	public AdapterExampleSnippets(List<Example.CodeSnippet> list) {
		super(list, ItemExampleSnippetBinding.class);
	}

	@Override
	void onBind(ItemExampleSnippetBinding root, int position) {
		root.textTitle.setText(list.get(position).getFilename());
		root.textSourceCode.setSource(list.get(position).getSource(), list.get(position).getExtension());
	}
}
