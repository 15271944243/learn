package xxx.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import xxx.proxy.jdkProxy.demo2.UserService;
import xxx.proxy.jdkProxy.demo2.UserServiceImpl;

/**
 * @description:
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/1/25
 */
public class Test {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(cglibProxy);

        UserService userService = (UserService)enhancer.create();
        userService.getName(1);
        userService.getAge(1);
    }
}
