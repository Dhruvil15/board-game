/**
 Author: Dhruvil Trivedi
 This class creates the board of the game and has proper checking methods.
 */

public class Board {

    Piece[][] board;

    public Board(){
        board = new Piece[8][8];
    }

    //method for adding a piece to the game
    public void addPiece(Piece piece){
        int x = piece.getPosition().getXpos();
        int y = piece.getPosition().getYpos();
        Piece p = board[x][y];

        if(board[x][y] == null){
            board[x][y] = piece;
        }else{
            System.out.println("Cannot add game piece, already a game piece placed.");
        }
    }

    //method for checking that a piece can be added or not in the board
    public boolean check(position position, String direction, int n){
        int x = position.getXpos();
        int y = position.getYpos();
        Piece p = board[x][y];

        switch (direction) {
            case "left":
                if (board[x][y-n] == null && y - n >=-1) {
                    return true;

                } else {
                    System.out.println("ERROR: can't make the piece move.");
                    return false;
                }

            case "right":
                if (board[x][y+n] == null && y + n < 8) {
                    return true;

                } else {
                    System.out.println("ERROR: can't make the piece move.");
                    return false;
                }

            case "up":
                if (board[x-n][y] == null && x - n >= 0) {
                    return true;

                } else {
                    System.out.println("ERROR: can't make the piece move.");
                    return false;
                }

            case "down":
                if (board[x+n][y] == null && x + n < 8) {
                    return true;

                } else {
                    System.out.println("ERROR: can't make the piece move.");
                    return false;
                }
        }
        return false;
    }

    //method for making a move for a piece in the game
    public void move(String direction, int n, position position) {
        int x = position.getXpos();
        int y = position.getYpos();
        Piece p = board[x][y];

        if (check(position, direction, n)) {
            if (p instanceof SlowFlexible) {
                if (((SlowFlexible)p).move(direction)) {
                    board[p.getPosition().getXpos()][p.getPosition().getYpos()] = p;
                    board[x][y] = null;
                }
            }
            else if (p instanceof FastFlexible) {
                if (((FastFlexible)p).move(direction, n)) {
                    board[p.getPosition().getXpos()][p.getPosition().getYpos()] = p;
                    board[x][y] = null;
                }
            }
            else if (p instanceof FastPiece) {
                if (((FastPiece)p).move(direction, n)) {
                    board[p.getPosition().getXpos()][p.getPosition().getYpos()] = p;
                    board[x][y] = null;
                }
            }
            else {
                if (((SlowPiece)p).move(direction)) {
                    board[p.getPosition().getXpos()][p.getPosition().getYpos()] = p;
                    board[x][y] = null;
                }
            }
        }

        if (p==null){
            System.out.println("There's no game piece there, please try another.");
        }
    }


    //method to display the board in the game
    public void display(){
        for (Piece[] pieces : board) {
            for (int j = 0; j < board.length; j++) {
                Piece p = pieces[j];
                if (p == null)
                    System.out.print("-\t");
                else
                    System.out.print(p + "\t");
            }
            System.out.println();
        }
    }
}
