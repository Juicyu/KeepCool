package RESTful.APIs;

import RESTful.DAOs.ThermometerDAOLocal;
import RESTful.DAOs.ThermometerXML;
import RESTful.classes.Thermometer;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

//http://localhost:8080/deployments/KeepCool/ThermometerAnlegen
@Path("/ThermometerAnlegen")
public class ThermometerAPI {

    @GET
    public String hallo(){
        return "Hallo!";
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void speichereThermometer(final ThermometerXML thermometerXML){
        try {
            InitialContext context = new InitialContext();
            ThermometerDAOLocal thermometerDAOLocal = (ThermometerDAOLocal) context.lookup("java:module/ThermometerDAO!RESTful.DAOs.ThermometerDAOLocal");
            int id = Integer.parseInt(thermometerXML.id);

            Thermometer thermometer = new Thermometer(id, thermometerXML.name);
            System.out.println(thermometer.getId());
            System.out.println(thermometer.getName());
            thermometerDAOLocal.speichereThermometer(thermometer);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
