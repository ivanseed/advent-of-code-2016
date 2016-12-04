# Day 4: Security Through Obscurity

### [Source](./Solution.java)

To test the solution, copy and paste your given inputs into the data.txt.

Day 4 is a step up from the previous days, providing much more of a challenge. My solution takes on a very object orientated approach while making use of maps. There are some really impressive solutions on the sub-reddit which I can only hope to come close to the elegancy they display. While parsing the data I save important snippets into the `Room` object so that they can be accessed when needed, then using a Map I go through the String to determine frequency. Then I use a custom comparator I sort the frequency map and compare it to the check sum.

For part 2 I just call a custom method to rotate valid `Room` object strings against their sector id and then you can go through all of the Strings to see the output, but I have left in a `contains` loop to print out the sector id of the `Room` the answer is looking for.
