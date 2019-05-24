package com.study.studyredislock.util;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @Description IP地址校验
 * @Author liubing
 * @Date 2015年2月3日 下午4:39:18
 * @Copyright：北京邦孚力德商务服务有限公司
 */
public class IPUtils {
	/**
	 * ip校验
	 * 
	 * @param s
	 * @return Boolean
	 */
	public static Boolean isIpAddress(String s) {
		String regex = "(((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		return m.matches();
	}

	/**
	 * 获取客户端ip
	 * 
	 * @param request
	 * @return String
	 */
	public static String getClientAddress(HttpServletRequest request) {
		String address = request.getHeader("X-Forwarded-For");
		if (address != null && isIpAddress(address)) {
			return address;
		}
		return request.getRemoteAddr();
	}

	/**
	 * 检验ip是否在访问列表中
	 * 
	 * @param visitIP 访问的ip
	 * @param accessIP 允许访问的ip列表，例如"127.0.1.*|192.168.[1-50].*"
	 * @return true 匹配成功 false 匹配失败
	 */
	public static boolean checkIP(String visitIP, String accessIP) {
		if (accessIP == null || "".equals(accessIP)) {
			return false;
		}
		if (accessIP.contains(visitIP)) {
			return true;
		}
		// 遍历白名单,判断是否匹配
		boolean match = true;
		String[] accessIPArray = accessIP.split("\\|");
		String[] srcIPGroup = visitIP.split("\\.");
		for (String tarIP : accessIPArray) {
			String[] tarIPGroup = tarIP.split("\\.");
			match = true;
			for (int i = 0; i < 4; i++) {// 分组计算
				if (tarIPGroup[i].contains("-")) {// 区间通配符判断是否在区间内
					String[] tmp = tarIPGroup[i].replaceAll("[\\[\\]]", "").split("\\-");
					int min = Integer.valueOf(tmp[0]);
					int max = Integer.valueOf(tmp[1]);
					int srcTmp = Integer.valueOf(srcIPGroup[i]);
					if (srcTmp < min || srcTmp > max) {
						match = false;
						break;
					}
				} else if (!tarIPGroup[i].contains("*") && !srcIPGroup[i].equals(tarIPGroup[i])) {
					match = false;
					break;
				}
			}
			if (match) {
				break;
			}
		}
		return match;
	}

	public static void main(String[] args) {
		// String visitIP = "127.0.0.1";
		// String visitIP = "192.168.20.1";
		// String accessIP = "127.*.0.*|[190-199].[166-169].[1-50].[0-9]";
		// boolean flag = checkIP(visitIP, accessIP);
		// System.out.println(flag);
	}
}
