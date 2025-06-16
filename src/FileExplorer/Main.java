package FileExplorer;

import java.util.Scanner;

public class Main {
    public static Folder currentDir;
    public static Scanner sc;
    public static void main(String[] args) {
        boolean loop = true;
//        int choice;
        currentDir = Folder.rootDir;
        sc = new Scanner(System.in);

        System.out.println("1. MD\n2. CD \n3. Touch\n4. List\n5. Tree\n6. PWD");
        while (loop){
//            System.out.print("1. MD\n2. CD \n3. Touch\n4. List\n5. Tree\n6. PWD\nEnter Option : ");
//            choice = sc.nextInt();
            currentDir.printCurrentDir();
            System.out.print(":\\> ");
            String str = sc.nextLine();
            String[] splitedArray = str.split(" ");
            String choice=splitedArray[0];
            switch (choice){
                case "md":{
//                    System.out.print("Enter Directory Name : ");
                    String name = splitedArray[1];
                    currentDir.makeDir(name);
                    System.out.println("Directory Created Successfully...");
                    break;
                }
                case "cd":{
//                    System.out.println("Enter Path : ");
                    String path = splitedArray[1];
                    currentDir = currentDir.changeDir(path);
                    System.out.println("Directory changed..");
//                    currentDir.printCurrentDir();
                    break;
                }
                case "touch":{
//                    System.out.print("Enter File Name : ");
                    String name = splitedArray[1];
                    currentDir.touch(name);
                    System.out.println("File Created Successfully...");
                    break;
                }
                case "list":{
                    System.out.println("The List of SubDirectory and Files ....");
                    currentDir.list();
                    break;
                }
                case "tree":{
                    System.out.println("The List of SubDirectory and Files ....");
                    currentDir.tree();
                    break;
                }
                case "pwd":{
                    System.out.print("The Current Directory path : ");
                    currentDir.printCurrentDir();
                    System.out.println();
                    break;
                }
                case "esc":{
                    loop = false;
                    break;
                }
            }
        }
    }
}
