package com.practice.algorithmAndDataStructure.algorithm.recursive;

public class StringPermutation {

    public static void main(String[] args) {
        StringPermutation stringPermutation = new StringPermutation();
        String str = "abcd";
        stringPermutation.permute(str, 0, str.length()-1);
    }

    private void permute(String str, int left, int right) {
        if(left == right) {
            System.out.println(str);
            System.out.println();
        }
        else{
            System.out.println("left= "+left+"\t right= "+right+"\t str= "+str);
            for(int i=left; i<=right;i++){
                String swappedString = swap(str, left , i);
                System.out.println("str="+str+"\tswappedString= "+swappedString+"\t i= "+i+"\t left= "+left);
                permute(swappedString, left+1, right);
            }
        }
    }

    private String swap(String str, int i, int j){
        char temp;
        char[] charArray = str.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
