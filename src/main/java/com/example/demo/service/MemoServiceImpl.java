package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entitiy.Memo;
import com.example.demo.repsitory.MemoDao;

@Service
public class MemoServiceImpl implements MemoService {

	private final MemoDao memoDao;

	public MemoServiceImpl (MemoDao memoDao) {
		this.memoDao = memoDao;
	}

	@Override
	public List<Memo> findAll() {

		return memoDao.findAll();
	}

}
