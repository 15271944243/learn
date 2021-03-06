package xxx.base;

/**
 * http://ifeve.com/disruptor-getting-started/
 * 从一个简单的例子开始学习Disruptor：生产者传递一个long类型的值给消费者，
 * 而消费者消费这个数据的方式仅仅是把它打印出来。首先声明一个Event来包含需要传递的数据
 */
public class LongEvent {

    private long value;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
