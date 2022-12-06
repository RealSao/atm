# Changes made since project 4 and 5:
# Optimize the terminal output to make it look cleaner and nicer
# Fixed some error caused by invalid input (add input validation)
# Make the code cooperate with self build database
# Add "add account" feature
# Add break in feature in the UI: Simulate someone breaks the ATM

# The GUI is in the html folder
# Procedure to run:
# First, clone this project and open it with any IDE/editor
# To view login/register page, clicks on the login.html file and run it
# You should be able to switch between login and register page
# To view any other pages, clicks on the homepage.html and runs it
# You should be able to redirect to any page with the correct button clicked


# The Demo of the project is in the PartialFunction folder
# Procedure to run:
# Clicks on login.java file and runs it
# Please avoid entering non-numerical values when prompted to choose from a menu
# That will breaks the program since input are read with nextInt
# accounts.txt and users.txt are our databases which stores user infomartion and account information

# If you want to test the demo with blank database at the beginning, you could delete everything in accounts.txt and users.txt
# Or create your own file of .txt format and change the path in Bank.java to ./PartialFunctions/your_file_name.txt (4 changes needed)
# If you want to have predefined users and accounts, pls follow the format
# accounts.txts: <Account_Num (8 digits or characters)><space><balance (at most 2 decimal places)><newline>
# users.txt: <username><space><password><space><Account 1><space><Account 2><space>...<space><Account n><newline>
# Notice that blank lines will not be detected, you could add blank lines (newline) in between any lines or at the end
# But do no have anything else other than just newlines