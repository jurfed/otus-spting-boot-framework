package ru.jurfed.springbootproject.dao;

import java.util.List;

public class TestDaoImpl implements TestDao {


    List<String> questions;
    List<String> answers;
    List<String> currentAnswer;


    public TestDaoImpl(List<String> questions, List<String> answers, List<String> currentAnswer) {
        this.questions = questions;
        this.answers = answers;
        this.currentAnswer = currentAnswer;
    }


    public List<String> getQuestions() {
        return questions;
    }


    public List<String> getAnswers() {
        return answers;
    }


    public List<String> getCurrentAnswer() {
        return currentAnswer;
    }

}
