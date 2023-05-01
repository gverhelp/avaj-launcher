#!/bin/bash

GREEN='\033[1;32m'
RED='\033[1;31m'
YELLOW='\033[1;33m'
BLUE='\033[1;34m'
NC='\033[0m'

function print_header() {
    local title="$1"
    local title_len=${#title}
    local width=80
    local border=$(printf "%${width}s" | tr " " "=")
    local padding=$(printf "%$((($width-$title_len-2)/2))s")

    echo -e "${BLUE}${border}${NC}"
    echo -e "${BLUE}|${NC}${padding}${title}${padding}${BLUE}|${NC}"
    echo -e "${BLUE}${border}${NC}"
}

function print_title() {
    local title="$1"
    local title_len=${#title}
    local width=40
    local border=$(printf "%${width}s" | tr " " "=")
    local padding=$(printf "%$((($width-$title_len-2)/2))s")

    echo -e "\n${GREEN}${border}${NC}"
    echo -e "${GREEN}|${NC}${padding}${title}${padding}${GREEN}|${NC}"
    echo -e "${GREEN}${border}${NC}"
}

if [ "$#" -ne 1 ]; then
  echo -e "${RED}Error: Please provide the path of the scenario as argument.${NC}">&2
  exit 1
fi

print_header "Testing <${1}>"

###########
# Compile #
###########
print_title "Compile:"

echo -e "${YELLOW}Find the .java files using:${NC} 'find * -name "*.java" > sources.txt'"
find * -name "*.java" > sources.txt

while read line
do
  echo -e "${line}"
done < sources.txt
echo -e "${GREEN}-> SUCCESS : File has been printed! <-${NC}"

echo -e "${YELLOW}\nCompile the .java files using:${NC} 'javac @sources.txt'"
javac @sources.txt
echo -e "${GREEN}-> SUCCESS : All the .class files are created! <-${NC}"

###########
# Execute #
###########
print_title "Execute the program:"

echo -e "${YELLOW}Execute the program using:${NC} 'java ro.academyplus.avaj.simulator.Simulator ${1}'"
java ro.academyplus.avaj.simulator.Simulator ${1}
echo -e "${GREEN}-> SUCCESS : The program has been executed! <-${NC}"

#######################
# Print scenario file #
#######################
print_title "Print scenario file:"

while read line
do
  echo -e "${line}"
done < ${1}
echo -e "${GREEN}-> SUCCESS : File has been printed! <-${NC}"

################
# Print result # 
################
print_title "Print result:"

echo -e "${YELLOW}Print the simulation.txt file using:${NC} 'cat -e simulation.txt'"
cat -e simulation.txt
echo -e "${GREEN}-> SUCCESS : The simulation file has been printed! <-${NC}"

#########################
# Delete unuseful files # 
#########################
print_title "Delete unuseful files:"

echo -e "${YELLOW}Searching for .class files...${NC}"
for file in $(find ./ro/academyplus/avaj/simulator -name "*.class"); do
    echo -e "${RED}Deleting $file${NC}" && rm -rf ${file}
done
echo -e "${RED}Deleting ./sources.txt${NC}" && rm -rf ./sources.txt
echo -e "${RED}Deleting ./simulation.txt${NC}" && rm -rf ./simulation.txt
echo -e "${GREEN}-> SUCCESS : Files has been deleted! <-${NC}"