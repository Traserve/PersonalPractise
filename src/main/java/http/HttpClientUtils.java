/* ==================================================================
 * 中道互联网金融信息服务有限公司拥有该文件的使用、复制、修改和分发的许可权
 * 如果你想得到更多信息，请联系<532186767@qq.com>
 *
 * China Letter Cloud Technology CO LTD . owns permission to use, copy, modify and
 * distribute this documentation.
 * For more information, please see <532186767@qq.com>.
 * ==================================================================
 */
package http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Title: httpUtils
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2017
 * </p>
 * <p>
 * Company: 中道互联网金融信息服务有限公司
 * </p>
 * <p>
 * Date: 2018-04-30 11:45
 * </p>
 *
 * @author yirde <532186767@qq.com>
 * @version 1.0
 */
public class HttpClientUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    private static final String APPLICATION_JSON = "application/json";
    private static final String APPLICAION_X_FORM = "application/x-www-form-urlencoded";


    private static final String UTF_8 = "UTF-8";

    // 设置连接超时时间，单位毫秒。
    private static final int CONNECT_TIMEOUT = 600000;

    // 请求获取数据的超时时间(即响应时间)，单位毫秒。
    private static final int SOCKET_TIMEOUT = 600000;


    /**
     * JSON
     */
    public static String postWithJSON(String url, String json) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");

            StringEntity se = new StringEntity(json, UTF_8);
            se.setContentType(APPLICATION_JSON);
            se.setContentEncoding(UTF_8);
            httpPost.setEntity(se);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            return httpClient.execute(httpPost, responseHandler);
        } catch (Exception ex) {
            logger.error("【HttpClientUtils Post】请求地址: {}，参数:{},请求错误。", ex);
        } finally {
            try {
                httpClient.close();
            } catch (Exception ex) {
                logger.error("【HttpClientUtils Post】请求地址: {}，参数:{},httpClient.close关闭错误。", ex);
            }
        }
        return null;
    }

    /**
     * form
     *
     * @param url 地址
     * @param hashMap 参数
     */
    public static String postWithFormUrl(String url, Map<String, String> hashMap) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");

            StringBuilder sb = new StringBuilder();
            ArrayList<NameValuePair> pairList = new ArrayList<NameValuePair>();
            for (Entry<String, String> entry : hashMap.entrySet()) {
                BasicNameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue());
                pairList.add(pair);
                //输出 请求结果 用于LogUtil 调试
                sb.append(entry.getKey()).append("=").append(entry.getValue())
                        .append("&");
            }
            logger.info("【HttpClientUtils】【x-www-form-urlencoded】 请求地址: {}?{}", url, sb.toString());
            UrlEncodedFormEntity se = new UrlEncodedFormEntity(pairList, "UTF-8");
            se.setContentType(APPLICAION_X_FORM);
            se.setContentEncoding(UTF_8);

            httpPost.setEntity(se);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            return httpClient.execute(httpPost, responseHandler);
        } catch (Exception ex) {
            logger.error("【HttpClientUtils Post】请求地址: {}，参数:{},请求错误。", ex);
        } finally {
            try {
                httpClient.close();
            } catch (Exception ex) {
                logger.error("【HttpClientUtils Post】请求地址: {}，参数:{},httpClient.close关闭错误。", ex);
            }
        }
        return null;
    }

    /**
     * 发送get请求；不带请求头和请求参数
     *
     * @param url 请求地址
     */
    public static HttpClientResult doGet(String url) throws Exception {
        return doGet(url, null, null);
    }

    /**
     * 发送get请求；带请求头和请求参数
     *
     * @param url 请求地址
     * @param headers 请求头集合
     * @param params 请求参数集合
     */
    public static HttpClientResult doGet(String url, Map<String, String> headers, Map<String, String> params)
            throws Exception {
        // 创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建访问的地址
        URIBuilder uriBuilder = new URIBuilder(url);
        if (params != null) {
            Set<Entry<String, String>> entrySet = params.entrySet();
            for (Entry<String, String> entry : entrySet) {
                uriBuilder.setParameter(entry.getKey(), entry.getValue());
            }
        }

        // 创建http对象
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        /**
         * setConnectTimeout：设置连接超时时间，单位毫秒。
         * setConnectionRequestTimeout：设置从connect Manager(连接池)获取Connection
         * 超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的。
         * setSocketTimeout：请求获取数据的超时时间(即响应时间)，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
         */
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT).build();
        httpGet.setConfig(requestConfig);

        // 设置请求头
        packageHeader(headers, httpGet);

        // 创建httpResponse对象
        CloseableHttpResponse httpResponse = null;

        try {
            // 执行请求并获得响应结果
            return getHttpClientResult(httpResponse, httpClient, httpGet);
        } finally {
            // 释放资源
            release(httpResponse, httpClient);
        }
    }

    /**
     * Description: 封装请求头
     */
    public static void packageHeader(Map<String, String> params, HttpRequestBase httpMethod) {
        // 封装请求头
        if (params != null) {
            Set<Entry<String, String>> entrySet = params.entrySet();
            for (Entry<String, String> entry : entrySet) {
                // 设置到请求头到HttpRequestBase对象中
                httpMethod.setHeader(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * Description: 获得响应结果
     */
    public static HttpClientResult getHttpClientResult(CloseableHttpResponse httpResponse,
            CloseableHttpClient httpClient, HttpRequestBase httpMethod) throws Exception {
        // 执行请求
        httpResponse = httpClient.execute(httpMethod);

        // 获取返回结果
        if (httpResponse != null && httpResponse.getStatusLine() != null) {
            String content = "";
            if (httpResponse.getEntity() != null) {
                content = EntityUtils.toString(httpResponse.getEntity(), UTF_8);
            }
            return new HttpClientResult(httpResponse.getStatusLine().getStatusCode(), content);
        }
        return new HttpClientResult(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    /**
     * Description: 释放资源
     */
    public static void release(CloseableHttpResponse httpResponse, CloseableHttpClient httpClient) throws IOException {
        // 释放资源
        if (httpResponse != null) {
            httpResponse.close();
        }
        if (httpClient != null) {
            httpClient.close();
        }
    }

}
