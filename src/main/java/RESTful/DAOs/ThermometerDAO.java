package RESTful.DAOs;

import RESTful.classes.Thermometer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ThermometerDAO implements ThermometerDAOLocal{

    @PersistenceContext
    private EntityManager entityManager;

    public void speichereThermometer(Thermometer thermometer){
        try {
            entityManager.persist(thermometer);
        } catch (Exception exception){
            System.out.println("Fehler");
        }
    }

    public void loescheThermometer(int thermometerID){
        Thermometer thermometer = entityManager.find(Thermometer.class, thermometerID);
        entityManager.remove(thermometer);
    }
    @Override
    public Thermometer findeThermometer(int thermometerID){
        return entityManager.find(Thermometer.class, thermometerID);
    }

    public void aendereThermometer(Thermometer thermometer){
        entityManager.merge(thermometer);
    }

    public List<Thermometer> listeThermometer(){
        return entityManager.createQuery("SELECT thermometer FROM Thermometer thermometer", Thermometer.class).getResultList();
    }
}
