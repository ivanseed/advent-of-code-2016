## Day 1: No Time for a Taxicab

### [Source](./Solution.java)

To test the solution, copy and paste your given inputs into the data.txt or just pass everything as a String. Make sure you call `parseDataFile(path)` or `parseDataString(data)` in the correct manor.

Imagine you are originally facing North, if you were to go Left, you would then face West or if you went Right you would face the East. From this we can write that:

* From `North` you can go `West` or `East`.
* From `East` you can go `North` or `South`.
* From `South` you can go `East` or `West`.
* From `West` you can go `South` or `North`.

You can basically only go clockwise 90 degree or counter clockwise by 90 degrees.

To represent NESW I use an int called `facing` which determines which position you are facing by simply starting from 0 (North) and adding +1 or -1 depending if you turned left or right. To ensure we keep the range between 0 and 3 we can % 4, and to ensure we stay in the positive index `+4` whenever we `-1` and `+1`.

Simply iterate through all the commands and get a final position which is represented as `X, Y`, then `abs(X) + abs(Y)` provides the _step 1_ answer.

I have created a separate method that does the same but keeps track of every single point, by adding every point between position `N` and `N + 1`. At the end of the calculation :
> Then, you notice the instructions continue on the back of the Recruiting Document. Easter Bunny HQ is actually at the first location you visit twice.

You could easily edit the code to check after each movement, to then break through following the rest of the commands.

i.e. move the command after the `addVisitedPoints...` method so then you can just return `if != NULL` to break out of the code, without calculating the rest of the commands.

Again this is subject to interpretation, I read it as do this calculation after moving rather then checking while you are moving.
