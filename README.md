To assemble a jar file for your project, run the "jar" gradle task, either through IntelliJ or by doing
`gradle jar` on a terminal. Gradle will automatically download all dependencies needed to compile your jar file,
which will be stored in the build/libs folder.

Make sure to edit the main class attribute the build.gradle file, you'll need to change it in order to obtain
a working jar file.

## Requirements
Java Development Kit (JDK) version 17.x
<br>MaterialFX

# Important Files
## build.gradle / gradle.properties
This is the gradle configuration file. Modify this file to add dependencies to your project. In
 general you should only modify the depedencies section of this file, however there are a few
  modification you will need to make when you begin the project
  
  - `mainClassName`
    - Modifiy this variable to point to your main class. By default it is `edu.wpi.teamb.Main
    `, but once you update your teamname package to your team letter you will need to update this
     path.
     
  - jaCoCo
    - jaCoCo is a JAva COde COverage checker that enforces testing. By default the rules are 25
    % line coverage and 25% branch coverage, but if you would like to be more successful you
     should raise these numbers higher to enforce team members to write more tests. Simply modify
      the `minimum` values to enforce stricter tests (but do not change to below .25, as that is
       the required minimum for this class)
  - spotless
    - spotless is a style guider checker/formatter that will automatically detect if your code
     adheres to an agreed style guide. For this starter code I have defaulted to Google's style
     guide, as it is well known and well liked. You can find more documentation for spotless 
     [here](https://github.com/diffplug/spotless). If you would like to disable the spotless
      checks, comment out the spotless plugin as well as the spotless configuration at the bottom
       of the file

