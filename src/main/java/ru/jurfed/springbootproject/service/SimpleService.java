package ru.jurfed.springbootproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.jurfed.springbootproject.dao.TestDao;
import ru.jurfed.springbootproject.user.SimpleUser;
import ru.jurfed.springbootproject.user.UserDao;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@ShellComponent("simpleService")
public class SimpleService implements ServiceInterface {


    public SimpleService() {
        System.out.println("Enter your name: ");
    }

    //    @Autowired
    TestDao testDao;

    String name;

    UserDao userDao;

    @Autowired
    public void bla_bla_bla(TestDao testDao){
        this.testDao = testDao;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public TestDao getTestDao() {
        return testDao;
    }

    @ShellMethod("Enter your name: ")
    public void name(@ShellOption(defaultValue = "Petia") String name){
        userDao = new SimpleUser(name);
        System.out.println("Hello! " + name);
    }

    @ShellMethod("Start test")
    public void start() {
        userDao.setCorrectQuestions(0);
        List<String> questions = testDao.getQuestions();
        List<String> answers = testDao.getAnswers();
        List<String> currentAnswer = testDao.getCurrentAnswer();

        for(int i=0; i<questions.size(); i++){
            System.out.println("Вопрос номер: " + i);
            System.out.println(questions.get(i));
            System.out.println(answers.get(i));

            Scanner scanner = new Scanner(System.in);
            String markedQuestion = scanner.nextLine();
            checkQuestion(markedQuestion, currentAnswer.get(i));
        }
        System.out.println("Dear " + userDao.getName() + "!");
        System.out.println("Your result is: " + userDao.getCorrectQuestions() +" correct answers");

    }


    public void checkQuestion(String a, String b){
        if(a.equals(b)){
            userDao.setCorrectQuestions(userDao.getCorrectQuestions()+1);
        }
    }

}
