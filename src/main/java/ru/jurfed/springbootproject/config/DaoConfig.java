package ru.jurfed.springbootproject.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.jurfed.springbootproject.dao.TestDaoImpl;
import ru.jurfed.springbootproject.dao.TestDao;

import java.util.List;
import java.util.Locale;

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

    @Bean(name = "testDaoImpl")
    public TestDao getTestDao(){
        String locale = Locale.getDefault().getLanguage();
        if (locale.equals("ru")) {
            return new TestDaoImpl(questionsRu, answersRu, currentAnswerRu);
        } else {
            return new TestDaoImpl(questionsEn, answersEn, currentAnswerEn);

        }
    }

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


}
