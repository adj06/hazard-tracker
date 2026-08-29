# Hazard Tracker API

I have built this backend API which is able to track local community hazards such as potholes, broken streetlights, flooding, worn out road markings, etc.

I made sure to build my API in a way a professional software engineer would. I focused on clean code, making sure it works as intended with automated tests, and packaging it using Docker to make sure that anyone is able to run it instantly on their computer.

## Stack I Used
* **Language:** Java 21
* **Framework:** Spring Boot, Spring Data JPA
* **Database:** PostgreSQL
* **Testing:** JUnit5, Mockito
* **Containerisation:** Docker
* **Documentation:** Swagger

## Features
### Management
* Create hazard reports
* Retrieve all hazards
* Retrieve a hazard by its ID
* Update status of a hazard
* Validation for required fields
* Prevent duplicate hazards from being reported at the same location
* Record when a hazard was reported and last updated

### Classification
* Type - pothole, flooding, broken streetlight, etc.
* Severity - low, medium, high, or urgent
* Status - reported, scheduled, under review, resolved, or dismissed
* GPS coordinates
* Description
* Reported/Updated times

### Testing

I used JUnit 5 and Mockito to test the business logic of the API.

Repository layer is mocked in the unit tests which allows the service layer to be tested without connecting to the live database.

My tests cover:

* Hazards being created successfully
* Duplicate hazards being rejected
* Hazard status updates
* Handling hazard IDs which don't exist

### API Documentation

I used Swagger UI which provided me with interactive API documentations to test my endpoints straight from a browser.

### Preloaded Data 

There are sample hazard reports loaded into my PostgreSQL database when the application starts which allowed me to test the API straight away.

## Architecture

Application follows typical REST API structure using controller, dto, service, and repository layers.

Controller: Handles the HTTP requests and responses.
DTO: Separates API request and response data from the entities in the database.
Service: Business logic for the application such as detection for duplicates and updating status.
Repository: Spring JPA communication with database.
   
## What I learned

This was my first Spring Boot and REST API project and was quite a bit of a step up from my usual university projects. It really helped me understand how backend applications are structures and gave me practical experience with the technology used in backed software engineering.

### RESTful API Development

How to design REST endpoints and how to handle different HTTP requests using Spring Boot. I also learned how to separate different responsibilities between the Controller, Service, and Repository layers.

### DTOs

Using request and response DTOs helped separate API data from database entity.

### Database persistence

Retrieving Java objects from a relational database with the use of Spring Data JPA, Hibernate, and PostgreSQL.

### Testing 

Mocking the repository which allowed me to test the service layer without touching the database. Making efficient and reliable unit tests for key functionality.

## API Documentation

Swagger provided me with an interactive testing interface which allowed me to test the API and made the endpoints easeier to understand and use.

## Java

While researching the technology stack, I came across quite a useful Java library called Lombok which uses annotations to automatically generate repetitive code like getters, setters, and constructors. I made sure not to use Lombok as writing the code manually made it easier for me to understand the structure of my application and how each component connects together.

## What to do next

This is my first backend project and I will hopefully improve it over time as I learn more.

* **Building a User Interface:** Creating a frontend UI such as a webpage or mobile app so that people are easily able to report any hazard they see on the road.
* **Login and Security:** Adding a security layer so that users have an account to track hazards.
* **Integration of maps:** Connecting the API to Google Maps, where when a hazard is reported it can save the GPS coordinates automatically instead of the user inputting it in themselves.
* **Cloud integration:** The app runs on my computer locally using Docker however I want to possibly deploy it to a cloud server so that anyone can access it over the internet.

   
