package ru.jurfed.springbootproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import ru.jurfed.springbootproject.dao.Logger2;
import ru.jurfed.springbootproject.dao.SimpleTest;
import ru.jurfed.springbootproject.dao.TestDao;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Locale;

@EnableAspectJAutoProxy
@ConfigurationProperties("application")
@Configuration
public class DaoConfig {


    private double version;

    private List<String> questionsEn;
    private List<String> questionsRu;

    private List<String> answersRu;
    private List<String> answersEn;

    private List<String> currentAnswerRu;
    private List<String> currentAnswerEn;

    public List<String> getCurrentAnswerRu() {
        return currentAnswerRu;
    }

    public void setCurrentAnswerRu(List<String> currentAnswerRu) {
        this.currentAnswerRu = currentAnswerRu;
    }

    public List<String> getCurrentAnswerEn() {
        return currentAnswerEn;
    }

    public void setCurrentAnswerEn(List<String> currentAnswerEn) {
        this.currentAnswerEn = currentAnswerEn;
    }

    public List<String> getAnswersRu() {
        return answersRu;
    }

    public void setAnswersRu(List<String> answersRu) {
        this.answersRu = answersRu;
    }

    public List<String> getAnswersEn() {
        return answersEn;
    }

    public void setAnswersEn(List<String> answersEn) {
        this.answersEn = answersEn;
    }

    public List<String> getQuestionsRu() {
        return questionsRu;
    }

    public void setQuestionsRu(List<String> questionsRu) {
        this.questionsRu = questionsRu;
    }

    public List<String> getQuestionsEn() {
        return questionsEn;
    }

    public void setQuestionsEn(List<String> questionsEn) {
        this.questionsEn = questionsEn;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    @Bean(name = "simpleDao")
    public TestDao getTestDao() throws FileNotFoundException {
        String locale = Locale.getDefault().getLanguage();
        if (locale.equals("ru")) {
            return new SimpleTest(questionsRu, answersRu, currentAnswerRu);
        } else {
            return new SimpleTest(questionsEn, answersEn, currentAnswerEn);

        }
    }

    @Bean
    public Logger2 getlogger2() {
        return new Logger2();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer getConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
