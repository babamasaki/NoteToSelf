package com.example.demo.entitiy;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class JsonNoteToSelf {

//	genre
	@JsonIgnore
	private int genreId;
	@JsonIgnore
	private String genre;
	@JsonIgnore
	private Timestamp  genreCreated_at;
	@JsonIgnore
	private Timestamp  genreUpdated_at;

//	memo
	private int memoId;
	@JsonIgnore
	private int genre_id;
	private String title;
	private String contents;
	@JsonIgnore
	private Timestamp  memoCreated_at;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
	private Timestamp  memoUpdated_at;

	public int getGenreId() {
		return genreId;
	}
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Timestamp getGenreCreated_at() {
		return genreCreated_at;
	}
	public void setGenreCreated_at(Timestamp genreCreated_at) {
		this.genreCreated_at = genreCreated_at;
	}
	public Timestamp getGenreUpdated_at() {
		return genreUpdated_at;
	}
	public void setGenreUpdated_at(Timestamp genreUpdated_at) {
		this.genreUpdated_at = genreUpdated_at;
	}
	public int getMemoId() {
		return memoId;
	}
	public void setMemoId(int memoId) {
		this.memoId = memoId;
	}
	public int getGenre_id() {
		return genre_id;
	}
	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Timestamp getMemoCreated_at() {
		return memoCreated_at;
	}
	public void setMemoCreated_at(Timestamp memoCreated_at) {
		this.memoCreated_at = memoCreated_at;
	}
	public Timestamp getMemoUpdated_at() {
		return memoUpdated_at;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public void setMemoUpdated_at(Timestamp memoUpdated_at) {
		this.memoUpdated_at = memoUpdated_at;
	}


}
