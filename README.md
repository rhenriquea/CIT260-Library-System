# CIT260-Library-System
Java program for BYU-I CIT-260.

Library program that will have options to manipulate the media resources in the catalog and also check out the materials. 
It will give the user options to add books to the library, check out books, and add add library employees. 

### External Dependencies

The project has a dependency on `json-simple-1.1.1.jar`.
(More information about it can be found on https://code.google.com/archive/p/json-simple/).

In order to use the program, you need to put the latest `json-simple-1.1.1.jar` in your CLASSPATH before compiling 
and running the project. 

A copy of the JAR is included in the */lib* directory of the project.

You can add the dependency as follows:

#### IntelliJ Idea
- Right click on the project package name
- Select "Open Module Settings"
- Click on the plus icon button at the left bottom of the window
- Select option 1: JAR's or Directories
- Select the JAR file provided in the folder named lib `${YOURWORKPASCE}/lib/json-simple-1.1.1.jar`

You should be able to run now without any issues.

#### Eclipse
- Right click on the project package name
- Select "Build Path" -> "Configure Build Path..."
- Go to the "Libraries" tab
- Select "Add JARs..." on the right corner
- Select the JAR file provided in the folder named lib `${YOURWORKPASCE}/lib/json-simple-1.1.1.jar`

You should be able to run now without any issues.