# Objective

- Student has a `.java` file, which gets parsed into AST format
- Instructor has a pattern in String format, which gets parsed into AST format
- End goal: Look for instances of the **instructor pattern**
in the student **source code**

## Patterns

- `_identifier_` - single symbol, save (analogous to capture groups in regex)
- `__subtree__` - any subtree, save
- `___` - any subtree, don't save

### Example instructor pattern

```java
public void readGroceryList(String[] _groceries_) {
  for(String _item_ : _groceries_) {
    System.out.println(_item_);
  }
}
```

## Shallow matching

- Are two nodes equivalent?
  - Look for particular attributes (variable as load **or** variable as store),
  independent of name
  - Don't care about the nodes' children

## Deep matching

- Are two nodes equivalent, all the way down?
  - Check children recursively

### Horizontal stretching

Relax the equality conditions a bit:

1. Commutative operations can be reversed

This subtree (which would be represented in code as `A * B`):
```
value: binop (*)
|-- left: variable A
|-- right: variable B
```

is equivalent to this subtree (which would be represented in code as `B * A`):
```
value: binop (*)
|-- left: variable B
|-- right: variable A
```

1. Irrelevant nodes can be skipped over

This instructor pattern:
```
body[0] (foreach)
|-- target: ___
|-- iter: ___
|-- body (assignment)
  |-- (etc.)
```

Could match this student code:
```
body[0] (whatever)
body[1] (whatever)
body[2] (foreach)
|-- target: steps_hiked
|-- iter: steps_hiked_list
|-- body (assignment)
  |-- (etc.)
```
The `body[0]` and `body[1]` nodes can be ignored when searching,
as the instructor pattern doesn't have mappings for them.

## Symbol tables

- A `Map` of instructor identifiers to student identifiers
- At the bottom levels of the tree, create entries for all possible mappings
- Recurring up the tree,
merge all possible combinations of symbol tables that **don't** produce conflicts
