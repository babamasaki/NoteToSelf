package com.example.demo.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entitiy.Genre;
import com.example.demo.entitiy.Memo;
import com.example.demo.service.GenreService;
import com.example.demo.service.MemoService;

@Controller
@RequestMapping("/NoteToSelf")
public class NoteToSelfController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final GenreService genreService;
	private final MemoService memoService;

	public NoteToSelfController(GenreService genreService, MemoService memoService) {
		this.genreService = genreService;
		this.memoService = memoService;
	}


	@GetMapping("/index")
	public String index(Model model) {

		//ジャンルの取得
		 List<Genre> listGenre =genreService.findAll();
		//コンテンツの取得
		 List<Memo>listMemo = memoService.findAll();

		model.addAttribute("title","一覧画面");
        model.addAttribute("listGenre", listGenre);
        model.addAttribute("listMemo", listMemo);
		return "index";
	}

	@GetMapping("/genreCreate")
	public String genreCreate(Model model) {
		return "genreCreate";
	}
}
