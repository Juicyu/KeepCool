package RESTful.classes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Thermometer implements Serializable {

    @Id
    private String id;
    private String seriennummer;
    @OneToMany(mappedBy = "thermometer")
    private List<Messung> messungen = new ArrayList<Messung>();

    //Konstruktoren
    public Thermometer() {
    }

    public Thermometer(String id, String seriennummer) {
        this.id = id;
        this.seriennummer = seriennummer;
    }

    //Getter und Setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeriennummer() {
        return seriennummer;
    }

    public void setSeriennummer(String seriennummer) {
        this.seriennummer = seriennummer;
    }

    public List<Messung> getMessungen() {
        return messungen;
    }

    public void setMessungen(List<Messung> messungen) {
        this.messungen = messungen;
    }
}
