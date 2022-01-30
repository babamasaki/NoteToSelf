package com.example.demo.repsitory;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entitiy.Memo;

@Repository
public class MemoDaoImpl implements MemoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Memo> findAll() {
		String sql = "SELECT * FROM memos";
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
        //return用のgenrelist
        List<Memo> list = new ArrayList<Memo>();
        //取得した件数分データをentityに格納する
        for(Map<String, Object> result: resultList) {
        	Memo memo = new Memo();
        	memo.setId((int)result.get("id"));
        	memo.setId((int)result.get("genre_id"));
        	memo.setTitle((String)result.get("title"));
        	memo.setContents((String)result.get("contents"));
        	memo.setCreated_at((Timestamp) result.get("created_at"));
        	memo.setUpdated_at((Timestamp) result.get("updated_at"));
        	//格納したデータをreturn用のgenrelistに格納
        	list.add(memo);
        }
		return list;
	}

}
