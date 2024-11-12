# Workshop

**Back-end:**

1) Build the application `mvn clean install`
2) Start the application with `mvn spring-boot:run`
3) Test the API endpoints with for example the API-testtool Bruno, download: https://www.usebruno.com/downloads \
You can open the Bruno project from the bruno folder in the Workshop project. \
Try to get all objects, an object with a certain id, update (put) an object, add (post) an object, and delete an object.
After every change, you can get the list of all objects again and see the change.
4) Optional: Try to add a new request in Bruno to get all objects from a specific type.
5) Optional: Try to add a new endpoint in the AstronomicalObjectController for a specific name, and test this in Bruno.

**Front-end:**

1) Open a command prompt in the workshop-gui folder and use the following command to install the packages:
`npm install`
2) When you've done this you can start the project with:
`ng serve --open`
Tip: You can use F12 to see the chrome devtools (with possible errors, logging, etc)
3) For the front-end you can try to display more data on the screen
- you can use html to display it in a list or a table (https://www.w3schools.com/html/)
- you can add some styling using css (https://www.w3schools.com/css/)
- you can use angular material (a UI component library) to present the data in a card (https://material.angular.io/components/card/examples)
4) Or you can try to add the function to get the objects by type and log them in the console / present them on screen. \
Tip: You can use the getObjectById() function as an example.
 