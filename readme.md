# Getting Started With Spring Boot & Cucumber
> Integraiotn testing a Spring Boot Application using BDD Framework called Cucumber


<details>
    <summary>Synopsis</summary>
 
* [Objectives](#objectives)
* [Pre-requisites](#pre-requisites)
* [Project Structure](#project-structure)
* [Running the Project](#running-the-project)

</details>


## Objectives
Learn how to use BDD framework Cucumber with Spring Boot application to run integration tests.  
Explore various development recommendations for working with Cucumber.

## Pre-requisites

### Framework/Language Knowledge

Following topics should be clear before starting with Spring Boot Cucumber:  

* Developing Restful API with Spring Boot _(for developing testable rest-api)_
* Writing Unit tests using JUnit _(for writing assertions)_
* Creating multi-module maven project

### IDE/Tools Setup
Following are the tools & setup I used for developing this application.

* **Development Kit**, 1.8.0_281 (x86_64) By "Oracle Corporation"
* **Project Management**, Apache Maven 3.6.1
* **IDE**, IntelliJ IDEA 2021.3
* **Plugins**, Gherkin, Cucumber for Java (bundled with IntelliJ)

## Project Structure
The project consists of 3 submodules divided into `main`, `it` & `interface`.  

* The `main` module houses the Rest APIs which needs to be integration tested.  
* The `it` module consists of the Cucumber Test that will be tested against the Rest APIs in `main` module
* The `interface` module consists of domain objects that are used state sharing _(like request, response, entity, 
  etc.)_ 

## Running the Project
Currently, the project is work-in-progress, so you won't be able to run it directly from Maven.
For running, 

* clone/download the project and go to `**-main` module and run
  * ```mvn clean spring-boot:run```
* once the application has started, go to `**-it` module and run
  * ```mvn clean test -Dcucumber.options="--tags @validation"```

<hr/>

### Important References

* [Cucumber - Official API Docs](https://cucumber.io/docs/cucumber/)
* [BDD Testing with Cucumber and JUnit 5](https://medium.com/codex/bdd-testing-with-cucumber-junit-5-fb5a1c4354f9)
* [REST API Testing with Cucumber](https://www.baeldung.com/cucumber-rest-api-testing)

### Contributions 
For adding your contributions, please see **contribution.md** file.

### Changelogs
For changelog & release information, please see *changelog.md** file.
