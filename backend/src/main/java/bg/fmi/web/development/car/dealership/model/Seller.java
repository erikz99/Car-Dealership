package bg.fmi.web.development.car.dealership.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Seller {

    private String sellerName;
    private String sellerEmail;
    private String sellerPhoneNumber;
}
