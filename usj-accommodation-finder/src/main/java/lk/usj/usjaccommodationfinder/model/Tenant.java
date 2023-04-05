package lk.usj.usjaccommodationfinder.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "TENANT")
@Getter
@Setter
public class Tenant extends BaseUser {

    @NotBlank
    @Size(min = 3, max = 60)
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotBlank
    @Size(min = 3, max = 60)
    @Column(name = "LAST_NAME")
    private String lastName;

    @NotBlank
    @Size(max = 60)
    @Email
    @Column(name = "EMAIL", unique = true)
    private String email;
}
