# Customer Management Service API 🧾

API for managing client data as part of the technical challenge for the DXC. This API provides a set of endpoints, allowing users to:

1. Retrieve all clients.
2. Retrieve a client by ID.
3. Create a new client.
4. Update a client's information.
5. Delete a client.

## Technologies Used 🛠️

| Technology            | Description                                                                                    |
|-----------------------|----------------------------------------------------------------------------------------------|
| ⚙️ Spring Boot         | Java framework for developing web applications and RESTful APIs.                              |
| 💾 Spring Data JPA     | Spring library for integrating with relational databases using JPA.                             |
| 🌐 Spring Web          | Spring module for building web applications with REST API support.                             |
| 🏷️ Spring Validation   | Spring library for data validation and error handling.                         |
| 🔑 H2 Database         | Database used to store client data.                                                  |

## API Endpoints 🚀

The table below lists all the available endpoints in the API along with their descriptions:

| Endpoint                                      | Method   | Route                             | Payload                                                | Parameters                                                  | Description                                                          |
|-----------------------------------------------|----------|-----------------------------------|--------------------------------------------------------|-------------------------------------------------------------|--------------------------------------------------------------------|
| 🔒 Create a new client                         | ✉️ POST   | /client                           | ClientRequestDTO (`{"firstName": "Mac", "lastName": "Lovin", "email": "maclovin@example.com", "cpf": "12345678901", "birthDate": "1990-01-01"}`)       | -                                                           | Create a new client                                           |
| 🔍 Retrieve all clients                        | 🔎 GET    | /client                           | -                                                      | -                                                           | Retrieve all clients                                          |
| 🔍 Retrieve a client by ID                     | 🔎 GET    | /client/{id}                      | -                                                      | id (Long, required = true)                                  | Retrieve a client by ID                                       |
| 🔄 Update a client's information               | 🔄 PUT    | /client/{id}                      | ClientRequestDTO (`{"firstName": "Updated", "lastName": "Name", "email": "updated@example.com", "cpf": "12345678901", "birthDate": "1990-01-01"}`)  | id (Long, required = true)                                  | Update a client's information                                  |
| ❌ Delete a client                             | 🗑️ DELETE | /client/{id}                      | -                                                      | id (Long, required = true)                                  | Delete a client                                                |

## Running the Project ▶️

Follow the steps below to run the project in your development environment:

1. Ensure that you have Docker and Docker Compose installed on your machine.
2. Clone the project repository using the command `git clone https://github.com/ulissesassuncao/customer-manegement-service.git`.
3. Navigate to the project directory.
4. Run the command `docker-compose up -d` to start the project containers.
