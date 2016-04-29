#  Bru Language  ![alt text][logo]
[logo]: https://github.com/dpanu/westeros/tree/master/Docs/bru.png "Logo"
## *Compiler and Runtime Construction*
---
***
[![IMAGE ALT TEXT HERE](http://img.youtube.com/vi/YOUTUBE_VIDEO_ID_HERE/0.jpg)](http://www.youtube.com/watch?v=YOUTUBE_VIDEO_ID_HERE)
## Description
Bru is easy to use programming language for any beginner in programming. Aimed at rapid implementation, easy-to-use. Implements powerful 
features of Recursion, Stack, Symbol table, Activation Record. Showcase constructs in programming language Data types, Looping constructs, 
Conditional Statements, Function


## How to Run
Open Command Prompt cmd from your PC

```sh
cd dillinger
docker build -t <youruser>/dillinger:latest .
```

## Tools Used
* Parser / Lexer
  ANTLR 4.5
 - Translates your grammar to a parser/lexer in Java (or other target language)

Reference-style: 
![alt text][snippet]

[snippet]: https://github.com/dpanu/westeros/tree/master/Docs/antlr4.png "Snippet Text"

* Intermediate Code
Intermediate bytecode generated in Java

* Runtime Engine
Java translates Intermediate code to output

## Grammar Features
* Our grammar supports data types like boolean and number.
* Data structures supported include stacks.
* Control constructs provided are – if and while
* Can handle math operators like +, -, *, /, % 
* Handles relational operators like <, <=, >, >=, ==, !=


