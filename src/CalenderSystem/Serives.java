package CalenderSystem;

import java.util.ArrayList;
import java.util.HashMap;

public class Serives {

    private final static HashMap<String,Integer> monthCodes = new HashMap<>();
    private final static HashMap<Integer,Integer> yearCodes = new HashMap<>();

    private final static int[][] monthMatrix = new int[5][7];
    private final static ArrayList<String> dayIdentifyArray = new ArrayList<>();
    private final static HashMap<String,Integer> monthDates = new HashMap<>();
    private final static ArrayList<String> monthIdentifyArray = new ArrayList<>();

    private static String displayMonth = "";
    private static int displayYear = 0;


    static {
        //Codes for the Months
        monthCodes.put("Jan",0);
        monthCodes.put("Feb",3);
        monthCodes.put("Mar",3);
        monthCodes.put("Apr",6);
        monthCodes.put("May",1);
        monthCodes.put("Jun",4);
        monthCodes.put("Jul",6);
        monthCodes.put("Aug",2);
        monthCodes.put("Sep",5);
        monthCodes.put("Oct",0);
        monthCodes.put("Nov",3);
        monthCodes.put("Dec",5);
        //Codes for years or Centuries
        yearCodes.put(0,6);
        yearCodes.put(1,4);
        yearCodes.put(2,2);
        yearCodes.put(3,0);
        //Add day in String
        dayIdentifyArray.add("Sun");
        dayIdentifyArray.add("Mon");
        dayIdentifyArray.add("Tue");
        dayIdentifyArray.add("Wed");
        dayIdentifyArray.add("Thu");
        dayIdentifyArray.add("Fri");
        dayIdentifyArray.add("Sat");
        //Add Months Date
        monthDates.put("Jan",31);
        monthDates.put("Feb",28);
        monthDates.put("Mar",31);
        monthDates.put("Apr",30);
        monthDates.put("May",31);
        monthDates.put("Jun",30);
        monthDates.put("Jul",31);
        monthDates.put("Aug",31);
        monthDates.put("Sep",30);
        monthDates.put("Oct",31);
        monthDates.put("Nov",30);
        monthDates.put("Dec",31);
        // Add month for tracking
        //Add day in String
        monthIdentifyArray.add("Jan");
        monthIdentifyArray.add("Feb");
        monthIdentifyArray.add("Mar");
        monthIdentifyArray.add("Apr");
        monthIdentifyArray.add("May");
        monthIdentifyArray.add("Jun");
        monthIdentifyArray.add("Jul");
        monthIdentifyArray.add("Aug");
        monthIdentifyArray.add("Sep");
        monthIdentifyArray.add("Oct");
        monthIdentifyArray.add("Nov");
        monthIdentifyArray.add("Dec");
    }

    private String getMonth(String s){
        String[] sArray = s.split("\\s+");
        String month = "";
        if(sArray.length>=3){
            month = sArray[1];
        }
        return month;
    }

    private int getDate(String s){
        String[] sArray = s.split("\\s+");
        int date = 0;
        if(sArray.length>=3){
            date = Integer.parseInt(sArray[0]);
        }
        return date;
    }

    private int getYear(String s){
        String[] sArray = s.split("\\s+");
        int year = 0;
        if(sArray.length>=3){
            year = Integer.parseInt(sArray[2]);
        }
        return year;
    }

    public String helperToFindDate(String s){
        String[] sArray = s.split("\\s+");
        int date = 0;
        int year = 0;
        String month = "";
        if(sArray.length>=3){
            date = Integer.parseInt(sArray[0]);
            year = Integer.parseInt(sArray[2]);
            month = sArray[1];
        }

        return findDay(date,month,year);
    }
    
