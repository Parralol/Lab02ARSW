# Lab 02 ARSW

This program allow the user to process a set of data from a csv file, given it's columnn name and following data in a table-like format, processing it's mean and standard deviation and giving it's output in the terminal [Repo Link](https://github.com/Parralol/Lab02ARSW)
2024/06/14

## Architecture (Class diagram)

![image](https://github.com/Parralol/Lab02ARSW/assets/110953563/b3c10b10-cfb9-4dab-9fc8-3918e53e4e41)

As seen by the following diagram, in this case we will model the LinkedList implementation as requested by the document, in order to represent a generic type of data the _T_ used in the upper-right corner we can see it's definition, this interpretation means that LinkedList is a generic type.

LinkedList has a oneWay usage of Node<T> (note that this expression means that node is any type of data) which is stored in two variables, head and tail and has a nested relationship with node class, this means that node resides inside of the LinkedList class, as part of the estructure of the class, inside of every Node object resides two attributes: prev & next, this means that insisde of every Node a reference of the previous and next Node is stored.

The relationship between Node<T> and Node represents that any Node<T> is binded to Node by it's generic types _T_.

Now, App is the main class, in which Lister and CsvArray are used for their listAllFiles and getCsv methods respectively, CsvArray has a records attribute in which a LinkedList<String> is used, this LinkedList is binded to LinkedList class using it's generic type _T_ as _String_, App uses this same type of LinkedList, only that it's represented in two attributes: data & response, as the name implies this Lists store data and the response from the program respectively, App uses a interface named Calculator, this interface is the one used to store lambda functions, this is implied in the attributes names: deviation & mean, the names are self explainatory, the attributes represented by '~' it's because they are static methods with package visibility (have default visibility)

In this desing it was intended to use Factory Method (creational pattern) and Template method (behavioral pattern), the factory method is seen all inside the code, however the template method is only seen as the execution of the program is divided inside of it's diferents stages represented by methods.

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

![image](https://github.com/Parralol/Lab02ARSW/assets/110953563/fe8a0e8e-00bc-4269-8c0a-98483b6b4523)


And a acceptance test

### Break down into end to end tests

* **testSelectFiles**

    This test allow us to assure that the selection of files  works, this will asure that the program reads the files accordingly. 

* **testConvert**
  
    This test allow us to assure that the processed data is converted into a comprehensible manner, so that processing it's data is easier.

* **testGenerateLambdas**
  
     This test allow us to assure that the generation of the lambda functions works properly.

* **testGenerateResponse**

  This test allow us to assure that the output is the way it was designed to be

* **testIntegration**

  Validates if all methods in the program work properly in a controlled enviroment and sequential execution.


### Acceptance test

this acceptance test is build around the following file which you can see here -> [file used](https://github.com/Parralol/Lab02ARSW/blob/main/resources/mock.csv)


![image](https://github.com/Parralol/Lab02ARSW/assets/110953563/18bd4de0-b6da-4d1f-8274-96074ffa484d)


we proceed to test the mock.csv file, once entered we get:

![image](https://github.com/Parralol/Lab02ARSW/assets/110953563/3de9d8ee-6e32-4f89-bbd1-4e253ce68109)


as we can see, if you execute this .jar whenever you are executing it, it will find it's files and read them, also we get the corresponding answer.

## Deployment

**IN ORDER FOR THIS PROGRAM TO WORK, YOU'LL NEED TO EXECUTE THE PROGRAM ON THE FOLDER YOU WANT TO WORK WITH, WITH THE FILES YOU WANT TO WORK WITH**

if you want to use te programm before using the package command we use

```
mvn -e exec:java -Dexec'.mainClass=edu.escuelaing.arsw.ase.app.App' -Dexec'.args=<.csv file you want to use>'
```
or (depending on your system)

```
mvn -e exec:java -Dexec.mainClass=edu.escuelaing.arsw.ase.app.App -Dexec.args=<.csv file you want to use>
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Java](https://www.oracle.com/java/technologies/) - Programming Language

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Santiago Parra** - *Initial work* - [Parralol](https://github.com/Parralol)



