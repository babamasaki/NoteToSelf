package com.example.demo.service;

import java.util.List;

import com.example.demo.entitiy.Memo;

public interface MemoService {

	//メモ情報を全件取得
	List<Memo> findAll();

	//ジャンルに紐付いたデータのみを取得
	List<Memo> genreById(Memo memo);

	//メモ情報を追加
	void memoInsert(Memo memo);

}
