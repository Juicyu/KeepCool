package RESTful.APIs;

import RESTful.DAOs.ThermometerDAO;
import RESTful.classes.Thermometer;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/ThermometerAnlegen")
public class ThermometerAPI {

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void speichereThermometer(@FormParam("id") String id, @FormParam("seriennummer") String seriennummer){

        Thermometer thermometer = new Thermometer(id, seriennummer);
        ThermometerDAO thermometerDAO = new ThermometerDAO();
        thermometerDAO.speichereThermometer(thermometer);
    }
}
