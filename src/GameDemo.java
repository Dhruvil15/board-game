/**
 Author: Dhruvil Trivedi
 This is the demo class of the game and has a main class.
 */

import java.util.Scanner;

public class GameDemo {

        //board object for assessing the methods of Board class
        static Board b = new Board();

        //This method will print the board
        public static void display(){
            b.display();
        }

        //This method is for the reference of the user to know what they can do in this game
        public static void help(){
            System.out.println("Possible commands are as follows: ");
            System.out.println("create location [fast][flexible]: Creates a new piece.");
            System.out.println("move location direction [spaces]: Moves a piece.");
            System.out.println("print: Displays the board.");
            System.out.println("help: Displays help.");
            System.out.println("exit: Exits the program.");
        }

        //This method will check is the point entered are valid or not
        public static Boolean valid(int xpos, int ypos){
            return (xpos>=0 && xpos<8) && (ypos>=0 && ypos<8);
        }

        //This method will make a slowpiece in the game
        public static void buildSlowPiece(int xpos, int ypos){
            if(!valid(xpos, ypos)){
                System.out.println("no piece at "+xpos + "," + ypos);
                return;
            }

            //asks for colour and name
            Scanner kb = new Scanner(System.in);
            System.out.print("Enter a name for your slow non-flexible piece: ");
            String name = kb.next();
            System.out.print("Enter a colour: ");
            String colour = kb.next();

            //add the created piece to the board
            SlowPiece newSlowPiece = new SlowPiece(name, colour, new position(xpos, ypos));
            b.addPiece(newSlowPiece);

            //prints conclusion statement
            System.out.println("Created new game piece.");

        }

        public static void buildFastPiece(int xpos, int ypos){
            if(!valid(xpos, ypos)){
                System.out.println("no piece at "+xpos + "," + ypos);
                return;
            }

            //asks for colour and name
            Scanner kb = new Scanner(System.in);
            System.out.print("Enter a name for your fast non-flexible piece: ");
            String name = kb.next();
            System.out.print("Enter a colour: ");
            String colour = kb.next();


            //add the created piece to the board
            FastPiece newFastPiece = new FastPiece(name, colour, new position(xpos, ypos));
            b.addPiece(newFastPiece);

            //prints conclusion statement
            System.out.println("Created new game piece.");
        }

        public static void buildSlowFlexible(int xpos, int ypos){
            if(!valid(xpos,ypos)){
                System.out.println("no piece at "+xpos + "," + ypos);
                return;
            }

            //asks for colour and name
            Scanner kb = new Scanner(System.in);
            System.out.print("Enter a name for slow flexible piece: ");
            String name = kb.next();
            System.out.print("Enter a colour: ");
            String colour = kb.next();

            //add the created piece to the board
            SlowFlexible newSlowFlexible = new SlowFlexible(name, colour, new position(xpos, ypos));
            b.addPiece(newSlowFlexible);

            //prints conclusion statement
            System.out.println("Created new game piece.");
        }

        public static void buildFastFlexible(int xpos, int ypos){
            if(!valid(xpos,ypos)){
                System.out.println("no piece at "+xpos + "," + ypos);
                return;
            }

            //asks for colour and name
            Scanner kb = new Scanner(System.in);
            System.out.print("Enter a name for fast flexible piece: ");
            String name = kb.next();
            System.out.print("Enter a colour: ");
            String colour = kb.next();

            //add the created piece to the board
            FastFlexible newFastFlexible = new FastFlexible(name, colour, new position(xpos, ypos));
            b.addPiece(newFastFlexible);

            //prints conclusion statement
            System.out.println("Created new game piece.");
        }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        boolean exit = false;

