import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * 
 */

/**
 * @author asaha
 *
 */
public class dummy {
	
public static void main(String[] args) {
//	ArrayList< String> arr = new ArrayList<>();
//	for(int i=0;i<4;i++){
//		arr.add(((char)(i+100))+"asd");
//	}
//	System.out.println(arr);
//	String[] data = null;
//	
//	data = arr.toArray(new String[arr.size()]);
//	for(int i=0;i<data.length;i++){
//		System.out.println(data[i]);
//	}
//	
//	double d = 10/13;
//	System.out.println(d);
	
//	String str = "__-__-____";
//	
//	
//	String patternString = "[\\D++]";
//	
//	Pattern p = Pattern.compile(patternString);
//	Matcher matcher = p.matcher(str);
////	System.out.println(matcher.find());
//	while(matcher.find()){
//		System.out.println("<<<<<<<>>>>>>>>> "+matcher.group()+"?????????????"+matcher.start());
//		str = str.replace(matcher.group(), "");
//	}
//	System.out.println("##########"+str);
//	boolean c = true;
//	String s = "";
//	s = c==true ? "yes":"no";
//	System.out.println(s);
//	int[] a = {0,1,2,3,4,5,6,7,8,9,10};
//	int[] ar = {7,6,1,2};
//	Arrays.sort(ar);
//	boolean ck = true;
//	for(int i:a){
//	for(int j:ar){
//		if(i==j){
//			ck=false;
//			break;
//		}
//	}
//	if(ck){
//	System.out.println(i);
//	}
//	ck = true;
//	}
	
	//System.out.println(dateCheck("Thu Aug 04 01:07:00 IST 2016", "MM/dd/yyyy"));
//	String str = "Subject: Warning: You only have 60 days left to review Application 173QIQU";
//	String delim = "\t\n\r\f";
//	StringTokenizer tokens = new StringTokenizer(str);
//	while(tokens.hasMoreElements()){
//		System.out.println(tokens.nextToken());
//	}
	
//	Map<String, Object> map = new HashMap<>();
//	map.put("0", "qwerty");
//	System.out.println("111111111111111111"+map);
//	map = dummy.check(map);
//	System.out.println("222222222222222222"+map);
//	
//	System.out.println(dummy.class.getClassLoader().getResource("abc.properties"));
//	
//	dummy d = new dummy();
//	d.check("qwe");
//	d.check(Arrays.asList("1","2"));
	
//	List<String> arr = Arrays.asList("qwerty","asdfgh","zxcvbn");
//	System.out.println(arr.toString().contains("qwerty"));

//	String str = WorkFlowReference.valueOf("wf_1").getWorkFlowName();
//	System.out.println(">>>>>>>>>"+str);
//
//	String s = new String("qwerty");
//String s = "i am, not good, to work";
//s.split(",");
//s.split("");
//	System.out.println(s);
//	class abc{
//		abc(){
//			System.out.println("asdasd");
//		}
//	}

	System.out.println("abc".length());
	System.out.println("abc".substring(0,3));

	System.out.println(isPalindrone("12321"));
}

private static String dateCheck(String date,String dateformat){
	String result = "";
	try {
	SimpleDateFormat parseFormat = new SimpleDateFormat(parse(date));
			Date d = parseFormat.parse(date);
		
		SimpleDateFormat format = new SimpleDateFormat(dateformat);
		 result = format.format(d);
	} catch (ParseException e) {
		e.printStackTrace();
	}
	return result;
}

private static final String[] formats = { 
        "yyyy-MM-dd'T'HH:mm:ss'Z'",   "yyyy-MM-dd'T'HH:mm:ssZ",
        "yyyy-MM-dd'T'HH:mm:ss",      "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
        "yyyy-MM-dd'T'HH:mm:ss.SSSZ", "yyyy-MM-dd HH:mm:ss", 
        "MM/dd/yyyy HH:mm:ss",        "MM/dd/yyyy'T'HH:mm:ss.SSS'Z'", 
        "MM/dd/yyyy'T'HH:mm:ss.SSSZ", "MM/dd/yyyy'T'HH:mm:ss.SSS", 
        "MM/dd/yyyy'T'HH:mm:ssZ",     "MM/dd/yyyy'T'HH:mm:ss", 
        "yyyy:MM:dd HH:mm:ss",        "yyyyMMdd","EEE MMM dd HH:mm:ss z yyyy" };


public static String parse(String d) {
	String result = "";
    if (d != null) {
        for (String parse : formats) {
            SimpleDateFormat sdf = new SimpleDateFormat(parse);
            try {
                sdf.parse(d);
                System.out.println("Printing the value of " + parse);
                result = parse;
            } catch (ParseException e) {
//            	e.printStackTrace();
            }
        }
    }
    return result;
}



private static String removePinAddress(String data){
	  //Pattern p = Pattern.compile("[0]+");
	  //boolean hasSpecialChar = p.matcher(s).find();
	  /*Pattern p = Pattern.compile("[^0-9a-z]");
	  boolean hasSpecialChar = p.matcher(s).find();*/
	
	
	  int split = data.split("-",-1).length-1;
	  System.out.println("split = " + split);
	  
	  if(data!=null && split==2){
	   data = data.substring(0, data.length() - 13);
	  }else if(data!=null && split==1){
	   data = data.substring(0, data.length() - 8);
	  }
	  System.out.println(data);
	  return data;
}

public static Map<String, Object> check(Map<String, Object> map){
	map.put("1", "qwerty");
	return map;
}


public void check(Object type) {
	System.out.println("#############:- "+type.getClass().getSimpleName());
	if(type.getClass().getSimpleName().equalsIgnoreCase(Integer.class.getSimpleName())) {
		System.out.println("Integer");
	}
	else if(type.getClass().getSimpleName().equalsIgnoreCase(ArrayList.class.getSimpleName())) {
		System.out.println("ArrayList");
	}
}

	enum WorkFlowReference{
		wf_1("Application/Screening"),wf_2("Resubmitted"),wf_3("Proposed Approval"),wf_4("Proposed Denial"),wf_5("CloseWithoutUpdated");
		private String workFlowName;
		public String getWorkFlowName() {
			return workFlowName;
		}
		WorkFlowReference(String _workflowname){
			this.workFlowName = _workflowname;
		}
	}

	public static boolean isPalindrone(String str){
        int[] arr = new int[2];
        arr[0] = 2;
        int len = str.length() - 1;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(len - i);
            if (ch1 == ch2)
                count++;
        }
        return count == str.length();
    }
}

