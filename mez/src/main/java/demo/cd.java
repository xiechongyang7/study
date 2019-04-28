package demo;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xiechongyang
 * @description
 * @createTime 2019/4/8 下午 4:12
 * @since JDK1.8
 */
public class cd {
    private static String secret = "2B92E1BF69A3E35C78BBA564B495A2BE";

    public static void main(String[] args) throws Exception {
//        Map jo = new HashMap();
//        jo.put("merchant_id", "6619161553064051");
//        jo.put("sign_type","MD5");
//        jo.put("timestamp", "1550919346");
//        jo.put("uuid", "2a7cbda4-28de-4a19-a0b6-9c76f6df63f9");
//        jo.put("sign", "98d7abc9e6d2c9eef61c4612965df5c0");
//        jo.put("version","1.0.0");
//        jo.put("custom", "111");
//        jo.put("order_no","2019040400024");
//        jo.put("mode", "union_we_chat_pay");
//        jo.put("subject", "腾讯游戏王者荣耀皮肤");
//        jo.put("amount", "36500");
//        jo.put("currency", "CNY");
//        jo.put("user_client_ip", "180.168.11.10");
//        jo.put("notify_url", "https://testsdmuat.srbank.cn/notify_url");

        Aa aa = new Aa();
        aa.setMerchant_id("6619161553064051");
        aa.setSign_type("MD5");
        aa.setTimestamp("1550919346");
        aa.setUuid("2a7cbda4-28de-4a19-a0b6-9c76f6df63f9");
        aa.setSign("98d7abc9e6d2c9eef61c4612965df5c0");
        aa.setVersion("1.0.0");
        aa.setCustom("111");
        aa.setOrder_no("2019040400024");
        aa.setMode("union_we_chat_pay");
        aa.setSubject("腾讯游戏王者荣耀皮肤");
        aa.setAmount("36500");
        aa.setCurrency("CNY");
        aa.setUser_client_ip("180.168.11.10");
        aa.setNotify_url("https://testsdmuat.srbank.cn/notify_url");

        String str = sortValue(aa);
        System.out.println("排序后字符串" + str);
        System.out.println("sign是" + HmacSHA1Encrypt(str, secret));
//        Signutrue signStr = new Signutrue();
//        String TestStr = signStr.getSignTokens(jo);
//        System.out.println(TestStr);
//
//        byte[]  Data= TestStr.getBytes(Charset.forName("UTF-8"));
//        byte[]  secretData = signStr.secret.getBytes(Charset.forName("UTF-8"));

//        System.out.println(Hmacs(Data, secretData, "HmacMD5"));
    }


    public static String sortValue(Object obj) {
        String str = null;
        try {
            if (obj == null) {
                return str;
            }
            Class<?> clz = obj.getClass();
            Field[] declaredFields = clz.getDeclaredFields();
            List<String> list = new ArrayList<>();
            for (Field field : declaredFields) {
                String name = field.getName();
                if ("SIGN".equals(name.toUpperCase()) || "THIS$0".equals(name.toUpperCase()) || "SERIALVERSIONUID".equals(name.toUpperCase())) {
                    continue;
                }
                String methodName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
                Method declaredMethod = clz.getMethod(methodName);
                Object fieldValue = declaredMethod.invoke(obj);
                if (null == fieldValue || "".equals(fieldValue)) {
                    continue;
                }
                list.add(name + "=" + fieldValue.toString());
            }
            if (list.size() == 0) {
                return str;
            }
//            logger.info(list+"排序前");
            Collections.sort(list);
//            logger.info(list+"排序后");
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                stringBuilder.append("&").append(list.get(i));
            }
            str = stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return str;
    }

    private static final String MAC_NAME = "HmacSHA1";
    private static final String ENCODING = "UTF-8";

    public static String HmacSHA1Encrypt(String encryptText, String encryptKey) throws Exception {
        byte[] data = encryptKey.getBytes(ENCODING);
        //根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
        SecretKey secretKey = new SecretKeySpec(data, MAC_NAME);
        //生成一个指定 Mac 算法 的 Mac 对象
        Mac mac = Mac.getInstance(MAC_NAME);
        //用给定密钥初始化 Mac 对象
        mac.init(secretKey);

        byte[] text = encryptText.getBytes(ENCODING);
        //完成 Mac 操作
        return encodeHex(mac.doFinal(text), false);
//        return Base64.encodeBase64(mac.doFinal(text));
    }


    //
//
//    public String getSignTokens(Map<String, String> map)
//    {
//        String result = "";
//        try {
//            List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(map.entrySet());
//            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
//            Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {
//
//                public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
//                    return (o1.getKey()).toString().compareTo(o2.getKey());
//                }
//            });
//
//            int size = map.size();
//            int tmpSize = 0;
//            // 构造签名键值对的格式
//            StringBuilder sb = new StringBuilder();
//            for (Map.Entry<String, String> item : infoIds) {
//                if (item.getKey() != null || item.getKey() != "" || item.getKey() !="sign") {
//                    String key = item.getKey();
//                    String val = item.getValue();
//
//                    if (!(val == "" || val == null)) {
//                        if(size - tmpSize > 1) {
//                            sb.append(key + "=" + val + "&");
//                        }else {
//                            sb.append(key + "=" + val);
//                        }
//
//                        tmpSize +=1;
//                    }
//                }
//            }
//            result = sb.toString();
//        } catch (Exception e) {
//            return null;
//        }
//        return result;
//    }
//
//
//
//    private static String Hmacs(byte[] data, byte[] key, String signType) {
//        try {
//            SecretKeySpec signingKey = new SecretKeySpec(key, signType);
//            Mac mac = Mac.getInstance(signType);
//            mac.init(signingKey);
//            return encodeHex(mac.doFinal(data));
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (InvalidKeyException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static String byte2hex(byte[] b) {
//        StringBuilder hs = new StringBuilder();
//        String stmp;
//        for (int n = 0; b != null && n < b.length; n++) {
//            stmp = Integer.toHexString(b[n] & 0XFF);
//            if (stmp.length() == 1) {
//                hs.append('0');
//            }
//            hs.append(stmp);
//        }
//        return hs.toString().toUpperCase();
//    }
//
//
//    // 数据准16进制编码
//    public static String encodeHex(final byte[] data) {
//        return encodeHex(data, false);
//    }
//
    // 数据转16进制编码
    public static String encodeHex(final byte[] data, final boolean toLowerCase) {
        final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        final char[] toDigits = toLowerCase ? DIGITS_LOWER : DIGITS_UPPER;
        final int l = data.length;
        final char[] out = new char[l << 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
            out[j++] = toDigits[0x0F & data[i]];
        }
        return new String(out);
    }
}
