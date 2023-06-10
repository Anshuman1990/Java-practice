package com.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class Main {



    final public static char COMMA = ',';
    final public static String COMMA_STR = ",";
    final public static char ESCAPE_CHAR = '\\';

	public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("A","B"));
        DecimalFormat decimalFormat = new DecimalFormat("0.00000");
        double scale = Math.pow(10, 5);
        double value = (double)20/2;
        String format = decimalFormat.format(value);
        System.out.println(format);
        System.out.println(Double.valueOf(format));
        System.out.println(18%10+"---"+18/10);

//		Map<String, String> attributes = new HashMap<String,String>();
//		Map<Integer, String> attributes1 = new HashMap<Integer,String>();
//		attributes.put("FNAME", "qwerty");
//		attributes.put("MNAME", "asdfg");
//		attributes.put("LNAME", "zxcvb");
//		attributes.put("GNAME", "qazwsx");
//		
////		attributes.keySet().stream().forEach(new Consumer<Integer>() {
////
////			@Override
////			public void accept(Integer t) {
////				int count=0;
////				attributes1.put(count, t);
////				count++;
////			}
////		});
//		ArrayList<String> keys = new ArrayList<String>(attributes.keySet());
//		
//		IntStream.range(0, attributes.size()).forEach(new IntConsumer() {
//			
//			@Override
//			public void accept(int value) {
//				
//				attributes1.put(value, keys.get(value));
//			}
//		});
//		
//		System.out.println("jsafsadfjsadf"+attributes1);
//		try {
//			Main.html_compressor("D:\\Dataset\\html\\Java 8_ Reading A File Into A String _ Adam Bien's Weblog.html");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        System.out.println(">>>>>>>>>>>>"+escapeString("Clinic, Drug"));

        System.out.println(System.getProperty("JAVA_HOME"));
	}
	
//	private static void html_compressor(String path) throws IOException
//	{
//		String html = new String(Files.readAllBytes(Paths.get(path)));
//		System.out.println(html);
//		HtmlCompressor compressor = new HtmlCompressor();
//		compressor.setEnabled(true);
//	    compressor.setCompressCss(false);
//	    compressor.setCompressJavaScript(false);
//
//	    compressor.setGenerateStatistics(false);
//
//	    
//		String compressed = compressor.compress(html);
//		System.out.println(compressed);
//		
//		Files.write(Paths.get("D:\\Dataset\\html\\compressed.html"), compressed.getBytes());
//	}


    public static String escapeString(String str) {
        return escapeString(str, ESCAPE_CHAR, COMMA);
    }

    /**
     * Escape <code>charToEscape</code> in the string
     * with the escape char <code>escapeChar</code>
     *
     * @param str string
     * @param escapeChar escape char
     * @param charToEscape the char to be escaped
     * @return an escaped string
     */
    public static String escapeString(String str, char escapeChar, char charToEscape) {
        if (str == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (int i=0; i<str.length(); i++) {
            char curChar = str.charAt(i);
            if (curChar == escapeChar || curChar == charToEscape) {
                // special char
                result.append(escapeChar);
            }
            result.append(curChar);
        }
        return result.toString();
    }
}


enum AbbreviationOfDays{
   SUNDAY("SUN"), MONDAY("MON"), TUESDAY("TUES"), WEDNESDAY("WED"),
   THURSDAY("THURS"), FRIDAY("FRI"), SATURDAY("SAT");
   private String abbreviation;
   public String getAbbreviation() {
       return this.abbreviation;
   }
   AbbreviationOfDays(String abbreviation) {
           this.abbreviation = abbreviation;
   }
}
