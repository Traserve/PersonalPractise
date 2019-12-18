package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/10/25 9:57
 */

public class SendSMS {

    //用户名  实际使用时应该从session中获取
    String username = "用户名";
    //密码 实际使用时应该从session中得到的用户名中获取
    String password = "密码";
    //手机号码  单一内容测试时使用
    String phoneid = "手机号";
    //原地址(扩展码 可不填 前端获取 测试时为方便定义)
    String source_address = "扩展码";
    //外部编码 (有需求是可获取)
    long external_id = 0x1L;
    //发送短信方法
    String mt = "mt";
    //定义常量
    //dc 数据类型
    private static final int DATACODING = 15; //定死
    //rf 响应格式
    private static final int REPSPONSEFORMAT = 2; //定死
    //rd 是否需要状态报告
    private static final int REPORTDATA = 1; //定死
    //tf 短信内容的传输编码
    private static final int TRANSFERENCODING = 3; //定死
    //serviceaddress service端地址 //变量可根据实际情况改变
    private static String serviceaddress = "http://101.227.68.68:7891/";

    //单一内容下发&单一内容群发
    public String sendSingleSMS(HttpServletResponse resp) {
        //以下参数均由前端页面传来
        String result = "";
        String content = "【测试】这是一条测试短信aaa123";
        //因做测试 故原地址与外部编码不参与测试 实际情况有需要从前端定义参数获取
        try {
            //做URLEncoder - UTF-8编码
            String sm = URLEncoder.encode(content, "utf8");
            //将参数进行封装
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("un", username);
            paramMap.put("pw", password);

            //单一内容时群发  将手机号用;隔开
            paramMap.put("da", phoneid);
            paramMap.put("sm", sm);
            //发送POST请求
            result = SendPOST(mt, paramMap);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //将返回结果返回给界面
        writeJson(result, resp);
        return null;
    }

    //不同内容不同号码群发
    @RequestMapping("sendGroupSMS")
    public String sendGroupSMS(HttpServletResponse resp) {
        //以下参数均由前端页面传来 或者其他形式获取
        //不同内容不同号码群发  将手机号与下发内容分编写为：手机号#外部编码#短信内容|手机号#外部编码#短信内容。格式
        String[] mobiles = {"手机号", "手机号"};
        String[] contents = {"【测试】这是一条测试短信aaa123", "【测试】这是一条测试短信aaa123"};
        StringBuffer data = new StringBuffer();
        for (int i = 1; i <= mobiles.length; i++) {
            String mobile = mobiles[i - 1];
            if (i > 0 && i != mobiles.length && mobiles.length != 1) {
                data.append(mobile + "#" + contents[i - 1] + "|");
            } else if (i == mobiles.length) {
                data.append(mobile + "#" + contents[i - 1]);
            }
        }
        String content = data.toString();

        String result = "";
        try {
            //做URLEncoder - UTF-8编码
            String sm = URLEncoder.encode(content, "utf8");
            //将参数进行封装
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("un", username);
            paramMap.put("pw", password);
            paramMap.put("da", "");
            paramMap.put("sm", sm);
            result = SendPOST(mt, paramMap);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        writeJson(result, resp);
        return null;
    }

    public String SendPOST(String function, Map<String, Object> paramMap) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(serviceaddress + function);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // conn.setRequestProperty("Charset", "UTF-8");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            paramMap.put("dc", DATACODING);
            paramMap.put("rf", REPSPONSEFORMAT);
            paramMap.put("rd", REPORTDATA);
            paramMap.put("tf", TRANSFERENCODING);
            // 设置请求属性
            String param = "";
            if (paramMap != null && paramMap.size() > 0) {
                Iterator<String> ite = paramMap.keySet().iterator();
                while (ite.hasNext()) {
                    String key = ite.next();// key
                    Object value = paramMap.get(key);
                    param += key + "=" + value + "&";
                }
                param = param.substring(0, param.length() - 1);
                System.out.println(param);
            }

            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.err.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }


    //JSON方法输出
    public void writeJson(String array, HttpServletResponse resp) {
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter pw;
        try {
            pw = resp.getWriter();
            pw.write(array);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
