package DataBaseCommands;

import java.util.ArrayList;

public class Services {

    ArrayList<Record> permanentRecord;
    ArrayList<ArrayList<Record>> allRecords;
    static int pointer=-1;

    Services(){
        permanentRecord = new ArrayList<>();
        allRecords = new ArrayList<>();
    }

    public void unSet(String name){
        if (pointer<0){
            for(Record r:permanentRecord){
                if(r.name.equals(name)){
                    permanentRecord.remove(r);
                    return;
                }
            }
        }

        ArrayList<Record> searchRecord = allRecords.get(pointer);
        for(Record r:searchRecord){
            if(r.name.equals(name)){
                allRecords.get(pointer).remove(r);
                return;
            }
        }

        if(pointer==0){
            // Search in commited permanent Array
            for(Record r:permanentRecord){
                if(r.name.equals(name)){
                    permanentRecord.remove(r);
                    return;
                }
            }
        }
    }

    public void commit(){

        for (ArrayList<Record> rec:allRecords){
            for (Record r:rec){
                boolean flag = false;
                for (Record r2:permanentRecord){
                    if(r2.name.equals(r.name)){
                        r2.val = r.val;
                        flag = true;
                    }
                }
                if (!flag){
                    permanentRecord.add(new Record(r.name,r.val));
                }
            }
        }
        allRecords = new ArrayList<>();
        pointer = -1;

    }

    public void rollBack(){
        if (pointer<0){
            return;
        }
        allRecords.remove(pointer);
        pointer = allRecords.size()-1;
    }

    public void begin(){
        allRecords.add(new ArrayList<Record>());
        pointer = allRecords.size()-1;
    }

    public String get(String name){

        if (pointer<0){
            for(Record r:permanentRecord){
                if(r.name.equals(name)){
                    return String.valueOf(r.val);
                }
            }
            return null;
        }

        ArrayList<Record> searchRecord = allRecords.get(pointer);
        for(Record r:searchRecord){
            if(r.name.equals(name)){
                return String.valueOf(r.val);
            }
        }

        if(pointer==0){
            // Search in commited permanent Array
            for(Record r:permanentRecord){
                if(r.name.equals(name)){
                    return String.valueOf(r.val);
                }
            }
        }

         return null;
    }

    public void set(String name,int val){

        if (pointer<0){
            allRecords.add(new ArrayList<Record>());
            Record r = new Record(name,val);
            pointer = allRecords.size()-1;
            allRecords.get(pointer).add(r);
            return;
        }
        allRecords.get(pointer).add(new Record(name,val));

    }


}
