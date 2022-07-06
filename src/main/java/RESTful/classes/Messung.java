package RESTful.classes;

import RESTful.DAOs.ThermometerDAOLocal;

import javax.naming.InitialContext;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Messung implements Serializable {

    //@GeneratedValue
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private Date startzeit;
    private Date endzeit;
    @ManyToOne
    private Thermometer thermometer;
    private String richtlinie;
    private double minTemperatur;
    private double maxTemperatur;

    @OneToMany(mappedBy = "messung")
    private List<Messwert> messwerte = new ArrayList<Messwert>();

    //Konstruktor
    public Messung() {
    }

    public Messung(String name, double minTemperatur, double maxTemperatur, int thermometerId) {

        try{
            InitialContext initialContext = new InitialContext();
            ThermometerDAOLocal thermometerDAOLocal = (ThermometerDAOLocal) initialContext.lookup("java:module/ThermometerDAO!RESTful.DAOs.ThermometerDAOLocal");
            this.thermometer = thermometerDAOLocal.findeThermometer(thermometerId);
        } catch (Exception e){

        }

        this.name = name;
        this.minTemperatur = minTemperatur;
        this.maxTemperatur = maxTemperatur;
    }

    //Getter und Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public double getMinTemperatur() {
        return minTemperatur;
    }

    public void setMinTemperatur(float minTemperatur) {
        this.minTemperatur = minTemperatur;
    }

    public double getMaxTemperatur() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
