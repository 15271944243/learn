package xxx.generic;

/**
 * @description:
 * @author: xxx.
 * @createDate: 2018/1/19
 */
public class TestGeneric {

    // 1.泛型的类型参数只能是类类型，不能是简单类型。
    // 2.不能对确切的泛型类型使用instanceof操作。如下面的操作是非法的，编译时会出错。
    public static void main(String[] args) {
        //泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
        //传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        Generic<Integer> genericInteger = new Generic<Integer>(123456);

        //传入的实参类型需与泛型的类型参数类型相同，即为String.
        Generic<String> genericString = new Generic<String>("key_vlaue");
        System.out.println("泛型测试,key is " + genericInteger.getKey());
        System.out.println("泛型测试,key is " + genericString.getKey());
    }
}
