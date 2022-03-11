### How I Found the Tests:
![Script.sh](Screenshot 2022-03-11 024154.png)/
For each of the versions of markdown parse, I created a script.sh file. It loops through every file with the for loop and returns its output of running the code with that file. The `-n -e` ensures the test file and the output are returned on the same line. (This helps with later comparison to immediately see which test is causing the unexpected output). To store the result, I typed `bash script.sh > results.txt`. This outputs the results of running script.sh into a file named results.txt. I did this with both versions of markdown parse. 
![Diff_Command](Screenshot 2022-03-11 024057.png)/
Then I typed `diff [insert location of results.txt] [insert location of other results.txt]`. This compared the contents of results.txt and returns the differences between the two files. 

### Test 1

### Test 2