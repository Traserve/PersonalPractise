package test;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName NetUtil
 * @Description
 * @Author Cao.Zhuang
 * @Date 2019/9/5 10:17
 */

public class NetUtil {

    private static Logger logger = LoggerFactory.getLogger(NetUtil.class);

    public static ArrayList<String> getLocalIpAddr() {
        ArrayList<String> ipList = new ArrayList<String>();
        InetAddress[] addrList;
        try {
            Enumeration interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) interfaces.nextElement();
                Enumeration ipAddrEnum = ni.getInetAddresses();
                while (ipAddrEnum.hasMoreElements()) {
                    InetAddress addr = (InetAddress) ipAddrEnum.nextElement();
                    if (addr.isLoopbackAddress() == true) {
                        continue;
                    }

                    String ip = addr.getHostAddress();
                    if (ip.indexOf(":") != -1) {
                        //skip the IPv6 addr
                        continue;
                    }

                    logger.debug("Interface: " + ni.getName()
                            + ", IP: " + ip);
                    ipList.add(ip);
                }
            }

            Collections.sort(ipList);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Failed to get local ip list. " + e.getMessage());
            throw new RuntimeException("Failed to get local ip list");
        }

        return ipList;
    }

    public static void getLocalIpAddr(Set<String> set) {
        ArrayList<String> addrList = getLocalIpAddr();
        set.clear();
        for (String ip : addrList) {
            set.add(ip);
        }
    }

    public static void main(String args[]) {
        //ArrayList<String> addrList = getLocalIpAddr();
        HashSet<String> addrSet = new HashSet<String>();
        getLocalIpAddr(addrSet);
        for (String ip : addrSet) {
            System.out.println("Local ip:" + ip);
        }
    }
}
