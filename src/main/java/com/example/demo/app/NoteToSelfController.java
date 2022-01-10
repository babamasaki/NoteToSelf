package com.example.demo.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/NoteToSelf")
public class NoteToSelfController {

	@GetMapping("index")
	public String index(Model model) {
		model.addAttribute("title","一覧画面");
		return "index";
	}

}
