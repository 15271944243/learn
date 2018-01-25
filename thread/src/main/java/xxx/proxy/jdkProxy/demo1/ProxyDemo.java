package xxx.proxy.jdkProxy.demo1;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/1/25
 */
public class ProxyDemo {

    /**
     * proxy.newProxyInstance()
     * classLoader：类的加载器，使用null表示使用默认的加载器。
     * interfaces：需要代理的接口数组。
     * invocationHandler:调用处理器，使用新建的proxy对象调用方法的时候，都会调用到该接口中的invoke方法。
     * @param args
     */
    public static void main(String[] args) {
        List<String> content = new ArrayList<>();
        MyInvocationHandler handler = new MyInvocationHandler(content);
        /**
         * 委托类这里是ArrayList,必须实现某个接口
         */
        Object proxy = Proxy.newProxyInstance(null,new Class[]{List.class},handler);
        if(proxy instanceof List){
            System.out.println("proxy is list");
            List<String> list = (List<String>)proxy;
            list.add("one");
            list.add("two");
            list.add("three");
            list.add("apple");
        }
        System.out.println("proxy:" + proxy.toString());
        System.out.println("content:" + content.toString());
    }
}
