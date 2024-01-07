# Python script to create inputs to test the subsets (n=991, 1982,...,9910)
# 07 March
# Lehlohonolo Mosikili

import random
import csv

# Open full vaccinations data file to generate random inputs of date and countries
with open('data/vaccinationsbig.csv') as csv_file:
    csv_reader = csv.reader(csv_file)
    array = list(csv_reader)
    csv_file.close()

lines = [array[random.randint(0,9919)][1]] # creates random dates

for i in range(30):
    lines.append(array[random.randint(0,9910)][0]) # appends random countries
lines.append('')

with open('testinput5.txt','w') as f:
    for line in lines:
        f.write(line)
        f.write("\n")