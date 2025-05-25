package TollPaymentSystem;

import java.util.ArrayList;

public class Journey {
    int start;
    int destination;
    ArrayList<Integer> tollPoints;
    int amount=0;

    Journey(int start,int destination){
        this.start =start;
        this.destination =destination;
        tollPoints = new ArrayList<>();
        if(start<destination){
            for (int i = start; i <= destination; i++) {
                tollPoints.add(i);
            }
        }
        else{
            for (int i = start; i >= destination; i--) {
                tollPoints.add(i);
            }
        }
    }
}
