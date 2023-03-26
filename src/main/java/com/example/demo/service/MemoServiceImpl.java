package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entitiy.JsonNoteToSelf;
import com.example.demo.entitiy.Memo;
import com.example.demo.entitiy.NoteToSelf;
import com.example.demo.repsitory.MemoDao;

@Service
public class MemoServiceImpl implements MemoService {

	private final MemoDao memoDao;

	public MemoServiceImpl (MemoDao memoDao) {
		this.memoDao = memoDao;
	}

	@Override
	public List<Memo> findAll() {

		return memoDao.findAllDao();
	}

	@Override
	public List<Memo> genreById(Memo memo) {

		return memoDao.genreByIdDao(memo);
	}

	@Override
	public void memoInsert(Memo memo) {

		memoDao.memoInsertDao(memo);

	}

	@Override
	public List<Memo> memoById(Memo memo) {
		return memoDao.memoByIdDao(memo);
	}

	@Override
	public void memoUpdate(Memo memo) {
		memoDao.memoUpdate(memo);

	}

	@Override
	public List<NoteToSelf> showMemo(Memo memo) {
		return 	memoDao.showMemo(memo);
	}

	@Override
	public List<JsonNoteToSelf> memoSearch(Memo memo) {
		return 	memoDao.memoSearch(memo);
	}

}
