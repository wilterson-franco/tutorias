package ca.wilterson.patterns.patterns.converter.dto;

import ca.wilterson.patterns.patterns.converter.constants.AddressType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AddressDto {

    private String streetName;
    private int streetNumber;
    private String city;
    private String postalCode;
    private String province;
    private String countryName;
    private AddressType addressType;
}
