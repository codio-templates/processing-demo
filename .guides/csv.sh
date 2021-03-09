#!/bin/bash

javac -cp "jars/*" code/encapsulation/"$1".java && java -cp "jars/*:code/encapsulation/:." "$1" "$2"