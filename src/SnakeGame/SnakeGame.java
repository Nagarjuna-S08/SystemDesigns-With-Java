package SnakeGame;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class SnakeGame {
    public static void main(String[] args) {
        InnerSankeGame sg =new InnerSankeGame(6, 6);
        sg.start();
    }
}

class Node{
    int row;
    int col;

    Node(int row,int col){
        this.row=row;
        this.col=col;
    }
}

class InnerSankeGame {
    static int totalScore = 0;
    private final char[][] board;
    static Random r = new Random();
    int curRow=0;
    int curCol=0;
    char curHead;

    Queue<Node> snakeInd = new LinkedList<>();

    InnerSankeGame(int row,int col){
        board = new char[row][col];
        inatializeBoard();
        curHead ='>';
        snakeInd.add(new Node(curRow, curCol));
        board[curRow][curCol] = curHead;
    }

    public void start(){
        Scanner sc = new Scanner(System.in);
        char move;
        foodPlacement();
        while(true){
            printBoard();

            System.out.print("\nCurrent Score : "+totalScore+"\nEnter the Move : ");
            move = sc.next().toUpperCase().charAt(0);
            System.out.println();

            int newRow=curRow;
            int newCol=curCol;
            switch (move) {
                case 'W':{
                    newRow--;
                    curHead='^';
                    break;
                }
                case 'S':{
                    newRow++;
                    curHead='v';
                    break;
                }
                case 'A':{
                    newCol--;
                    curHead='<';
                    break;
                }
                case 'D':{
                    newCol++;
                    curHead='>';
                    break;
                }
                default:
                    System.out.println("\nEnter a vlaid Move ..........\n");
                    break;
            }

            if(!validateMove(newRow,newCol)){
                System.out.println("\nGame Over : Total Score : "+totalScore);
                break;
            }
            else{
                if(board[newRow][newCol]=='O'){
                    snakeInd.add(new Node(newRow, newCol));
                    board[curRow][curCol] = '.';
                    board[newRow][newCol] = curHead;
                    totalScore++;
                    foodPlacement();
                }
                else{
                    board[curRow][curCol] = '.';
                    Node n = snakeInd.poll();
                    board[n.row][n.col]= '*';
                    snakeInd.add(new Node(newRow, newCol));
                    board[newRow][newCol] = curHead;
                }
                curCol=newCol;
                curRow=newRow;
            }
        }
        sc.close();
    }

    public boolean validateMove(int row,int col){
        return row>=0 && row<board.length && col>=0 && col<board[0].length && board[row][col]!='.';
    }

    public void foodPlacement(){
        int row,col;
        do{
            row = r.nextInt(board.length);
            col = r.nextInt(board[0].length);
        }while(board[row][col]!='*');
        board[row][col]='O';
    }

    public void inatializeBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j]='*';
            }
        }
    }
    public void printBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

}
