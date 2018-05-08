package com.example.democorba;

import com.example.democorba.service.BytesDataHolder;
import com.example.democorba.service.GreetingService;
import com.example.democorba.service.GreetingServiceHelper;
import com.example.democorba.service.GreetingServiceOperations;
import com.example.democorba.support.IorFileSupport;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

public class GreetingTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoCorbaApplication.class);

    private static final String[] ORB_OPTIONS = new String[]{"-ORBInitialPort", "1050", "-ORBInitialHost", "localhost"};

    private static final IorFileSupport IOR_FILE_SUPPORT = new IorFileSupport();

    @Test
    public void testUsingNamingService() throws InvalidName, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName, NotFound {
        ORB orb = ORB.init(ORB_OPTIONS, null);

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
        ORB orb = ORB.init(new String[]{}, null);
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
