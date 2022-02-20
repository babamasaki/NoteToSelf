package com.example.demo.app;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String genreCreate(@Validated GenreForm genreForm, Model model) {

		return "genreCreate";
	}
	@PostMapping("/genreCreate")
	public String postGenreCreate(@Validated GenreForm genreForm, BindingResult result, Model model, RedirectAttributes redirectAttributes) {

		if(result.hasErrors()) {
		//入力エラーが発生した場合ジャンル追加画面に戻る
			return "genreCreate";
		}

		Genre genre = new Genre();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		genre.setGenre(genreForm.getGenre());
		genre.setCreated_at(timestamp);
		genre.setUpdated_at(timestamp);

		if(genreService.genreCheck(genre)) {
			//登録されているジャンルかチェック
	        model.addAttribute("checkMessage", "すでに登録されています。");
			return "genreCreate";
		}

		genreService.save(genre);
		redirectAttributes.addFlashAttribute("complete","登録完了");
		return "redirect:/NoteToSelf/index";
	}

	@GetMapping(value="/showGenre/{id}")
	public String showGenre(@PathVariable("id") int id, Model model) {

		//ジャンルの取得
		 List<Genre> listGenre =genreService.findAll();

		//コンテンツの取得
		Memo memo = new Memo();
		memo.setGenre_id(id);
		 List<Memo>listMemo = memoService.genreById(memo);

		model.addAttribute("title","個別画面");
		model.addAttribute("id",id);
        model.addAttribute("listGenre", listGenre);
        model.addAttribute("listMemo", listMemo);
		return "showGenre";
	}

	@GetMapping("/memoCreate")
	public String memoCreate(@Validated MemoForm memoForm, Model model) {

		//登録されているジャンルの取得
		 List<Genre> listGenre =genreService.findAll();

		 model.addAttribute("listGenre",listGenre);
		return "memoCreate";
	}

	@PostMapping("/memoCreate")
	public String memoCreate(@Validated MemoForm memoForm, BindingResult result, Model model, RedirectAttributes redirectAttributes) {

		if(result.hasErrors()) {
		//入力エラーが発生した場合ジャンル追加画面に戻る
			return "memoCreate";
		}

		Memo memo = new Memo();
		memo.setGenre_id(memoForm.getGenre_id());
		memo.setTitle(memoForm.getTitle());
		memo.setContents(memoForm.getContents());
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		memo.setCreated_at(timestamp);
		memo.setUpdated_at(timestamp);

		memoService.memoInsert(memo);

		return "redirect:/NoteToSelf/index";
	}

	@GetMapping(value="/showMemo/{id}")
	public String showMemo(@PathVariable("id") int id, Model model) {

		//ジャンルの取得
		 List<Genre> listGenre =genreService.findAll();

		//コンテンツの取得
		Memo memo = new Memo();
		memo.setGenre_id(id);
		 List<Memo>listMemo = memoService.genreById(memo);

		model.addAttribute("title","個別画面");
		model.addAttribute("id",id);
        model.addAttribute("listGenre", listGenre);
        model.addAttribute("listMemo", listMemo);
		return "showGenre";
	}

}
