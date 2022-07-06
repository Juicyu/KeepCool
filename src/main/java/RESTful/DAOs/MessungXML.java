package RESTful.DAOs;


import javax.xml.bind.annotation.XmlElement;

public class MessungXML {

    @XmlElement
    public int thermometerID;

    @XmlElement
    public double minTemperature;

    @XmlElement
    public double maxTemperature;

    @XmlElement
    public String name;
}
