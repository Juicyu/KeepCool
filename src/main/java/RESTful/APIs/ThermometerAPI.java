package RESTful.APIs;

import RESTful.DAOs.ThermometerDAO;
import RESTful.classes.Thermometer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/ThermometerAnlegen")
public class ThermometerAPI {

    @GET
    public String hallo(){
        return "Hallo!";
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void speichereThermometer(@FormParam("id") String id, @FormParam("seriennummer") String seriennummer){

        Thermometer thermometer = new Thermometer(id, seriennummer);
        ThermometerDAO thermometerDAO = new ThermometerDAO();
        thermometerDAO.speichereThermometer(thermometer);
    }
}
