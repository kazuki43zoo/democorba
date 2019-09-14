package com.example.democorba;

import com.example.democorba.server.GreetingServer;
import org.hamcrest.CoreMatchers;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.ORB;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoCorbaApplicationTests {

	@ClassRule
	public static OutputCapture outputCapture = new OutputCapture();

	@BeforeClass
	public static void setupOrb() throws InterruptedException {
		new Thread(()-> {
			try {
				GreetingServer.main(new String[0]);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}).start();
		TimeUnit.SECONDS.sleep(3);
	}

	@AfterClass
	public static void destroyOrb() {
		GreetingServer.stop();
	}

	@Test
	public void contextLoads() {
		outputCapture.expect(CoreMatchers.containsString("Hello !! (Hi Shimizu.) by hello"));
		outputCapture.expect(CoreMatchers.containsString("Hello !! (Hi Shimizu.) by execute"));
	}

}