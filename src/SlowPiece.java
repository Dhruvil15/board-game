/**
 Author: Dhruvil Trivedi
 This class is has all the details about a SlowPiece in the game.
 */

//This class extends the piece class
public class SlowPiece extends Piece {

    public SlowPiece(String name, String colour, position position){
        //calling the constructor of the super class
        super(name,colour,position);
    }

    //if the user enters move then it will first check that space is empty and if true then place the piece there
    public Boolean move(String direction){

        if (direction.equals("left") && position.getYpos()>=1){
            position.setYpos(position.getYpos()-1);
            return true;

        }else if(direction.equals("right") && position.getYpos()<8){
            position.setYpos(position.getYpos()+1);
            return true;

        }else{
            System.out.println("Invalid movement direction or magnitude.");
            return false;
        }
    }

    public String toString(){
        return (super.toString() + "SP");
    }
}
