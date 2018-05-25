package org.supcom.javase;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import org.jboss.resteasy.plugins.server.sun.http.HttpContextBuilder;
import org.supcom.javase.services.Config;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Scanner;
import java.util.logging.Logger;

public class BoostStrapHttpServer {
    private final static Logger log = Logger.getLogger(BoostStrapHttpServer.class.getName());
    private final static Integer port  = 80;
    private final static HttpContextBuilder contextBuilder = new HttpContextBuilder();

    public static void main(String[] args) {
        log.info("Starting Http Server with JAX-RS and JPA");
        HttpServer server = null;
        try {
            //create Http Server
            server = HttpServer.create(new InetSocketAddress(port),10);
            //initialize the CDI (Contexts and Dependencies Injection) container
            SeContainer container = SeContainerInitializer.newInstance().initialize();
            container.getBeanManager().fireEvent(new BootStrapEvent(container));
            //initialize RESTEasy
            contextBuilder.getDeployment().getActualResourceClasses().addAll(Config.getResources());
            contextBuilder.getDeployment().setInjectorFactoryClass("org.jboss.resteasy.cdi.CdiInjectorFactory");
            HttpContext context = contextBuilder.bind(server);
            //start Http server
            server.start();
            Scanner scan = new Scanner(System.in);
            while (true){
                String next = scan.nextLine();
                if(next.isEmpty()){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            contextBuilder.cleanup();
            if(server !=null){
                server.stop(0);
            }
        }
    }
}
