I imported a print writer to print to the output file
- a scanner to scan in the input file (Fail2Ban.txt)
- a File Class so I can instantiate a file object f 

the the file object takes in param args[0] which is the first file name in the command line (Fail2Ban.txt)
the print writer takes in param args[1] which is the second file name in the command line, output file 
the scanner take in the file object 
while the scanner has next line(ie. for each line in the file), we split the line by space and created an array of strings and assigned it to an array called words 
--if sixth element in the array words is valid, then we add the 10th element in that same array to a new arraylist called ips 
--after all the lines in Fail2Ban.txt or inputfile has been processed in the while loop, we close input
I passed in the arraylist of invalud ip addresses to the frequency method to generate an arraylist of counts
for each element in the ip arraylist that is not "counted", I reassigned that element to a new arraylist called countedIps
so the index of each counts matches with the index of counted ips 
for each element in counts, if that integer value is larger than 3, I printed the element in countedips with the same index number 

I created a seaprate method called frequency which takes in an arraylist of Strings (invalid ip addresses) and iterates through each ip in the array
--each ip is compared to the all ips on its right 
--when an ip on the right is same as the current ip, the ip on the right is mutated to string counted and we increment count by 1
--count goes back to 0 each time the outter for loop starts(ie. we restart the count for every element)
--we only compare the element to all elements on its right if that element is not marked as counted
--returns a arraylist of counts for the frequency of each invalid IP address 
--this method is also a mutator method where it turns every element that was counted into "counted" except the first instance 


