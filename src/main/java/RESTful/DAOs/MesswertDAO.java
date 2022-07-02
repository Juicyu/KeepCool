package RESTful.DAOs;

import RESTful.classes.Messwert;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateful
public class MesswertDAO implements MesswertDAOLocal{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public int speichereMesswert(Messwert messwert){
        entityManager.persist(messwert);
        return messwert.getId();
    }

    @Override
    public void loescheMesswert(int id){
        Messwert messwert = entityManager.find(Messwert.class, id);
        entityManager.remove(messwert);
    }

    @Override
    public void aendereMesswert(Messwert messwert){
        entityManager.merge(messwert);
    }

    @Override
    public List<Messwert> listeMesswerte(){
        return entityManager.createQuery("SELECT messwert FROM Messwert messwert", Messwert.class)
                .getResultList();
    }
}