    private String findDay(int date,String month,int year){

        if(month.isEmpty()){
            return "Enter Date in a Valid Format (For Eg: 08 Oct 2004)";
        }

        int totalSum;
        // Calculation Part
        int last2DigitOfYear = year%100;
        int rem = last2DigitOfYear/4;
        int monthCode = monthCodes.get(month);
        int yearCode = yearCodes.get((year/100)%4);

        totalSum = last2DigitOfYear+rem+date+monthCode+yearCode;

        // Correction for Leap Years in Jan and Feb
        if (isLeapYear(year) && (month.equals("Jan") || month.equals("Feb"))) {
            totalSum -= 1;
        }

        return dayIdentifyArray.get(totalSum % 7);
    }

    private void printMonth() {
        System.out.println("\n "+displayMonth+" "+displayYear+"\n");
        for (String day : dayIdentifyArray) {
            System.out.printf("%4s", day);
        }
        System.out.println();

//        int k = 0;
//        for (int i = monthMatrix.length-1; i <= monthMatrix.length-1 ; i++) {
//            for (int j = 0; j < monthMatrix[0].length; j++) {
//                if(monthMatrix[i][j] > 0 && monthMatrix[0][j]==0){
//                    monthMatrix[0][j] = monthMatrix[i][j];
//                    monthMatrix[i][j] = 0;
//                }
//            }
//        }

        for (int i = 0; i < monthMatrix.length; i++) {
            for (int j = 0; j < monthMatrix[i].length; j++) {
                if (monthMatrix[i][j] == 0) {
                    System.out.printf("%4s", "");
                } else {
                    System.out.printf("%4s", monthMatrix[i][j]);
                }
            }
            System.out.println();
        }
    }

    public void currentMonthSheetPrep(String date){

        String result = helperToFindDate(date);
        int startIndex = dayIdentifyArray.indexOf(result);
        int i=0,j=0,cnt=1;
        String month = getMonth(date);
        int year = getYear(date);
        fillRemainingToZero(i,j);

        int noOfDays = getDaysInMonth(month,year);

        while (i<1){
            while (j<7){
                if(j>=startIndex){
                    monthMatrix[i][j]=cnt++;
                }
                j++;
            }
            i++;
        }

        while (i<5){
            j=0;
            while (j<7){
                monthMatrix[i][j]=cnt++;
                if(cnt>noOfDays){
                    displayMonth = month ;
                    displayYear = year;
                    printMonth();
                    return;
                }
                j++;
            }
            i++;
        }
        j=0;
        while (j<7){

            if(cnt>noOfDays){
                displayMonth = month ;
                displayYear = year;
                printMonth();
                return;
            }
            monthMatrix[0][j]=cnt++;
            j++;
        }
    }

    public void nextMonthSheetPrep(){
        int monthIndex = monthIdentifyArray.indexOf(displayMonth);
        monthIndex++;
        if(monthIndex>=12){
            displayYear++;
        }
        monthIndex%=12;
        displayMonth = monthIdentifyArray.get(monthIndex);
        String date = "01" + " " + displayMonth + " " + displayYear;
        currentMonthSheetPrep(date);

    }


    public void previousMonthSheetPrep(){
        int monthIndex = monthIdentifyArray.indexOf(displayMonth);
        monthIndex--;
        if(monthIndex<=-1){
            displayYear--;
            monthIndex=11;
        }
        displayMonth = monthIdentifyArray.get(monthIndex);
        String date = "01" + " " + displayMonth + " " + displayYear;
        currentMonthSheetPrep(date);
    }

    public void fillRemainingToZero(int i,int j){
        while (i<5){
            while (j<7){
                monthMatrix[i][j]=0;
                j++;
            }
            j=0;
            i++;
        }
    }

    private boolean isLeapYear(int year){
        return (year%4==0 && year%100!=0) || (year%400==0) ;
    }

    private int getDaysInMonth(String month, int year) {
        int noOfDays = monthDates.get(month);
        if (month.equals("Feb") && isLeapYear(year)) {
            noOfDays = 29;
        }
        return noOfDays;
    }


}
