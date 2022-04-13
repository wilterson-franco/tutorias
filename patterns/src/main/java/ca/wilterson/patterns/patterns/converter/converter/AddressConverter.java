package ca.wilterson.patterns.patterns.converter.converter;

import ca.wilterson.patterns.patterns.converter.dto.AddressDto;
import ca.wilterson.patterns.patterns.converter.entity.Address;

public class AddressConverter extends Converter<AddressDto, Address> {

    public AddressConverter() {
        super(AddressConverter::fromDto, AddressConverter::fromEntity);
    }

    private static AddressDto fromEntity(Address address) {
        return AddressDto
                .builder()
                .streetNumber(address.getStreetNumber())
                .streetName(address.getStreetName())
                .city(address.getCity())
                .province(address.getProvince())
                .postalCode(address.getPostalCode())
                .countryName(address.getCountryName())
                .addressType(address.getAddressType())
                .build();
    }

    private static Address fromDto(AddressDto addressDto) {
        return Address
                .builder()
                .streetNumber(addressDto.getStreetNumber())
                .streetName(addressDto.getStreetName())
                .city(addressDto.getCity())
                .province(addressDto.getCity())
                .postalCode(addressDto.getPostalCode())
                .countryName(addressDto.getCountryName())
                .addressType(addressDto.getAddressType())
                .build();
    }
}
