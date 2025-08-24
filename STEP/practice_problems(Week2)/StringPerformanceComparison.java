public class StringPerformanceComparison {
    public static void main(String[] args) {
        System.out.println("=== PERFORMANCE COMPARISON ===");

        // Test String concatenation (slow)
        long startTime = System.nanoTime();
        String result1 = concatenateWithString(10000);
        long endTime = System.nanoTime();
        System.out.println("String concatenation time: " + (endTime - startTime) + " ns");

        // Test StringBuilder concatenation (fast, not thread-safe)
        startTime = System.nanoTime();
        String result2 = concatenateWithStringBuilder(10000);
        endTime = System.nanoTime();
        System.out.println("StringBuilder concatenation time: " + (endTime - startTime) + " ns");

        // Test StringBuffer concatenation (slower than StringBuilder, but thread-safe)
        startTime = System.nanoTime();
        String result3 = concatenateWithStringBuffer(10000);
        endTime = System.nanoTime();
        System.out.println("StringBuffer concatenation time: " + (endTime - startTime) + " ns");

        // Demonstrate StringBuilder methods
        System.out.println("\n=== StringBuilder Methods Demo ===");
        demonstrateStringBuilderMethods();

        // Demonstrate thread safety
        System.out.println("\n=== Thread Safety Demo ===");
        demonstrateThreadSafety();

        // Compare String comparison methods
        System.out.println("\n=== String Comparison Demo ===");
        compareStringComparisonMethods();

        // Demonstrate memory efficiency
        System.out.println("\n=== Memory Efficiency Demo ===");
        demonstrateMemoryEfficiency();
    }

    // String concatenation (inefficient)
    public static String concatenateWithString(int iterations) {
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "Java " + i + " ";
        }
        return result;
    }

    // StringBuilder concatenation
    public static String concatenateWithStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java ").append(i).append(" ");
        }
        return sb.toString();
    }

    // StringBuffer concatenation
    public static String concatenateWithStringBuffer(int iterations) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java ").append(i).append(" ");
        }
        return sb.toString();
    }

    // StringBuilder methods demo
    public static void demonstrateStringBuilderMethods() {
        StringBuilder sb = new StringBuilder("Hello World");
        System.out.println("Original: " + sb);

        sb.append(" Java");
        System.out.println("append(): " + sb);

        sb.insert(6, "Beautiful ");
        System.out.println("insert(): " + sb);

        sb.delete(6, 16);
        System.out.println("delete(): " + sb);

        sb.deleteCharAt(5);
        System.out.println("deleteCharAt(): " + sb);

        sb.reverse();
        System.out.println("reverse(): " + sb);

        sb.reverse(); // restore
        sb.replace(0, 5, "Hi");
        System.out.println("replace(): " + sb);

        sb.setCharAt(0, 'Y');
        System.out.println("setCharAt(): " + sb);

        System.out.println("capacity(): " + sb.capacity());
        sb.ensureCapacity(100);
        System.out.println("ensureCapacity(100): " + sb.capacity());
        sb.trimToSize();
        System.out.println("trimToSize(): " + sb.capacity());
    }

    // Thread safety demo
    public static void demonstrateThreadSafety() {
        StringBuffer buffer = new StringBuffer("Start");
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                buffer.append("X");
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("StringBuffer final result (thread-safe): " + buffer);

        // StringBuilder (not thread-safe)
        StringBuilder builder = new StringBuilder("Start");
        Runnable task2 = () -> {
            for (int i = 0; i < 5; i++) {
                builder.append("X");
            }
        };

        Thread t3 = new Thread(task2);
        Thread t4 = new Thread(task2);
        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("StringBuilder final result (not thread-safe): " + builder);
    }

    // Compare String comparison methods
    public static void compareStringComparisonMethods() {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");

        System.out.println("== operator (str1 == str2): " + (str1 == str2)); // true, same reference from string pool
        System.out.println("== operator (str1 == str3): " + (str1 == str3)); // false, str3 is new object

        System.out.println("equals(): " + str1.equals(str3)); // true, compares content
        System.out.println("equalsIgnoreCase(): " + "hello".equalsIgnoreCase(str1)); // true

        System.out.println("compareTo(): " + str1.compareTo("World")); // negative (lexicographic)
        System.out.println("compareToIgnoreCase(): " + "hello".compareToIgnoreCase("HELLO")); // 0
    }

    // Memory efficiency demo
    public static void demonstrateMemoryEfficiency() {
        String a = "Hello";
        String b = "Hello"; // points to same object in string pool
        String c = new String("Hello"); // new object in heap

        System.out.println("a == b (string pool): " + (a == b)); // true
        System.out.println("a == c (new object): " + (a == c)); // false

        StringBuilder sb = new StringBuilder();
        System.out.println("Initial capacity: " + sb.capacity());
        sb.append("Hello World");
        System.out.println("Capacity after append: " + sb.capacity());
    }
}
