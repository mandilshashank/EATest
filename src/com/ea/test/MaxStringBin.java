package com.ea.test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class MaxStringBin {

    public static void main(String[] args) throws IOException {

        try{
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));

            String input;
            ArrayList<String> inputData = new ArrayList<String>();

            while((input=br.readLine())!=null){
                inputData.add(input);
            }

            //This will bring the top length string to the top so that the max bin-string length can be found early
            Collections.sort(inputData, new StringComparator()); // Would take nlogn time

            int max_bin_str_dist = 0;
            for(int i = 0; i < inputData.size()-1; i++) {
                for(int j = 0; j< inputData.size(); j++) {
                    String str1 = inputData.get(i);
                    String str2 = inputData.get(j);

                    //Call the findDistance function only if the total length of the sum of string is greater than current max
                    if(str1.length() + str2.length() > max_bin_str_dist){
                        int dist = findDistance(str1, str2);
                        if(dist > max_bin_str_dist){
                            max_bin_str_dist = dist;
                        }
                    } else {
                        //No Point in looping through inner loop since sum of strings will be less than or equal to max
                        break;
                    }
                }
            }

            System.out.println("\nMax bin-string distance is : " + max_bin_str_dist);

        }catch(IOException io){
            io.printStackTrace();
        }
    }

    private static void printArrayList(ArrayList<String> arr){
        for(int i=0 ;i<arr.size();i++){
            System.out.println(arr.get(i));
        }
    }

    private static int findDistance(String str1, String str2){
        int len_common_prefix = 0;
        int min_len = 0;
        int str1_length = str1.length();
        int str2_length = str2.length();

        if(str1_length <= str2_length){
            min_len = str1_length;
        } else {
            min_len = str2_length;
        }

        for (int i = 0; i < min_len; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                len_common_prefix++;
            }
            else {
                break;
            }
        }

        return str1_length + str2_length - (2*len_common_prefix);
    }
}


