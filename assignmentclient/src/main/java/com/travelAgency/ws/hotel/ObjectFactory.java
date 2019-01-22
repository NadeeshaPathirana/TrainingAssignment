
package com.travelAgency.ws.hotel;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.travelAgency.ws.hotel package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddHotel_QNAME = new QName("http://ws.travelAgency.com/", "addHotel");
    private final static QName _GetHotelResponse_QNAME = new QName("http://ws.travelAgency.com/", "getHotelResponse");
    private final static QName _GetHotel_QNAME = new QName("http://ws.travelAgency.com/", "getHotel");
    private final static QName _AddHotelResponse_QNAME = new QName("http://ws.travelAgency.com/", "addHotelResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.travelAgency.ws.hotel
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddHotel }
     * 
     */
    public AddHotel createAddHotel() {
        return new AddHotel();
    }

    /**
     * Create an instance of {@link GetHotelResponse }
     * 
     */
    public GetHotelResponse createGetHotelResponse() {
        return new GetHotelResponse();
    }

    /**
     * Create an instance of {@link GetHotel }
     * 
     */
    public GetHotel createGetHotel() {
        return new GetHotel();
    }

    /**
     * Create an instance of {@link AddHotelResponse }
     * 
     */
    public AddHotelResponse createAddHotelResponse() {
        return new AddHotelResponse();
    }

    /**
     * Create an instance of {@link Hotel }
     * 
     */
    public Hotel createHotel() {
        return new Hotel();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddHotel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.travelAgency.com/", name = "addHotel")
    public JAXBElement<AddHotel> createAddHotel(AddHotel value) {
        return new JAXBElement<AddHotel>(_AddHotel_QNAME, AddHotel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHotelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.travelAgency.com/", name = "getHotelResponse")
    public JAXBElement<GetHotelResponse> createGetHotelResponse(GetHotelResponse value) {
        return new JAXBElement<GetHotelResponse>(_GetHotelResponse_QNAME, GetHotelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHotel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.travelAgency.com/", name = "getHotel")
    public JAXBElement<GetHotel> createGetHotel(GetHotel value) {
        return new JAXBElement<GetHotel>(_GetHotel_QNAME, GetHotel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddHotelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.travelAgency.com/", name = "addHotelResponse")
    public JAXBElement<AddHotelResponse> createAddHotelResponse(AddHotelResponse value) {
        return new JAXBElement<AddHotelResponse>(_AddHotelResponse_QNAME, AddHotelResponse.class, null, value);
    }

}
