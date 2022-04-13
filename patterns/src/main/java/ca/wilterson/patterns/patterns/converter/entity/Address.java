package ca.wilterson.patterns.patterns.converter.entity;

import ca.wilterson.patterns.patterns.converter.constants.AddressType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Address {

    private int id;
    private String streetName;
    private int streetNumber;
    private String city;
    private String postalCode;
    private String province;
    private String countryName;
    private AddressType addressType;
}
