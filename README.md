# User API

User API is a RESTful web service designed to store and manage user information, including name, email, and phone, using the Spring Boot framework.

Access the API using **postman** at http://127.0.0.1:8080/

## Usage

### API Endpoints

| HTTP method | URL           | Status                                               | Description                            |
| :---------- | :------------ |:-----------------------------------------------------| :------------------------------------- |
| `POST`      | `/users`      | **201 or (409 Conflict) if Validation Error Occurs** | `Create a new user.`                   |
| `GET`       | `/users`      | **200 or (204 No Content) if no user found**         | `Retrieve a list of all users.`        |
| `GET`       | `/users/:id`  | **200 or (404 Not Found) if User not found**         | `Retrieve a user by their ID.`         |
| `PUT`       | `/users/:id`  | **200 (404 Not Found) if User not found**            | `Update a user by their ID.`           |
| `DELETE`    | ` /users/:id` | **200 or (404 Not Found) if User not found**         | ` Delete a user by their ID.`          |


## Built With

-   Spring Web
-   MySQL

