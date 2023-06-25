# Book My Ticket

## Implementation

1. Application is developed in Spring Boot 3.1.1 with Java 17 on IntelliJ IDE. Database used is MySQL 8.0.

2. You can book movie tickets using the application.

3. Mandatory entities to book a ticket are - user, movie, theater with seats, shows of configured movies in configured theater with seats.


## Assumptions

For the simplicity of system, I have made following assumptions while implementing the solution -

1. Single User Model - One user will use at once. No locking implemented for seat selection.
2. Single Screen Theaters - No multiple screen handling for a theater has been done. However an option is given for future scope.
3. 10 seats for each show are configured - 5 for CLASSIC and 5 for PREMIUM. Seat numbers are kept fixed in all theaters.
4. No Payment flow used.


## Setup the Application

1. Create a database `bookmyticket`.

2. Open `src/main/resources/application.properties` and set `spring.datasource.username` and `spring.datasource.password` properties as per your MySQL installation.

3. Type `mvn spring-boot:run` from the root directory of the project to run the application.


## Setting up the data

Execute the API `http://localhost:8080/bms/initialize/generate` from swagger inside the heading `data-populator`. This will create a sample user, movie, theater, theater seats, shows, shows seats that will be used in booking ticket.


## Verifying the results from DB

1. Login to your MySQL and go to `bookmyticket` DB

2. `SELECT * FROM bookmyticket.users;` to see all registered users.

3. `SELECT * FROM bookmyticket.movies;` to see all movies.

4. `SELECT * FROM bookmyticket.theaters;` to see all theaters.

5. `SELECT * FROM bookmyticket.theater_seats;` to see all theater's seats.

6. `SELECT * FROM bookmyticket.shows;` to see all shows for movies in theaters.

7. `SELECT * FROM bookmyticket.show_seats;` to see all show's seats by type.

8. `SELECT * FROM bookmyticket.tickets;` to see all booked tickets.


## Other API Details

1. `UserController` -  API to add and get user

2. `MovieController` - API to add and get movie

3. `TheaterController` - API to add and get theater

4. `ShowController` - API to add and search show


## Future Scope

1. Multiple user handling
2. Seat locking during payment
3. Multiple Screen handling in theater
4. Seat management on the fly
5. Payment Flow
6. Login and User Account Management
