package np.com.rajeevman.userapi.service;


import np.com.rajeevman.userapi.helper.ErrorHelper;
import np.com.rajeevman.userapi.helper.ResponseHelper;
import np.com.rajeevman.userapi.helper.UserHelper;
import np.com.rajeevman.userapi.model.User;
import np.com.rajeevman.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<Object> getAllUsers() {

        try {

            long userCount = userRepository.count();

            if (UserHelper.checkUserTableEmpty(userCount)) {
                return ErrorHelper.handleUserTableEmpty();
            }

            return ResponseHelper.prepareResponse(
                    true,
                    "Users found",
                    HttpStatus.OK,
                    userRepository.findAll());

        } catch (Exception e) {
            return ErrorHelper.handleUnexpectedErrors(e);
        }
    }

    public ResponseEntity<Object> addUser(User newUser) {
        try {
            if (UserHelper.checkEmptyFields(newUser)) {
                return ErrorHelper.handleFieldEmpty();
            }

            if (!UserHelper.checkValidationErrors(newUser)) {
                return ErrorHelper.handleValidationErrors(newUser);
            }

            userRepository.save(newUser);

            return ResponseHelper.prepareResponse(
                    true,
                    "User created successfully",
                    HttpStatus.CREATED);

        } catch (Exception e) {
            return ErrorHelper.handleUnexpectedErrors(e);
        }
    }

    public ResponseEntity<Object> getUserById(Integer id) {
        try {
            Optional<User> existingUser = userRepository.findById(id);

            if (existingUser.isPresent()) {
                return ResponseHelper.prepareResponse(
                        true,
                        "User Found",
                        HttpStatus.OK,
                        userRepository.findById(id));
            } else {
                return ErrorHelper.handleUserNotFound();
            }
        } catch (Exception e) {
            return ErrorHelper.handleUnexpectedErrors(e);
        }
    }


    public ResponseEntity<Object> updateUserById(Integer id, User updatedUser) {

        try {
            if (UserHelper.checkEmptyFields(updatedUser)) {
                return ErrorHelper.handleFieldEmpty();
            }

            if (!UserHelper.checkValidationErrors(updatedUser)) {
                return ErrorHelper.handleValidationErrors(updatedUser);
            }

            Optional<User> existingUser = userRepository.findById(id);

            if (existingUser.isPresent()) {
                User user = existingUser.get();

                user.setName(updatedUser.getName());
                user.setEmail(updatedUser.getEmail());
                user.setPhone(updatedUser.getPhone());

                userRepository.save(user);

                return ResponseHelper.prepareResponse(
                        true,
                        "User updated successfully",
                        HttpStatus.OK, user);

            } else {
                return ErrorHelper.handleUserNotFound();
            }
        } catch (Exception e) {
            return ErrorHelper.handleUnexpectedErrors(e);
        }
    }

    public ResponseEntity<Object> deleteUserById(Integer id) {
        try {
            if (userRepository.existsById(id)) {

                userRepository.deleteById(id);

                return ResponseHelper.prepareResponse(
                        true,
                        "User deleted successfully",
                        HttpStatus.NO_CONTENT);

            } else {
                return ErrorHelper.handleUserNotFound();
            }
        } catch (Exception e) {
            return ErrorHelper.handleUnexpectedErrors(e);
        }
    }
}
