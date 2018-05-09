import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

    private String fileName;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void init() throws IOException {
        //throw new IOException();
        File file = new File(fileName);
        file.canWrite();
    }

    public void logEvent(Event event) {

        try {
            FileUtils.writeStringToFile(new File(fileName), event.getMsg()+"\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
