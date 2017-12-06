package xxx.multi;

import com.lmax.disruptor.RingBuffer;

public class Producer {
    private final RingBuffer<Order> ringBuffer;

    public Producer(RingBuffer<Order> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    /**
     * 用来发布事件,每调用一次就发布一次事件
     * 它的参数会通过事件传递给消费者
     * @param bb
     */
    public void onData(String data){
        // 可以把ringBuffer看做为一个事件队列,那么next就是得到下一个事件槽
        long sequence = ringBuffer.next();
        try {
            Order order = ringBuffer.get(sequence);
            //获取要通过事件传递的业务数据
            order.setId(data);
        }finally {
            // 发布事件
            //注意，最后的 ringBuffer.publish 方法必须包含在 finally 中以确保必须得到调用；如果某个请求的 sequence 未被提交，将会堵塞后续的发布操作或者其它的 producer。
            ringBuffer.publish(sequence);
        }
    }
}
