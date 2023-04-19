# Email Verification Project

> This project is one of my software development projects, aimed at implementing email verification for user login.
> Live demo [_here_](https://www.todo.com).

## Table of Contents

- [Project summary](#project-summary)
- [Technologies used](#technologies-used)
- [Features](#features)
- [Screenshots](#screenshots)
- [Setup](#setup)
- [Installation](#installation)

## Project Summary

This project is one of my software development projects, aimed at
implementing email verification for user login. The verification
process is a vital security feature that ensures the user logging in
is legitimate and prevents unauthorized access to the system.

The login verification feature implemented in this project will be
used in my future software development projects to ensure the security
and privacy of user data.

## Technologies Used

- Java
- Maven
- JWT for authentication
- MySql as the database
- Node.js
- React
- Redux
- Ant Design Library

## Features

- Login Page
- Registration Page
- Verification Page
- Email Verification mechanism.
- Authentication using JWT.
- Spring-boot filtering for unauthenticated access.
- Fully responsive web.
- Random session background using https://unsplash.com/.

## Screenshots

## Setup

To run the project, you need to have the following installed on your system:

- Node.js
- Yarn (Yarn - Package Manager)
- Java 8 or higher
- MySQL
- Maven (Optional)

## Installation

1. Clone the repository:

2. Install the dependencies:

- `cd front-end`
- `yarn install`

3. Start the front-end:

- `yarn start`

4. Start the back-end [Run with Maven or from supported IDEA (Eclipse, IntelliJ etc..)]

- `mvn spring-boot:run`

5. Set email credentials at /utils/EmailConstants

- `public static final String USERNAME = "{youremailhere}"`

- `public static final String PASSWORD = "{yourpasswordhere}"`
