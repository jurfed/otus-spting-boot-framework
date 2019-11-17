package ru.jurfed.springbootproject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jurfed.springbootproject.dao.TestDao;
import ru.jurfed.springbootproject.user.SimpleUser;
import ru.jurfed.springbootproject.user.UserDao;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service("myService1")
public class SimpleService implements ServiceInterface {

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

    public void enterYouName() throws IOException {
        System.out.println("Please enter your name\n");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        userDao = new SimpleUser(name);
        System.out.println("Hello! " + name);
    }

    public void startTests() {
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
