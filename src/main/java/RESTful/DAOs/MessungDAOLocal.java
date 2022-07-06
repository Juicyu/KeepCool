package RESTful.DAOs;

import RESTful.classes.Messung;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public interface MessungDAOLocal {

    public int speichereMessung(Messung messung);
    public Messung findeMessung(int messungID);
}
