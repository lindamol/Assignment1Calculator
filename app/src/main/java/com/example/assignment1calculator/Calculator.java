package com.example.assignment1calculator;

import android.util.Log;

import java.util.ArrayList;

public class Calculator {
    ArrayList<String> calArray = new ArrayList<>();
    ArrayList<String> historyArray = new ArrayList<>();
    double finalresult = 0;
    double calresult;
    int i = 0;
    boolean error = false;

    void pushtoArray(String value) {
        calArray.add(value);
    }
     //History Array
    void pushtoHistoryArray(String value) {
        historyArray.add(value);
    }

    //iterate and calculate
    double calculate() {
        while (calArray.size() >= 3) { //Untill Array list <=3
            //1+2+5+4
           // if(calArray.get(1).charAt(0) == '+' || calArray.get(1).charAt(0) =='-' || calArray.get(1).charAt(0) == '*' || calArray.get(1).charAt(0) =='/')
          //Array index for iteration is always 0,1,2, Because after each iteration first 3 array elements
            // will be removed and //push the rest  to first indexes
            double firstnum = (Double.parseDouble(calArray.get(0)));
            double secondnum = (Double.parseDouble(calArray.get(2)));
            String operator = calArray.get(1);
            //pass the first 3 elements and get the Result
            finalresult = getResult(firstnum, secondnum, operator);
            //Remove First 3 elements
            calArray.remove(0); // +2+5+4
            calArray.remove(0);//2+5+4
            calArray.remove(0);//+5+4
            //Add the result to first index of the Arraylist,Replace the first index to result and do iteration
            calArray.add(0, (Double.toString(finalresult))); // New arraylist : 3+5+4

//        else{
//            error = true; // if there is no operator set error as true;
//            System.out.println("Format Error");
//            System.exit(0);
//        }
        }
        return finalresult;
    }

    // To perform each iteration in the arraylist
    double getResult(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                calresult = num1 + num2;
                break;
            case "-":
                calresult = num1 - num2;
                break;
            case "/":
                calresult = num1 / num2;
                break;
            case "*":
                calresult = num1 * num2;
                break;
            default:
                System.out.println("Invalid Entry, Please Check");
                break;
        }

        return calresult;
    }

    void printarray() {
        Log.d("my array is ", "Cal " + calArray.toString() + "");
    }
//    void printHistory(){
//        Log.d("my History array is ","Cal "+historyArray.get(i)+"");
//        i++;
//    }
}