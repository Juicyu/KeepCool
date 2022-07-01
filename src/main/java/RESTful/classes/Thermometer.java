package RESTful.classes;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Thermometer implements Serializable {

    @Id
    private int id;
    private String name;
    @OneToMany(mappedBy = "thermometer")
    private List<Messung> messungen = new ArrayList<Messung>();

    //Konstruktoren
    public Thermometer() {
    }

    public Thermometer(String seriennummer) {
        this.name = seriennummer;
    }

    public Thermometer(int id, String seriennummer) {
        this.id = id;
        this.name = seriennummer;
    }

    //Getter und Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @OneToMany(mappedBy = "thermometer")
    public List<Messung> getMessungen() {
        return messungen;
    }

    public void setMessungen(List<Messung> messungen) {
        this.messungen = messungen;
    }
}
