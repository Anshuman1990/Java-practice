package com.practice.cracking.the.coding.interview;

public class BigO {

    void permutation(String str){
        permutation(str, "");
    }

    void permutation(String str, String prefix){
        if(str.length() == 0){
            System.out.println(prefix);
        }
        else {
            for(int i=0;i<str.length();i++){
                System.out.println("00000000"+str+"0000"+prefix);
                String rem = str.substring(0, i) + str.substring(i+1);
                System.out.println("111111111111111"+str.substring(0, i) +","+ str.substring(i+1)+"11111"+str.charAt(i));
                System.out.println(i);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        BigO bigO = new BigO();
        bigO.permutation("abc");

        int a = 5-10;
        System.out.println(a);
    }
}
