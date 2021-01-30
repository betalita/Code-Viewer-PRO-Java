package com.pointlessapps.codeviewerpro.adapters;

import com.pointlessapps.codeviewerpro.databinding.ItemExampleLanguageBinding;
import com.pointlessapps.codeviewerpro.models.Example;

import java.util.List;

public class AdapterExampleLanguages extends AdapterBase<Example.Language, ItemExampleLanguageBinding> {

	public AdapterExampleLanguages(List<Example.Language> list) {
		super(list, ItemExampleLanguageBinding.class);
	}

	@Override
	void onBind(ItemExampleLanguageBinding root, int position) {
		root.cardLanguage.setCardBackgroundColor(list.get(position).getColor());
		root.textLanguage.setText(list.get(position).getName());
	}
}
