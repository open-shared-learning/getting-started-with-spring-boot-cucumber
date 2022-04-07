
# Running Cucumber Tests when `mvn verify` is called

> When using mvn verify Failsafe is used and test names should follow these conventions:

See structure here:  
https://maven.apache.org/surefire/maven-failsafe-plugin/examples/inclusion-exclusion.html Inclusions 
and Exclusions of

### Tests Inclusions

By default, the Failsafe Plugin will automatically include all test classes with the following wildcard patterns:
```
"**/IT*.java" - includes all of its subdirectories and all Java filenames that start with "IT".
"**/*IT.java" - includes all of its subdirectories and all Java filenames that end with "IT".
"**/*ITCase.java" - includes all of its subdirectories and all Java filenames that end with "ITCase". If the test
```

_classes do not follow any of these naming conventions, then configure Failsafe Plugin and specify the tests you want to
include._

> When using mvn test Surefire is used and test names should follow these conventions:

See structure here:  
https://maven.apache.org/surefire/maven-surefire-plugin/examples/inclusion-exclusion.html 

### Inclusions and Exclusions

By default, the Surefire Plugin will automatically include all test classes with the following wildcard patterns:
```
"**/Test*.java" - includes all of its subdirectories and all Java filenames that start with "Test".
"**/*Test.java" - includes all of its subdirectories and all Java filenames that end with "Test".
"**/*Tests.java" - includes all of its subdirectories and all Java filenames that end with "Tests".
"**/*TestCase.java" - includes all of its subdirectories and all Java filenames that end with "TestCase". If the test
```
_classes do not follow any of these naming conventions, then configure Surefire Plugin and specify the tests you want to
include._

<hr/>

Help documentation from Cucumber:  
https://cucumber.io/docs/guides/10-minute-tutorial/
