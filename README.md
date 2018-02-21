# CompilersProject
Group 15's project for CSCI468 Compilers.

## Setup
This project was created using Intellij and is expected to run in Intellij using maven. 
**ETHAN AND TAYLOR: IF YOU CHOOSE NOT TO USE THIS IN INTELLIJ I WILL NOT HELP YOU GET IT WORKING. USE MAVEN, DON'T BE SAVAGES.**
### 1. Create project.
Clone the repo into whatever folder you like and create a new intellij project in that folder. When asked if you want to use library control, select Maven.

### 2. Get dependencies
The pom.xml file has already been set up. right click it and find the maven popout and select "Reimport." This will download the external libraries.

### 3. Generate the grammar classes.
From the "View" -> "Tool Windows" tab on the toolbar, select maven. When the window pops up, click the document icon with the "m" on it that's labeled "Execute Maven Goal," then type antlr4:antlr4 on the command line field to generate the files for the lexer and parser.

**NOTE: IF YOU MAKE CHANGES TO THE Little.g4 FILE YOU WILL NEED TO REPEAT STEP 3 IN ORDER TO REGENERATE THE GRAMMAR.

## Running the program
Click the play button at the top of the driver class and it will automatically set up the runtime parameters. From there, you can do the same thing or click the play button on the top right bar.

## Uploading to Oxiago
Modify/Add any files from the src folder. Instead of uploading the Lexer and Parser files, just execute the g4 file using java on Oxiago. The driver can then be executed to run on the test cases (Just make sure the input file is args[0] not your filepath).
