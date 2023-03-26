package com.example.demo.repsitory;

import java.util.List;

import com.example.demo.entitiy.Genre;

public interface GenreDao {

	//全件取得処理
	List<Genre> findAll();

	//追加処理
	void genreInsert(Genre genre);

	//重複チェック
	boolean genreCheck(Genre genre);

	//更新処理
	void genreUpdate(Genre genre);
}
