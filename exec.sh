#!/bin/bash

GREEN='\033[1;32m'
RED='\033[1;31m'
YELLOW='\033[1;33m'
NC='\033[0m'

if [ "$#" -ne 1 ]; then
  echo -e "${RED}Error: Please provide the path of the scenario as argument.${NC}">&2
  exit 1
fi

echo -e "${YELLOW}Find the .java files using:${NC} 'find * -name "*.java" > sources.txt'"
find * -name "*.java" > sources.txt
echo -e "${GREEN}-> SUCCESS : Print sources.txt file: <-\n${NC}"

echo -e "${YELLOW}Compile the .java files using:${NC} 'javac @sources.txt'"
javac @sources.txt
echo -e "${GREEN}-> SUCCESS : All the .class files are created! <-\n${NC}"

echo -e "${YELLOW}Execute the program using:${NC} 'java ro.academyplus.avaj.simulator.Simulator $1'"
java ro.academyplus.avaj.simulator.Simulator $1
echo -e "${GREEN}-> SUCCESS : The program has been executed! <-${NC}"