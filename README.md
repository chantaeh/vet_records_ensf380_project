# ensf380_project

W23 ENSF 380 Final Project

### Group 25
- Chantae Ho (30141743)
- Youssef Mamoun (30149233)
- Andrew Yan (30110460)


### To run the program (on Windows):
- Clone the repo and stay in the main folder (ensf380_project)
- Open a new terminal and compile the files with the command: ```javac -cp .;lib\hamcrest-core-1.3.jar;lib\junit-4.13.2.jar;lib\mysql-connector-java-8.0.23.jar edu/ucalgary/oop/*.java```
- Run the tester file with the command: ```java -cp .;lib\hamcrest-core-1.3.jar;lib\junit-4.13.2.jar;lib\mysql-connector-java-8.0.23.jar org.junit.runner.JUnitCore edu.ucalgary.oop.Tester```
- Run the GUI scheduler program with the command: ```java -cp .;lib\hamcrest-core-1.3.jar;lib\junit-4.13.2.jar;lib\mysql-connector-java-8.0.23.jar edu.ucalgary.oop.SchedulerGUI```

### To run the program (on MacOS):
- 

### Notes
- Please ensure you have the EWR database available on your computer prior to starting the program.
- A valid schedule must be generated before it can be printed to a file!
- The schedule.txt file generated will be created in directory you are running the program from (likely this will be the ```ensf380_project``` directory).
