# Python script to automate the process of comparing query list
# and subsets of data (n = 991, 1982,...,9910)

import csv
import os


# Open full data file
with open('data/vaccinationsbig.csv') as csv_file:
    csv_reader = csv.reader(csv_file)
    array = list(csv_reader)
    csv_file.close()


# Create a subset data file
subset = []

for i in range(991, 9920, 991):
    for j in range(i):

        subset.append(array[j]) # appends subsets of data (n = 991, 1982,...9910)

        with open('data/vaccinations.csv','w', encoding = 'UTF8', newline='') as csv_f:
            csv_writer = csv.writer(csv_f)

            csv_writer.writerows(subset)
            csv_f.close()

    os.system('java -cp bin VaccineArrayApp < testinput1.txt')
    os.system('java -cp bin VaccineBSTApp < testinput1.txt')
    subset.clear()
