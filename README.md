# Parameterized tests in JUnit 4, JUnit 5 and TestNG

## Build

TestNG and JUnit can't be run in one maven build. I used to separate this in two different profiles: ``junit`` and ``testng``. Both are active by default, so you just need to use:

- ``mvn test`` or
- ``mvn clean test``