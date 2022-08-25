package bg.fmi.web.development.car.dealership.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Buyer {

    private String buyerName;
    private String buyerEmail;
    private String buyerPhoneNumber;
}
