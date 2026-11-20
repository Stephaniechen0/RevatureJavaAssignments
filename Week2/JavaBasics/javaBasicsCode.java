import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class Employee {
    int employeeId;
    String employeeName;
    double salary;
    Double bonusPercentage;
    boolean active;

    Employee(int id, String name, double sal, Double bonus, boolean a) {
        employeeId = id;
        employeeName = name;
        salary = sal;
        bonusPercentage = bonus;
        active = a;
    }
}

class javaBasics {
    static void modify(int x) {
        x = 100;
    }

    static void modifyArray(int[] arr) {
        // arr[0] = 100;
        arr = new int[]{100, 200, 300};
    }

    static void addEmployee(List<Employee> employees, int id, String name, String salaryInput, Double bonus, boolean active) {
        try {
            double salary = Double.parseDouble(salaryInput);
            employees.add(new Employee(id, name, salary, bonus, active));
        } catch (NumberFormatException e) {
            System.out.println("Invalid salary: " + salaryInput);
        }
    }

    public static void main(String[] args) {
        // q1
        // int num = 100;
        // int newNum = 0;
        // while (num != 0) {
        //     int d = num % 10;
        //     newNum = newNum * 10 + d;
        //     num = num / 10;
        // }
        // System.out.println(newNum);

        // q2
        // int a = 10;
	    // double c = a;
        // double b = 3.5;

        // int result = (int) (c + b);

        // System.out.println(result);

        // char ch = 'A';
        // int value = ch + 5;

        // System.out.println(value);
        // System.out.println((char) value);

        // q3
        // String input = "Programming";
        // int vowels = 0;
        // int consonants = 0;
        // for (char c : input.toCharArray()) {
        //     if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        //         vowels++;
        //     }
        //     else {
        //         consonants++;
        //     }
        // }
        // System.out.println(vowels + " " + consonants);

        // q4
        // String age = "25";
        // String salary = "45000.75";
        // String active = "true";
        // try {
        //     Integer new_age = Integer.valueOf(age);
        //     Double new_salary = Double.valueOf(salary);
        //     boolean new_active = boolean.valueOf(active);
        //     System.out.println(new_age + ", " + new_salary + ", " + new_active);
        // } catch (NumberFormatException e) {
        //     System.out.println("Invalid number.");
        // }

        // q5
        // String s1 = "Hello";
        // String s2 = "Bello";
        // boolean ana = false;
        // if (s1.length() != s2.length()) {
        //     ana = false;
        // }
        // HashMap<Character, Integer> counts = new HashMap<>();
        // for (char c : s1.toCharArray()) {
        //     counts.put(c, counts.getOrDefault(c, 0) + 1);
        // }
        // for (char c : s2.toCharArray()) {
        //     if (counts.getOrDefault(c, 0) == 0 || !counts.containsKey(c)) {
        //         ana = false;
        //     }
        //     counts.put(c, counts.getOrDefault(c, 0) - 1);
        // }
        // if (ana == true) {
        //     System.out.println("Anagram");
        // }
        // else {
        //     System.out.println("Not Anagram");
        // }
        
        // q6
        // int a = 5;
        // int b = 6;
        // a = a + b;
        // b = a - b;
        // a = a - b;
        // a = a ^ b;
        // b = a ^ b;
        // a = a ^ b;

        // q8
        // String input = "programming";
        // StringBuilder sb = new StringBuilder();
        // for (Character c : input.toCharArray()) {
        //     if (sb.indexOf(String.valueOf(c)) == -1) {
        //         sb.append(c);
        //     }
        // }
        // System.out.println(sb);

        // q9
        // String input = "aaaabbbb";
        // boolean repeat = true;
        // HashMap<Character, Integer> letters = new HashMap<>();
        // for (char c : input.toCharArray()) {
        //     letters.put(c, letters.getOrDefault(c, 0) + 1);
        // }
        // for (Map.Entry<Character, Integer> e : letters.entrySet()) {
        //     if (e.getValue() == 1) {
        //         repeat = false;
        //         System.out.println(e.getKey());
        //         break;
        //     }
        // }
        // if (repeat == true) {
        //     System.out.println("No non-repeated character");
        // }

        // q10
        // String input = "abcabcbb";
        // if (input.length() == 0) {
        //     System.out.println("Empty string.");
        // }
        // else if (input.length() == 1) {
        //     System.out.println(input);
        // }
        // else {
        //     StringBuilder sb = new StringBuilder();
        //     String longest = sb.toString();
        //     for (int right = 0; right < input.length(); right++) {
        //         char rChar = input.charAt(right);
        //         while (sb.indexOf(String.valueOf(rChar)) != -1) {
        //             sb.deleteCharAt(0);
        //         }
        //         sb.append(rChar);
        //         if (sb.length() > longest.length()) {
        //             longest = sb.toString();
        //         }
        //     }
        //     System.out.println(longest + ", " + longest.length());
        // }

        // q12
        // String input = "a";
        // StringBuilder sb = new StringBuilder();
        // char curr = input.charAt(0);
        // int count = 1;
        // sb.append(curr);
        // for (int i = 1; i < input.length(); i++) {
        //     if (input.charAt(i) == curr) {
        //         count++;
        //     }
        //     else {
        //         sb.append(count);
        //         sb.append(input.charAt(i));
        //         curr = input.charAt(i);
        //         count = 1;
        //     }
        // }
        // sb.append(count);
        // System.out.println(sb);

        // q13
        // String input = "Java     is easy to learn!";
        // StringBuilder sb = new StringBuilder();
        // int pos = 0;
        // for (int i = input.length() - 1; i >= 0; i--) {
        //     System.out.println(input.charAt(i) + ": " + i);
        //     if (input.charAt(i) != ' ') {
        //         sb.insert(pos, input.charAt(i));
        //     }
        //     else {
        //         sb.append(" ");
        //         pos = sb.length();
        //     }
        // }
        // System.out.println(sb.toString());

        // q14
        // StringBuilder sBuild = new StringBuilder();
        // for (int i = 0; i < 10; i++) {
        //     sBuild.append('a');
        // }
        // StringBuffer sBuff = new StringBuffer();
        // for (int i = 0; i < 10; i++) {
        //     sBuff.append('a');
        // }
        // System.out.println(sBuild.toString());
        // System.out.println(sBuff.toString());
        // System.out.println(sBuild.toString().equals(sBuff.toString()));

        // StringBuilder sb1 = new StringBuilder();
        // Thread t1 = new Thread(() -> {
        //     for (int i = 0; i < 100; i++) {
        //         sb1.append('a');
        //     }
        // });
        // Thread t2 = new Thread(() -> {
        //     for (int i = 0; i < 100; i++) {
        //         sb1.append('b');
        //     }
        // });
        // t1.start();
        // t2.start();
        // try {
        //     t1.join();
        //     t2.join();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        // System.out.println(sb1.toString());

        // StringBuffer sb1 = new StringBuffer();
        // Thread t1 = new Thread(() -> {
        //     for (int i = 0; i < 100; i++) {
        //         sb1.append('a');
        //     }
        // });
        // Thread t2 = new Thread(() -> {
        //     for (int i = 0; i < 100; i++) {
        //         sb1.append('b');
        //     }
        // });
        // t1.start();
        // t2.start();
        // try {
        //     t1.join();
        //     t2.join();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        // System.out.println(sb1.toString());

        // q15
        // List<Employee> employees = new ArrayList<>();
        // addEmployee(employees, 1, "Bob", "50000.00", 0.12, true);
        // addEmployee(employees, 2, "Sob", "70000.00", 0.10, true);
        // addEmployee(employees, 3, "Cob", "60000.00", 0.15, false);

        // for (Employee e : employees) {
        //     double bonus = e.salary * e.bonusPercentage;
        //     double finalAmount = e.salary + bonus;
        //     System.out.println("Employee ID: " + e.employeeId);
        //     System.out.println("Employee Name: " + e.employeeName);
        //     System.out.println("Basic Salary: " + e.salary);
        //     System.out.println("Bonus: " + bonus);
        //     System.out.println("Final Salary" + finalAmount);
        //     System.out.println("Active: " + e.active);

        //     StringBuilder sb = new StringBuilder();
        //     for (char c : e.employeeName.toCharArray()) {
        //         sb.insert(0, c);
        //     }
        //     System.out.println("Reversed Name: " + sb.toString());

        //     if (e.salary > 75000) {
        //         System.out.println("Salary above 75000: No");
        //     }
        //     else {
        //         System.out.println("Salary above 75000: Yes");
        //     }
        //     System.out.println("-------------------");
        // }
    }

}