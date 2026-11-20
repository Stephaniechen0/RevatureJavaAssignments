public class javaMethods {
    public static void printProfile(String name, int age, double height, boolean student, char grade) {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height); 
        System.out.println("Student: " + student);
        System.out.println("Grade: " + grade);
    }

    public static double average (int a, int b, int c) {
        return (a + b + c) / 3.0;
    }

    public static boolean fitsInByte(int value) {
        return value >= -128 && value <= 127;
    }

    public static int addTexts(String a, String b) {
        return Integer.parseInt(a) + Integer.parseInt(b);
    }

    public static Integer boxTwice(int x) {
        return Integer.valueOf(x * 2);
    }

    public static void describe(Integer n) {
        System.out.println("Binary: " + Integer.toBinaryString(n));
        System.out.println("Max: " + Integer.MAX_VALUE);
        System.out.println("Compare with 10.5: " + Double.compare(n, 10.5));
    }
    
    public static boolean sameValue(Integer a, Integer b) {
        return a.equals(b);
    }
    
    public static int truncate(double d) {
        return (int) d;
    }

    public static double widen(int i) {
        return (double) i;
    }
    
    public static void overflowDemo() {
        int big = 130;
        byte b = (byte) big;
        System.out.println("b: " + b);
    }

    public static char shiftLetter(char c, int by) {
        return (char) (c + by);
    }
    
    public static void describeValue(int a) {
        System.out.println("int: " + a);
    }

    public static void describeValue(double a) {
        System.out.println("double: " + a);
    }

    public static void describeValue(String a) {
        System.out.println("String: " + a);
    }
    
    public static void tryChange(int n) {
        n = 99;
    }
    
    public static void appendBang(StringBuilder sb) {
        sb.append("!");
    }
    
    public static void replaceBuilder(StringBuilder sb) {
        sb = new StringBuilder("New");
    }

    public static void shout(String s) {
        s = s.toUpperCase();
    }
    
    public static void compareRefs() {
        String s1 = "java";
        String s2 = "java";
        String s3 = new String("java");
        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1 == s3: " + (s1 == s3));
        System.out.println("s1 equals s3: " + s1.equals(s3));
    }
    
    public static int safeLength(String s) {
        if (s == null) {
            return -1;
        } else {
            return s.length();
        }
    }
    
    public static String initials(String first, String last) {
        return first.toUpperCase().charAt(0) + "" + last.toUpperCase().charAt(0);
    }
    
    public static String clean(String raw) {
        return raw.trim().toLowerCase();
    }
    
    public static boolean isPalindrome(String w) {
        String reverse = new StringBuilder(w).reverse().toString();
        return w.equalsIgnoreCase(reverse);
    }
    
    public static String maskEmail(String email) {
        char beginning = email.charAt(0);
        int domainIndex = email.indexOf('@');
        String domain = email.substring(domainIndex);
        StringBuilder sb = new StringBuilder();
        sb.append(beginning);
        sb.append("*".repeat(3));
        sb.append(domain);
        return sb.toString();
    }
    
    public static String buildCsv(String a, String b, String c) {
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(",");
        sb.append(b);
        sb.append(",");
        sb.append(c);
        return sb.toString();
    }
    
    public static String edit(String text) {
        StringBuilder sb = new StringBuilder(text);
        sb.insert(0, "[");
        sb.append("]");
        sb.replace(7, 12, "Java");
        sb.deleteCharAt(6);
        return sb.toString();
    }
    
    public static long timeJoin(boolean useBuilder) {
        long start = System.nanoTime();
        if (useBuilder) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 20000; i++) {
                sb.append('x');
            }
        }
        else {
            String s = "";
            for (int i = 0; i < 20000; i++) {
                s += 'x';
            }
        }
        long end = System.nanoTime();
        return end - start;
    }
    
    public static String safeAppend(StringBuffer sb, String part) {
        sb.append(part);
        return sb.toString();
    }
    
    public static String formatReceipt(String customer, int quantity, double unitPrice) {
        StringBuilder sb = new StringBuilder();
        int whole = (int) (quantity * unitPrice);
        String uppercase = customer.toUpperCase();
        sb.append("Customer: ");
        sb.append(uppercase);
        sb.append("\nQty: ");
        sb.append(quantity);
        sb.append(" | Price: ");
        sb.append(unitPrice);
        sb.append("\nTotal: ");
        sb.append(unitPrice);
        sb.append(" (whole: ");
        sb.append(whole);
        sb.append(")");
        return sb.toString();
    }

    public static double toFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }
    
    public static int percent(int obtained, int total) {
        double d = (double) obtained / total;
        return (int) (d * 100);
    }

    public static String describeInt(int n) {
        String binary = Integer.toBinaryString(n);
        String hexa = Integer.toHexString(n);
        String octal = Integer.toOctalString(n);
        return n + " -> binary: " + binary + ", hex: " + hexa + ", octal: " + octal;
    }
    
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("inside: a=" + a + ", b=" + b);
    }
    
    public static void addTitle(StringBuilder name) {
        name.insert(0, "Dr. ");
    }

    public static String addTitleToString(String name) {
        return "Dr. " + name;
    }
    
    public static String padLeft(String s, int width, char fill) {
        while (s.length() < width) {
            s = fill + s;
        }
        return s;
    }

    public static String joinWithDash(String s, int times) {
        StringBuilder sb = new StringBuilder();
        sb.repeat(s + '-', times - 1);
        sb.append(s);
        return sb.toString();
    }
    
    public static int roundHalfUp(double d) {
        return (int) (d + 0.5);
    }
    
    public static int factorialInt(int n) {
        int total = 1;
        for (int i = 1; i <= n; i++) {
            total = total * i;
        }
        return total;
    }

    public static long factorialLong(int n) {
        long total = 1;
        for (int i = 1; i <= n; i++) {
            total = total * i;
        }
        return total;
    }
    
    public static int countVowels(String s) {
        int vowels = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                vowels++;
            }
        }
        return vowels;
    }
    
    public static String summarize(String text) {
        StringBuilder sb = new StringBuilder();
        int length = text.length();
        String upper = text.toUpperCase();
        int vowels = countVowels(text);
        sb.append("Length: ");
        sb.append(length);
        sb.append(" | Upper: ");
        sb.append(upper);
        sb.append(" | Vowels: ");
        sb.append(vowels);
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // /* SECTION A */
        // printProfile("Asha", 21, 5.6, true, 'A');
        // printProfile("Ravi", 30, 5.9, false, 'B');

        // System.out.println("Average: " + average(1, 2, 2));

        // System.out.println("Fits in Byte? " + fitsInByte(127));
        // System.out.println("Fits in Byte? " + fitsInByte(128));
        // System.out.println("Fits in Byte? " + fitsInByte(-129));

        // System.out.println("Add texts: " + addTexts("12", "30"));

        // int r = boxTwice(21);
        // System.out.println("Box Twice: " + r);

        // describe(10);

        // // Integer caches -128 to 127, so == compares the same object for 127 but two different objects for 1000. Use equals for wrapper values.
        // Integer one = 127;
        // Integer two = 127;
        // System.out.println("127: equals=" + sameValue(one, two) + ", ==" + (one == two));
        // Integer three = 1000;
        // Integer four = 1000;
        // System.out.println("1000: equals=" + sameValue(three, four) + ", ==" + (three == four));

        // System.out.println("Truncate 9.99: " + truncate(9.99));
        // System.out.println("Truncate -9.99: " + truncate(-9.99));

        // System.out.println("Widen: " + widen(7));

        // // 130 is 2 more than byte max of 127, so it wraps 130 - 256 = -126
        // overflowDemo();

        // System.out.println("Shift letter: " + shiftLetter('a', 2));

        // describeValue(5);
        // describeValue(2.5);
        // describeValue("hi");
        // describeValue('A');
        // describeValue(5L);

        // int x = 1;
        // tryChange(x);
        // System.out.println("x = " + x);

        // StringBuilder sb = new StringBuilder("Hi");
        // appendBang(sb);
        // System.out.println(sb);
        
        // // Comment to write: the parameter holds a copy of the reference. 
        // // Pointing the copy at a new object does not move the caller's variable.
        // StringBuilder sb2 = new StringBuilder("Hi");
        // replaceBuilder(sb2);
        // System.out.println(sb2);

        // String s = "java";
        // shout(s);
        // System.out.println(s);

        // StringBuilder a = new StringBuilder("cat");
        // StringBuilder b = a;
        // b.append("s");
        // System.out.println(a);

        // compareRefs();

        // System.out.println(safeLength(null));
        // System.out.println(safeLength("hello"));

        // System.out.println(initials("ashu", "jauhari"));

        // System.out.println(clean("  HeLLo "));

        // System.out.println(isPalindrome("Level"));
        // System.out.println(isPalindrome("Java"));

        // System.out.println(maskEmail("asha@mail.com"));

        // System.out.println(buildCsv("a", "b", "c"));

        // System.out.println(edit("Hello World"));

        // System.out.println("String +=     : " + timeJoin(false));
        // System.out.println("StringBuilder : " + timeJoin(true));

        // // use StringBuffer when several threads may change the same text, 
        // // because its methods are synchronized. 
        // // Otherwise use the faster StringBuilder.
        // System.out.println(safeAppend(new StringBuffer("Hi"), " there"));

        // System.out.println(formatReceipt("Asha", 3, 9.99));
        // System.out.println(formatReceipt("Ravi", 2, 4.5));
    
        // /* SECTION B */
        // System.out.println(toFahrenheit(0));
        // System.out.println(toFahrenheit(37.5));
        // System.out.println(toFahrenheit(-40));

        // System.out.println(percent(45, 60));
        // System.out.println(percent(1, 3));

        // System.out.println(describeInt(255));
        // System.out.println(describeInt(8));

        // x and y only swap inside the method.
        int c = 1, d = 2;
        swap(c, d);
        System.out.println("outside: x=" + c + " y=" + d);

        // calling addTitle passes the reference to sb, so the method can change it
        // calling addTitleToString passes a copy of the reference to s, so the method cannot change it
        StringBuilder sb = new StringBuilder("Rao");
        addTitle(sb);
        System.out.println(sb);
        String s = "Rao";
        addTitleToString(s);   // result ignored
        System.out.println(s);
        System.out.println(addTitleToString(s));

        System.out.println(padLeft("42", 5, '0'));
        System.out.println(padLeft("12345", 3, '0'));
        System.out.println(joinWithDash("ab", 3));
        System.out.println(joinWithDash("x", 1));

        System.out.println(roundHalfUp(2.5));
        System.out.println(roundHalfUp(2.4));
        System.out.println(roundHalfUp(7.0));

        // ints can only store up to 2,147,483,647.
        // longs can store a greater amount.
        System.out.println(factorialInt(5));
        System.out.println(factorialLong(5));
        System.out.println(factorialInt(13));
        System.out.println(factorialLong(13));
        System.out.println(factorialLong(20));

        System.out.println(summarize("Hello World"));
        System.out.println(summarize("Sky"));
    }
}
