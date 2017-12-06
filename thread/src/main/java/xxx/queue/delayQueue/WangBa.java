package xxx.queue.delayQueue;

import java.util.concurrent.DelayQueue;

public class WangBa implements Runnable{
    private DelayQueue<WangMing> delayQueue = new DelayQueue<WangMing>();
    public boolean yingye = true;

    public void shangji(String idCard,String name,int money){
        WangMing wangMing = new WangMing(idCard,name,1000*money+System.currentTimeMillis());
        System.out.println("身份证:" + wangMing.getIdCard() + ",名称:" + wangMing.getName() + ",交钱:" + money + ",开始上机...");
        delayQueue.add(wangMing);
    }

    public void xiaji(WangMing wangMing){
        System.out.println("身份证:" + wangMing.getIdCard() + ",名称:" + wangMing.getName() + ",时间到,下机...");
    }

    @Override
    public void run() {
        while (yingye){
            try {
                WangMing wangMing = delayQueue.take();
                xiaji(wangMing);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("网吧开始营业...");
        WangBa wangBa = new WangBa();
        Thread shangwang = new Thread(wangBa);
        shangwang.start();
        wangBa.shangji("123","路人甲",2);
        wangBa.shangji("234","路人乙",5);
        wangBa.shangji("456","路人丙",10);
        wangBa.shangji("567","路人丁",8);
    }
}
