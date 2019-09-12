# Dave Queiser's Indie Project

This project will do something travel-related. I am sure it will be awesome. 
Everything that follows is from Ex 1, and will need to be updated. Later. 

## Getting Started

To begin using this project:

1. Accept the assignment using the provided link. This will create a repository containing this exercise.
2. Copy the clone url from your repository in GitHub.
3. From the IntelliJ Welcome Screen, check out the project from Git/GitHub using the clone url you copied above.
4. Edit the run configuration.
5. Build and deploy.
6. The application should deploy, but it will not function correctly since there is no database connected at this point.
7. Explore the code to understand what's been given to you.


## Next Steps

1. Create the database. You can use the sql below, or, you may write your own.

        mysql> CREATE DATABASE sample;
       
1. Select the database you just created. 

        mysql> use sample
    
1. Create the user table.
    
        mysql> create table user
               (
                 id int auto_increment
                   primary key,
                 first_name varchar(25) null,
                 last_name varchar(30) null,
                 user_name varchar(15) null,
                 password varchar(30) null,
                 date_of_birth date null,
                 constraint users_user_name_uindex
                 unique (user_name)
               );

1. Populate the user table. 

        insert into user values (1, 'Joe', 'Coyne', 'jcoyne', 'supersecret1', '1964/04/01');
        insert into user values (2, 'Fred', 'Hensen', 'fhensen', 'supersecret2', '1988/05/08');
        insert into user values (3, 'Barney', 'Curry', 'bcurry', 'supersecret3',  '1947/11/11');
        insert into user values (4, 'Karen', 'Mack', 'kmack', 'supersecret4', '1986/07/08');
        insert into user values (5, 'Dianne', 'Klein', 'dklein', 'supersecret5', '1991/01/22');
        insert into user values (6, 'Dawn', 'Tillman', 'dtillman', 'supersecret6', '1979/08/30');
        
1. Find and complete the TODO in "database.properties" to configure the program to use the database you created above. Question: did you know you can easily find all TODOs in intelliJ with a single click?

1. Once the TODO is completed, build and deploy. The application should open in the browser, and clicking the "Go to the User Search" link should show you a list of users, but this probably isn't working quite yet...

1. What if any errors do you see in the console? Do you see this "SearchUser.getAllUsers()...SQL Exception: java.sql.SQLException: The server time zone value 'CDT' is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specifc time zone value if you want to utilize time zone support."? 
The fix is to run this command in mysql: SET GLOBAL time_zone = '-6:00';  If this error had happened and the fix wasn't included here, what would you have searched to find the correct answer?  Try your search idea to see if you find the same solution.

1. After fixing that error, it's likely you'll encounter one more bug to fix in the code. Use the console and the debugger to figure out what very small change you need to make.

1. Remember to build and deploy after any code change. If you make the correct code fix, you should see a list of users. It's not pretty, but you'll fix that in a little bit.

## Next Next Steps

1. Add to the project such that the completed application provides the ability to search for and display users from the database. The user display/search results
    should include userid, first name, last name, and age, and be displayed in a table. At minimum, provide a last name search. Some TODOs have been added to help you get started.
    
## Exercise Submission

To receive credit for this exercise:

1. Take a screenshots of your search screen and search results screen.  Please be sure that Barney Curry is included in the output and that his age is correct.
2. Create a directory named "screenshots" to your project. 
3. Add the screenshots from step 1 to your screenshots directory.
2. Push your completed code to GitHub. 
3. Verify your latest code and screebshots are visible on GitHub.

