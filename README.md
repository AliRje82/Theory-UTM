# About project
This project is about universal turing machine for theory of languages and machines course in Ferdowsi university of Mashhad.
this is a document for you to undrestand the code better :).

### contributors
Ali rajaee
Sania Dolat

# What is Universal turing machine ?
A UTM is a theoretical model of computation that can simulate the behavior of any other Turing machine , Like a Computer.

![UTM](https://github.com/AliRje82/Theory-UTM/assets/121222311/6975ae80-4bfd-4bbf-bafc-a2b163aaaa7d)

As you see in this picture it has three tape one for rules the other for the state that machine is currently in and another tape that is input tape.
for more details check here: https://en.wikipedia.org/wiki/Universal_Turing_machine

# Classes
There are 4 important classes that is described 

### Turing machine (TM)
This is a simple turing machine,you can construct a turing machine by giving an array of string with Standard format.

#### Standard input format
Standard format : 
states:{(States like qn that n represent state number)}
start_state:{[starting state]}
final_states:{[final states]}
actions:{[transaction rules like (qi,1,x,R,q0)]}

for exmaple this is a turing machine for adding to number with standard format:


### Binary Turing machine (BTM)
This turing machine do everythings with 0 and 1's . note that universal turing machine can run only BTM.

BTM will convert everything to 0 and 1.
we will cover more detail about impelemntions later.

### InputTape
As you know a turing machine need infinite tape but we cant allocate such memory in our code so we made a tape that grows if necessary.

### Universal turing machine






# Implementation details
## TM
### Class attributes
![Attr](https://github.com/AliRje82/Theory-UTM/assets/121222311/f28090b8-ac87-4978-899d-250379a57374)

As you can see in the picture it has array of string for rules that save transaction rules with this format : 
qi a b L/R qj that are seprated with space and i , j is number and a and b are alphabets.
Also save all states in an array of string .
Save start and end states in string.
Save the alphabet of machine in a Arraylist.

### TM constructor 

![Tm](https://github.com/AliRje82/Theory-UTM/assets/121222311/f274ca2e-980d-4843-b351-dde7e5d37a19)

This function uses regex to find information in standard input and also saves them in class attributes.
if we have more than 1 finish state in our machine it will call a function to make just one final state and return the new rules for Tm.
it also will rise and exception if machine has more than 1 final state.

### TMtoBTM

![TMtoBTM](https://github.com/AliRje82/Theory-UTM/assets/121222311/14d1ff36-5ab6-41a6-bb97-5c3205efa4b8)

This method will return a BTM that we will cover next. It will change attrebuits to 0 and 1's.
This method will use attributes in TM to construct a BTM.
the blank will be 1
start state will be 1
and final state will be 11
L : 1
R : 11
the transaction rules will be like this 10101011011.

### Print
it is a simple method that prints attributes of class nothing fancy.

### SingeFinal




## BTM
### Class attributes

![BTM](https://github.com/AliRje82/Theory-UTM/assets/121222311/2069cea7-f5db-46f5-a38b-9f1da44afec5)
This class contains a Hashtabe to hash input tapes to 1's , and also has a rules String that contains 0 and 1's

### Constructor
nothing fancy you can just read it.

### convert

![convert](https://github.com/AliRje82/Theory-UTM/assets/121222311/614cda6e-481a-4c04-b5d3-c39d67113f6e)

This method will get a String[] as input and will convert it to 1's based on hashtable and will return a new tape.

## Input Tape
### Class attributes
a String array that every string shows a symbol of alphabet ( It has better time complexity that array of char because when you want to put a
new elemet that length is more or less than last one you should shift elements , but here its not necessery )
### Replace

![Replace](https://github.com/AliRje82/Theory-UTM/assets/121222311/9aa56c3a-00a4-4d69-8ec4-dc71c15714cc)

In replace method it will replace element i with another string that is given . it is like when you want write b on tape. 
if i was out of bound it will make tape bigger by 3 
for example if tape was blank,x,blank => blank,blank,blank,blank,x,blank,blank,blank,blank 
this will be done if and only if we want to write somewhere is out of bound.
also it will return new head because as you see in the example x was in index 1 but after resize it is in position 4

## UTM












