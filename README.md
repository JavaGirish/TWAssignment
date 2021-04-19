## RestAssured Framework for THOUGHTWORKS


### Framework designed for testing below API endpoints of reqres website (https://reqres.in/)
- Register Successful
- Login Successful
- Create User
- Get List of Users
- Delete User


Manual Test Cases for Login endpoint is available in project under root path (File Name: Login_Endpoint_Manual_TC.xlsx)

### Project package Details:

1. src/main/java 

         com.tw.constants: Constants to be across in framework
         com.tw.model: PojoModel and DataObject are available here
         com.tw.specs: ResponseSpecification methods to validate responses
         com.tw.utils: Utilities and helpers methods
         
 2. src/test/java
 
			com.tw.base: TestBase class
			com.tw.factory: Factory method to build requests
			com.tw.tests: Test cases are added here
			
3. src/test/resources

			config: contains config.properties file
			responsePayloads: Contains actual response body pay loads for GET requests
			testData: JSON Data files to be used for data driving scripts
			allure.properties: config for Allure reports
	
### Command line execution can be done using Maven
Command line execution for full suite can be done via Maven, please ensure that you have installed maven in your machine <br>
Use mvn test or mvn clean install

### Test Reports using Allure
Test Run Reports will be generated via Allure Reports, please ensure that you have installed Allure Reports in your machine. <br>
If you need to install Allure in your machine, please visit: [Get Started-Allure](https://docs.qameta.io/allure/#_get_started) 

### Generate Test Reports
Post every test run, allure-results folder will be generated in target folder <br>
To generate allure reports, execute command: allure serve target/allure-results from project directory
