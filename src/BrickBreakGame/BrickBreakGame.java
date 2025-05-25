package BrickBreakGame;

import java.util.Scanner;

public class BrickBreakGame {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the size : ");
        int size = sc.nextInt();
        Services obj = new Services(size);
        boolean flag = true;

        System.out.print("Enter number of brick : ");
        int cntBrick = sc.nextInt();
        int i=0;
        while(i < cntBrick) {
            System.out.println("Enter Position of Brick ( eg: 2 3 ) : ");
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(obj.setBrick(x,y)){
                i++;
            }
            else{
                System.out.println("Enter a Valid positions.......");
            }
        }

        System.out.print("Enter How Many Life : ");
        obj.setLife(sc.nextInt());

        while (flag){
            System.out.print("\n1. St(UP)\n2. lt(LEFT)\n3. rt(RIGHT)\n");
            System.out.print("Enter a Option : ");
            int opt = sc.nextInt();

            switch (opt){
                case 1:{
                    obj.up();
                    break;
                }
                case 2:{
                    obj.left();
                    break;
                }
                case 3:{
                    obj.right();
                    break;
                }
                case 4:{
                    flag=false;
                    break;
                }
            }

        }
    }
}
