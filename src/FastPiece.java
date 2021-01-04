/**
 Author: Dhruvil Trivedi
 This class is has all the details about a FastPiece in the game.
 */

//This class extends the piece class
public class FastPiece extends Piece {

    //calling the constructor of super class
    public FastPiece(String name, String colour, position position){
        super(name, colour, position);
    }

     //if the user enters move then it will first check that space is empty and if true then place the piece there
    public Boolean move(String direction, int n){

        if (direction.equals("left") && (position.getYpos()-n)>=0){
            position.setYpos(position.getYpos()-n);
            return true;

        }else if(direction.equals("right") && (position.getYpos()+n)<8){
            position.setYpos(position.getYpos()+n);
            return true;

        }else{
            System.out.println("Invalid movement direction or magnitude.");
            return false;
        }
    }

    public String toString(){
        return (super.toString() + "FP");
    }
}
