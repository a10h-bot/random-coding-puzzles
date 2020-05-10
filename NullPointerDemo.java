public class NullPointerDemo {

    static class Student {
        int id;
        int roll_no;
    }

    public static void main(String[] args) {
        NullPointerDemo.Student o = new NullPointerDemo.Student();

        System.out.println(o.id);
        System.out.println(helper(o));
    }

    public static int helper(NullPointerDemo.Student obj) {
        obj.id = 10;
        return obj.id;
    }
}

// loan ac/ no : 6023626