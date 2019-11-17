package ru.jurfed.springbootproject.dao;


import com.opencsv.CSVReader;

import javax.xml.bind.annotation.XmlAnyElement;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleTest implements TestDao {


    List<String> questions;
    List<String> answers;
    List<String> currentAnswer;


    public SimpleTest(List<String> questions, List<String> answers, List<String> currentAnswer) {
        this.questions = questions;
        this.answers = answers;
        this.currentAnswer = currentAnswer;
    }


    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public List<String> getCurrentAnswer() {
        return currentAnswer;
    }

    public void setCurrentAnswer(List<String> currentAnswer) {
        this.currentAnswer = currentAnswer;
    }
}
