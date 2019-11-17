package ru.jurfed.springbootproject.service;


import ru.jurfed.springbootproject.dao.TestDao;

import java.io.IOException;

public interface ServiceInterface {

    public String getName();

    public void setName(String name);

    public TestDao getTestDao();

    public void name(String name) throws IOException;

    public void start();

    public void checkQuestion(String a, String b);


}
