package com.day1;

public class StringDemo {

	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "Java";
		String s3 = new String("Hello");
		String s4 = "Hello";
		System.out.println(s1 == s4);
		System.out.println(s1 == s3);
		
		String name = "Alice";
		String newname = name.concat("Max");
		System.out.println(newname);
		
		int nameLength = name.length();
		System.out.println(nameLength);
		System.out.println(name.length());		
		System.out.println(newname.indexOf('A'));
		
		String capName = "ALICE";
		System.out.println(name.equals(capName));
		System.out.println(name.equalsIgnoreCase(capName));
		System.out.println(name.equals(capName.toLowerCase()));
		System.out.println(name.toUpperCase().equals(capName));
		
		String words = "Java,Python,C++,Java";
		String newWords = words.replace("Java", "SQL");
		System.out.println(newWords);
		String[] parts = words.split(",");
		
		for (String part : parts) {
			System.out.println(part);
		}
		
		StringBuffer BF = new StringBuffer("Hello");
		BF.append(" Some String");
		System.out.println(BF);
		
		String s5 = new String("Hello");
		s5.concat("Yello");
		System.out.println(s5);
		
		StringBuilder SB = new StringBuilder("Hello");
		SB.append(" Some String");
		System.out.println(SB);
		
		String s6 = "    Hello     ";
		System.out.println(s6);
		
		String s7 = s6.trim();
		System.out.println(s7);
	}

}
