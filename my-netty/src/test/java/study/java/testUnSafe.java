package study.java;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.HashMap;

public class testUnSafe {
    @Test
    public void testMemory() {

        Unsafe unsafe = reflectGetUnsafe();
        try {
            assert unsafe != null;
            long base = unsafe.allocateMemory(100);
            unsafe.setMemory(base, 100, (byte) 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testCAS() {

        Unsafe unsafe = reflectGetUnsafe();
        try {
            assert unsafe != null;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test1() {
        Unsafe unsafe = reflectGetUnsafe();
        assert unsafe != null;
        A o1 = new A(); // constructor
        o1.a(); // prints 1
        A o3 = null; // unsafe
        try {
            A o2 = A.class.newInstance(); // reflection
            o2.a(); // prints 1
            o3 = (A) unsafe.allocateInstance(A.class);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        o3.a(); // prints 0

    }

    @Test
    public void testMap() {
        HashMap<Integer, Integer> test = new HashMap<>();
        test.put(150, 30);
        test.put(900, 10);
        test.put(2400, 10);
        test.put(24000, 10);
        test.put(240000, 10);
        test.forEach((key, value) -> System.out.println(key));
    }

    private static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}

class A {
    private long a; // not initialized value

    public A() {
        this.a = 1; // initialization
    }

    public long a() {
        System.out.println(this.a);
        return this.a;
    }
}