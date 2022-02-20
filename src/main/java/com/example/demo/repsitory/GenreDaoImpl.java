package com.example.demo.repsitory;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entitiy.Genre;

@Repository
public class GenreDaoImpl implements GenreDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Genre> findAll() {
		String sql = "SELECT * FROM genres";
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);

        //return用のgenrelist
		List<Genre> list = new ArrayList<Genre>();
        	//取得した件数分データをentityに格納する
		for(Map<String, Object> result: resultList) {
			Genre genre = new Genre();
			genre.setId((int) result.get("id"));
			genre.setGenre((String) result.get("genre"));
			genre.setCreated_at((Timestamp) result.get("created_at"));
			genre.setUpdated_at((Timestamp) result.get("updated_at"));
        	//格納したデータをreturn用のgenrelistに格納
			list.add(genre);
		}

		return list;
	}

	@Override
	public void genreInsert(Genre genre) {

		jdbcTemplate.update("INSERT INTO genres(genre, created_at, updated_at) VALUES ( ?, ?, ?)",
		genre.getGenre(), genre.getCreated_at(), genre.getUpdated_at());

	}

	@Override
	public boolean genreCheck(Genre genre) {

		String genreName = genre.getGenre();

		String sql =
				  "SELECT count(*) "
				+ "FROM genres "
				+ "WHERE genre ='" + genreName + "'";
        int count = jdbcTemplate.queryForObject(sql,Integer.class);

        //入力されたジャンルとの重複チェック
		if(0 < count) {
			return true;
		}
		return false;
	}

	@Override
	public void genreUpdate(Genre genre) {
		jdbcTemplate.update("UPDATE genres SET genre = ?, updated_at = ? HWERE id = ?",
		genre.getGenre(), genre.getCreated_at(), genre.getId());

	}

}
