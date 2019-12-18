package test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import http.HttpClientResult;
import http.HttpClientUtils;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 高德地图
 */
public class AmapUtil {

    private static Logger logger = LoggerFactory.getLogger(AmapUtil.class);
    private static final String KEY = "eb029ffa86723f795b5d0a38cd77a448";

    /**
     * 获取行政区域信息
     *
     * @param keyword 规则：只支持单个关键词语搜索关键词支持：行政区名称、citycode、adcode 例如，在subdistrict=2，搜索省份（例如山东），能够显示市（例如济南），区（例如历下区）
     * @param subdistrict 规则 设置显示下级行政区级数（行政区级别包括：国家、省/直辖市、市、区/县4个级别） 可选值：0、1、2、3 0：不返回下级行政区； 1：返回下一级行政区； 2：返回下两级行政区；
     * 3：返回下三级行政区；
     */
    public static HttpClientResult getAreaInfo(String keyword, int subdistrict) {
        HttpClientResult result = null;
        try {
            result = HttpClientUtils
                    .doGet("https://restapi.amap.com/v3/config/district?key=" + KEY + "&keywords=" + keyword
                            + "&subdistrict=" + subdistrict + "&extensions=base");
        } catch (Exception e) {
            logger.error("请求高德地图行政区域查询接口出错", e);
        }
        return result;
    }


    /**
     * 根据坐标获得地址  经度在前，纬度在后，经纬度间以“,”分割
     */
    public static HttpClientResult getDetailLocationInfo(String location) {
        HttpClientResult result = null;
        try {
            result = HttpClientUtils
                    .doGet("https://restapi.amap.com/v3/geocode/regeo?key=" + KEY + "&location=" + location);
        } catch (Exception e) {
            logger.error("请求高德地图坐标查询地址接口出错", e);
        }
        return result;
    }

    /**
     * 根据IP获取位置信息
     */
    public static HttpClientResult getDetailLocationByIp(String ip) {
        HttpClientResult result = null;
        try {
            //{"status":"1","info":"OK","infocode":"10000","province":"广东省","city":"广州市","adcode":"440100","rectangle":"113.1017375,22.93212254;113.6770499,23.3809537"}
            result = HttpClientUtils
                    .doGet("https://restapi.amap.com/v3/ip?key=" + KEY + "&ip=" + ip);
        } catch (Exception e) {
            logger.error("请求高德地图IP定位接口出错", e);
        }
        return result;
    }


    @Test
    public void getAreaInfoTest() {
        String areaInfo;
//        HttpClientResult result = getAreaInfo("中华人民共和国", 3);
        HttpClientResult result = getAreaInfo("511325", 1);
        if (Objects.nonNull(result) && StringUtils.isNotEmpty(result.getContent())) {
            JSONObject outJson = JSONObject.parseObject(result.getContent());
            String status = outJson.getString("status");
            if ("1".equals(status)) {
                JSONArray districtsArray = outJson.getJSONArray("districts");
                areaInfo = districtsArray.toJSONString();
                System.err.println(areaInfo);
            }
        }
    }

    @Test
    public void getDetailLocationInfoTest() {
        HttpClientResult result = getDetailLocationInfo("107.6493856959542,35.71521598356201");
        System.err.println(result.getContent());
    }

    @Test
    public void getDetailLocationByIpTest() {
        HttpClientResult result = getDetailLocationByIp("219.136.134.157");
        System.err.println(result.getContent());
    }
}
