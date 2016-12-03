## Day 3: Squares With Three Sides

### [Source](./Solution.java)

To test the solution, copy and paste your given inputs into the data.txt.

Took a bit of time to actually parse the data, I had no idea why I was getting empty Strings when using the `split` method. First part is straight forward, to validate a triangle, the sum of two sides must exceed the final side - for all sides. So in part 1 we just iterate through the List of ints and then just validate for all the different side combinations.

For part 2, instead of calculating across rows, the specification wants to calculate down columns. So for each 3 ints down a column, validate that triangle. Visually it looks something like this;

```
 x1 x2 x3
 x1 x2 x3
 x1 x2 x3
 x4 x5 x6
 x4 x5 x6
 x4 x5 x6
```

And you will want to compare all the `x1` with the other `x1`, and same for `x2`, `x3`.. ect.

So to do this I simply changed the logic to increment through the List of Arrays by 3 and add another inside loop to check each column one by one. So we check `x1` is valid, `x2` then `x3` before we increment the outside loop by 3 again to start with `x4`... ect and just repeat.
