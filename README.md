# Bink
W Ganizo Bink Assessment Test

As Requested, I have completed the task according to the requirements, expectations and user journey described.

In implementing the solution, I mainly used the following libraries:
1 Retrofit
To make an https request and get a response from the REST APIs.
(https://www.themealdb.com/api/json/v1/1/categories.php, https://www.themealdb.com/api/json/v1/1/filter.php?c= 
https://www.themealdb.com/api/json/v1/1/search.php?s=)
2. Glide 
To load the image from the thumbnail URLs provided to the IMAGEVIEWS  

1.	User Story Solution
DONE: (SCREEN 1 ABOVE) AC1: As a user running the application, I can view a list of recipe categories.

DONE: (SCREEN 2 ABOVE) AC2: As a user running the application, selecting a meal category will show a list of recipes for that category. 
DONE: (IMPLIMENTED THRUOT THE SOLUTION) AC3: As a user running the application, I can see a thumbnail for each item in the lists where available.

DONE: (SCREEN 3 ABOVE) AC4: As a user running the application, I can see a detail page for each recipe when selecting one from a list. 
DONE: OPTIONAL AC5: As a user running the application, I can turn off my internet connectivity and see the previously viewed recipes. 

NOTE
•	To spice up things I also implemented a cardview for my imageviews to display nice and round thumbnails
•	I also used a progress dialog.
 
CHALLENGES
The only challenge that I can note is when I tried to run the app from start without internet connection. I realized it would crash therefore I created my function to check network connection and display an error message


