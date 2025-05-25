package BrickBreakGame;

public class Services {
    private char[][] gameMat;
    private int life;
    private int curRow;
    private int curCol;

    Services(int size){
        gameMat = new char[size][size];
        this.assignWall();
    }

    public void fallDown(int row) {
        for (int i = row; i < gameMat.length - 1; i++) {
            if (gameMat[i][curCol] == '1') {
                gameMat[i][curCol] = ' ';
            }
        }
    }

    public void traverseRow(int row,int col){
        if(col==0){
            int i;
            for (i = 0; i < gameMat[row].length-1; i++) {
                if(gameMat[row][i]=='1'){
                    gameMat[row][i]=' ';
                    if(i!=curCol){
                        gameMat[curRow][curCol]='G';
                        curCol= i;
                        gameMat[curRow][curCol]='O';
                        life--;
                    }
                    fallDown(row);
                    return;
                }
            }
            if(i== gameMat.length-1){
                if(i!=curCol){
                    gameMat[curRow][curCol]='G';
                    curCol= i-1;
                    gameMat[curRow][curCol]='O';
                    life--;
                    fallDown(row);
                }
            }
        }
        else{
            int i;
            for (i = gameMat[row].length-1; i > 0; i--) {
                if(gameMat[row][i]=='1'){
                    gameMat[row][i]=' ';
                    if(i!=curCol){
                        gameMat[curRow][curCol]='G';
                        curCol= i;
                        gameMat[curRow][curCol]='O';
                        life--;
                    }
                    fallDown(row);
                    return;
                }
            }
            if(i == 0){
                if(i!=curCol){
                    gameMat[curRow][curCol]='G';
                    curCol= i+1;
                    gameMat[curRow][curCol]='O';
                    fallDown(row);
                    life--;
                }
            }

        }
    }

    public void right(){
        int i=curRow;
        int j=curCol;
        while (j<gameMat.length && i>0){
            if(gameMat[i][j]=='1'){
                gameMat[i][j]=' ';
                if(j!=curCol){
                    gameMat[curRow][curCol]='G';
                    curCol= j;
                    gameMat[curRow][curCol]='O';
                    life--;
                    fallDown(i);
                }
                this.printBoard();
                return;
            }
            j++;
            i--;
        }
        if(j== gameMat.length){
            this.traverseRow(i+1,j-1);
        }
        else{
            fallDown(1);
        }
        this.printBoard();
    }

    public void left(){
        int i=curRow;
        int j=curCol;
        while (j>0 && i>0){
            if(gameMat[i][j]=='1'){
                gameMat[i][j]=' ';
                if(j!=curCol){
                    gameMat[curRow][curCol]='G';
                    curCol= j;
                    gameMat[curRow][curCol]='O';
                    life--;
                    fallDown(i);
                }
                this.printBoard();
                return;
            }
            j--;
            i--;
        }
        if(j==0){
            this.traverseRow(i,j);
        }
        else{
            fallDown(1);
        }
        this.printBoard();
    }

    public void up(){
        for (int i = curRow; i > 0 ; i--) {
            if(gameMat[i][curCol]=='1'){
                gameMat[i][curCol]=' ';
                break;
            }
        }
        this.printBoard();
    }

    public void assignWall(){
        int ballPosition = gameMat.length/2;

        for (int i = 0; i < gameMat.length; i++) {
            for (int j = 0; j < gameMat.length; j++) {
                gameMat[i][j] = ' ';
                if(i==0 || j==0 || j== gameMat.length-1){
                    gameMat[i][j] = 'W';
                }

                if( i== gameMat.length-1 && j==ballPosition){
                    gameMat[i][j] = 'O';
                    curRow = i;
                    curCol = j;
                }
                else if(i== gameMat.length-1 && (j!=0 || j!= gameMat.length-1)){
                    gameMat[i][j] = 'G';
                }
            }
        }
    }

    public void printBoard(){
        for (char[] chars : gameMat) {
            for (int j = 0; j < gameMat.length; j++) {
                System.out.printf("%3s", chars[j]);
            }
            System.out.println();
        }
        System.out.println("Remaining Life : "+life);
    }

    public void setLife(int cnt){
        life = cnt;
        this.printBoard();
    }

    public boolean checkValidForBrick(int x,int y){
        return (x>0 && y>0 && x < gameMat.length-1 && y < gameMat.length-1) && gameMat[x][y]!='1';
    }

    public boolean setBrick(int x,int y){
        if(checkValidForBrick(x,y)){
            gameMat[x][y] = '1';
            return true;
        }
        return false;
    }
}
