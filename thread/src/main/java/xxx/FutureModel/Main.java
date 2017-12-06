package xxx.FutureModel;

/**
 *  并行设计模式属于设计优化的一部分,它是对一些常用的多线程结构的总结和抽象。
 *  与串行程序相比,并行程序的结构通常更为复杂。因此合理的使用并行模式在多线程开发中更具有意义。
 *  这里主要介绍Future,Master-Worker和生产者-消费者模式
 *
 *  Future模式有点类似于商品订单。比如在网购时，当看中某一件商品时，就可以提交订单，当订单处理完后，在家等待商品送货上门即可。
 *  或者说类似Ajax异步请求,页面无须等待后台结果返回才继续往下处理。
 *  注:在java.util.concurrent有Future接口,无须自己去实现了
 */
public class Main {

    public static void main(String[] args) {
        FutureClient fc = new FutureClient();
        Data data = fc.request("请求参数");
        System.out.println("请求发送成功!");
        System.out.println("做其他事情...");
        String result = data.getRequest();
        System.out.println(result);
    }
}
