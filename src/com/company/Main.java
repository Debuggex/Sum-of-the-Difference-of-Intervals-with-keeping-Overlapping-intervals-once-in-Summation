package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static int SumIntervalDifference(int[][]IntervalArray){

        //Initialization
        int Sum=0;

        //Sorting whole Array on the basis of final interval using Bubble Sort. You may Use other Sorting Algos.
        for (int j = 0; j < IntervalArray.length; j++) {
            for (int i = 0; i < IntervalArray.length-1; i++) {
                if (IntervalArray[i][1] > IntervalArray[i+1][1]) {
                    int []temp=IntervalArray[i];
                    IntervalArray[i]=IntervalArray[i+1];
                    IntervalArray[i+1]=temp;
                }
            }
        }

        /*

        Computing Sum of Interval Difference

        NOTE: We need to take care of Overlapping Intervals. Overlapping Intervals need to be counted once.
        For Example: if we have intervals like (1,5) and (2,6), then final intervals i.e 5 and 6 are Overlapping so we
        will do this in this way : Difference = 6-1. 6 From Second Interval group and 1 from First Interval Group.

        */
        for (int i = 0; i < IntervalArray.length-1; i++) {
            int first=IntervalArray[i][0];
            int last=IntervalArray[i][1];

            if (IntervalArray[i+1][1]==last+1) {
                Sum=Sum+(IntervalArray[i+1][1]-first);
                i++;
            }else if (IntervalArray[i+1][1]==last-1) {
                Sum=Sum+(last-IntervalArray[i+1][0]);
            }else{
                Sum=Sum+last-first;
            }
        }

        //Return Final Output
        return Sum;
    }

    public static void main(String[] args) {

        //Creating and Initializing Random Jagged Array
        int arr_name[][] = new int[][]  {
                new int[] {50, 60},
                new int[] {10,20},
                new int[] {110, 120},
                new int[] {10,20}
        };

        //Calling the Function and Printing the Output to Console.
        System.out.println(SumIntervalDifference(arr_name));

    }
}
