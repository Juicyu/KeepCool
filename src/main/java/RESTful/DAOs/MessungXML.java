package RESTful.DAOs;


import javax.xml.bind.annotation.XmlElement;

public class MessungXML {

    @XmlElement
    public int thermometerID;

    @XmlElement
    public double minTemp;

    @XmlElement
    public double maxTemp;

    @XmlElement
    public String name;
}
