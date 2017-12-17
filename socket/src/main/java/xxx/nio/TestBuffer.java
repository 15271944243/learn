package xxx.nio;

import java.nio.IntBuffer;

public class TestBuffer {

    public static void main(String[] args) {
        // 1.基本操作
        // 创建指定长度的缓冲区
        IntBuffer buffer = IntBuffer.allocate(10);
        buffer.put(13);         // position位置：0 - > 1
        buffer.put(33);         // position位置：1 - > 2
        buffer.put(93);         // position位置：2 - > 3
        //把位置复位为0，也就是position位置：3 - > 0
        buffer.flip();

        System.out.println("使用flip复位：" + buffer);
        System.out.println("容量为: " + buffer.capacity());	    //容量一旦初始化后不允许改变（warp方法包裹数组除外）
        System.out.println("限制为: " + buffer.limit());		//由于只装载了三个元素,所以可读取或者操作的元素为3 则limit=3

        System.out.println("获取下标为1的元素：" + buffer.get(1));
        System.out.println("get(index)方法，position位置不改变：" + buffer);

        buffer.put(1, 4);
        System.out.println("put(index, change)方法，position位置不变：" + buffer);

        for(int i=0;i<buffer.limit();i++){
            //调用get方法会使其缓冲区位置（position）向后递增一位
            // 如果不进行flip(),会异常
            System.out.print(buffer.get() + "\t");
        }
        System.out.println("buf对象遍历之后为: " + buffer);

        // 2.wrap方法使用(不建议使用此方法)
        //  wrap方法会包裹一个数组: 一般这种用法不会先初始化缓存对象的长度，因为没有意义，最后还会被wrap所包裹的数组覆盖掉。
        //  并且wrap方法修改缓冲区对象的时候，数组本身也会跟着发生变化。
        int[] arr = new int[]{1,3,5};
        IntBuffer buffer1 = IntBuffer.wrap(arr);
        System.out.println(buffer1);
        IntBuffer buffer2 = IntBuffer.wrap(arr, 0 , 2);
        //这样使用表示容量为数组arr的长度，但是可操作的元素只有实际进入缓存区的元素长度
        System.out.println(buffer2);

        // 3.其他方法
        IntBuffer buffer3 = IntBuffer.allocate(10);
        int[] arr2 = new int[]{1,11,111};
        buffer3.put(arr2);
        System.out.println(buffer3);
        //一种复制方法
        IntBuffer buffer4 = buffer3.duplicate();
        System.out.println(buffer4);

        //设置buf1的位置属性
        //buffer3.position(0);
        buffer3.flip();
        System.out.println(buffer3);

        System.out.println("可读数据为：" + buffer3.remaining());

        int[] arr3 = new int[buffer3.remaining()];
        //将缓冲区数据放入arr3数组中去
        buffer3.get(arr3);
        for(int i : arr3){
            System.out.print(Integer.toString(i) + ",");
        }
    }
}
