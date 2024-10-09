# Parking Lot Application

A little parking lot API I built with Spring Boot and PostgreSQL. It is configured to create a parking lot of 2 floors with 220 spaces on each floor in the PostGreSQL db.


## How to Setup 🏗️
- Make sure you have Maven, git, PostgreSQL setup and an IDE like Intellij that can run Spring Boot
- If you want to change the number of parkingspots and levels, you change that in the AppConfig.java and change a line that will update the parking in Postgres. In the application.properties file look for this line `spring.jpa.hibernate.ddl-auto=create-drop` and change it to `spring.jpa.hibernate.ddl-auto=update`
