package com.example.demo.app;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/NoteToSelf")
public class NoteToSelfController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("title","一覧画面");
		String sql = "SELECT * FROM genres";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        model.addAttribute("testList", list);
		return "index";
	}
}
