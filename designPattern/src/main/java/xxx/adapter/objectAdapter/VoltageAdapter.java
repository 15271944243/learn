package xxx.adapter.objectAdapter;

/**
 * @description: Adapter类：完成220V-5V的转变
 * 通过继承src类，实现 dst 类接口，完成src->dst的适配。
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/5/11
 */
public class VoltageAdapter implements Voltage5 {

    private Voltage220 voltage220;

    public VoltageAdapter(Voltage220 voltage220) {
        this.voltage220 = voltage220;
    }

    @Override
    public int output5V() {
        int dst = 0;
        if (null != voltage220) {
            int src = voltage220.output220V();
            System.out.println("对象适配器工作，开始适配电压");
            dst = src / 44;
            System.out.println("适配完成后输出电压：" + dst);
        }
        return dst;
    }
}
