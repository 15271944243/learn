package xxx.decorator;


/**
 * @description: A部门的打印处理
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/5/8
 */
public class SecretDepartment {

    /**
     * 可以看到，使用了设计模式的方法后，打印业务的变化，
     * 可以通过类似数学上的排列组合已有的打印功能来完成。
     * @param args
     */
    public static void main(String[] args) {
        SecretDepartment sd = new SecretDepartment();
        sd.print01("我是打印的文本11111");
        System.out.println("-----------------");
        sd.print02("我是打印的文本22222");
    }

    /**
     * A部门的第一个打印任务，打印页眉、页脚、文本水印
     * @param text
     */
    public void print01(String text){
        PrintComponent printComponent = new TextComponent(text);
        // 注意header聚合了printComponent
        PrintDecorator header = new HeaderDecorator(printComponent,"绝密");
        // 注意footer聚合了header，而不是printComponent,这样就能够嵌套执行下去
        PrintDecorator footer = new FooterDecorator(header,"本文包含绝密信息，请勿泄露！");
        // 注意watermark聚合了footer，而不是printComponent,这样就能够嵌套执行下去
        PrintDecorator watermark = new TextWatermarkDecorator(footer,"绝密文档");
        // 开始打印
        watermark.print();
    }

    /**
     * A部门的第二个打印任务，将文本水印改为图片水印，并且不再打印页脚
     * @param text
     */
    public void print02(String text){
        PrintComponent printComponent = new TextComponent(text);
        PrintDecorator header = new HeaderDecorator(printComponent,"绝密");
        PrintDecorator watermark = new ImgWatermarkDecorator(header);
        watermark.print();
    }
}
