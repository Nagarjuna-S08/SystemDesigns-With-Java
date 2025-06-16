package MineSweeper;

import java.util.Random;

public class MineGrid {
    private int row;
    private int col;
    private Block[][] grid;

    MineGrid(int row,int col){
        this.row = row;
        this.col = col;
        this.grid = new Block[row][col];

        initialize();
        int noOfMine = Math.min(row,col);
        fixMine(noOfMine);
        printGrid();
    }

    public void printGrid(){
        for (int i = 0; i < grid.length; i++) {
            System.out.println("-".repeat(grid.length*5+1));
            System.out.print("|");
            for (int j = 0; j < grid[i].length; j++) {
                if(isShown(i,j)){
                    if (isMineFixed(i,j)){
                        System.out.print(" M ");
                    }
                    else{
                        System.out.print(" "+grid[i][j].noOfMine+" ");
                    }
                }
                else{
                    System.out.print("   ");
                }
                System.out.print(" |");
            }
            System.out.println();
            System.out.println("-".repeat(grid.length*5+1));
        }
    }

    private boolean isShown(int row,int col){
        return grid[row][col].isShown;
    }

    private void initialize(){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Block();
            }
        }
    }

    private void fixMine(int cnt){
        int counter = 1;
        while (counter <= cnt){
            Random r = new Random();
            int row = r.nextInt(grid.length);
            int col = r.nextInt(grid.length);

            if(!isMineFixed(row,col)){
                grid[row][col].isMine = true;
                counter++;
            }

        }
    }

    private boolean isMineFixed(int row,int col){
        return grid[row][col].isMine;
    }

    private void countAdjacentMine(){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(!isMineFixed(i,j)){
                    int count = countAroundBlock(row,col);
                    grid[i][j].noOfMine = count;
                }
            }
        }
    }

    private int countAroundBlock(int row,int col){
        int[] rowIncOrDec = new int[]{1,-1,0,0,1,-1};
        int[] colIncOrDec = new int[]{0,0,1,-1,1,-1};
        int cnt = 0;

        for (int i = 0; i < rowIncOrDec.length; i++) {
            if( isMineFixed(row + rowIncOrDec[i] , col+ colIncOrDec[i]) ){
                cnt++;
            }
        }

        return cnt;
    }

}
