# testtaskBD2023
## Algorithm Explanation
The program follows these steps to find the unique character:
1. Split the input text into words using regular expressions.
2. For each word check if the first character is unique within the word.
3. If the first character is unique add it to the respective lists for lowercase and uppercase unique characters.
4. If the first character is not unique check the rest of the characters to find a unique one and add it to the corresponding list.
5. After processing all words check the lists for lowercase and uppercase unique characters for any character that appears only once.
6. If such a character is found it is considered the unique character and returned by the program.
