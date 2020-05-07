package JavaEffective;

/**
 * “Go Further进无止境” <br>
 * 〈break 不可忘〉
 *
 * @author Luoxun
 * @create 2020/4/22
 * @since 1.0.0
 */
public class Client15 {
    public static void main(String[] args) {
        System.out.println(" 2 = " + toChineseNumberCase(2));
    }

    //把 阿拉伯 数字 翻译 成 中文 大写 数字
    public static String toChineseNumberCase(int n) {
        String chineseNumber = "";
        switch (n) {
            case 0:
                chineseNumber = "零";
                break;
            case 1:
                chineseNumber = "壹";
                break;
            case 2:
                chineseNumber = "贰";
                break;
            case 3:
                chineseNumber = "叁";
                break;
            case 4:
                chineseNumber = "肆";
                break;
            case 5:
                chineseNumber = "伍";
                break;
            case 6:
                chineseNumber = "陆";
                break;
            case 7:
                chineseNumber = "柒";
                break;
            case 8:
                chineseNumber = "捌";
                break;
            case 9:
                chineseNumber = "玖";
        }
        return chineseNumber;
    }

}
