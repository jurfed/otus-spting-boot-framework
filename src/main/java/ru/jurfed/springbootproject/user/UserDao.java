package ru.jurfed.springbootproject.user;

public interface UserDao {

    public int getCorrectQuestions();

    public void setCorrectQuestions(int correctQuestions);

    public String getName();

}
