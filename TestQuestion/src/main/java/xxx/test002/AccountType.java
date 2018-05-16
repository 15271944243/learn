package xxx.test002;

/**
 * @description:
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/5/14
 */
public enum AccountType {
    SAVING, FIXED, CURRENT;
    private AccountType(){
        System.out.println("It is a account type");
    }
}
