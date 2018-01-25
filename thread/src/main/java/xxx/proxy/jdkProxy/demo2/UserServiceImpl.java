package xxx.proxy.jdkProxy.demo2;

/**
 * @description:
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/1/25
 */
public class UserServiceImpl implements UserService{

    @Override
    public String getName(Integer id) {
        System.out.println("------getName------");
        return "Tom";
    }

    @Override
    public Integer getAge(Integer id) {
        System.out.println("------getAge------");
        return 10;
    }
}
