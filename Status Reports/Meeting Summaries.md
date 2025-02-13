# Meeting Summaries
Here you will find notes recapping the key points of each synchronous meeting our group partakes in. They are listed in chronological order with the most recent entry at the top.

# 2025-02-13
**Attendees**: Derek, Luca, Luke, Qasimi, Kennedy

**Scribed by**: Derek

## Read from String
- Sample code from previous semester should be available: https://github.com/VCU-CS-Capstone/CS-24-337-Java-Pedagogical-Libraries-for-Code-Analysis/tree/master/src/AST_Testing/src
- Check previous JavaParser documentation
- Check `ParserTest` (uses JavaParser, written by Luke)
- Javadoc as you go

# 2025-02-12
**Attendees**: Derek, Luca, Qasimi, Kennedy

**Scribed by**: Derek

## Updated timeline
- Symbol table by spring break, horizontal stretching after spring break
- First immediate deliverable: **Get AST data, given a source file or text**

## Collaborative workflow
- Likely divide by method, will become clearer as we write more

# 2025-02-06
**Attendees**: Luca, Luke, Qasimi, Kennedy

**Scribed by**: Luca

## Testing
- JUnit tests
- Gradescope: we have access to canvas classroom as teachers for testing there. However, this is not on our tasklist as Gradescope integration is not part of our project’s scope.
## Revised timeline
- Luke has asked us to give a revised schedule of tasks (last semester’s is outdated).
- Making another timeline may be helpful for keeping pace.
- Can be high level, large milestones should have an accurate timeline.
- Will help structure meetings so Luke will know what to expect from us at each meeting.
## Code
- Reference our pseudocode as well as the last group’s pseudocode.
- We should meet and work on documenting the code so working asynchronously is easier.
## Goals for next meeting
- Update our timeline
- Have working class templates (with methods even if their bodies are empty)
- Don’t leave questions for next meeting! Send Luke an e-mail or message especially if the question it stalls progress

# 2025-02-05
**Attendees**: Luca, Qasimi, Kennedy

**Scribed by**: Luca

Derek is sick today, was not present in call.

There are currently four classes to work on:
- IdentifierType
- Match
- Symbol
- SymbolTable

We will be working on IdentifierType and SymbolTable first as Derek has completed the basic implementation of Symbol. Tomorrow we will communicate with Derek to figure out how to implement parts of the UML into the code.

## Questions for tomorrow's meeting:
We are going to be implementing CAIT first. What data is CAIT going to be passing to TIFA?

# 2025-01-30 - Reconvene, start planning
**Attendees**: Derek, Luca, Luke, Qasimi, Kennedy

**Scribed by**: Derek

- Tasks
    - [ ] Tooling for development
    - [ ] Divide needed work (smaller and smaller!)
- Milestones
    - [ ] New timeline written
    - [ ] Search for a particular node, e.g. "`for` loop with variable named `j`" or "enhanced `for` loop" and get its elements
        - [ ] Store its information into a symbol table
        - [ ] Test AST, what will an intended AST look like?
- Dividing work by methods?
    - 1x Symbol table, 2x matching, 1x testing?
- Considerations
    - Symbol table might require more complex data structure
    - Create templates (from UML), so the interface is functional

# 2025-01-29 - Contract Completion, first steps
**Attendees**: Derek, Qasimi, Kennedy

**Scribed by**: Derek

- Final pass and submission of updated team contract
- Review what to talk about tomorrow
    - Collaborative workflows
    - Expectations
    - Pacing / starting point

# 2025-01-23 - Contract Discussion
**Attendees**: Derek, Luca, Qasimi, Kennedy

**Scribed by**: Derek

- Discuss new semester
- Confirm new contract entries
- Wait for advisor (did not attend)

# 2025-01-22 - Semester Start
**Attendees**: Derek, Luca, Kennedy

**Scribed by**: Derek

- Reintroduce the spring semester
- Start on contract update
    - Switch roles around? Kennedy switching off Project Manager
    - New meeting times: (student) Wednesdays at 6, (advisor) Thursdays at 6:15
    - Start rewrite of Step 2: Team Culture

# 2024-12-11 - UML Critique
**Attendees**: Derek, Luca, Luke, Qasimi, Kennedy

**Scribed by**: Derek

- Discuss UML draft
    - Good starting point, though a lot will change
    - Consider which classes will need to have instances and which will act as libraries
    - Add more instance variables or arguments to ensure the methods have the information they need
