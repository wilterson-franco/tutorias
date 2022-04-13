package ca.wilterson.patterns.patterns.converter.converter;

import ca.wilterson.patterns.patterns.converter.dto.UserDto;
import ca.wilterson.patterns.patterns.converter.entity.User;

public class UserConverter extends Converter<UserDto, User> {

    private static AddressConverter addressConverter;

    public UserConverter() {
        super(UserConverter::fromDto, UserConverter::fromEntity);
        addressConverter = new AddressConverter();
    }

    private static UserDto fromEntity(User user) {
        return UserDto
                .builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .isActive(user.isActive())
                .email(user.getEmail())
                .addresses(user.getAddresses()
                        .stream()
                        .map(addressConverter::convertFromEntity)
                        .toList())
                .build();
    }

    private static User fromDto(UserDto dto) {
        return User.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .isActive(dto.isActive())
                .email(dto.getEmail())
                .addresses(dto.getAddresses()
                        .stream()
                        .map(addressConverter::convertFromDto)
                        .toList())
                .build();
    }
}
