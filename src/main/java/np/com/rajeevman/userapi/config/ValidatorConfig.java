package np.com.rajeevman.userapi.config;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import np.com.rajeevman.userapi.model.User;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class ValidatorConfig {

    /**
     * Validates a User object using the configured validator.
     *
     * @param newUser The User object to be validated.
     * @return A Set of validation errors.
     */
    public static Set<ConstraintViolation<User>> validateuser(User newUser){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validatorObject = factory.getValidator();

        return validatorObject.validate(newUser);
    }
}
