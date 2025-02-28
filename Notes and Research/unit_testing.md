# unit testing
Testing **units** of a code
A unit can be a **method**, **class**, or **module**
# integration testing
Testing how units fit together
# assertions
- testing that outputs look right

# coverage
- what % of the code is being tested?
- can be different metrics:
	- classes
	- lines
	- methods
	- branches
IntelliJ has "Run [module] with Coverage" tool

## line coverage
- go for 100% line coverage at minimum, then go for other metrics

## branch coverage
Consider this code:
```
if condition1:
	do something
if condition2:
	do something
```
To test every **branch** of the following code, you could use two tests:
condition1 = true, condition2 = true
condition1 = false, condition2 = false

To test every **path**, you'd need 4 tests:
(the above, plus)
condition1 = true, condition2 = false
condition1 = false, condition1 = true

Consider this code:
```
if condition1 && condition2:
	do something
else:
	do something else
```
**Especially** where short-circuiting is supported, **both** condition1 and condition2 individually being false are considered separate branches
## proliferation control
### priority-based
- prioritize code that runs more often (test it more)
- typically used in industry for stress-testing
### boundary-based
- go straight for the edge-cases, as those are most likely to cause issues
- typically used in academic settings, simple and covers what you need
- also typically used in industry
```
if grade > 90:
	print A
elif grade > 80:
	print B
```
You'd test 91, 90, and 89, and 81, 80, and 79.
## equivalence-based
- group paths together that tend to cause the same issues, then have one test speak for them all
```
if error type1:
	doSomething(...)
elif error type2:
	doSomething(...)
else:
	do the cool thing
```
If we think of error type1 and error type2 as the same class of error, then we could group them together and test the group
