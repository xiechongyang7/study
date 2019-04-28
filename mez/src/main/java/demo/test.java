package demo;

/**
 * @author xiechongyang
 * @description
 * @createTime 2019/1/31 上午 11:36
 * @since JDK1.8
 */
public class test {

    String str = "";


    public static void main(String arg[]) {
        xd xd = new xd();
        int a = 1;
        xd.one(a);
        xd.two(a);
        one(a);
        two(a);
    }

    public static void one(int a) {
        System.out.println(a);
        a = a + 1;
    }

    public static void two(int a) {
        System.out.println(a);
    }
}
