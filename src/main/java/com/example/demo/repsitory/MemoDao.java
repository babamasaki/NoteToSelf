package com.example.demo.repsitory;

import java.util.List;

import com.example.demo.entitiy.Memo;

public interface MemoDao {

	// コンテンツを全件取得
	List<Memo> findAllDao();

	// ジャンルIDごとのコンテンツを取得
	List<Memo> genreByIdDao(Memo memo);

	// コンテンツを登録
	void memoInsertDao(Memo memo);

	// コンテンツを一件取得
	List<Memo> memoByIdDao(Memo memo);

}
