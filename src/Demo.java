import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Demo {
public static void main(String[] args) {
//	String str = "html,br,<br>,";
//	System.out.println(formatString(str, ","));
//
//	ArrayList<Map<String, String>> arr = new ArrayList<>();
//	HashMap<String, String> hm = new HashMap<String, String>();
//    //add key-value pair to hashmap
//	for(int i=0;i<5;i++){
//    hm.put("first"+i, "FIRST INSERTED");
//    hm.put("second"+i, "SECOND INSERTED");
//    hm.put("third"+i,"THIRD INSERTED");
//    arr.add(hm);
//    hm.clear();
//	}
//
//    System.out.println(arr);
//
//
//    new ByteArrayInputStream(str.getBytes());


    String str = "qwertyu";
    String str1 = "qwertyu";

    if(str == str1){
		System.out.println("true");
	}
    else{
		System.out.println("false");
	}
}

private static String formatString(String text,String delimiter){
	System.out.println("CHECk===="+text.matches(".*\\<[^>]+>.*"));
	String outputString = "";
	text = text.replaceAll("<.*?>", "");
	System.out.println(":>? "+text);
	String[] str = text.split(delimiter);
//	System.out.println("&&&&&&&&&&&&&&&"+str.length);
	StringBuilder s_build = new StringBuilder();
	for(int i=0;i<str.length;i++){
		if(str[i]!="" && str[i]!=null && str[i].length()>0){
			s_build.append(str[i]);
			s_build.append(delimiter);
		}
	}
	if(s_build.toString().contains(","))
	outputString = s_build.toString().substring(0, s_build.toString().lastIndexOf(","));
	return outputString;
}
}
