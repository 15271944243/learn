package xxx.FutureModel;

public class FutureClient {

    public Data request(final String queryStr){
        // 1.我想找一个代理对象(Data接口的实现类)先返回给发送请求的客户端，告诉他请求已收到，可以做其他事
        final FutureData fd = new FutureData();
        // 2.启动一个新线程，去加载真实数据，传递给这个代理对象
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 3.这个新线程可以慢慢去加载真实对象，然后传递给代理对象
                RealData realData = new RealData(queryStr);
                fd.setRealData(realData);
            }
        });
        t1.start();
        return fd;
    }
}
