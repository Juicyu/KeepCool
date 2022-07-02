package RESTful.APIs;

import RESTful.DAOs.MesswertDAOLocal;
import RESTful.classes.Messwert;

import javax.naming.InitialContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;

@Path("/Messwert")
@Produces("text/json")
public class MesswertAPI {

    @Path("/messen")
    @GET
    public Response messeTemperatur(){

        try{
            InitialContext initialContext = new InitialContext();
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(2);
            double temp = Math.random()*(-12)-18;
            int akku = 100;
            Messwert messwert = new Messwert(temp, LocalDateTime.now(), akku);
            MesswertDAOLocal messwertDAOLocal = (MesswertDAOLocal) initialContext.lookup("java:module/MesswertDAO!RESTful.DAOs.MesswertDAOLocal");            messwert.setId(messwertDAOLocal.speichereMesswert(messwert));
            List<Messwert> messwertList = messwertDAOLocal.listeMesswerte();
            double gesamtTemp = 0;
            for(Messwert messwert1:messwertList){
                gesamtTemp += messwert1.getTemperatur();
            }
            String durchschnittstemperatur = df.format(gesamtTemp/messwertList.size());
            System.out.println("Messwert-ID: " + messwert.getId() +
                    "\nDatum: " + messwert.getMesszeit().toLocalDate() +
                    "\nUhrzeit " +messwert.getMesszeit().toLocalTime() +
                    "\naktuelle Temperatur: " + df.format(messwert.getTemperatur()) + " °C" +
                    "\nDurchschnittstemperatur: " + durchschnittstemperatur + " °C" +
                    "\nAkkustand: " + messwert.getAkku() +
                    "\n----------------------------------------");
            return Response.accepted(messwert).build();
        } catch (Exception e){

        }
        return null;
    }
}
