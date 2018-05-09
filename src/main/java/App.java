import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private Client client;
    private EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public void logEvent(Event event, String msg) {

        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(client.getGreeting() + " " + message);

        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");

        Event event = ctx.getBean(Event.class);
        app.logEvent(event, "Some event for 1");

        event = ctx.getBean(Event.class);
        app.logEvent(event,"Some event for 2");

        event = ctx.getBean(Event.class);
        app.logEvent(event,"Some event for 3");

        ctx.close();
    }

}
