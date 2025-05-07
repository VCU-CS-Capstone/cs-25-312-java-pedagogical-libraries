# *Java Pedagogical Libraries for Code Analysis*

## *VCU College of Engineering*

## Short Project Description

Adaptation of PEDAL (PEDAgogical Library) from Python to Java
for syntactic analysis of student-submitted code.

Giving large amounts of timely and impactful feedback is difficult because
instructor time in classrooms is becoming more limited as class sizes in
Computer Science continue to grow larger.
To address the scale of current classes and give students timely feedback,
we develop tools for automated student feedback that targets
specific conceptual misunderstandings that can be deployed at-scale and
received immediately.

## Project Structure

The directory structure in this GitHub is to allow the project to have all its
resources self-contained. Open Source software should not just be a repository
of code. There are a number of directories to help you and others who will
follow in your footsteps.  It'll also allow the Linux Foundation OMP Mentorship
program to keep track of your project and get a better understanding of the
problems you encountered during the development of this project.

| Folder | Description |
|---|---|
| Documentation |  All documentation the project team has created to describe the architecture, design, installation, and configuration of the project |
| Notes and Research | Relevant helpful information to understand the tools and techniques used in the project |
| Project Deliverables | Folder that contains final pdf versions of all Fall and Spring Major Deliverables |
| Status Reports | Project management documentation - weekly reports, milestones, etc. |
| src | Source code |

## Project Team

- *Luke Gusukuma* - *Computer Science* - Faculty Advisor
- *Derek Chiou* - *Computer Science* - Student Team Member
- *Luca Doutt* - *Computer Science* - Student Team Member
- *Ghulam Mujtaba Qasimi* - *Computer Science* - Student Team Member
- *Kennedy Westry* - *Computer Science* - Student Team Member

## For future contributors

- Please see [Luke Gusukuma's dissertation](https://vtechworks.lib.vt.edu/server/api/core/bitstreams/5e3b9983-bdcb-4c4b-8ecc-46db979f4c01/content),
section 4.2 (Matching Algorithm), for a high-level overview of the algorithm.
- The [original Pedal source code](https://github.com/pedal-edu/pedal/tree/master)
may be of use, see also:
  - [stretchy_tree_matching.py](https://github.com/pedal-edu/pedal/blob/master/pedal/cait/stretchy_tree_matching.py)
  - [test_cait.py](https://github.com/pedal-edu/pedal/blob/master/tests/test_cait.py)

### Key files

I'm not sure how admin is going to handle this repository next year,
so here's an outline of what files you should know about
(in case you need to manually import to a new repository).

- `src` contains all our code so far. It's mostly shell code.
See the `README` in that directory for more details.
- The `.gitignore` is honestly a mess, but it currently covers ignores for
VSCode, IntelliJ, Eclipse, and general Java and Gradle ignores.
- Ensure the Gradle files carry over:
  - The `gradle` directory, which should contain only a few files
  - `build.gradle` declares necessary imports. Currently it's just JavaParser.
  - `settings.gradle`, currently only stating the project name
  - `gradlew` and `gradlew.bat`
- `Notes\ and\ Research` contains a few markdown files on different concepts.
If anything doesn't make sense, ask Luke directly.
- `Documentation/UML` has a PlantUML source, as well as
generated output in `png` and `svg` format.
Refer to it, or modify it, as you see fit.
