package NoGUI;

import java.util.Scanner;

public  class Main
{
    private static int x;
    private static int y;


    public static void main(String[] args)
    {
        char[][] board =    {{' ', '|', ' ', '|', ' ','|',' ','|',' '},
                            {'-', '+', '-', '+', '-','+', '-','+', '-'},
                            {' ', '|', ' ', '|', ' ','|',' ','|',' '},
                            {'-', '+', '-', '+', '-','+', '-','+', '-'},
                            {' ','|', ' ', '|', ' ','|',' ','|',' '}};

        printBoard(board);

        while (true)
        {
            Scanner in = new Scanner(System.in);
            System.out.print("input number: ");
            int mark = in.nextInt();

            placePiece(board,mark);
            check(board);
            printBoard(board);

          if (win(board) == true)
          {
               System.out.println("\nYou Win!!");
               break;
          }
        }
    }

    public static void printBoard(char[][] board) {
        for (char[] row : board)
        {
            for (char c : row)
            {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] board,int mark)
    {

        int flag=0;
        A: for (int i = 0; i < 5 ; i+=2)
        {
            for (int j = 0;j < 9; j+=2)
            {
                setX(i);
                setY(j);
                flag++;
                if(flag==mark)
                    break A;
            }
    }   }

    public static void check(char[][] board) {
        char s = board[getX()][getY()];
        if (s == '1') {
            board[getX()][getY()] = ' ';
        } else {
            board[getX()][getY()] = '1';
        }

        if (getX()<board.length -1 ||getX() == 0)
        {
            if (board[getX() + 2][getY()] == '1')
            {
                board[getX() + 2][getY()] = ' ';
            }
            else
                {
                board[getX() + 2][getY()] = '1';
                }
        }

        if (getX()>0)
        {
            if (board[getX() - 2][getY()] == '1')
            {
                board[getX() - 2][getY()] = ' ';
            }
            else
                {
                board[getX() - 2][getY()] = '1';
                }
        }


        if (getY() < board[x].length - 1 || getY() == 0)
        {
            if (board[getX()][getY() + 2] == '1') {
                board[getX()][getY() + 2] = ' ';
            } else {
                board[getX()][getY() + 2] = '1';
            }
        }
        if (getY() > 0) {
            if (board[getX()][getY() - 2] == '1') {
                board[getX()][getY() - 2] = ' ';
            } else {
                board[getX()][getY() - 2] = '1';
            }
        }
    }

    public static boolean win (char[][] board)
    {
        for (int i =0 ; i<5; i+=2)
        {
            for (int j =0 ; j<9; j+=2) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }

    public static int getX() {
        return x;
    }

    public static void setX(int x) {
        Main.x = x;
    }

    public static int getY() {
        return y;
    }

    public static void setY(int y) {
        Main.y = y;
    }
}
