package RESTful.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MesswertRueckgabe extends Messwert{

    String date;
    String time;
    String durchschnittstemperatur;

    public MesswertRueckgabe(double temperatur,
                             LocalDateTime messzeit, int akku,
                             String date,
                             String time,
                             String durchschnittstemperatur) {
        super(temperatur, messzeit, akku);
        this.date = date;
        this.time = time;
        this.durchschnittstemperatur = durchschnittstemperatur;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDurchschnittstemperatur() {
        return durchschnittstemperatur;
    }

    public void setDurchschnittstemperatur(String durchschnittstemperatur) {
        this.durchschnittstemperatur = durchschnittstemperatur;
    }
}