- Discuss collaborative process
    - Prioritize shell code
    - Consult before making non-additive changes outside your designated module
    - Continue to update UML
- Discuss design report
    - Social impact of the project (think of long-run categories of impact)
    - Microsoft using Pedal in [bakery](https://python-bakery.github.io/)
    - Template replaced with Luke's Line Items

# 2024-12-10 - Design Report overview
**Attendees**: Derek, Luca, Qasimi, Kennedy

**Scribed by**: Derek

- Discuss specification for Preliminary Design Report
- Prepare resources for dev meeting tomorrow
    - Qasimi: Complete CAIT UML (even if not perfect)
    - Derek: Review CAIT UML, review sections A-C
    - Team: Have questions ready

# 2024-11-19 - CAIT algorithm overview
**Attendees**: Derek, Luke, Qasimi, Kennedy

**Scribed by**: Derek

- Talk about poster results (no UML yet)
- Make overview of CAIT inputs, outputs, and procedure
    - Whiteboard image saved to notes channel
    - Input: Two ASTs, already generated by previous layers from 1) **student code** and 2) **instructor pattern**
    - Output: List of Matches, each of which contains metadata such as a SymbolTable
    - Procedure:
        - Naively match exactly on types, creating **symbol table entries** at the leaves
        - Implement **horizontal stretching** to widen the search by 1) swapping  **commutative** operands and 2) ignoring **irrelevant** nodes
        - **Merge** symbol tables as the recursion resolves upwards, striking out matches that produce conflicts
- Next steps: Use this information to properly produce a Java UML for CAIT

# 2024-11-14 - Poster layout
**Attendees**: Derek, Luca, Qasimi, Kennedy

**Scribed by**: Derek

- Lay down all the poster components
- Discuss UML finalization and next steps
- Derek and Kennedy: Use time tomorrow to flesh out CAIT in UML

# 2024-11-12 - UML discussion
**Attendees**: Derek, Luca, Luke, Qasimi, Kennedy

**Scribed by**: Derek

- **Hash out CAIT module UML**
    - Separate into classes (the original PEDAL had 5 or 6)
