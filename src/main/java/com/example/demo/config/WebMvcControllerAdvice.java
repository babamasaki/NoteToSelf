package com.example.demo.config;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;


@ControllerAdvice
public class WebMvcControllerAdvice {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        // 入力値の空文字をnullに変換
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}