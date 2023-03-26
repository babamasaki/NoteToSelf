package com.example.demo.service;

import java.util.List;

import com.example.demo.entitiy.JsonNoteToSelf;
import com.example.demo.entitiy.Memo;
import com.example.demo.entitiy.NoteToSelf;

public interface MemoService {

	//メモ情報を全件取得
	List<Memo> findAll();

	//ジャンルに紐付いたデータのみを取得
	List<Memo> genreById(Memo memo);

	//メモ情報を追加
	void memoInsert(Memo memo);

	//ジャンルに紐付いたデータのみを取得
	List<Memo> memoById(Memo memo);

	//メモ情報を更新
	void memoUpdate(Memo memo);

	// ジャンルテーブルとメモテーブルから一致するデータを取得
	List<NoteToSelf> showMemo(Memo memo);

	// 検索結果を取得
	List<JsonNoteToSelf> memoSearch(Memo memo);

}
