package ca.wilterson.patterns.patterns.converter;

import static org.assertj.core.api.Assertions.assertThat;

import ca.wilterson.patterns.patterns.converter.constants.AddressType;
import ca.wilterson.patterns.patterns.converter.converter.UserConverter;
import ca.wilterson.patterns.patterns.converter.dto.AddressDto;
import ca.wilterson.patterns.patterns.converter.dto.UserDto;
import ca.wilterson.patterns.patterns.converter.entity.Address;
import ca.wilterson.patterns.patterns.converter.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserConverterTest {

    UserConverter userConverter;

    @BeforeEach
    void setup() {
        userConverter = UserConverter.singleton;
    }

    @Test
    void convertUserDtoToUserEntity() {
        var dtoUser = UserDto
                .builder()
                .firstName("John")
                .lastName("Doe")
                .isActive(true)
                .email("whatever@wherever.com")
                .address(AddressDto
                        .builder()
                        .streetNumber(904)
                        .streetName("Whiteford Way")
                        .city("Kanata")
                        .province("Ontario")
                        .postalCode("K2M 0C9")
                        .countryName("Canada")
                        .addressType(AddressType.RESIDENCIAL)
                        .build())
                .build();

        var user = userConverter.convertFromDto(dtoUser);

        assertThat(user.getFirstName()).isEqualTo("John");
        assertThat(user.getLastName()).isEqualTo("Doe");
        assertThat(user.isActive()).isTrue();
        assertThat(user.getEmail()).isEqualTo("whatever@wherever.com");
        assertThat(user.getAddresses()).hasSize(1);
        Address address = user.getAddresses().get(0);
        assertThat(address.getStreetNumber()).isEqualTo(904);
        assertThat(address.getStreetName()).isEqualTo("Whiteford Way");
        assertThat(address.getCity()).isEqualTo("Kanata");
        assertThat(address.getPostalCode()).isEqualTo("K2M 0C9");
        assertThat(address.getCountryName()).isEqualTo("Canada");
    }

    @Test
    void convertUserEntityToDto() {
        var user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .isActive(true)
                .email("whatever@wherever.com")
                .address(Address
                        .builder()
                        .streetNumber(904)
                        .streetName("Whiteford Way")
                        .city("Kanata")
                        .province("Ontario")
                        .postalCode("K2M 0C9")
                        .countryName("Canada")
                        .addressType(AddressType.RESIDENCIAL)
                        .build())
                .build();

        var userDto = userConverter.convertFromEntity(user);

        assertThat(userDto.getFirstName()).isEqualTo("John");
        assertThat(userDto.getLastName()).isEqualTo("Doe");
        assertThat(userDto.isActive()).isTrue();
        assertThat(userDto.getEmail()).isEqualTo("whatever@wherever.com");
        assertThat(userDto.getAddresses()).hasSize(1);
        AddressDto addressDto = userDto.getAddresses().get(0);
        assertThat(addressDto.getStreetNumber()).isEqualTo(904);
        assertThat(addressDto.getStreetName()).isEqualTo("Whiteford Way");
        assertThat(addressDto.getCity()).isEqualTo("Kanata");
        assertThat(addressDto.getPostalCode()).isEqualTo("K2M 0C9");
        assertThat(addressDto.getCountryName()).isEqualTo("Canada");
    }
}