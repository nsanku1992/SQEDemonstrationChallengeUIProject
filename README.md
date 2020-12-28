## Demo Challenge

#### Instructions
1. Complete the project setup as listed below
2. Complete the Excerise
3. Email a synopsis of your work and the link to your git repo containing the completed exercise to: sqedemonstrationchallenge@nbcuni.com

#### Technologies
1. Java
2. Selenium
3. TestNG
4. Any other technologies you see fit.
5. Please do not use a BDD framework.

#### Project Setup
1. Clone this project to your git account in a public repo
2. Setup the project in your IDE
3. Open the index.html file from src/test/resource/files in a browser
4. Copy the url from the browser and update the url value in src/test/resource/config.properties to be the copied url.
5. In src/test/resources update the config.properties file platform for your OS.
6. From command line run mvn clean install -U -DskipTests
7. Make sure you can run the DemoTest and chrome launches.  You may need to update the chromedriver in /src/test/resources/chromedriver/ to the version that works with your browser
   https://chromedriver.chromium.org/

#### Expectations
We will be evaluating
1. Quality of test cases
2. Variety  of testing types (examples: boundary, happy path, negative, etc)
3. Code structure and organization
4. Naming conventions
5. Code readability
6. Code modularity

#### Exercise
1. Use the site at the index.html
2. There are helper locators provided for you in the src/test/resource/files/locators.txt file.
3. In the Test Cases section below:
  - List all of the test cases you think are necessary to test the sample page
  - Note any defects or issues observed
4. Code up a few examples of:
  - At least one happy path case placing an order
  - At least one error case
5. When complete please check your code into your public git repo

#### Test Cases

We are using Page object model for automation of index.html. Index_page class is page class which is added by me. 

Also , Test Cases are divided in 3 classes as following :

###### Progression / Functional - Sanity (SanityTest.java)
 1. Place a Order and make sure you are able to place order with credit card payment - Automated
 2. Place a Order and make sure you are able to place order with Cash payment- Automated

	 
###### Progression / Functional - Positive (Functional_POS.java)

 1.  Make sure selecting pizza with n number of toppings enable only n dropdown e.g. 1 topping will enable 1 dropdown. - This functionality does not work in UI so not automated.
 2.  Make sure Cost Calculation for all kinds of Pizza is correct .  - Automated
 3.  Missing any  mandatory information must show an alert.- Automated
 4.  Clicking on Reset must clear all filled informations.- Automated
 5.  Refreshing browser must clear all fields .- Automated
 6.  Missing any  non-mandatory information must not show an alert.- Automated
 
###### Progression / Functional - Negative (Functional_NEG.java)

 1. Text Box Validations : - Automated
 
	 i.   Email Box allows value in email format only.
	 ii.  Phone number allow only digits and country code only.
	 iii. Name can't have digits.
	 iv.  Quantity does not allows anything else apart from digits.
	 
 2.  Selecting Cash / Credit Card radio button must be not allowed simulataneously. - Automated
 
 3. Closing / Crashing /refreshing browser while clicking submit must not place order - Not Automated.
 
