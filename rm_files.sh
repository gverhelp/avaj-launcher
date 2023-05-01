#!/bin/bash

GREEN='\033[1;32m'
RED='\033[1;31m'
NC='\033[0m'

for file in $(find ./ro/academyplus/avaj/simulator -name "*.class"); do
    echo -e "${RED}Deleting $file${NC}" && rm -rf ${file}
done

if [ ! -e ./simulation.txt ] || [ ! -e ./sources.txt ]; then
    exit 0
fi

echo -e "${RED}Deleting ./sources.txt${NC}" && rm -rf ./sources.txt
echo -e "${RED}Deleting ./simulation.txt${NC}" && rm -rf ./simulation.txt
echo -e "${GREEN}-> SUCCESS : Files has been deleted! <-${NC}"