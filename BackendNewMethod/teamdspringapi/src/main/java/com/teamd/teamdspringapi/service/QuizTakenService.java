package com.teamd.teamdspringapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamd.teamdspringapi.entity.QuizTaken;
import com.teamd.teamdspringapi.repository.QuizTakenRepository;

@Service
public class QuizTakenService {
    @Autowired
    private QuizTakenRepository quizTakenRepository;

    public List<QuizTaken> getAllQuizTaken() {
        return quizTakenRepository.findAll();
    }

    public QuizTaken getQuizTakenId(Long quiztknID) {
        return quizTakenRepository.findById(quiztknID).orElse(null);
    }

    public List<QuizTaken> getQuizTakenByUserId(Long user_ID) {
        return quizTakenRepository.findByUserId(user_ID);
    }

    public QuizTaken savQuizTaken(QuizTaken quizTaken) {
        return quizTakenRepository.save(quizTaken);
    }

    public void deleteQuizTaken(Long quiztknID) {
        quizTakenRepository.deleteById(quiztknID);
    }
}

