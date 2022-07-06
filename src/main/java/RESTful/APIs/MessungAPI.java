package RESTful.APIs;

import RESTful.DAOs.MessungDAOLocal;
import RESTful.DAOs.MessungXML;
import RESTful.classes.Messung;

import javax.naming.InitialContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/Messung")
public class MessungAPI {

    @POST
    @Path("/anlegen")
    @Consumes({MediaType.APPLICATION_JSON})
    public String legeMessungAn(final MessungXML messungXML){

        int messungID = -1;

        try{
            InitialContext initialContext = new InitialContext();
            MessungDAOLocal messungDAOLocal = (MessungDAOLocal) initialContext.lookup("java:module/MessungDAO!RESTful.DAOs.MessungDAOLocal");
            Messung messung = new Messung(
                    messungXML.name,
                    messungXML.minTemperature,
                    messungXML.maxTemperature,
                    messungXML.thermometerID
            );
            messung.setId(messungDAOLocal.speichereMessung(messung));
            messungID = messung.getId();

        }catch (Exception e){

        }
        return "{\"id\": " + messungID + "}";
    }
}
