package edu.study.lab.spring6webapp;

import edu.study.lab.spring6webapp.controllers.MyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class Spring6WebappApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private MyController myController;

	@Test
	void testAutowired(){
		System.out.println(myController.sayHi());
	}

	@Test
	public void testGenerateController(){
		MyController myController = applicationContext.getBean(MyController.class);
		System.out.println(myController.sayHi());
	}

	@Test
	void contextLoads() {
	}

}