        while (!exit){

            System.out.println("Enter a command (Type help for details): ");
            String inputFinal = in.nextLine();
            Scanner kb = new Scanner(inputFinal);
            String input = kb.next();
            //take first word and make a scanner for it

            //otherwise, command is invalid and error message given
            if ("help".equals(input)) {  //ask for help
                help();
            } else if ("exit".equals(input)) {  //ask to exit program
                System.out.println("Done.");
                exit = true;
            } else if ("print".equals(input)) {  //ask to print the board
                display();
            } else if ("create".equals(input)) {  //ask to create a new piece
                //if hasNext int
                if (kb.hasNextInt()) {
                    //take the x pos
                    int xpos = kb.nextInt();
                    //if hasNext int
                    if (kb.hasNextInt()) {
                        //take the y pos
                        int ypos = kb.nextInt();
                        //if hasNext string for type
                        if (kb.hasNext()) {
                            //check string for type (fast or slow or redundant)
                            String type = kb.next();
                            //if fast
                            if (type.equals("fast")) {
                                //if hasNext string for flexibility
                                if (kb.hasNext()) {
                                    //check for flexibility (flexible or nonflexible)
                                    String flexibleFast = kb.next().toLowerCase();
                                    //if flexible
                                    if (flexibleFast.equals("flexible")) {
                                        //MAKE FAST FLEXIBLE
                                        buildFastFlexible(xpos, ypos);
                                        //else
                                    } else {
                                        //MAKE FAST NON-FLEXIBLE
                                        buildFastPiece(xpos, ypos);
                                    }
                                } else {
                                    //no valid flexibility given, make non-flex fast
                                    buildFastPiece(xpos, ypos);
                                }
                                //else if slow
                            } else if (type.equals("slow")) {
                                //if hasNext string for flexibility
                                if (kb.hasNext()) {
                                    //check for flexibility (flexible or nonflexible)
                                    String flexibleSlow = kb.next().toLowerCase();
                                    //if flexible
                                    if (flexibleSlow.equals("flexible")) {
                                        //MAKE SLOW FLEXIBLE
                                        buildSlowFlexible(xpos, ypos);
                                        //else
                                    } else {
                                        //MAKE SLOW NON-FLEXIBLE
                                        buildSlowPiece(xpos, ypos);
                                    }
                                } else {
                                    //no valid flexibility given, make slow non-flex
                                    buildSlowPiece(xpos, ypos);
                                }

                                //else (no valid specified speed)
                            } else {
                                //MAKE A SLOW-NONFLEX
                                System.out.println("No valid type specified. Default to slow non-flexible piece.");
                                buildSlowPiece(xpos, ypos);
                            }

                            //else (no specified speed)
                        } else {
                            //MAKE A SLOW NON-FLEX
                            System.out.println("No type specified. Default to slow non-flexible piece.");
                            buildSlowPiece(xpos, ypos);
                        }
                        //else (no ypos int)
                    } else {
                        //INVALID COMMAND
                        System.out.println("ERROR: No y-position given.");
                    }

                    //else (no xpos int)
                } else {
                    //INVALID COMMAND
                    System.out.println("ERROR: No x-position given.");
                }
            } else if ("move".equals(input)) {  //ask to move a piece
                //if hasNext int
                if (kb.hasNextInt()) {
                    //take the xpos
                    int xpos = kb.nextInt();
                    //if hasNext int
                    if (kb.hasNextInt()) {
                        //take the ypos
                        int ypos = kb.nextInt();
                        //if hasNext direction
                        if (kb.hasNext()) {
                            //take the direction as string
                            String direction = kb.next();
                            //if hasNext int
                            if (kb.hasNext()) {
                                //take the magnitude
                                int mag = kb.nextInt();
                                //MOVE PIECE at (x, y) IN GIVEN DIRECTION WITH GIVEN MAGNITUDE
                                b.move(direction, mag, new position(xpos, ypos));
                                //else
                            } else {
                                //MOVE PIECE at (x, y) IN GIVEN DIRECTION WITH MAGNITUDE 1
                                b.move(direction, 1, new position(xpos, ypos));
                            }
                            //else (no direction)
                        } else {
                            //INVALID COMMAND
                            System.out.println("ERROR: No direction given.");
                        }
                        //else (no ypos int)
                    } else {
                        //INVALID COMMAND
                        System.out.println("ERROR: No y-position given.");
                    }
                    //else (no xpos int)
                } else {
                    //INVALID COMMAND
                    System.out.println("ERROR: No x-position given.");
                }
            } else {
                System.out.println("Invalid Command.");
            }
            System.out.println(); //line gap between command runs
        }
    }
}


