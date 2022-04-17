package com.example.demo.repsitory;

import java.util.List;

import com.example.demo.entitiy.JsonNoteToSelf;
import com.example.demo.entitiy.Memo;
import com.example.demo.entitiy.NoteToSelf;

public interface MemoDao {

	// コンテンツを全件取得
	List<Memo> findAllDao();

	// ジャンルIDごとのコンテンツを取得
	List<Memo> genreByIdDao(Memo memo);

	// コンテンツを登録
	void memoInsertDao(Memo memo);

	// コンテンツを一件取得
	List<Memo> memoByIdDao(Memo memo);

	// コンテンツを更新
	int memoUpdate(Memo memo);

	// ジャンルテーブルとメモテーブルから一致するデータを取得
	List<NoteToSelf> showMemo(Memo memo);

	// 検索結果を取得
	List<JsonNoteToSelf> memoSearch(Memo memo);
}