- Use previous project (don't worry - it's not plagiarism), readjust as desired
- Describe the CAIT algorithm in words
- **Feb 22 Lecture.mp4** - Explains the algorithm
- Short-term task: look more deeply into the previous group's work
- Section 4.2 of this [dissertation](https://vtechworks.lib.vt.edu/server/api/core/bitstreams/5e3b9983-bdcb-4c4b-8ecc-46db979f4c01/content) describes the matching algorithm in detail
- **Make more regular contacts** - Send contact after each student meet?
- Poster should **tell a story** (context-problem-solution)
- Solution: Workflow we hope for

# 2024-11-11 - Poster planning
**Attendees**: Derek, Qasimi, Kennedy

**Scribed by**: Derek

- Plan for poster completion
    - 2 hour meeting on Thursday
- Discuss meeting points for tomorrow's advisor meeting
    - UML feedback
    - Poster
- Delegate tasks and write into Asana

# 2024-11-07 - Tooling progress
**Attendees**: Derek, Luca, Kennedy

**Scribed by**: Derek

- Confirm Gradle working on different machines
- Discuss poster workflow
- Review Git procedures
- Discuss syntax tree notes

# 2024-11-04 - UML progress
**Attendees**: Derek, Luca, Qasimi, Kennedy

**Scribed by**: Derek

- Reconvene on Java build systems
- Confirm that everyone familiarized with Git
- Plan for next meeting
    - Thursday, 6 pm, Library (booked room)
    - Discuss poster and UML
- Short-term tasks
    - Derek: Gradle build and UML modules
    - Luca: Git and design patterns
    - Qasimi: UML relationships
    - Kennedy: UML modules

# 2024-10-31 - Planning procedures
**Attendees**: Derek, Luca, Qasimi, Kennedy

**Scribed by**: Derek

- Set up Asana
- Plot out short-term goals
    - Everyone: get familiar with [Git](https://git-scm.com/book/en/v2)
        - Chapters 1 and 2 are key; chapters 3 and 6 are nice to have
    - Everyone: annotate papers and source code, settle on functionality set in preparation for UML writing
    - Derek: Research Maven and Gradle build systems, plan build configuration
- Start thinking about what will go on the Fall Poster

# 2024-10-29 - Project structure discussion
**Attendees**: Derek, Luca, Luke, Qasimi, Kennedy

**Scribed by**: Derek

- Discuss planning process
    - Make up a **textual description** (as detailed as possible) for the **functionality** you need to implement (whole-project)
    - Extract **noun phrases** (classes) and **verb phrases** (methods)
    - Extract iterations (for) and decisions (if)
    - Draw connections with inheritance
    - [Battleship example](https://docs.google.com/document/d/1RzUwoTF1XLtFxA8B8z2nrc77ZGpVvWeGwGhm7uZ71G8/edit?usp=drive_link) given
- Reminder about previous year's efforts (pseudocode is available)
- Review [Asana](https://asana.com) for task scheduling
- Review packaging systems (Maven/Gradle/raw Java)
- Tasks by next meeting:
    - Use planning process above, produce complete UML
    - Java tooling setup as planned (collaborative environment with packaging)

# 2024-10-28 - UML design
**Attendees**: Derek, Luca, Qasimi

**Scribed by**: Derek

- Discuss UML tooling
- Open a diagrams.net drawing in the shared drive folder
- Examine Pedal source code more closely

# 2024-10-21 - Workspace configuration
**Attendees**: Derek, Luke, Qasimi, Kennedy

**Scribed by**: Derek

- Discuss revised proposal timeline
- **Meeting time move**: Monday 1 pm -> Tuesday 5:15 pm
- Add sample student code to the repository

# 2024-10-17 - Logistics
**Attendees**: Derek, Luca, Kennedy

**Scribed by**: Derek

- Discuss time costs as 3
- Move completion dates from Mondays to Tuesdays, providing an additional day to discuss with advisor
- Move hours from academic deliverables to Source and CAIT
- Review next steps:
    - Ensure everyone's Java development environment works by Monday
    - Draft UML by Tuesday

# 2024-10-15 - Check-in, start poster
**Attendees**: Derek, Luca, Kennedy

**Scribed by**: Derek

- Attend seminar, discuss fall design poster due 2024-11-15
    - Graded on formatting and aesthetics over content
- Discuss software engineering workflows (Waterfall, Agile, Rapid Application Development)

# 2024-10-14 - Proposal Discussion
**Attendees**: Derek, Luca, Luke, Qasimi, Kennedy

**Scribed by**: Derek

- Students need to be able to use JPedal locally
- Discuss cost-importance analysis
    - Double-check time estimates with everyone, make sure they match up
    - Consider how much time will be dedicated per week
    - e.g. 8 hours may be a bit low for UML design

# 2024-10-10 - Final Proposal Preparations
**Attendees**: Derek, Luca, Qasimi

**Scribed by**: Derek

- Discuss final two days of work on final proposal
    - Progress is behind, dedicate additional time to pushing forward
    - Run through papers again
    - Synthesize sections together
    - Use Google Docs built-in citation system
    - Derek will submit
- Qasimi will record advisor feedback / transcript going forward

# 2024-10-03 - More Proposal Writing
**Attendees**: Derek, Luca, Qasimi, Kennedy

**Scribed by**: Derek

- Move weekly meetings:
    - (unchanged) Monday 1-2 pm with advisor
    - Tuesday morning -> 5:30 pm before class in person
    - (unchanged) Thursday evening
    - (this week) Sunday evening
- Discuss cost-importance analysis table, create template in Google Sheets
- Immediate goals:
    - Derek: Section C, cost-importance analysis
    - Luca: Section A
    - Qasimi: Section B
    - Kennedy: Section A

# 2024-09-30 - First Draft Review
**Attendees**: Derek, Luca, Luke, Qasimi, Kennedy

**Scribed by**: Derek

- Two paths: Implement only **CAIT** module, or lay down groundwork for an entire Pedal system
    - The latter seems like the direction we're headed
- If porting all of Pedal, **make a cost-importance table** - completing everything may not be realistic
    - Get this **before Thursday** if possible
    - Put CAIT at the top, then focus on the larger infrastructure
- Appendix 1: Timeline earlier is better but not strictly necessary
- "This paper cites" only goes back in time - "Cited by these papers" goes forward; much more attention has been given to autograding post-2020

# 2024-09-29 - Draft Writing
**Attendees**: Derek, Luca, Qasimi

**Scribed by**: Derek

- Continue reading papers
- Make progress writing proposal body text
- Lay out goals by tomorrow's advisor meeting
    - Finish as much of sections A and B as possible
- Talk about background experience - what parts of CMSC 304 will be necessary?
    - Concept of an AST
    - Java's static typing

# 2024-09-26 - Proposal and Planning
**Attendees**: Derek, Luca, Qasimi

**Scribed by**: Derek

- Put down template for Project Proposal
- Start reading the literature for student code feedback
- Lay out short-term plans:
    - Think about preliminary design for JPedal
    - Meet on Sunday
    - All read the Pedal paper, each read one additional paper for 5 sources total
    - Look for **unmet engineering need** (problem space) and technical implementation (syntactic analysis)

# 2024-09-23 - Requirements
**Attendees**: Derek Chiou, Luca Doutt, Luke Gusukuma, Ghulkam Mujktaba Qasimi, Kennedy Westry

**Scribed by**: Derek Chiou

- Set recurring Zoom meeting
- Go over understanding of project requirements
- Priority: CAIT > TIFA > the rest of PedaL
- Long term ideal: one backend, Java and Python both interface with it separately for feature parity
- Short term goal: Have CAIT for Java ready for use in the classroom
- Impact both in the classroom and in academic research contexts
- Previous group had suboptimal software design - keep in mind the Java framework we're dealing with
- Map out a UML diagram for the proposal
- **Next steps**:
    - Start work on project proposal
        - first draft by Monday, 2024-09-30
            - Sections A and B (excluding B.4)
        - final draft by Monday, 2024-10-07 (submission due: 2024-10-11)
            - Section C
    - No deadline, but get a UML software design as soon as possible

# 2024-09-16 - Clarifications
**Attendees**: Derek Chiou, Luca Doutt, Luke Gusukuma, Ghulkam Mujktaba Qasimi, Kennedy Westry

**Scribed by**: Derek Chiou

- Verify that we can use external Java libraries
    - Make sure to document it and how it integrates
- It has to be runnable in Gradescope (runs a Docker container)
- Highlight [Gradescope tutorial](https://docs.google.com/document/d/1emrYDSGkIYHiohU5BM2_WDNxGv_FpYfAQB-HTk6rXWY/edit)
- Clarify specific goals
    - Detect structures such as nested for loops, recursion, "a constant named THIS", etc. via AST
    - Focus on the [CAIT](https://pedal-edu.github.io/pedal/teachers/tools/cait.html) part
- Horizontal stretching - scanning over multiple possible matches within one indentation level (focus on this)
- Vertical stretching - looks into deeper levels (don't worry too much about implementing this)
- Review tasks:
    - Read and understand the proposal template
    - Have a written document of the requirements as we understand them
- Make sure we record meetings **to the cloud**

# 2024-09-10 - Getting Started
**Attendees**: Derek Chiou, Luca Doutt, Ghulam Mujktaba Qasimi, Kennedy Westry

**Scribed by**: Derek Chiou

- Catch up Kennedy on missed meeting
- Plot out next steps
    - Kennedy - Fill in status reports up to week 3
    - Luca - Update README.md in project root
    - Derek and Qasimi - Research existing files / project context

# 2024-09-09 - First Advisor Meeting
**Attendees**: Derek Chiou, Luca Doutt, Luke Gusukuma, Ghulam Mujktaba Qasimi

**Scribed by**: Derek Chiou

- Get Google Drive link for previous group project
- Get last semester’s GitHub repository
- Using Luke’s dissertation (misconception-driven student analysis model) as a basis
- PEDAL (PEDAgogical Library): runs static analysis in Python code, looking for syntactic markers
    - sideways tree stretching (TODO: clarify)
    - AST analysis (compare instructor and student ASTs)
- **Goal**: make something similar to PEDAL’s static analysis but for Java
- Java includes comments in its AST, so we can check that as well
- CAIT: Capturing AST-Included Trees
- TIFA: Type-Inferencing and Flow Analysis
- Last semester’s work:
    - Identified JavaParser as the best available core tool
- Preferred method of contacting Luke:
    - Long response -> **email**
    - Short response -> **Discord**
- Goals by next week:
    - Demonstrate understanding of the context and project outline
    - Find out areas of potential improvement on the existing design
    - Bonus points: preliminary design ideas
    - Brush up on abstract syntax trees (ASTs) and symbol tables

# 2024-09-03 - Contract Completion
**Attendees**: Derek Chiou, Luca Doutt, Ghulam Mujktaba Qasimi, Kennedy Westry

**Scribed by**: Derek Chiou

- Review meeting times with advisor
- Completely fill out Team Contract document
- Submit Team Contract on Canvas, EduSourced and GitHub

