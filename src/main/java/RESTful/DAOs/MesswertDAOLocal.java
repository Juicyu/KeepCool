package RESTful.DAOs;

import RESTful.classes.Messwert;

import javax.ejb.Local;
import java.util.List;

@Local
public interface MesswertDAOLocal {

    public int speichereMesswert(Messwert messwert);
    public void loescheMesswert(int id);
    public void aendereMesswert(Messwert messwert);
    public List<Messwert> listeMesswerte();
}
