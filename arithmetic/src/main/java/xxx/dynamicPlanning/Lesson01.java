package xxx.dynamicPlanning;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 爬楼梯
 * 假设你正在爬楼梯。需要 n 步你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1： 输入： 2  输出： 2  解释： 有两种方法可以爬到楼顶。
 * 1.  1 步 + 1 步
 * 2.  2 步
 * 示例 2： 输入： 3  输出： 3  解释： 有三种方法可以爬到楼顶。
 * 1.  1 步 + 1 步 + 1 步
 * 2.  1 步 + 2 步
 * 3.  2 步 + 1 步
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/4/13
 */
public class Lesson01 {

    /*
    斐波那契数列
    由于斐波纳挈数列是以兔子的繁殖引入的，因此也叫“兔子数列”。
    它指的是这样一个数列：0,1,1,2,3,5,8,13......从这组数可以很明显看出这样一个规律：
    从第三个数开始，后边一个数一定是在其之前两个数的和。在数学上，斐波纳挈数列可以以这样的公式表示：F(0) = 0  F(1) = 1 F(n) = F(n-1) + F(n-2),(n>=2)
    * */

    /**
     * 思路: 不要用递归,递归的时间耗费太多,用斐波那契数列
     * @return
     */
    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int[] r = new int[n+1];
        r[1] = 1;
        r[2] = 2;
        for(int i = 3;i<r.length;i++){
            r[i] = r[i-1] + r[i-2];
        }
        return r[n];
    }

    public static void main(String[] args) {
//        int n = 5;
        Lesson01 lesson01 = new Lesson01();
//        int x = lesson01.climbStairs(n);
//        System.out.println(x);
        lesson01.invoker();
    }

    private void invoker(){
        Parent p = new Parent();
        HashMap map = new HashMap();
        p.doSomething(map);
    }

    class Parent{
        public Collection doSomething(Map map){
            System.out.println("父类被执行...");
            return map.values();
        }

        public  float  aFun(float a, float b) throws IllegalAccessException { return a; }
    }

    class Child extends Parent{
        public Collection doSomething(HashMap map){
            System.out.println("子类被执行...");
            return map.values();
        }

        public float aFun(float a, float b){
            return a;
        }

        private int aFun(int a, int b){
            return a;
        }

        // 错误写法
        /*int aFun(int a, int b){
            return a;
        }*/

//        public  float  aFun(float a, float b) throws Exception { return a; }
    }
}
