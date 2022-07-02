package RESTful.APIs;

import RESTful.DAOs.ThermometerDAOLocal;
import RESTful.DAOs.ThermometerXML;
import RESTful.classes.Thermometer;
import com.google.gson.Gson;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

//http://localhost:8080/KeepCool-1.0/KeepCool/Thermometer/hallo
@Path("/Thermometer")
public class ThermometerAPI {

    @GET
    @Path("/hallo")
    public String hallo(){
        return "Hallo!";
    }

    @POST
    @Path("/anlegen")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response speichereThermometer(final ThermometerXML thermometerXML){
        try {
            InitialContext context = new InitialContext();
            ThermometerDAOLocal thermometerDAOLocal = (ThermometerDAOLocal) context.lookup("java:module/ThermometerDAO!RESTful.DAOs.ThermometerDAOLocal");
            int id = Integer.parseInt(thermometerXML.id);

            Thermometer thermometer = new Thermometer(id, thermometerXML.name);
            System.out.println(thermometer.getId());
            System.out.println(thermometer.getName());
            thermometerDAOLocal.speichereThermometer(thermometer);
            Response.ResponseBuilder ok = Response.accepted();
            return ok.build();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("/alle")
    @Produces("text/json")
    public Response alleThermometer(){
        try {
            InitialContext context = new InitialContext();
            ThermometerDAOLocal thermometerDAOLocal = (ThermometerDAOLocal) context.lookup("java:module/ThermometerDAO!RESTful.DAOs.ThermometerDAOLocal");
            List<Thermometer> thermometerList = thermometerDAOLocal.listeThermometer();
            String json = new Gson().toJson(thermometerList);
            System.out.println(json);
            return Response.accepted(thermometerList).build();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
