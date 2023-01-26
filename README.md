To assemble a jar file for your project, run the "jar" gradle task, either through IntelliJ or by doing
`gradle jar` on a terminal. Gradle will automatically download all dependencies needed to compile your jar file,
which will be stored in the build/libs folder.

Make sure to edit the main class attribute the build.gradle file, you'll need to change it in order to obtain
a working jar file.

## Requirements
<li>Java Development Kit (JDK) version 17.x
<li>MaterialFX

# Important Features
Note: All features have been implemented into the application User Interface, and all
can be found inside this jar file

## Front-End
<li>A user-friendly interface for navigating and interacting with the system
<li>Forms for inputting data and making requests
<li>Display and visualization of data and results


## Back-End
<li>integration into front end user interface (in the Database page of the application)
<li>JDBC program that includes an ORM
<li>User authentication and authorization (in-progress)
<li>Ability to interact with and manipulate Nodes in real-time
<li>Ability to view node and edge tables
<li>Error handling and logging
<li>Help Display on how to use the database program


## PathFinding
<li>integration into front end user interface (in the Pathfinding page of the application)
<li>Finds a path between two given locations in the hospital
<li>Returns the shortest path found as an easy-to-follow string representation
<li>Locations are represented by their Unique ID


