package su.ezhidze.server.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRegistrationModel extends UserRegistrationModel {

    @NotNull(message = "dateOfBirth cannot be null")
    private String dateOfBirth;

    @NotNull(message = "gender field name cannot be null")
    private String gender;

    @NotNull(message = "contactNumber cannot be null")
    @Size(min = 1, message = "contactNumber should not be empty")
    @Size(max = 100, message = "contactNumber length should not be greater than 100 symbols")
    private String contactNumber;

    @NotNull(message = "address cannot be null")
    @Size(min = 1, message = "address should not be empty")
    @Size(max = 100, message = "address length should not be greater than 100 symbols")
    private String address;

    private String otherRelevantInfo;
}
