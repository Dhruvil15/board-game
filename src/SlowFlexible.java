/**
 Author: Dhruvil Trivedi
 This class is has all the details about a SlowFlexiblePiece in the game.
 */

//This class extends the SlowPiece class
public class SlowFlexible extends SlowPiece {

    //calling the constructor of a superclass
    public SlowFlexible(String name, String colour, position position){
        super(name, colour, position);
    }

     //if the user enters move then it will first check that space is empty and if true then place the piece there
    public Boolean move(String direction){
        if (direction.equals("left") && position.getYpos()>=1){
            position.setYpos(position.getYpos()-1);
            return true;

        }else if(direction.equals("right") && position.getYpos()<8){
            position.setYpos(position.getYpos()+1);
            return true;

        }else if(direction.equals("up") && position.getXpos()>=1){
            position.setXpos(position.getXpos()-1);
            return true;

        }else if(direction.equals("down") && position.getXpos()<8){
            position.setXpos(position.getXpos()+1);
            return true;

        }else{
            System.out.println("Invalid movement direction or magnitude.");
            return false;
        }
    }

    public String toString(){
        return (super.toString() + "SF");
    }
}
