package FileExplorer;

import java.util.HashMap;

public class Folder {
    String name;
    Folder parent;
    HashMap<String,Folder> childDir;
    HashMap<String, File> childFile;
    String path;

    Folder(String name,Folder parent){
        this.name = name;
        this.parent = parent;
        childDir = new HashMap<>();
        childFile = new HashMap<>();
    }

    static Folder rootDir;
    static String rootPath;

    static {
        rootDir = new Folder("C",null);
        rootDir.path = "C";
        rootPath = rootDir.name;
    }

    public void makeDir(String name){
        Folder fn = new Folder(name,this);
        this.childDir.put(name,fn);

        fn.path = this.path+"\\"+fn.name;
    }

    public Folder changeDir(String input) {
        if (input.equals("..")) {
            return this.parent;
        } else if (input.equals("/")) {
            return rootDir;
        } else if (input.equals(".")){
            return this;
        }else{
            if(getDir(input)==null){
                return null;
            }
            return getDir(input);
        }

    }

    public Folder getDir(String name){
        return this.childDir.getOrDefault(name,null);
    }

    public void list(){
        System.out.println("Folders ...");
        for (String name : this.childDir.keySet()){
            Folder child1 = this.childDir.get(name);
            System.out.println(child1.name);
        }
        System.out.println("File ...");
        for (String name : this.childFile.keySet()){
            File child1 = this.childFile.get(name);
            System.out.println(child1.name);
        }
    }

    public void tree(){
        System.out.println(this.path);
        list();
        for (String name : this.childDir.keySet()){
            Folder child1 = this.childDir.get(name);
            child1.tree();
        }
    }

    public void touch(String name){
        File fn = new File(name,this);
        this.childFile.put(name,fn);
    }

    public void printCurrentDir(){
        System.out.print(this.path);
    }

}
