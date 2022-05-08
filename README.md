# SpringMVCFilmCRUD


## Overview
This team project saw three individuals putting several technologies and design patterns into practice to produce a Full-Stack project that creates, reads, updates, and deletes (CRUD) from a film database while collaborating remotely via Zoom and Slack. The user starts on a welcome page with the option to search for a film by ID or Keyword, and to add a new film. The user stories below describe each option the user has in more detail.

## User Stories

* **Story 1:** A user can enter a Film's ID and see the details of the film in a web page. If the film is not found, they are redirected to a custom error page.
* **Story 2:** A user can choose to add a new film. They can enter all the properties of the film. Their input will be used to create Film object, which the DAO implementation will save in the database. If, for any reason, the insertion to the database fails, the user is redirected to a custom error page.
* **Story 3:** When a user retrieves a film, they have the option of deleting it.
* **Story 4:** When a user retrieves a film, they have the option of editing or deleting it. If the film is successfully deleted or update, the user is redirected to the home page, and if either operation is unsuccessful, the user is redirected to a custom error page.
* **Story 5:** A user can search for films using a keyword, if any films have that keyword the are listed on a webpage, each with the same options as when an individual film is displayed.
* **Story 6:** When a film's details are displayed, its actors and categories are also listed.

## Technologies 

* Java
* Spring MVC
* Spring Tool Suite
* Tomcat Server
* HTML
* MAMP
* SQL
* Git
* mySQL


## Project Owners
[Mason Keeney](https://github.com/Mason-Keeney)
<br>
[Nick Gonzalez](https://github.com/gonzanick)
<br>
[Jacob Nguyen](https://github.com/jacobello)
