package ru.jurfed.springbootproject.dao;

import java.util.List;

public interface TestDao {
    public List<String> getQuestions();

    public List<String> getAnswers();

    public List<String> getCurrentAnswer();

}
