package np.com.rajeevman.userapi.helper;

import jakarta.validation.ConstraintViolation;
import np.com.rajeevman.userapi.config.ValidatorConfig;
import np.com.rajeevman.userapi.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public class ErrorHelper {
    /**
     * Handles the scenario when a user is not found.
     *
     * @return A ResponseEntity indicating that the user was not found with an HTTP status 404 Not Found.
     */
    public static ResponseEntity<Object> handleUserNotFound() {
        return ResponseHelper.prepareResponse(
                false,
                "User not Found",
                HttpStatus.NOT_FOUND);
    }

    /**
     * Handles the scenario when a required field is empty.
     *
     * @return A ResponseEntity indicating that a required field is empty with an HTTP status 400 Bad Request.
     */
    public static ResponseEntity<Object> handleFieldEmpty() {
        return ResponseHelper.prepareResponse(
                false,
                "All fields are required",
                HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles the scenario when the user table is empty.
     *
     * @return A ResponseEntity indicating that the user table is empty with an HTTP status 404 Not Found.
     */
    public static ResponseEntity<Object> handleUserTableEmpty() {
        return ResponseHelper.prepareResponse(
                true,
                "Users not Found",
                HttpStatus.NOT_FOUND);
    }

    /**
     * Handles unexpected errors such as Internal Server Error, No database connection, etc.
     *
     * @param e The default exception.
     * @return A ResponseEntity with an HTTP Status 500 Internal Server Error.
     */
    public static ResponseEntity<Object> handleUnexpectedErrors(Exception e) {
        e.printStackTrace();

        return ResponseHelper.prepareResponse(
                false,
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles unexpected errors.
     *
     *  @return A ResponseEntity with an HTTP Status 500 Internal Server Error.
     */
    public static ResponseEntity<Object> handleUnexpectedErrors() {

        return ResponseHelper.prepareResponse(
                false,
                "Something went wrong",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles validation errors by providing an error response based on the validation constraints.
     *
     * @param newUser The user object that failed validation.
     * @return A ResponseEntity with an error response indicating validation errors and HTTP Status 409 Conflict.
     */
    public static ResponseEntity<Object> handleValidationErrors(User newUser) {

        Set<ConstraintViolation<User>> violations = ValidatorConfig.validateuser(newUser);

        for (ConstraintViolation<User> violation : violations) {
            return ResponseHelper.prepareResponse(false, violation.getMessage(), HttpStatus.CONFLICT);
        }

        return ErrorHelper.handleUnexpectedErrors();
    }
}
