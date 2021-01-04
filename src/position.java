/**
 Author: Dhruvil Trivedi
 This class is has all the details about a Position in the game.
 */

public class position {

    //variable declaration
    private int xpos, ypos;

    //constructor initializing the variables
    public position(int xpos, int ypos){
        this.xpos = xpos;
        this.ypos = ypos;
    }


    //getters and setters
    public int getXpos(){return xpos;}
    public int getYpos(){return ypos;}

    public void setXpos(int xpos){this.xpos=xpos;}
    public void setYpos(int ypos){this.ypos=ypos;}

    public String toString(){
        return (xpos+","+ypos);
    }
}
