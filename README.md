//--- CLINICAL MANAGEMENT SYSTEM (Work in progress)---//
A mini full-stack application designed to simulate a clinical database environment. This system allows healthcare providers to manage patient records through a unified interface, featuring full CRUD capabilities and data filtering.
The project is currently in progress and many details are subject to change. 


//--- Tech stack ---//
- Frontend: HTML, CSS, Vanilla JavaScript (Fetch API)
- Backend: Java Spring Boot, Maven, Spring Data JPA (REST)
- Database: MySQL (current), H2 (planned)
- Tools: Postman (API testing)


//--- Current state of the project ---//
- I built an RESTful API using Spring Boot to handle data operations, Maven to manage dependencies and JPA to efficiently interact with the database. The project can perform basic CRUD operations on an object named "user"
- The database is currently using MySQL.
- HTML, CSS and vanilla JS fetch API are used to connect to the backend


//--- Known issues and limitations---//
- Portability: The database is currently hardcoded to a local MySQL instance. To run this on another machine, the application.properties must be manually updated.
- Exception Handling: The program does not implement exception handling yet and invalid user input may cause unexpected behavior


//--- Setup and installation (local only) ---//
As of version 1, a local MySQL installation is required to run this project.

Setup & Installation (Local Only)
Note: As of Version 1, a local MySQL installation is required to run this project.

1. Clone the Repo:

    (Bash)
    git clone https://github.com/LiquideCephaloRachidien/Clinical-Management-System.git


2. Database Setup:
    - Create a schema named crudusers in your MySQL instance.
    - Update src/main/resources/application.properties with your username and password.
    - Run Backend:
        Navigate to the root and run ./mvnw spring-boot:run.
    - Run Frontend:
        Open index.html in any modern web browser.

//--- Forseeable next steps ---//
1. Integrate a H2 database to allow portability of the program and place it as default
2. Build the back end logic to allow smooth handling of patient records and be able to perform operations such as filtering
3. Improve the front end to match the general theme and refactor variables
4. Add exception handling to handle invalid user data or missing files
5. add program improvements to improve back end efficiency (ex. replacing arrays by hashmaps where more efficient) 


//--- Versions ---//
Version 1: Built a functional (locally) java RESTful API and successfully connected it to the front end and the database