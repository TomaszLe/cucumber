# Overview
This is a QA project using Selenium, Maven and Cucumber.
There is onu one branch: master, where you can find feature file and jenkins file.

#Application overview
Test are running at http://www.kurs-selenium.pl/demo/ web page. It's a web page where customers can:

Find and book flights and hotels, rent a car, create new user account, log in to existent account.

#Prerequisites
java (16.0.2),
JDK 16 or above,
maven (3.8.2).

#Running
1. Clone repo.
2. Go to project folder.
3. Run "mvn clean test" command in a terminal or command line.

or

You can run this test using Jenkins as well.

#Reporting
Cucumber reports you can find here:
target/index.html and also as json file target/cucumber.json

For online cucumber reports, please change settings in cucumber.properties file.