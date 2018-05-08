package com.example.democorba;

import org.hamcrest.CoreMatchers;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoCorbaApplicationTests {

	@ClassRule
	public static OutputCapture outputCapture = new OutputCapture();

	@Test
	public void contextLoads() {
		outputCapture.expect(CoreMatchers.containsString("Hello !! (Hi Shimizu.) by hello"));
		outputCapture.expect(CoreMatchers.containsString("Hello !! (Hi Shimizu.) by execute"));
	}

}