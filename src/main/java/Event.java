import java.text.DateFormat;
import java.util.Date;

public class Event {

    private int id = 1 + (int)(Math.random() * ((9999) + 1));
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df = df;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(date) +
                '}';
    }

    public static void main(String[] args) {

    //    System.out.println( new Event(new Date()) );

    }

    /*
    - id: int; // Auto-generated
    - msg: String; // Set in setter
    - date: Date; // Set in constructor
    + toString()
    */

}
