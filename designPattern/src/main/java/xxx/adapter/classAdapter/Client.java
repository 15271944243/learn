package xxx.adapter.classAdapter;

/**
 * @description:
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/5/11
 */
public class Client {
    public static void main(String[] args) {
        Voltage5 voltage5 = new VoltageAdapter();
        System.out.println("开始充电!");
        voltage5.output5V();
    }
}
