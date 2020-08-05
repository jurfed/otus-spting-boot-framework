package ru.jurfed.springbootproject;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.jurfed.springbootproject.config.DaoConfig;
import ru.jurfed.springbootproject.dao.TestDao;
import ru.jurfed.springbootproject.service.SimpleService;

import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootProjectApplicationTests {

	@Autowired
	TestDao testDao;

	@Autowired
	private DaoConfig config;

	@MockBean
	private SimpleService service;

	@Test
	void contextLoads() {
		double version = config.getVersion();
		assertTrue(version==1.0);
		System.err.println("Version= " + version);

		System.err.println(config.getAnswersEn());
		given(this.service.getName()).willReturn("Testov Test Testivich");
		System.err.println(service.getName());

	}

}
