import java.util.Date;

public class Event {

    private int id;
    private String msg;
    private Date date;

    public Event(Date date) {
        this.date = date;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                '}';
    }

    /*
    - id: int; // Auto-generated
    - msg: String; // Set in setter
    - date: Date; // Set in constructor
    + toString()
    */

}
