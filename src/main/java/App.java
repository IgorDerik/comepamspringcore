import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private Client client;
    private EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public void logEvent(String msg) {

        String message = msg.replaceAll(client.getId(), client.getFullName());

    //    eventLogger.logEvent(message);
    }

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) ctx.getBean("app");

        app.logEvent("Some event for 1");
        app.logEvent("Some event for 2");

//        App app = new App();
//        app.client = new Client("1", "John Smith");
//        app.consoleEventLogger = new ConsoleEventLogger();
//        app.logEvent("Some event for user 1");

    }

}
