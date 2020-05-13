
//can we override and overload static methods in java 

// Static methods can be overloaded 
//but cannot be overriden as Run time polymorphism won't happen in this case
public class staticMethodsSample {
    public static void main(String[] args) {
        // sample.m1();
        // sample2.m1();
        sample3.m1(5);
        sample3.m1(5, 5);

    }

}

class sample2 extends sample {
    public static void m1() {
        System.out.println("From static method in sample2");
    }
}

class sample {
    public static void m1() {
        System.out.println("From Static method in sample ");
    }

}

class sample3 {
    public static void m1(int x) {
        System.out.println(x);
    }

    public static void m1(int x, int y) {
        System.out.println(x + y);
    }
}