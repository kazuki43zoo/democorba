package com.example.democorba;

import com.example.democorba.server.GreetingServer;
import com.example.democorba.service.BytesDataHolder;
import com.example.democorba.service.GreetingService;
import com.example.democorba.service.GreetingServiceHelper;
import com.example.democorba.service.GreetingServiceOperations;
import com.example.democorba.support.IorFileSupport;
import org.hamcrest.core.Is;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class GreetingTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoCorbaApplication.class);

    private static final String[] ORB_OPTIONS = new String[]{"-ORBInitialPort", "1050", "-ORBInitialHost", "localhost"};

    private static final IorFileSupport IOR_FILE_SUPPORT = new IorFileSupport();

    private static ORB orb;

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
        TimeUnit.SECONDS.sleep(2);
        orb = ORB.init(ORB_OPTIONS, null);
    }

    @AfterClass
    public static void destroyOrb() {
        if (orb != null) {
            orb.destroy();
        }
        GreetingServer.stop();
    }

    @Test
    public void testUsingNamingService() throws InvalidName, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName, NotFound {
        org.omg.CORBA.Object nameServiceRef =
                orb.resolve_initial_references("NameService");
        NamingContextExt namingContextRef = NamingContextExtHelper.narrow(nameServiceRef);

        GreetingService greetingService = GreetingServiceHelper.narrow(namingContextRef.resolve_str("GreetingService"));

        LOGGER.info("Obtained a handle on server object: " + greetingService);

        String requestMessage = "I'm Kazuki!";
        {
            String returnMessage = greetingService.hello(requestMessage);
            Assert.assertThat(returnMessage, Is.is("Hello !! (I'm Kazuki!) by hello"));
        }

        {
            BytesDataHolder responseHolder = new BytesDataHolder();
            greetingService.execute(requestMessage.getBytes(StandardCharsets.UTF_8), responseHolder);
            Assert.assertThat(new String(responseHolder.value, StandardCharsets.UTF_8), Is.is("Hello !! (I'm Kazuki!) by execute"));
        }
    }

    @Test
    public void testUsingIorFile() {
        String ior = IOR_FILE_SUPPORT.read();
        GreetingServiceOperations greetingService = GreetingServiceHelper.narrow(orb.string_to_object(ior));

        LOGGER.info("Obtained a handle on server object: " + greetingService);

        String requestMessage = "I'm Kazuki!";
        {
            String returnMessage = greetingService.hello(requestMessage);
            Assert.assertThat(returnMessage, Is.is("Hello !! (I'm Kazuki!) by hello"));
        }

        {
            BytesDataHolder responseHolder = new BytesDataHolder();
            greetingService.execute(requestMessage.getBytes(StandardCharsets.UTF_8), responseHolder);
            Assert.assertThat(new String(responseHolder.value, StandardCharsets.UTF_8), Is.is("Hello !! (I'm Kazuki!) by execute"));
        }
    }

}
