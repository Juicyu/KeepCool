package RESTful.APIs;

import RESTful.DAOs.MesswertDAOLocal;
import RESTful.classes.Messwert;
import RESTful.classes.MesswertRueckgabe;

import javax.naming.InitialContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

            //Temperaturwert generieren
            double temp = (Math.random()*(-12)-18);

            //Temperatur formatieren
            temp = ((double)Math.round(temp * 100))/100;

            //Messwert anlegen
            int akku = 100;
            Messwert messwert = new Messwert(temp, LocalDateTime.now(), akku);
            MesswertDAOLocal messwertDAOLocal = (MesswertDAOLocal) initialContext.lookup("java:module/MesswertDAO!RESTful.DAOs.MesswertDAOLocal");
            messwert.setId(messwertDAOLocal.speichereMesswert(messwert));

            //Durchschnittstemperatur berechnen
            List<Messwert> messwertList = messwertDAOLocal.listeMesswerte();
            double gesamtTemp = 0;
            for(Messwert messwert1:messwertList){
                gesamtTemp += messwert1.getTemperatur();
            }
            String durchschnittstemperatur = df.format(gesamtTemp/messwertList.size());

            MesswertRueckgabe messwertRueckgabe = new MesswertRueckgabe(messwert.getTemperatur(),
                    messwert.getMesszeit(),
                    messwert.getAkku(),
                    messwert.getMesszeit().toLocalDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    messwert.getMesszeit().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                    durchschnittstemperatur);

            //Antworten
            return Response.accepted(messwertRueckgabe).build();
        } catch (Exception e){

        }
        return null;
    }
}
