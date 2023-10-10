package com.firstProjecct.QuizApp.repository;

import com.firstProjecct.QuizApp.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Questions, Integer> {

     List<Questions> findByCategory(String category);

     @Query(value = "SELECT * from questions q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
     List<Questions> findRandomQuestionsByCategory(String category, int numQ);
}
