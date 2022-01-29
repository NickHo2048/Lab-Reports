## Original Code
##### Code
![OriginalCodePicture](OG.png)
##### First Error
![Test1ErrorPic](Test2Error.png)
The original code finds the hard brackets and then finds the link between the paranthesis after those brackets; however, we get **our first error** when no file containing links is passed. We get an IndexOutofBoundsException that must be resolved. 

## Updated to Account for Test 1
##### Updated Code:
![UpdatedCodePicture](Test2.png)
##### Error:
![Test2ErrorPic](Fix.png)
Previously, the **failure-inducing input** was not passing a file at all, and the **symptom** was the IndexOutofBoundsException. The implemented solution was adding a try catch system that prints out the error and tells the user to try again because **the bug** was in how we were reading in the files (it assumed we would be passing in a file at all). However, what if the file we did pass caused a bug? In this case, there is another link and set of paranthesis in side of the paranthesis. The **bug** in our code is that we assumed the link would come over the hard brackets not amongst them. As a result, the **symptom** is that we get an unexpected result. Here is the link to the new test/failure-inducing input: [Test 2](test-file4.md)

## Updated to Account for Test 2
##### Updated Code:
![UpdatedCodePicture](Test2FIXX.png)
##### Error:
![Test3ErrorPic](Additi.png)
The implemented solution was to simply skip looking for hard brackets. We simply look for the paranthesis and print out whats between them. However, what if what was between paranthesis wasn't a link? In this case, the bug is that we print out whatever is between paranthesis, and we need to determine if those are actually links or not. Here is the link to the new test/failure-inducing input: [Test 3](test-file3.md)

## Updated to Account for Test 3
##### Updated Code:
![UpdatedCodePicture](Test3Fix.png)
While not a perfect implementation, I had it immediately skip strings that contain spaces. No link can contain a space, so I figured it would be an adequate implementation. In this case, the **bug** was that we printed out whatever was between the paranthesis, and the **symptom** was that it printed out things that we did not want it to. The failure inducing input was the file with things other than links in the paranthesis. 
