public class ConsoleEventLogger implements EventLogger {

    public void logEvent(Event event) {

        System.out.println(event);

    }

    /*
    public void logEvent(String msg) {

        System.out.println(msg);

    }
    */

}
