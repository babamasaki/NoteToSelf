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
	public List<Memo> findAllDao() {
		String sql = "SELECT * FROM memos";
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
        //return用のgenrelist
        List<Memo> list = new ArrayList<Memo>();
        //取得した件数分データをentityに格納する
        for(Map<String, Object> result: resultList) {
        	Memo memo = new Memo();
        	memo.setId((int)result.get("id"));
        	memo.setGenre_id((int)result.get("genre_id"));
        	memo.setTitle((String)result.get("title"));
        	memo.setContents((String)result.get("contents"));
        	memo.setCreated_at((Timestamp) result.get("created_at"));
        	memo.setUpdated_at((Timestamp) result.get("updated_at"));
        	//格納したデータをreturn用のgenrelistに格納
        	list.add(memo);
        }
		return list;
	}

	@Override
	public List<Memo> genreByIdDao(Memo memo) {
		String sql = "SELECT * FROM memos"
				+" WHERE genre_id = " + memo.getGenre_id();
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
        //return用のgenrelist
        List<Memo> list = new ArrayList<Memo>();
        //取得した件数分データをentityに格納する
        for(Map<String, Object> result: resultList) {
        	Memo returnMemo = new Memo();
        	returnMemo.setId((int)result.get("id"));
        	returnMemo.setGenre_id((int)result.get("genre_id"));
        	returnMemo.setTitle((String)result.get("title"));
        	returnMemo.setContents((String)result.get("contents"));
        	returnMemo.setCreated_at((Timestamp) result.get("created_at"));
        	returnMemo.setUpdated_at((Timestamp) result.get("updated_at"));
        	//格納したデータをreturn用のgenrelistに格納
        	list.add(returnMemo);
        }
		return list;
	}

	@Override
	public void memoInsertDao(Memo memo) {

		jdbcTemplate.update("INSERT INTO memos(genre_id, title, contents, created_at, updated_at) VALUES ( ?, ?, ?, ?, ?)",
		memo.getGenre_id(),memo.getTitle(), memo.getContents(),memo.getCreated_at(),memo.getUpdated_at());

	}

	@Override
	public List<Memo> memoByIdDao(Memo memo) {

		String sql = "SELECT * FROM memos"
				+" WHERE id = " + memo.getId();
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
        //return用のgenrelist
        List<Memo> list = new ArrayList<Memo>();
        //取得した件数分データをentityに格納する
        for(Map<String, Object> result: resultList) {
        	Memo returnMemo = new Memo();
        	returnMemo.setId((int)result.get("id"));
        	returnMemo.setGenre_id((int)result.get("genre_id"));
        	returnMemo.setTitle((String)result.get("title"));
        	returnMemo.setContents((String)result.get("contents"));
        	returnMemo.setCreated_at((Timestamp) result.get("created_at"));
        	returnMemo.setUpdated_at((Timestamp) result.get("updated_at"));
        	//格納したデータをreturn用のgenrelistに格納
        	list.add(returnMemo);
        }
		return list;

	}

}
