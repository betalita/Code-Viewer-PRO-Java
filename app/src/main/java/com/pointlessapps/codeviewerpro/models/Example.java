package com.pointlessapps.codeviewerpro.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.ColorInt;

import java.util.ArrayList;
import java.util.List;

public class Example implements Parcelable {

	public static final Creator<Example> CREATOR = new Creator<Example>() {
		@Override
		public Example createFromParcel(Parcel in) {
			return new Example(in);
		}

		@Override
		public Example[] newArray(int size) {
			return new Example[size];
		}
	};
	private String title;
	private List<Language> languages;
	private List<CodeSnippet> codeSnippets;
	public Example(String title, List<Language> languages, List<CodeSnippet> codeSnippets) {
		this.title = title;
		this.languages = languages;
		this.codeSnippets = codeSnippets;
	}

	protected Example(Parcel in) {
		title = in.readString();
		languages = new ArrayList<>();
		in.readTypedList(languages, Language.CREATOR);
		codeSnippets = new ArrayList<>();
		in.readTypedList(codeSnippets, CodeSnippet.CREATOR);
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(title);
		dest.writeTypedList(languages);
		dest.writeTypedList(codeSnippets);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public List<CodeSnippet> getCodeSnippets() {
		return codeSnippets;
	}

	public void setCodeSnippets(List<CodeSnippet> codeSnippets) {
		this.codeSnippets = codeSnippets;
	}

	public static class Language implements Parcelable {
		public static final Creator<Language> CREATOR = new Creator<Language>() {
			@Override
			public Language createFromParcel(Parcel in) {
				return new Language(in);
			}

			@Override
			public Language[] newArray(int size) {
				return new Language[size];
			}
		};
		private String name;
		@ColorInt
		private int color;
		public Language(String name, int color) {
			this.name = name;
			this.color = color;
		}

		protected Language(Parcel in) {
			name = in.readString();
			color = in.readInt();
		}

		@Override
		public void writeToParcel(Parcel dest, int flags) {
			dest.writeString(name);
			dest.writeInt(color);
		}

		@Override
		public int describeContents() {
			return 0;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getColor() {
			return color;
		}

		public void setColor(int color) {
			this.color = color;
		}
	}

	public static class CodeSnippet implements Parcelable {
		public static final Creator<CodeSnippet> CREATOR = new Creator<CodeSnippet>() {
			@Override
			public CodeSnippet createFromParcel(Parcel in) {
				return new CodeSnippet(in);
			}

			@Override
			public CodeSnippet[] newArray(int size) {
				return new CodeSnippet[size];
			}
		};
		private String filename;
		private String source;
		private String extension;
		public CodeSnippet(String filename, String source, String extension) {
			this.filename = filename;
			this.source = source;
			this.extension = extension;
		}

		protected CodeSnippet(Parcel in) {
			filename = in.readString();
			source = in.readString();
			extension = in.readString();
		}

		@Override
		public void writeToParcel(Parcel dest, int flags) {
			dest.writeString(filename);
			dest.writeString(source);
			dest.writeString(extension);
		}

		@Override
		public int describeContents() {
			return 0;
		}

		public String getFilename() {
			return filename;
		}

		public void setFilename(String filename) {
			this.filename = filename;
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public String getExtension() {
			return extension;
		}

		public void setExtension(String extension) {
			this.extension = extension;
		}
	}
}
