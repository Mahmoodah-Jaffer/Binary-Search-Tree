#!/bin/bash
#Create set of N data from CSV file to compare the best, average and worst cases

set -x

for N in {2..501}
do
	head -n $N cleaned_data.csv | tail -n $((N-1)) > subSet1.csv

	while IFS=, read -ra arr;do
		java PowerBSTApp "${arr[0]}" >> SpeedBST.csv
				echo -n "," >> SpeedBST.csv

	done < subSet1.csv
	echo "" >> SpeedBST.csv

done
rm -f subSet.csv 