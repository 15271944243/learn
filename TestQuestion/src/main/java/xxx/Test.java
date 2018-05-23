package xxx;

/**
 * @description: 自动装箱、拆箱、缓存
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/5/14
 */
public class Test {

    {

    }
    /**
     * 在 Java 5 中，为 Integer 的操作引入了一个新的特性，用来节省内存和提高性能。整型对象在内部实现中通过使用相同的对象引用实现了缓存和重用。
     * 上面的规则适用于整数区间 -128 到 +127。
     * 这种 Integer 缓存策略仅在自动装箱（autoboxing）的时候有用，使用构造器创建的 Integer 对象不能被缓存。
     * ********Java 编译器把原始类型自动转换为封装类的过程称为自动装箱（autoboxing），这相当于调用 valueOf 方法.
     * 这种缓存行为不仅适用于Integer对象。我们针对所有整数类型的类都有类似的缓存机制。
     * ByteCache 用于缓存 Byte 对象
     * ShortCache 用于缓存 Short 对象
     * LongCache 用于缓存 Long 对象
     * CharacterCache 用于缓存 Character 对象
     * @param args
     */
    public static void main(String[] args) {
        int i0 = 1;
        Integer i1 = 1;
        Integer i2 = new Integer(1);
        Integer i3 = 127;
        Integer i4 = 127;
        Integer i5 = new Integer(127);
        Integer i6 = 128;
        Integer i7 = 128;
        Integer i8 = new Integer(128);

        Long l1 = 1L;
        Long l2 = 1L;
        Long l3 = 128L;
        Long l4 = 128L;
        System.out.println(i0 == i1);
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
        System.out.println(i3 == i5);
        System.out.println(i6 == i7);
        System.out.println(i6 == i8);
        System.out.println("------");
        System.out.println(l1 == l2);
        System.out.println(l3 == l4);

        // 封装类型和基础类型比较时,封装类型会自动拆箱成基础类型
        Integer a1 = 134;
        int a2 = 134;
        System.out.println(a1 == a2);

        System.out.println(100 + 5 + "ss");

        byte q1 = 2;
        short s = 16;
    }
}
