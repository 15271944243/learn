package xxx.proxy.jdkProxy.demo2;

import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/1/25
 */
public class Test {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(userService);
        /**
         * 委托类这里是UserServiceImpl,必须实现某个接口
         */
        UserService proxy = (UserService)Proxy.newProxyInstance(userService.getClass().getClassLoader(),userService.getClass().getInterfaces(),handler);
        System.out.println(proxy.getName(1));
        System.out.println(proxy.getAge(1));
    }
}
