package ru.jurfed.springbootproject.dao;

import java.io.IOException;
import java.util.List;

public interface TestDao {
    public List<String> getQuestions();

    public void setQuestions(List<String> questions);

    public List<String> getAnswers();

    public void setAnswers(List<String> answers);

    public List<String> getCurrentAnswer();

    public void setCurrentAnswer(List<String> currentAnswer);

}
