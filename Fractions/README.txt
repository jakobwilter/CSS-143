PROJECT TITLE: Fractions
PURPOSE OF PROJECT: Implements data structures, reading inputs from files, and counters to evaluate a file containing fractions.
VERSION or DATE: 2018
AUTHORS: Jakob Wilter

PROJECT DESCRIPTION: This program reads in a series of fractions from a text file, which will have each line 
formatted as follows: “A/B”.  A sample text file is provided in the Fractions folder. Program reads in one line at a time 
and builds a Fraction object from A and B.  For each unique Fraction seen, program will create a FractionCounter object 
used to track the number of occurrences of that specific fraction.  When all the input is consumed, the program will print
out its ObjectList of unique FractionCounters, which will report the fraction and its count. 

* Assumption: no blank lines or misleading characters; see the text file for the valid inputs. 
