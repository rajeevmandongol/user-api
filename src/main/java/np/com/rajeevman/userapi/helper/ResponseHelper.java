package np.com.rajeevman.userapi.helper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Helper class for creating and managing HTTP response entities and responses.
 */
public class ResponseHelper {

    /**
     * Prepares a ResponseEntity with a custom response based on the provided success status, message, and HTTP status code.
     *
     * @param success Whether the operation was successful or not.
     * @param message A message describing the result of the operation.
     * @param status  The HTTP status code to be included in the response.
     * @return A ResponseEntity with a custom response.
     */
    public static ResponseEntity<Object> prepareResponse(Boolean success, String message, HttpStatus status) {
        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("success", success);
        responseMap.put("message", message);

        return new ResponseEntity<Object>(responseMap, status);
    }


    /**
     * Prepares a ResponseEntity with a custom response based on the provided success status, message, HTTP status code, and response data.
     *
     * @param success      Whether the operation was successful or not.
     * @param message      A message describing the result of the operation.
     * @param status       The HTTP status code to be included in the response.
     * @param responseData The data to include in the response.
     * @return A ResponseEntity with a custom response.
     */
    public static ResponseEntity<Object> prepareResponse(Boolean success, String message, HttpStatus status, Object responseData) {
        Map<String, Object> responseMap = new HashMap<>();


        responseMap.put("success", success);
        responseMap.put("message", message);
        responseMap.put("data", responseData);

        return new ResponseEntity<Object>(responseMap, status);
    }


}
