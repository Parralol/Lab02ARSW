# Lab 01 ARSW

This programm allow the user to count the number of lines of code of the file prompted in the terminal, developed in 
2024/06/12

### LOC/h

Total time spent in this proyect: 6hrs
Total lines of code: 

* App.java = 41
* Lister.java = 22
* Loc.java = 55
* Phy.java = 26
* AppTest.java = 62

**In total i did 206 lines of code making my LOC/h = 34.33333**

## Architecture (Class diagram)

![image](https://github.com/Parralol/Lab01ARSW/assets/110953563/a1b15734-af58-44e5-a4b4-f2ddd36370a6)

As you can see, there is not an especified connection between app and Loc, Lister and Phy, this is because App only uses them for their methods, however they do not get stored as a variable nor in an Array or a List.

App consist of two attributes being files which is an ArrayList identified in a generic class (List) of Strings, this attribute saves all paths leading to certain files, this attribute is public static, the same happens with res, however res is the variable which saves up the response from Phy or Loc and displays it to the user, consists on 3 methods: App (it's a private constructor), SelectFiles (it's a public method which parameter is the arguments of the main method) and main (the good ol' main method ).

For Lister we have only one method: listAllFiles() (method in charge to list and get all files from a directory to all directories, this method recieves the current path as a Path object and all files as a List of Path)

Phy and it's only method counts all lines in a file with it's method: calculate (as parameter gets the name of the file which will be used and returns a list of String, this being the whole file and the number of lines)

Loc class has a javadoc attribute, which is an boolean attribute that allows us to know when a line is javadoc or not, consists of two methods: calculate (counts and saves each line of code, excluding white lines and comments and returns the whole document whitout them and it's number of lines) and analize (recieves a line and processes it validating it's not a comment, wildcard or whitespace)

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

First clone this proyect into your own system, then 

```
mvn clean package
```


### Windows

first we create a file named 'countlines.bat'
```
echo @echo off > countlines.bat
```

then we enter inside of the file

```
echo java -jar  target\loc-1.0-SNAPSHOT.jar %* >> countlines.bat
```
and the we can execute the program

### linux/macOS

first create a file named 'countlines'
```
touch countlines
```
and we give it execution permissions

```
chmod +x countlines
```

then we edit the file so that it executes the following

```
#!/bin/bash
java -jar path/to/your/target/LineCounter-1.0-SNAPSHOT-jar-with-dependencies.jar "$@"
```


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



