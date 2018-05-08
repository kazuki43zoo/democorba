package com.example.democorba.server;

import com.example.democorba.service.GreetingService_Tie;
import com.example.democorba.support.IorFileSupport;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GreetingServer {

    private static final String[] ORB_OPTIONS = new String[]{"-ORBInitialPort", "1050", "-ORBInitialHost", "localhost"};
    private static final IorFileSupport IOR_FILE_SUPPORT = new IorFileSupport();

    public static void main(String args[]) throws IOException, InterruptedException {

        List<String> orbdStartupCommands = new ArrayList<>();
        orbdStartupCommands.add("orbd");
        orbdStartupCommands.addAll(Arrays.asList(ORB_OPTIONS));

        Process orbdProcess = new ProcessBuilder(orbdStartupCommands).start();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("GreetingService Exiting ...");
            orbdProcess.destroy();
        }));

        TimeUnit.SECONDS.sleep(1);

        try {
            bindService(ORB_OPTIONS);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void bindService(String[] options) throws InvalidName, AdapterInactive, ServantNotActive, WrongPolicy, org.omg.CosNaming.NamingContextPackage.InvalidName, NotFound, CannotProceed, IOException {
        ORB orb = ORB.init(options, null);
        POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
        poa.the_POAManager().activate();

        GreetingService_Tie greetingServiceTie = new GreetingService_Tie(new GreetingServiceImpl());

        NamingContextExt namingContextRef =
                NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
        namingContextRef.rebind(namingContextRef.to_name("GreetingService"), greetingServiceTie);

        String ior = orb.object_to_string(greetingServiceTie);
        IOR_FILE_SUPPORT.write(ior);

        System.out.println("GreetingService IOR: " + ior);
        System.out.println("GreetingService ready started and waiting request ...");

        orb.run();
    }

}
