package RESTful.DAOs;

import RESTful.classes.Messung;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MessungDAO implements MessungDAOLocal{


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public int speichereMessung(Messung messung) {
        entityManager.persist(messung);
        return messung.getId();
    }
}
