#!/bin/bash

javac -cp "jars/*" code/advanced/"$1".java code/advanced/"$2".java && java -cp "jars/*:code/advanced/:." "$1" "$3"