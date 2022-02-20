package com.example.demo.repsitory;

import java.util.List;

import com.example.demo.entitiy.Memo;

public interface MemoDao {

	List<Memo> findAllDao();

	List<Memo> genreByIdDao(Memo memo);

	void memoInsertDao(Memo memo);

}
