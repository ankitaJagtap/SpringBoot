package com.firstProjecct.QuizApp.service;

import com.firstProjecct.QuizApp.model.Questions;
import com.firstProjecct.QuizApp.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;
    public ResponseEntity<List<Questions>> getAllQuestions(){
        try {
            return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Questions>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionRepo.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> addQuestion(Questions question) {
        questionRepo.save(question);
        try {
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(" ", HttpStatus.BAD_REQUEST);
        }

    }
}
