import java.util.Arrays;
import java.lang.reflect.Array;
import java.util.stream.Stream;

//import java.lang.*;
public class Outer {

    public static void main(String[] args) {
        System.out.println("Hello World! my friend");
        Outer m = new Outer();

        m.myTest();
        StringClass str = new StringClass();
        str.demoInner(new String[10]);
        Outer.StringClass stat = new Outer.StringClass();
    }

    private void myTest() {
        int[] ns = new int[]{1, 2, 3, 4, 5};
        Arrays.stream(ns)
                .map(n -> n * 2)
                .filter(n -> n % 4 == 0)
                .forEach(System.out::println);
        System.out.println("-------------------------");
        int[] a = Arrays.stream(ns)
                .map(n -> n * 3)
                .filter(n -> n % 4 == 0)
                .toArray();
        Arrays.stream(a).forEach(System.out::println);

        int[] array = {1, 2, 3};
        // Get the value of the third element.
        Object o = Array.get(array, 2);
        System.out.println("o:" + o);
//        System.out.println("ms = " + ms);
    }

    static class StringClass {
        public void demoInner(String[] args) {
            // declares an Array of integers.
            Student[] arr;

            // allocating memory for 5 objects of type Student.
            arr = new Student[5];

            // initialize the first elements of the array
            arr[0] = new Student(1, "aman");

            // initialize the second elements of the array
            arr[1] = new Student(2, "vaibhav");

            // so on...
            arr[2] = new Student(3, "shikar");
            arr[3] = new Student(4, "dharmesh");
            arr[4] = new Student(5, "mohit");

            // accessing the elements of the specified array
            for (int i = 0; i < arr.length; i++)
                System.out.println("Element at " + i + " : " +
                        arr[i].roll_no + " " + arr[i].name);
        }
    }
}

class Student {

    int roll_no;
    String name;

    public Student(int roll_no, String name) {
        this.roll_no = roll_no;
        this.name = name;
    }
}
