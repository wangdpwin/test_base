package cn.wangdpwin.test.jdk7;

/**
 * @Author wangdongpeng
 * @Date 2022/3/28 6:37 下午
 * @Version 1.0
 */
public class SwitchWithString {

    public static void main(String[] args) {
        String gender = "男";
        System.out.println(gender.hashCode());
        switch (gender) {
            case "男":
                System.out.println("先生你好");
                break;
            case "女":
                System.out.println("女士你好");
                break;
            default:
                System.out.println("你好");
        }
    }
}

/*
public class SwitchWithString {
    public SwitchWithString() {
    }

    public static void main(String[] args) {
        String gender = "男";
        System.out.println(gender.hashCode());
        byte var3 = -1;
        switch(gender.hashCode()) {
        case 22899:
            if (gender.equals("女")) {
                var3 = 1;
            }
            break;
        case 30007:
            if (gender.equals("男")) {
                var3 = 0;
            }
        }

        switch(var3) {
        case 0:
            System.out.println("先生你好");
            break;
        case 1:
            System.out.println("女士你好");
            break;
        default:
            System.out.println("你好");
        }

    }
}
 */
