package FileExplorer;

public class File {
    String name;
    Folder parent;
    String content;

    File(String name,Folder parent){
        this.name = name;
        this.parent = parent;
    }
}
