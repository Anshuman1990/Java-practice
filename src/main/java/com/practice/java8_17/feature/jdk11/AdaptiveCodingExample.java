package  com.practice.java8_17feature.jdk11;

import java.util.ArrayList;
import java.util.List;

public class AdaptiveCodingExample {
    public static void main(String[] args) {
        String str1 = "nagalandanshumanjava";
        String str2 = "javaanshumandev";

        System.out.println(fetchLongestSubString(str1,str2));
//        int i = 10;
////        System.out.println(~i);
    }

    public static String fetchLongestSubString(String str1, String str2){
         String commonSubString = "";

        List<String> arr1 = new ArrayList<String>();
        List<String> arr2 = new ArrayList<String>();
        List<String> commonArray = new ArrayList<String>();

        arr1.add(str1.substring(0,8));
        arr1.add(str1.substring(8,16));
        arr1.add(str1.substring(16,20));



        arr2.add(str2.substring(0,4));
        arr2.add(str2.substring(4,12));
        arr2.add(str2.substring(12,15));

        arr1.forEach(s -> {
            if(arr2.contains(s)){
                commonArray.add(s);
            }
        });

        commonArray.sort(String::compareToIgnoreCase);
        return commonArray.get(0);
    }
}

