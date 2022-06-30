package RESTful.DAOs;

import RESTful.classes.Thermometer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ThermometerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public String speichereThermometer(Thermometer thermometer){
        entityManager.persist(thermometer);
        return thermometer.getId();
    }

    public void loescheThermometer(String thermometerID){
        Thermometer thermometer = entityManager.find(Thermometer.class, thermometerID);
        entityManager.remove(thermometer);
    }

    public void aendereThermometer(Thermometer thermometer){
        entityManager.merge(thermometer);
    }

    public List<Thermometer> listeThermometer(){
        return entityManager.createQuery("SELECT thermometer FROM Thermometer thermometer", Thermometer.class).getResultList();
    }
}
