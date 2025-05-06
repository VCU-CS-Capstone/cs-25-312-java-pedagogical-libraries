# JPedal source directory

This directory follows the
[conventional Gradle structure](https://docs.gradle.org/current/userguide/organizing_gradle_projects.html)
for Java projects with unit testing.

The project falls under the `vcu.edu.jpedal` package.

| Subdirectory Name | Description |
|---|---|
| main | Java source code, used in production |
| test | Unit testing methods and resources |

## Priorities

- [ ] Complete the `findMatches` method.
  - [ ] Solidify test cases and desired output
    (make sure your team feels good on what the end goal is).
  - [ ] Update the structures of the data container classes (`Match`, `SymbolTable`)
  as you see fit.
- [ ] Complete an instructor-facing CLI for CAIT.
  - [ ] Include a guide for incorporating it in scripts.

## Modules

### CAIT

Front-end containing public methods.
JPEDAL will eventually defer to this module.

`findMatches` is the **core** method.
The implementation gets deferred to `TreeMatcher`.

### TreeMatcher

Given two AST nodes (`Node` from JavaParser),
`findMatches` should get a list of possible `Match`es.

Each `Match` represents a mapping of instructor nodes
to student nodes, along with a `SymbolTable` to detect
conflicts in case of ambiguous mappings.

The `findMatches` algorithm holds a list of `Match`es,
generating cartesian products as it recurs upwards,
while cancelling out `Match`es resulting from merges
that produce conflicts in `SymbolTable`.

### Match

Should hold a `Map` of instructor nodes to student nodes.
It's undecided if `Node` should be used directly,
or some other indexing system.

### SymbolTable

Local to each `Match`, a `SymbolTable` tracks instructor
names to student names. It's undecided if we want to use
`Map<String, String>` or encode some other information.
