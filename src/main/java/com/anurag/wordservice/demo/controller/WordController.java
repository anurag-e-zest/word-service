package com.anurag.wordservice.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.wordservice.demo.dto.WordRequest;
import com.anurag.wordservice.demo.service.WordService;

import java.util.List;

@RestController
public class WordController {
    private final WordService wordService;

    @Autowired
    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @PostMapping("/top-words")
    public List<String> getTopNLargestWords(@RequestBody WordRequest request) {
        return wordService.getTopNLargestWords(request.getCount(), request.getSorting(), request.getText());
    }
}
