package huawei;

/**
 * Description: 给定一个字符串去除相邻两个相等的字符，比如"ABBAC",去除后结果"C"
 *
 * @author Martin
 * @date 2020/3/26 20:27
 */

public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(null));
        System.out.println(removeDuplicates(""));
        System.out.println(removeDuplicates("FAABCEECBD"));
    }

    public static String removeDuplicates(String input) {
        if(input == null || input.length() == 0){
            return "";
        }
        StringBuffer sb = new StringBuffer(input);
        boolean flag = true;
        //当字符串中存在相邻字符相等的情况且字符长度大于0继续进行循环
        while (flag) {
            //去掉替换后的0字符
            String str = sb.toString().replace("0", "");
            sb = new StringBuffer(str);
            char last = str.charAt(0);
            flag = false;
            for (int i = 1; i < str.length(); i++) {
                //判断是否跟上一个字符相等
                if (str.charAt(i) == last) {
                    //把相邻两个字符设为0
                    sb.setCharAt(i, '0');
                    sb.setCharAt(i - 1, '0');
                    flag = true;
                    if (i + i < str.length()) {
                        last = str.charAt(i + 1);
                        i++;
                    } else {
                        break;
                    }
                }else{
                    last = str.charAt(i);
                }
            }
        }
        return sb.toString();
    }
}
