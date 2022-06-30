package RESTful.classes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Messwert implements Serializable {

    @Id
    private String id;
    private String seriennummer;
    @ManyToOne
    private Messung Messung;
    private float temperatur;
    private LocalDateTime messzeit;
    private int akku;

    public Messwert(String id) {
        this.id = id;
    }

    public Messwert() {

    }

    public Messwert(String id, String seriennummer) {
        this.id = id;
        this.seriennummer = seriennummer;
    }

    public Messwert(String id, float temperatur, LocalDateTime messzeit, int akku) {
        this.id = id;
        this.temperatur = temperatur;
        this.messzeit = messzeit;
        this.akku = akku;
    }

    //Getter und Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getTemperatur() {
        return temperatur;
    }

    public void setTemperatur(float temperatur) {
        this.temperatur = temperatur;
    }

    public LocalDateTime getMesszeit() {
        return messzeit;
    }

    public void setMesszeit(LocalDateTime messzeit) {
        this.messzeit = messzeit;
    }

    public int getAkku() {
        return akku;
    }

    public void setAkku(int akku) {
        this.akku = akku;
    }

    public Messung getMessung() {
        return Messung;
    }

    public void setMessung(Messung messung) {
        Messung = messung;
    }

    public String getSeriennummer() {
        return seriennummer;
    }

    public void setSeriennummer(String seriennummer) {
        this.seriennummer = seriennummer;
    }
}
