package com.hema.userconfig;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * @ClassName UserConfig
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/9 18:09
 * @Version 1.0
 **/
public class UserConfig {
    /**url前半部分*/
    public static final String BASE_URL = "https://openapi.miaodiyun.com/distributor/sendSMS";

    /**开发者注册后系统自动生成的账号，可在官网登录后查看*/
    public static final String ACCOUNT_SID = "f7615b97c318230a318c3cf591925f81";

    /**开发者注册后系统自动生成的TOKEN，可在官网登录后查看*/
    public static final String AUTH_TOKEN = "e2615cf8d631ecba241c7d2bf5f401ef";

    /**响应数据类型, JSON或XML*/
    public static final String RESP_DATA_TYPE = "JSON";

    /**随机数*/
    public static final String RANDOM_NUM = (int)((Math.random()*9+1)*100000) + "";

    /**短信模板*/
    public static final String SMS_CONTENT = "【姚生记】亲爱的用户，您的短信验证码为："+ RANDOM_NUM +"，2分钟内有效，若非本人操作请忽略。";

    /**
     * 构造通用参数timestamp、sig和respDataType
     *
     * @return
     */
    public static String createCommonParam(String sid,String token) {
        // 时间戳
        long timestamp = System.currentTimeMillis();
        // 签名
        String sig = DigestUtils.md5Hex(sid + token + timestamp);
        StringBuilder commonParam = new StringBuilder();
        commonParam.append("&timestamp=").append(timestamp);
        commonParam.append("&sig=").append(sig);
        commonParam.append("&respDataType=").append(RESP_DATA_TYPE);
        return commonParam.toString();
    }

    /**
     * post请求
     *
     * @param url
     *            功能和操作
     * @param body
     *            要post的数据
     * @return
     * @throws Exception
     */
    public static String post(String url, String body) {
        System.out.println("body:" + System.lineSeparator() + body);

        String result = "";
        try {
            OutputStreamWriter out = null;
            BufferedReader in = null;
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();

            // 设置连接参数
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(20000);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            // 提交数据
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(body);
            out.flush();

            // 读取返回数据
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line = "";
            boolean firstLine = true; // 读第一行不加换行符
            while ((line = in.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                } else {
                    result += System.lineSeparator();
                }
                result += line;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 回调测试工具方法
     *
     * @param url
     * @return
     */
    public static String postCallBack(String url, String body) {
        String result = "";
        try {
            OutputStreamWriter out = null;
            BufferedReader in = null;
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();

            // 设置连接参数
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(20000);

            // 提交数据
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(body);
            out.flush();

            // 读取返回数据
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line = "";
            boolean firstLine = true; // 读第一行不加换行符
            while ((line = in.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                } else {
                    result += System.lineSeparator();
                }
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 短信发送(验证码通知，会员营销)
     * 接口文档地址：http://www.miaodiyun.com/doc/https_sms.html
     */
    public static void execute(String phone){
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("accountSid").append("=").append(ACCOUNT_SID);
            sb.append("&to").append("=").append(phone);
            sb.append("&param").append("=").append(URLEncoder.encode("","UTF-8"));
            //sb.append("&templateid").append("=").append("1521");
            sb.append("&smsContent").append("=").append(URLEncoder.encode(SMS_CONTENT,"UTF-8"));
            //URLEncoder.encode("【秒嘀科技】您的验证码为123456，该验证码5分钟内有效。请勿泄漏于他人。","UTF-8");
            String body = sb.toString() + createCommonParam(ACCOUNT_SID, AUTH_TOKEN);
            String result = post(BASE_URL, body);
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void duanxin(String phone){
        execute(phone);
    }
}
