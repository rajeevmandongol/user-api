package np.com.rajeevman.userapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Pattern(regexp = "^[A-Za-z\\ ]+$", message = "Provide a valid name")
    private String name;

    @Email(message = "Provide a valid e-mail")
    private String email;


    @Pattern(regexp = "^9[0-9]{9}$", message = "Provide a valid mobile number")
    private String phone;

    public void setName(String name) {
        this.name = name.trim();
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    public void setPhone(String phone) {
        this.phone = phone.trim();
    }
}
