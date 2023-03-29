/*∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗
        ∗ @description : This program implements the game tic tac toe
        ∗ @author: Cecilia Liu
        ∗ @acknowledgement : Miller L
∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗*/

public class TicTacToe {
    // Implement drawGrid method here
    public static void drawGrid(){
        //Draw the horizontal lines and vertical lines.
        for (int i = 0; i < 4; i++) {
            StdDraw.line(10*i,0,10*i,30);
        }
        for (int i = 0; i < 4; i++) {
            StdDraw.line(0,10*i,30,10*i);
        }
    }

    //Declare isWinnder method.
    public static int isWinner(int[][] board){

        // return 1 if player 1 wins
        if (((board[0][0]==1)&&(board[0][1]==1)&&(board[0][2]==1))||
                ((board[1][0]==1)&&(board[1][1]==1)&&(board[1][2]==1))||
                ((board[2][0]==1)&&(board[2][1]==1)&&(board[2][2]==1))||
                ((board[0][0]==1)&&(board[1][0]==1)&&(board[2][0]==1))||
                ((board[0][1]==1)&&(board[1][1]==1)&&(board[2][1]==1))||
                ((board[0][2]==1)&&(board[1][2]==1)&&(board[2][2]==1))||
                ((board[0][0])==1)&&((board[1][1])==1)&&(board[2][2]==1))
        {return 1;}

        // return 2 if player 2 wins
        else if (((board[0][0]==2)&&(board[0][1]==2)&&(board[0][2]==2))||
                ((board[1][0]==2)&&(board[1][1]==2)&&(board[1][2]==2))||
                ((board[2][0]==2)&&(board[2][1]==2)&&(board[2][2]==2))||
                ((board[0][0]==2)&&(board[1][0]==2)&&(board[2][0]==2))||
                ((board[0][1]==2)&&(board[1][1]==2)&&(board[2][1]==2))||
                ((board[0][2]==2)&&(board[1][2]==2)&&(board[2][2]==2))||
                ((board[0][0])==2)&&((board[1][1])==2)&&(board[2][2]==2))
        {return 2;}

        // return 3 if it's a tie.
        else {return 3;}
    }

    //Declare main method.
    public static void main(String[] args) {
        final int NUM_CLICKS = 9;
        final int CELL_SIZE = 10;
        final int GRID_SIZE = 30;
        boolean[][] board = new boolean[GRID_SIZE / CELL_SIZE][GRID_SIZE / CELL_SIZE];
        int[][] game = new int[3][3];
        StdDraw.setScale(-1, GRID_SIZE + 1);
        StdDraw.setPenRadius(0.005);
        // call drawGrid method
        drawGrid();
        int clicks = 0;

        // declare coordinates of mouse click
        double x, y;

        while (clicks < NUM_CLICKS) {
            if (StdDraw.isMousePressed()) {

                //get x and y parameters and concert the measure to array representation.
                x = StdDraw.mouseX();
                y = StdDraw.mouseY();
                int i = (int)(x/10);
                int j = (int)(y/10);

                if (board[i][j]) {
                    continue;
                }
                clicks++;

                //Draw the circle according to x, y parameters
                if (clicks % 2 == 1) {
                    if ((x < 30) && (x > 0) && (y < 30) && (y > 0) && (!board[(int) (x / 10)][(int) (y / 10)])) {
                        x = (int) (x / 10) * 10 + 5;
                        y = (int) (y / 10) * 10 + 5;
                        StdDraw.circle(x, y, 5);
                        game[i][j] = 1;
                    }
                }
                //Draw the cross according to x, y parameters
                else {
                    StdDraw.line(i*10,j*10, (i*10)+10, (j*10)+10);
                    StdDraw.line((i*10)+10,j*10, i*10, (j*10)+10);
                    game[i][j] = 2;
                }
                //call isWinnder Method.
                int win = isWinner(game);
                //outprint result O wins.
                if (win == 1) {
                    System.out.println("O Wins.");
                    break;
                }
                //outprint result X wins.
                else if (win == 2) {
                    System.out.println("X wins");
                    break;
                }
                //outprint result tie.
                if ((win == 3)&&board[i][j])
                {
                    System.out.println("It's a tie.");
                }
                board[i][j] = true;
            }
            StdDraw.pause(300);
        }
        System.out.println("Done.");

    }
}
