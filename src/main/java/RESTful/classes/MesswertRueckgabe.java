package RESTful.classes;

import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class MesswertRueckgabe extends Messwert implements Serializable {

    String date;
    String time;
    String durchschnittstemperatur;

    public MesswertRueckgabe(double temperatur,
                             LocalDateTime messzeit,
                             int akku,
                             String date,
                             String time,
                             String durchschnittstemperatur) {
        super(temperatur, messzeit, akku);
        this.date = date;
        this.time = time;
        this.durchschnittstemperatur = durchschnittstemperatur;
    }

    public MesswertRueckgabe() {

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
