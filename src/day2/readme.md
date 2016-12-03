## Day 2: Bathroom Security

### [Source](./Solution.java)

To test the solution, copy and paste your given inputs into the data.txt.

Was a pretty straight forward challenge, pretty much the same as day1 but easier in my opinion. I represented the number/key pad as an array of arrays because we already knew what the order of the keys are on that number pad, meaning we know the limits in both directions (3x3 or 5x5). We know the starting position of they key (5) so you can just hard code the first point to be the index of 5, and commands translated to:

* `U` & `D` - increment or decrement the first Array (`[x][]`)
* `R` & `L` - increment or decrement the second Array (`[][x]`)

And obviously since we knew the limits (0 & 3, 0 & 4) we just have a simple check to only increment and decrement when !=.

The second part was straight forward too as you could just have `null` in all blank spaces to ensure you still have that 5x5 Array of Arrays, and just do a `null` check before you move (and of course still checking the edge cases of the array bounds).

The second part also required the use of Objects as since there were `chars` in the number pad I represented the object as an Array of Array of Strings, so when getting the value and coordinates I return `object` and cast to String and int when I want the result and the new `column` and `row`. I think the code is fairly straight forward, and not too complex.
