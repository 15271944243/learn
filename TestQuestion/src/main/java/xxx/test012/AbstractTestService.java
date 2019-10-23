package xxx.test012;

/**
 * @Description:
 * @Auther: xiaoxiaoxiang
 * @Date: 2018/7/30 15:13
 */
public abstract class AbstractTestService implements TestService{

    @Override
    public void test() {
        System.out.println("AbstractTestService");
    }

    void commonService(){
        System.out.println("commonService");
    }
}
