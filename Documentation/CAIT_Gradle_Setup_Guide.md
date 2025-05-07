# Project Setup Guide – IntelliJ + Gradle

## Prerequisites

- Java 17+ (JDK installed
- IntelliJ IDEA (Community or Ultimate)
- Git
- Internet access (for Gradle dependency downloads)

## 1. Clone the Repository

Open your terminal and run:

```sh
git clone https://github.com/VCU-CS-Capstone/cs-25-312-java-pedagogical-libraries.git
cd cs-25-312-java-pedagogical-libraries
```

## **2. Open Project in IntelliJ**

- Open IntelliJ
- Click on File > Open
- Select the root folder of the cloned repo
- When prompted: "Trust project?" → Yes
- IntelliJ will auto-detect Gradle and load the build

## 3. Let Gradle Sync

- Wait for IntelliJ to complete
"Indexing" and "Gradle sync" in the background.
- Check the bottom status bar to ensure no errors appear.

## 4. Run Unit Tests

- Navigate to `src/test/java/edu/vcu/jpedal/SymbolTableTest.java`.
- Right-click → Run 'SymbolTableTest'

## 5. Building the Project

To build manually with Gradle:

```sh
./gradlew build
```

For Windows (PowerShell):

```sh
.\gradlew.bat build
```

## **Optional: Run the CAIT Demo**

Run `src/main/java/edu/vcu/jpedal/CAITDemo.java`
to try a sample AST pattern matching test
between instructor and student code snippets.

## **Directory Overview**

```
src/  
├── main/  
│   └── java/edu/vcu/jpedal/  
│       ├── CAIT.java  
│       ├── TreeMatcher.java  
│       ├── SymbolTable.java  
│       ├── ScopedSymbolTable.java  
│       └── InstructorSymbolTable.java  
├── test/  
│   └── java/edu/vcu/jpedal/  
│       └── SymbolTableTest.java
```
