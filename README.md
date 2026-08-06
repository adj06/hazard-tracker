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

## The function of the application

* **CRUD:** Create, view, update, and delete hazard reports from db.
* **Status updates:** Able to change the status of a hazard as it gets worked on (changing the status from "REPORTED" to "RESOLVED")
* **Testing:** I wrote automated tests using mock databases which makes sure my logic works the way intended without accidentally ruining data.
* **Preloaded data:** When my app starts, it injects sample hazards into the database so you can start testing straight away.

## How to run the project

1. **Download my code:**
   ```bash
   git clone [https://github.com/adj06/hazard-tracker.git](https://github.com/adj06/hazard-tracker.git)
    ```
2. **Build the container**
    ```bash
    docker build -t hazard-tracker .
   ```

3. **Start the application**
    ```bash
    docker run -p 8080:8080 \
    -e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/hazard_db \
    -e SPRING_DATASOURCE_USERNAME=postgres \
    -e SPRING_DATASOURCE_PASSWORD="Password" \
    hazard-tracker
    ```
   
## What I learnt

This was my first ever Spring Boot and REST API project which was quite a big step up from my usual university projects. It really helped me understand what is expected in industry and helped me gain a lot of knowledge on backend system architecture.

My biggest takeaways from this project include:

* **Building a RESTful API from scratch:** I learned how to handle HTTP requests, design working endpoints, and separate my code into a Controller layer, a Service layer, and a Repository layer to make sure my data was managed efficiently.
* **Containerisation:** It made me realise why Docker is used in industry throughout major projects. It is crucial to wrap the application and the environment into a deployable image which is able to run on any machine.
* **Testing with Mockito:** I learned how to properly test the business logic by mocking the database layer. I realised you don't need a live db connection in order to test the functionality and made sure to write fast and robust unit tests.
* **API documentation:** I used Swagger UI which was able to make the API look like a real webpage. It made it easy to test my endpoints which made me realise the backend part is only half of it.
* **Choosing manual code over Lombok:** I knew a tool that I could use called Lombok which would automatically generate repetitive code such as getters, setters, and constructors. However, it was my first project and wanted to write it all out myself which for me personally helped to make the code readable and understandable.

## What to do next

This is my first backend project and I will hopefully improve it over time as I learn more.

* **Building a User Interface:** Creating a frontend UI such as a webpage or mobile app so that people are easily able to report any hazard they see on the road.
* **Login and Security:** Adding a security layer so that users have an account to track hazards.
* **Integration of maps:** Connecting the API to Google Maps, where when a hazard is reported it can save the GPS coordinates automatically instead of the user inputting it in themselves.
* **Cloud integration:** The app runs on my computer locally using Docker however I want to possibly deploy it to a cloud server so that anyone can access it over the internet.

   
