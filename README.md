# Pet Pal: A Java-based Desktop Application for Tracking Pet Care
## Project Proposal 
<!--Added Title and Sub-title-->

- This application allows pet owners to keep track of important 
activities related to their pet's care and well-being. The application
will let users record when they fed, gave water, gave treats, 
and took their pet for a walk. Additionally, the application will 
offer personalized recommendations for pet owners, based on 
the previous recorded activities. This will help determine 
the pet's current needs and provide helpful suggestions on 
how to address any signs of irritation or distress.
This innovative feature will make it easier for pet 
owners to care for their pets, ensuring their well-being 
and comfort, even in uncertain situations.
The application will also provide a user-friendly interface for viewing the recorded activities, 
searching and filtering through them, and setting reminders for 
regularly scheduled tasks. The application will be designed to be 
easy to use and understandable, so that pet owners can quickly and 
efficiently manage their pet's care.


- The target users of this application are pet owners who want an 
efficient and convenient way to keep track of their pet's daily 
routine. The app will be particularly useful for people who have 
busy schedules and need to keep track of their pet's activities 
to ensure they are providing proper care. 


- This project is of interest to me because I am a pet owner myself, and I understand 
the importance of tracking my pet's care to ensure their well-being. Furthermore, this app would make it
easier for newly turned pet-owners to cater to the requirements of their pets, easily and without any confusions by keeping in track
when and how they last interacted with their pets. I believe that this project will provide me with an opportunity 
to combine my interest in pet care with my passion for programming
and software development.
<!--Used Bulleted points to answer each of the questions.-->

## User Stories:

- As a user, I want to be able to add my new pet to the list of pets I have
- As a user, I want to be able to delete a pet I don't own anymore
- As a user, I want to see all the pets I have in my house
- As a user, I want to update an interaction with a pet I recently performed, such as giving water to the pet
- As a user, I want to see a history of interactions performed with a selected pet
- As a user, I want recommendations from the app for what to do at current time to cater to my pet's needs
- As a user, I want to save my House of Pets to a file (if I so choose)
- As a user, I want to be able to load my House of Pets from a file (if I so choose)

# Instructions for Grader

- Run the GUI Application by running HouseOfPetsGUI.java file in UI Package.
- You can generate the first required action related to adding Xs to a Y by clicking the button "Add a pet", thereafter
  filling in the required information.
- You can generate the second required action related to adding Xs to a Y by clicking the "Remove a pet" button,
  thereafter choosing a pet you want to remove from the HouseOfPets.
- You can locate my visual component by adding a pet first and then clicking "Show all pets" button which would show
  names of the added pets along with corresponding images.
- You can save the state of my application by clicking "Save" button.
- You can reload the state of my application by clicking "Load" button.

# Phase 4: Task 2
Wed Apr 12 17:12:55 PDT 2023 \
Added Pet: Tommy\
Wed Apr 12 17:12:56 PDT 2023\
Removed Pet: Tommy\
Wed Apr 12 17:12:58 PDT 2023\
Added Pet: ABC\
Wed Apr 12 17:13:02 PDT 2023\
Played with Pet: ABC\
Wed Apr 12 17:13:04 PDT 2023\
Played with Pet: ABC\
Wed Apr 12 17:13:05 PDT 2023\
Converted pet to JSON format for saving locally\
Wed Apr 12 17:13:05 PDT 2023\
Created a JSON array of all pets in HouseOfPets for saving locally\
Wed Apr 12 17:13:05 PDT 2023\
Put the jsonArray of pets into JSON object for saving locally\
Wed Apr 12 17:13:07 PDT 2023\
Created a list of Pet Names to be shown on screen 

# Phase 4: Task 3
Some of the refactoring I'd like to do to this project are:\
Abstraction: Implementing abstraction in my UI package would help increase code cohesion and reduce code duplications. Specifically, if I create an abstract class for all the panels in my project and make each of them extend that class would help implement this idea. One potential disadvantage of this concept is, that if there is a problem or error in the abstract class, this would lead to errors in all classes that extend it.\
Exception handling: Introducing exception handling to this project would make it even more robust and more ready to be deployed to the public for use. But Exception handling increases code complexity and increases the memory usage of our project.

<!--
## A subtitle

A *bulleted* list:
- item 1
- item 2
- item 3

An example of text with **bold** and *italic* fonts.  
-->