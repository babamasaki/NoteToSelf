package com.example.demo.repsitory;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entitiy.JsonNoteToSelf;
import com.example.demo.entitiy.Memo;
import com.example.demo.entitiy.NoteToSelf;

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

		String sql = "SELECT * from memos"
				+" WHERE id = " + memo.getId();
		System.out.println(sql);

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
	public int memoUpdate(Memo memo) {
		return jdbcTemplate.update("UPDATE memos SET genre_id = ?, title = ?, contents = ?, updated_at = ? WHERE id = ?",
				memo.getGenre_id(), memo.getTitle(), memo.getContents(), memo.getUpdated_at(), memo.getId());
	}

	@Override
	public List<NoteToSelf> showMemo(Memo memo) {

		String sql = "SELECT "
				+ " genres.id as genreId"
				+ " ,genres.genre as genreName"
				+ " ,memos.id as memoId"
				+ " ,memos.genre_id as memoGenreId"
				+ " ,memos.title as title"
				+ " ,memos.contents as contents"
				+ " ,memos.created_at as memoCreated_at"
				+ " ,memos.updated_at as memoUpdated_at"
				+ " FROM memos"
				+ " INNER JOIN genres"
				+ " ON memos.genre_id = genres.id"
				+ " WHERE "
				+ " 	memos.id = " + memo.getId()
				+ " AND memos.genre_id =  " + memo.getGenre_id();
		System.out.println(sql);

        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
        //return用のgenrelist
        List<NoteToSelf> list = new ArrayList<NoteToSelf>();
        //取得した件数分データをentityに格納する
        for(Map<String, Object> result: resultList) {
        	NoteToSelf returnNoteToSelf = new NoteToSelf();
        	returnNoteToSelf.setGenreId((int)result.get("genreId"));
        	returnNoteToSelf.setGenre((String)result.get("genreName"));
        	returnNoteToSelf.setMemoId((int)result.get("memoId"));
        	returnNoteToSelf.setTitle((String)result.get("title"));
        	returnNoteToSelf.setContents((String)result.get("contents"));
        	returnNoteToSelf.setMemoCreated_at((Timestamp) result.get("memoCreated_at"));
        	returnNoteToSelf.setMemoUpdated_at((Timestamp) result.get("memoUpdated_at"));
        	//格納したデータをreturn用のgenrelistに格納
        	list.add(returnNoteToSelf);
        }
		return list;
	}

	@Override
	public List<JsonNoteToSelf> memoSearch(Memo memo) {

		String sql = "SELECT "
//				+ " genres.id as genreId"
//				+ " ,genres.genre as genreName"
				+ " memos.id as memoId"
//				+ " ,memos.genre_id as memoGenreId"
				+ " ,memos.title as title"
				+ " ,memos.contents as contents"
//				+ " ,memos.created_at as memoCreated_at"
				+ " ,memos.updated_at as memoUpdated_at"
				+ " FROM memos"
				+ " INNER JOIN genres"
				+ " ON memos.genre_id = genres.id"
				+ " WHERE "
				+ " 	memos.title like '%" + memo.getTitle() + "%'";
		System.out.println(sql);

        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
        //return用のgenrelist
        List<JsonNoteToSelf> list = new ArrayList<JsonNoteToSelf>();
        //取得した件数分データをentityに格納する
        for(Map<String, Object> result: resultList) {
        	JsonNoteToSelf returnJsonNoteToSelf = new JsonNoteToSelf();
//        	returnJsonNoteToSelf.setGenreId((int)result.get("genreId"));
//        	returnJsonNoteToSelf.setGenre((String)result.get("genreName"));
        	returnJsonNoteToSelf.setMemoId((int)result.get("memoId"));
        	returnJsonNoteToSelf.setTitle((String)result.get("title"));
        	returnJsonNoteToSelf.setContents((String)result.get("contents"));
//        	returnJsonNoteToSelf.setMemoCreated_at((Timestamp) result.get("memoCreated_at"));
        	returnJsonNoteToSelf.setMemoUpdated_at((Timestamp) result.get("memoUpdated_at"));
        	//格納したデータをreturn用のgenrelistに格納
        	list.add(returnJsonNoteToSelf);
        }
		return list;
	}
}
