# ZillionGroup
API that searches NASA patents and determines the number of palindromic strings that can be created from inventor's name.


Details
-------
The implementation should expose a service at the following entry point:
```
GET /palindromes
```
The service accepts the following parameters:

Name | Required | Default | Description
---- | -------- | ------- | -----------
`search` | yes | - | patent search text
`limit`  | no  | 1 | number of patents considered (min:1, max:5)

Request example:
```
GET /palindromes?search=electricity&limit=3
```

The service should search the NASA patents for given text and retrieve up to given number of patents. For each extracted inventor, first and last name should be concatenated into a single string (e.g. `"Graham"` and `"Bell"` becomes `"Graham Bell"`). For each such name the service should calculate the number of palindromic strings that can be created using the name letters. Name should be treated as case-insensitive (i.e. `b` and `B` is the same letter) and all white-spaces should be ignored. A valid palindromic string is one that uses only the letters in the given name, and is the same length as the given name. Each letter can be used more than once, and not every letter must be used. For example, given the name `"Graham Bell"`, `"aaahhhhaaa"` and `"bellmmlleb"` are valid, but `"aaa"` and `"hhhsagtbbb"` are not. Results should be returned in JSON format sorted by the count, highest to lowest.

Response example (with actual palindrome counts):
```
[
    { "name": "Nicola Tesla", "count": 531441 },
    { "name": "Max Planck", "count": 32768 },
    { "name": "Marie Curie", "count": 16807 },
    { "name": "Maria Mayer", "count": 7776 }
]
```
Solution
-------
Following is the algorithm used to get the required count for the palindrome.
 Check if the number of characters is even then calculate with the formula : 
 `u^n/2`
  else if the number of characters is odd then calculate with the formula 
  ```u^(n+1)/2
     where u is unique chars
     and n is number of chars
  ```
  Take a simple example of 2 unique characters (`a` & `b` )and and 3 is the string length
  Following will be list of valid palindromes
  ``` 
  aaa,
  bbb,
  aba,
  bab
  ``` 
  which according to the formula is `u^(n+1)/2`
  
  Installation
---------------
###Build an executable JAR

I have used Spring Boot and Gradle for deploying the application. It was build in STS. 

 you can run the application using ./gradlew bootRun.
![alt text](https://github.com/dipikam86/ZillionGroup/blob/master/images/bootRun.png "Spring Boot Run")

  Output
---------------
Palindrome result for query 
`localhost:8080/palindromes?search=electricity&limit=1`
![alt text](https://github.com/dipikam86/ZillionGroup/blob/master/images/demo1.png "Spring Boot Run")
`localhost:8080/palindromes?search=electricity&limit=0`
![alt text](https://github.com/dipikam86/ZillionGroup/blob/master/images/demo3.png "Spring Boot Run")
`localhost:8080/palindromes?search=electricity&limit=6`
![alt text](https://github.com/dipikam86/ZillionGroup/blob/master/images/demo4.png "Spring Boot Run")

Thanks 
--------------
  
