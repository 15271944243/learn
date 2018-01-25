package xxx.proxy.jdkProxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/1/25
 */
public class MyInvocationHandler implements InvocationHandler{

    // 具体的调用类
    Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy    当前所持有的proxy对象
     * @param method   当前被调用的方法
     * @param args     方法中传递的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法名:" + method.getName());
        if(method.getName().equals("add")){
            if(args[0].toString().equals("apple")){
                return false;
            }
        }
        return method.invoke(target,args);
    }
}
