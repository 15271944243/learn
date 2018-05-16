package xxx.test001;

/**
 * Test001.main() 函数执行后的输出是（）
 */
public class Test001 {
    public static void main(String [] args){
        System.out.println(new B().getValue());
    }
    static class A{
        protected int value;
        public A(int v) {
            setValue(v);
        }
        public void setValue(int value){
            this.value = value;
        }
        public int getValue(){
            // try{ }中返回了某一个值，如果finally有返回值，finally中的返回值会覆盖try的返回值，如果finally没有返回值，就是try中的返回值。
            try{
                value++;
                return value;
            } catch(Exception e){
                System.out.println(e.toString());
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
            return value;
        }
    }
    static class B extends A{
        // 子类继承父类，调用方法时先是调用子类中的方法，如果没有就调用父类中的方法
        public B() {
            super(5);
            setValue(getValue() - 3);
        }
        public void setValue(int value){
            super.setValue(2 * value);
        }
    }
}
