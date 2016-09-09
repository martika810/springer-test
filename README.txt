
I used maven to create the progress. To implement the test my approach is the following:

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
      
      The zip file contains a build. Run it using: java -jar <jar_file>
      
   POSSIBLE ERRORS:
   
   In case the command is unknown it could display some help information with the available
   commands and then allow you to enter the command again.
   
   In case the line or the rectangle goes out of the canvas, it could be truncated.
  