# IoTBay Online Store 

IoTBay is a Java web application developed with Java EE 7, JSP, and Maven.

## Run

### Pre-requisites
- Java EE 7
- Netbeans 12.3
- GlassFish or other server available in Netbeans

### Run the app
1. Open the project in Netbeans
2. Run the project in Netbeans
3. Select the server (e.g. GlassFish)

The code will then be compiled and the web app should automatically be launched in the browser. Otherwise, it can be located at [localhost:8080/IoTBay](localhost:8080/IoTBay)

## Database
The official database should be automatically connected (configured in src/main/resources/META-INF/persistence.xml). 

A local version can be initialised using the postgreSQL script at src/main/resources/db.sql, but compatability with the application cannot be guaranteed.


## Assignment Responsibilities
- Shopping cart
- Ordering system
- Repo management / Integration
