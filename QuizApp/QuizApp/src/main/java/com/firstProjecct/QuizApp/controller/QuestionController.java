package com.firstProjecct.QuizApp.controller;


import com.firstProjecct.QuizApp.model.Questions;
import com.firstProjecct.QuizApp.service.QuestionService;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Questions>> getAllQuestions(){

        return questionService.getAllQuestions();
    }

    @GetMapping("category/{cat}")
    public ResponseEntity<List<Questions>> getQuestionsByCategory(@PathVariable("cat") String category){

        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Questions question){
        return questionService.addQuestion(question);
    }
}
