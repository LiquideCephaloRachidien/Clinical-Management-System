Louis Racine
If you have any questions please feel free to reach out. Thank you for visiting.
GitHub: https://github.com/LiquideCephaloRachidien
LinkedIn: https://www.linkedin.com/in/louis-racine-3a064a300

//--- CLINICAL MANAGEMENT SYSTEM (Work in progress)---//
A mini full-stack application designed to simulate a clinical database environment. This system allows healthcare providers to manage patient records through a unified interface, featuring full CRUD capabilities and data filtering.
The project is currently in progress and many details are subject to change. 



//--- Tech stack ---//
- Frontend: HTML, CSS, Vanilla JavaScript (Fetch API)
- Backend: Java Spring Boot, Maven, Spring Data JPA (REST)
- Database: MySQL, H2 
- Tools: Postman (API testing)



//--- Current state of the project ---//
- Built a RESTful API using Spring Boot to handle data operations, Maven to manage dependencies and JPA to efficiently interact with the database. The project can perform basic CRUD operations on patient objects.
- The database is currently using MySQL and H2. User can choose between the two
- HTML, CSS and vanilla JS fetch API are used to connect to the backend




//--- Current functionalities ---//
- On the web page, you can add a patient, and specify characteristics like age, gender, prescribed medication, etc.
- characteristics can be modified and deleted



//--- Known issues and limitations---//
- Exception Handling: The program does not implement rigorous exception handling yet and invalid user input may cause unexpected behavior
- Database switch: The program currently offers two database modes: H2 (default setting) or MySQL. Users need to manually change the database in the IDE if they wish to use MySQL database



//--- Setup and installation (local only) ---//
As of version 2, you can choose between two database types.

1. Clone the Repo:

    (Bash)
    git clone https://github.com/LiquideCephaloRachidien/Clinical-Management-System.git

2. Database Setup
a) H2 database: No further action is required as it is the default setting. you can proceed to step 3
b) MySQL database:
    - In an IDE, set the profile to mysql (for ex. in IntelliJ, go to Run->Edit Configurations, and set the active profile box to "mysql")
    - Create a schema named patient_db in your MySQL instance.
    - Update src/main/resources/application.properties with your username and password.
    - If you wish to revert back to H2, either empty the active profile box or set it to "h2"

Note: H2 requires no setup but has no persistence, contrary to MySQL.

3. Run the program
  - Run Backend:
      Navigate to the root and run ./mvnw spring-boot:run.
  - Run Frontend:
      Open src/main/html-css-js/website.html in any modern web browser.

//--- Foreseeable next steps ---//
- Integrate a H2 database to allow portability of the program and place it as default
- Build the back end logic to allow smooth handling of patient records and be able to perform operations such as filtering
- Improve the front end to match the general theme and refactor variables
- Add exception handling to handle invalid user data and prevent future features from crashing the program
- add program improvements to improve back end efficiency (ex. replacing arrays by hashmaps where more efficient) 

I plan on eventually connecting the open FDA API to this project so that a user can get detailed information on medication associated to patients. 





//--- Versions ---//
Version 2: Fixed: Added an H2 database. The program can now function without prior setup and features two database modes

Version 1.1: Changed default class "user" into "patient" and added medical-setting attributes to better match the overall theme of the project

Version 1: Built a locally functional java RESTful API and successfully connected it to the front end and the database
