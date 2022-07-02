package RESTful.DAOs;

import RESTful.classes.Thermometer;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ThermometerDAOLocal {

    public void speichereThermometer(Thermometer thermometer);
    public void loescheThermometer(int thermometerID);
    public Thermometer findeThermometer(int thermometerID);
    public void aendereThermometer(Thermometer thermometer);
    public List<Thermometer> listeThermometer();
}
