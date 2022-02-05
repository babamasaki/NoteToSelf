package com.example.demo.app;

import javax.validation.constraints.Size;

public class GenreForm {

	@Size(min=1,max=20, message="1 から 20 の間のジャンル名を入力してください")
	private String genre;

	public GenreForm() {
		super();
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
