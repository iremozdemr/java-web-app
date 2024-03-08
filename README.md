[![Build Status](https://app.travis-ci.com/iremozdemr/java-web-app.svg?token=ymX6sLjyqBoVrXFpXx2K&branch=main)](https://app.travis-ci.com/iremozdemr/java-web-app)

# Student Success Evaluation System

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Introduction
The Student Success Evaluation System is a web application designed to evaluate the success of students based on their grades and other criteria. It allows users to input their personal information, grades, and lectures, and then calculates whether the student is successful or not.

## Features
- Evaluate student success based on grades and other criteria.
- Dynamic web interface using Spark Framework.
- Simple and intuitive user interface.

## Prerequisites
Before you begin, ensure you have met the following requirements:
- Java Development Kit (JDK) 8 or higher installed on your machine.
- Apache Maven installed on your machine to build the project.
- Basic knowledge of Java programming and web development concepts.

## Installation
To install and run this application, follow these steps:
1. Clone the repository to your local machine:
   ```sh
   git clone https://github.com/iremozdemr/java-web-app.git
2. Navigate to the project directory:
   ```sh
   cd myDemoApp
3. Build the project using Maven:
   ```sh
   mvn clean package
4. Run the application:
   ```sh
   java -jar target/myDemoApp.jar
5. Acess the application in your web browser at http://localhost:4567.
  

## Usage

To use the Student Success Evaluation System, follow these steps:

1. Open your web browser and navigate to the application URL (e.g., [http://localhost:4567](http://localhost:4567)).
2. Fill out the evaluation form with the required information:
   - Full Name
   - Age
   - Term 1 Notes (comma-separated)
   - Term 2 Notes (comma-separated)
   - Term 1 Lectures (comma-separated)
   - Term 2 Lectures (comma-separated)
3. Click on the "Evaluate" button to see the evaluation result.

## Contributing

Contributions are welcome! Here's how you can contribute to this project:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature`).
3. Make your changes.
4. Commit your changes (`git commit -am 'Add new feature'`).
5. Push to the branch (`git push origin feature`).
6. Create a new Pull Request.

## License