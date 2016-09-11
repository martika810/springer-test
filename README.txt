
Used maven to create the project. To implement the test my approach is the following:

  - READ INPUTS: Wrap the command input in an object CommandLine which contains:
  		-Action: Canvas,Line,Rectangle
  		-Arguments: Created three types of arguments
  		
  - DRAW : CommandLine object contains a method draw which takes as parameter an Action which will
        be executed passing the arguments received from the input.
  		
  		
   DESIGN PATTERN USED:
   
      - Command: Used the Command Design pattern because the actions(Line,Rectangle...) are 
  		independent so the command pattern provides high decoupling between them and it keeps
  		the design opened to be extended with more operations. The Canvas object will be the receiver,
  		and the concrete implementations of Action will represents the different Commands.
  		
  	  - Singleton: The canvas object is a singleton
  	  
  	  - Factory: ArgumentFactory and ActionFactory. Those will generate different objects based on the
  	  		action received. 
  	  		
   HOW TO RUN:
      
      The zip file contains a ready build. Run it using: "java -jar springer-test-1.0-SNAPSHOT-jar-with-dependencies.jar"
      The code is also available in GITHUB (https://github.com/martika810/springer-test)
      To run it : 
            - clone repo
      		- mvn clean install
      		- run the jar using (java -jar). Run the file named "springer-test-1.0-SNAPSHOT-jar-with-dependencies.jar"
      
      
   POSSIBLE ERRORS:
   
   In case the command is unknown it could display some help information with the available
   commands and then allow you to enter the command again.
   
   In case the line or the rectangle goes out of the canvas, it could be truncated.
  
