package RESTful.classes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Messung implements Serializable {

    //@GeneratedValue
    @Id
    private String id;
    private Date startzeit;
    private Date endzeit;
    @ManyToOne
    private Thermometer thermometer;
    private String richtlinie;
    private float minTemperatur;
    private float maxTemperatur;

    @OneToMany(mappedBy = "messung")
    List<Messwert> messwerte = new ArrayList<Messwert>();

    //Konstruktor
    public Messung() {
    }

    public Messung(String id) {
        this.id = id;
    }


    //Getter und Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStartzeit() {
        return startzeit;
    }

    public void setStartzeit(Date startzeit) {
        this.startzeit = startzeit;
    }

    public Date getEndzeit() {
        return endzeit;
    }

    public void setEndzeit(Date endzeit) {
        this.endzeit = endzeit;
    }

    public Thermometer getThermometer() {
        return this.thermometer;
    }

    public void setThermometer(Thermometer thermometer) {
        this.thermometer = thermometer;
    }

    public String getRichtlinie() {
        return richtlinie;
    }

    public void setRichtlinie(String richtlinie) {
        this.richtlinie = richtlinie;
    }

    public float getMinTemperatur() {
        return minTemperatur;
    }

    public void setMinTemperatur(float minTemperatur) {
        this.minTemperatur = minTemperatur;
    }

    public float getMaxTemperatur() {
        return maxTemperatur;
    }

    public void setMaxTemperatur(float maxTemperatur) {
        this.maxTemperatur = maxTemperatur;
    }

    public List<Messwert> getMesswerte() {
        return messwerte;
    }

    public void setMesswerte(List<Messwert> messwerte) {
        this.messwerte = messwerte;
    }

    /*Funktionen*/
    //Speichern eines Messwertes
    public void speichereMesswert(Messwert thermometer){
        this.messwerte.add(thermometer);
    }
    //Rückgabe der Durchschnittstemperatur
    public float berechneDurchschnittstemperatur(){
        float zwischenspeicher = 0;
        for (Messwert thermometer:
                messwerte) {
            zwischenspeicher += thermometer.getTemperatur();
        }
        return zwischenspeicher/ messwerte.size();
    }
}
