package RESTful.classes;

import RESTful.DAOs.MessungDAOLocal;

import javax.naming.InitialContext;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Messwert implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ManyToOne
    private Messung messung;
    private double temperatur;
    private LocalDateTime messzeit;
    private int akku;

    public Messwert(int id) {
        this.id = id;
    }

    public Messwert() {

    }

    public Messwert(String name) {
        this.name = name;
    }

    public Messwert(double temperatur, LocalDateTime messzeit, int akku) {
        this.temperatur = temperatur;
        this.messzeit = messzeit;
        this.akku = akku;
    }

    //Getter und Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTemperatur() {
        return temperatur;
    }

    public void setTemperatur(double temperatur) {
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
        return messung;
    }

    public void setMessung(Messung messung) {
        this.messung = messung;
    }

    public String getName() {
        return name;
    }

    public void setName(String seriennummer) {
        this.name = seriennummer;
    }
}
