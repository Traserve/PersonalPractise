package bank;

import http.HttpClientUtils;
import org.json.JSONObject;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2020/1/13 11:50
 */

public class Bank {

    public static void main(String[] args) throws Exception {
        String bankNo = "6228483610058294110";
        //银行代码请求接口 url
        String url = "https://ccdcapi.alipay.com/validateAndCacheCardInfo.json?_input_charset=utf-8&cardNo=" + bankNo
                + "&cardBinCheck=true";
        //发送请求，得到 josn 类型的字符串
        String result = HttpClientUtils.doGet(url).getContent();
        // 转为 Json 对象
        JSONObject json = new JSONObject(result);
        //获取到 bank 代码
        String bank = String.valueOf(json.get("bank"));
        //爬取支付宝银行合作商页面
        String listContent = HttpClientUtils.doGet("http://ab.alipay.com/i/yinhang.htm").getContent();
        //过滤得到需要的银行名称
    }
}
