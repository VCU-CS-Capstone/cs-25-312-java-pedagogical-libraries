# JPedal source directory

This directory follows the [conventional Gradle structure](https://docs.gradle.org/current/userguide/organizing_gradle_projects.html) for Java projects with unit testing.

The project falls under the `vcu.edu.jpedal` package.


| Subdirectory Name | Description |
|---|---|
| main | Java source code, used in production |
| test | Unit testing methods and resources |

---
##  Project Overview

This project focuses on **symbol tracking, scope resolution, and instructor-student mappings** for AST-based analysis.

###  **Symbol Table**
- Supports **storing and retrieving symbols**.
- Implements **merging with conflict detection**.

###  **Scoped Symbol Table**
- Supports **nested scopes** for AST matching.
- Enables **hierarchical symbol lookup**.

###   **Instructor Symbol Table**
- Maps **instructors to student symbols**.
- Supports **lookup and merging** with conflict handling.

---

##  Setup & Running Tests

```sh
# 1 Clone the Repo
git clone https://github.com/your-repo/jpedal.git
cd jpedal

# 2⃣ Build the Project
./gradlew build

# 3 Run All Tests
./gradlew test
```
## Tests Overview & Example Usage
```sh
Test File
SymbolTableTest.java
ScopedSymbolTableTest.java
InstructorSymbolTableTest.java

Purpose
Tests symbol tracking & merging
Tests scoped resolution & lookup
Tests instructor-student mappings
```
