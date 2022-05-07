# Dancing With Death
 
[![](https://forthebadge.com/images/badges/built-with-love.svg)](https://github.com/acamus79/Dancing-With-Death) [![](https://forthebadge.com/images/badges/check-it-out.svg)](https://acamus79.github.io/dwd/) [![](https://forthebadge.com/images/badges/made-with-java.svg)](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)

##

DwD is a web application developed for educational purposes, it was developed in JAVA 11 with Spring Boot and Postgres SQL for the BackEnd; JavaScript and Html-CSS for the FrontEnd, for its development 146 hours of coding were necessary and the following technologies were used:

##

<div style="display: inline_block">
<br>
<img align="center" alt="JAVA" height="84" width="84" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg">
<img align="center" alt="SPRING" height="84" width="84" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg">
<img align="center" alt="POSTGRESSQL" height="84" width="84" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-plain-wordmark.svg">
<img align="center" alt="HEROKU" height="84" width="84" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/heroku/heroku-plain-wordmark.svg">
<img align="center" alt="JAVASCRIPT" height="84" width="84" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/javascript/javascript-original.svg" />
<img align="center" alt="HTML" height="84" width="84" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/html5/html5-original.svg">
<img align="center" alt="CSS" height="84" width="84" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/css3/css3-original.svg">
<img align="center" alt="BOOTSTRAP" height="84" width="84" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/bootstrap/bootstrap-original.svg" />
</div>

##

> BackEnd: 

A REST API for programming dance with death quotes The API has to be implemented as a CRUD that keeps appointments, intended to be consumed in a web client.

- The system must not allow booking more than 1 appointment per hour.
- Hours should be set for office hours (9 am to 6 pm Monday through Friday) year-round
- Death is very demanding with its schedule, so each the appointment must contain date, start time and contact of information (such as email).
- You can only date with Death for 1 hour, more would be useless. less would be too much traumatic.

To develop this API I have used Java 11 with Maven and Spring Boot 2.6.5; PostgreSQL 14, although it was also tested on MySQL.

> FrontEnd: 
 
A web client for the API you just created, 

- The first layout will display a date picker.
- If you click on any date, the available time slots will be displayed on the screen to be selected.
- When you create an appointment, you get a unique code to be able to edit that appointment, in QR code format
- Death needs to see all the appointments and since he likes to handle the data he also wants to export it to excel

I use [jquery.qrcode.js](https://github.com/jeromeetienne/jquery-qrcode) a jquery plugin for a pure browser qrcode generation.

Also use [TableExport.js](https://github.com/clarketm/TableExport) to export the data table.

The CSS is mostly the [Bootswatch](https://bootswatch.com/) LUX theme, with personal modifications, I think a little more work needs to be done on responsiveness

The background image is my own design.

##

If you misread or don't understand me, don't blame me it was [GoogleTranslator](https://translate.google.com.ar/)

##

[![](https://forthebadge.com/images/badges/works-on-my-machine.svg)](https://github.com/acamus79)
