# Meeting Summaries
Here you will find notes recapping the key points of each synchronous meeting our group partakes in. They are listed in chronological order with the most recent entry at the top.

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

