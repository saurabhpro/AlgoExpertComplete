 ### Why does the first solution run in O(n^2) time when it only uses a single for loop?

At each iteration in the for loop, the first solution adds a character to the reversedString. In most languages where strings are immutable, adding a character to a string involves re-creating the entire string, which in turn involves iterating through every character in the string (an O(n)-time operation).

This, the first solution has us perform an O(n)-time operation at each iteration in the for loop, leading to an O(n^2)-time algorithm overall.