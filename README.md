# Lab 02 ARSW

This program allow the user to process a set of data from a csv file, given it's columnn name and following data in a table-like format, processing it's mean and standard deviation and giving it's output in the terminal
2024/06/14

## Architecture (Class diagram)

![image](https://github.com/Parralol/Lab02ARSW/assets/110953563/b3c10b10-cfb9-4dab-9fc8-3918e53e4e41)




## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

First you need the following java version (command to see your current java version below)

```
java -version
```

![image](https://github.com/Parralol/Taller1ARSW/assets/110953563/6088e13f-2c49-4e5f-9eb3-c09642af5d65)

to see the maven version we are using we need to enter the following command, also this is the version of Maven this programm uses

```
mvn -version
```

![image](https://github.com/Parralol/Taller1ARSW/assets/110953563/0c2f20e7-a955-4aa5-bb92-a073488ba7e1)

### Installing

First clone this proyect into your own system, then enter in the terminal, on the cloned repository

```
mvn clean package
```

then we enter the following command once inside the directory of the cloned repo

```
java -jar  target\calculator-1.0-SNAPSHOT.jar <.csv file you want to use>
```
and the we can execute the program


## Running the tests

To run the automated tests you'll have to type in the console 
```
mvn test
```
this program works with the following tests:

![image](https://github.com/Parralol/Lab01ARSW/assets/110953563/1b5c19d6-0f1d-43bf-b1f4-4fdb767c5844)

And a acceptance test

### Break down into end to end tests

* **testSelectFiles_phy**

    This test allow us to assure that the selection of files in the phy case works, this will asure that the program reads the files accordingly. 

* **testSelectFiles_loc**
  
    This test allow us to assure that the selection of files in the loc case works, this will asure that the program reads the files accordingly. 

* **testSelectFiles_throwsExceptionForMultipleFiles**
  
     This test allow us to assure that the selection of files in both cases works, this will asure that the program reads the files accordingly and only validates one file. 

* **testSelectFiles_throwsExceptionForNoFiles**

  This test allow us to assure that the selection of files in both cases works, this will asure that the program reads the files accordingly and will validate if no file exists.

* **testSelectFiles_throwsExceptionForInvalidArgument**

  Validates if loc or phy is entered, if not it should raise an error.

* **testFileHasFourLOC**

  This test validates if the program calculates correctly the amount of lines of code.


### Acceptance test

this acceptance test is build around the following file which you can see here -> [file used](https://github.com/Parralol/Lab01ARSW/blob/main/Test%20set/xd/Peticion.java)

![image](https://github.com/Parralol/Lab01ARSW/assets/110953563/68b6b00b-53b8-4777-82ca-6a50336696eb)

we proceed to test the loc option, once entered we get:

![image](https://github.com/Parralol/Lab01ARSW/assets/110953563/c159f251-caf0-4a5f-a448-48451815d9f0)


and if we test phy we get

![image](https://github.com/Parralol/Lab01ARSW/assets/110953563/3cc3ca2e-6bdb-4b36-a6a2-357cc627361f)

as we can see, if you execute this .jar whenever you are executing it, it will find it's files and read them.



the corresponding answer.

## Deployment

**IN ORDER FOR THIS PROGRAM TO WORK, YOU'LL NEED TO EXECUTE THE PROGRAM ON THE FOLDER YOU WANT TO WORK WITH, WITH THE FILES YOU WANT TO WORK WITH**

if you want to use te programm before using the package command we use

```
mvn -e exec:java -Dexec'.mainClass=edu.escuelaing.arsw.ase.app.App' -Dexec'.args=<loc, phy> <file you want to use>'
```
or (depending on your system)

```
mvn -e exec:java -Dexec.mainClass=edu.escuelaing.arsw.ase.app.App -Dexec.args=<loc, phy> <file you want to use>
```

to execute the program like it's intended we'll need to enter

```
countlines <phy | loc> <program to count lines>
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Java](https://www.oracle.com/java/technologies/) - Programming Language

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Santiago Parra** - *Initial work* - [Parralol](https://github.com/Parralol)



