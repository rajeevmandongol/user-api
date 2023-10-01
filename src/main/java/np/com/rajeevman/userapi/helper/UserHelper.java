package np.com.rajeevman.userapi.helper;

import jakarta.validation.ConstraintViolation;
import np.com.rajeevman.userapi.config.ValidatorConfig;
import np.com.rajeevman.userapi.model.User;

import java.util.Set;

public class UserHelper {

    /**
     * Checks if any required fields in the User object are empty.
     *
     * @param user The User object to be checked.
     * @return true if any required fields are empty, otherwise false.
     */
    public static Boolean checkEmptyFields(User user) {
        return user.getName() == null
                || user.getEmail() == null
                || user.getPhone() == null;
    }

    /**
     * Checks if the user table is empty.
     *
     * @param userCount The count of users in the user table.
     * @return true if the user table is empty, otherwise false.
     */
    public static Boolean checkUserTableEmpty(long userCount){

        return userCount == 0;
    }

    /**
     * Checks for validation errors in a User object.
     *
     * @param newUser The User object to be checked for validation errors.
     * @return true if validation errors are found, otherwise false.
     */
    public static boolean checkValidationErrors(User newUser) {
        Set<ConstraintViolation<User>> violations = ValidatorConfig.validateuser(newUser);

        return violations.isEmpty();
    }
}
