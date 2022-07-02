package RESTful.DAOs;

import RESTful.classes.Thermometer;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "thermometerList")
public class ThermometerListXML {

    private List<Thermometer> list;

    public List<Thermometer> getList() {
        return list;
    }

    public void setList(List<Thermometer> list) {
        this.list = list;
    }
}
