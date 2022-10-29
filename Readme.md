# Automation-Challenge

## **Required Setup :**

- [Java 11](https://www.oracle.com/ar/java/technologies/javase/jdk11-archive-downloads.html) should be installed and configured.
- [Maven](https://mkyong.com/maven/how-to-install-maven-in-windows/) should be installed and configured.
- [ChromeDriver](https://chromedriver.chromium.org/downloads) should be the same version of Chrome choose the right version and replace in **/Drivers** folder
- Download the files from Git repository either as [zip file](https://github.com/BohemKorp/automation-challenge/archive/refs/heads/master.zip) OR using **Git**.

## **Run tests :**
Open the command prompt and navigate to the folder in which pom.xml file is present.
Run the below Maven command.

    mvn clean test

To run specific test you can choose one tag and add to command maven

    mvn clean test -Dgroups='challenge'

Finally you can run tests by [Github Actions](https://github.com/BohemKorp/automation-challenge/actions)