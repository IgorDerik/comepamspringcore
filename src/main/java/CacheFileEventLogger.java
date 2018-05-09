import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {

    private int cacheSize;

    private List<Event> cache = new ArrayList<Event>();

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
    }

    private void writeEventsFromCache () {
        for (Event e : cache) {
            super.logEvent(e);
        }
        cache.clear();
    }

    public void logEvent(Event event) {

        cache.add(event);

        if (cache.size() == cacheSize) {
            writeEventsFromCache();
        }

    }

    public void destroy() {
        if ( !cache.isEmpty() )
            writeEventsFromCache();
    }

}

