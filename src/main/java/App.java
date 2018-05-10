import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {

    private Client client;

    private Map<EventType, EventLogger> loggers;

//    private EventLogger defaultLogger;

    public App(Client client, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.loggers = loggers;
    }

    public void logEvent(Event event, EventType type, String msg) {

        EventLogger eventLogger = loggers.get(type);

        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(client.getGreeting() + " " + message);

        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");

        Event event = ctx.getBean(Event.class);
        app.logEvent(event, EventType.INFO, "Some event for 1");

        event = ctx.getBean(Event.class);
        app.logEvent(event, EventType.ERROR, "Some event for 2");

        ctx.close();
    }

}
