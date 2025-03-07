# Symbol table
- Map each instructor Symbol to a List of student Symbols

Consider the instructor pattern:
```python
for insSym1 in insList:
	insSym2 = insSym2 + 1
```
and the student code:
```python
for stdSym1 in stdList:
	stdSym1 = stdSym2 + stdSym1
```
There is a conflict when `insSym2` tries to map to `stdSym1`.

> [!QUESTION]
> Does this imply that the mapping reports conflicts if it violates **injectivity**?

## Pedal source
[ast_map.py](https://github.com/pedal-edu/pedal/blob/master/pedal/cait/ast_map.py)

See the `AstMap` class for mapping logic

TODO: write more detail here, especially about the `Match` architecture
