/**
Author: Dhruvil Trivedi
 This class is has all the details about a piece in the game.
 */
public class Piece {

    //Variable declarition
    private String name, colour;
    protected position position;

    //constructor
    public Piece(String name, String colour, position position){
        this.name = name;
        this.colour = colour;
        this.position = position;
    }

    //getter ans setters
    public String getName(){return name;}
    public String getColour(){return colour;}
    public position getPosition(){return position;}

    public void setname(String name){this.name=name;}
    public void setColour(String colour){this.colour=colour;}
    public void setPosition(position position){this.position=position;}

    public String toString(){
        return (getName()+ getColour());
    }

}
