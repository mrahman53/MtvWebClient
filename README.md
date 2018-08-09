# MtvWebClient

This repository is Automation Framework for MTV Web Application.

## Build Requirements:

Install JDK-8

Install Maven

Install git

### get repo into your local machine:

git clone https://github.com/mrahman53/MtvWebClient.git

### Run Test Command in Terminal:

mvn test -DargLine="-DbrowserName=chrome"
mvn test -DargLine="-DbrowserName=firefox"

### Read Test Report from Terminal:

open ./ExtentReport.html

Report will open in your browser.

Test Steps will generate in console but better and details view is on ExtentReport.html

## Implementation Details:

All the dependencies are outlined in pom.xml

Selenium, TestNG, Extent Reporting.

Ideally Framework should be flexible to run in any environment and should accomodate any web application.
This framework can be modified to become scalable to add multiple application under test.

For MTV, few of the test cases are implemented as per the requirements. Some of the flow are attached to ad. So the way 
test cases were written to just get to the end but can be handled better way once you get to know more insight of the 
application and have access of the source code.






