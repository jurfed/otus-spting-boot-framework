package ru.jurfed.springbootproject.user;

import org.springframework.stereotype.Component;

@Component

public class SimpleUser implements UserDao{

    public SimpleUser() {
    }

    String name;

    public String getName() {
        return name;
    }

    int correctQuestions;

    public SimpleUser(String name) {
        this.name = name;
    }

    public int getCorrectQuestions() {
        return correctQuestions;
    }

    public void setCorrectQuestions(int correctQuestions) {
        this.correctQuestions = correctQuestions;
    }

}
