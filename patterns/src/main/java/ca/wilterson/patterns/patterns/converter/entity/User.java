package ca.wilterson.patterns.patterns.converter.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {

    private String id;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String email;
    @Singular
    private List<Address> addresses;
}
