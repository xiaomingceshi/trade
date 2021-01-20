package com.cloud.cloudbootconsumertrade.utils;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号,开发时使用沙箱提供的APPID，生产环境改成自己的APPID
    public static String APP_ID = "2021000116685239";

    // 商户私钥，您的PKCS8格式RSA2私钥
    //public static String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCu2UMZX9IEXn+H2ptW9scAHoG+J0SSbmTz2EZb+44j1cM0WqGgPat7Edi3HVp0y4yj5qCpZxfKy1Dm2jwUAyWbBM/PyrxqeA0K9/kUDYIpF6PgT41EdLkwL2o4gg/bM+0CCdNbkghRxHbV7VC+z71ebEMiKDRo4Zg0s9LJZzt5jywkdAsAXeSIj49nXDAURduhik2K18xHKmPeXyVculQg1IQ/fBTIZWZXw1ViFa3q2NOg/LBkiguduIJHX9yhoTe69RjiiHYg9gDgl6XvDyWFV1jmIc/5pht3AOOJU57RAS+qTbF6Y+D5EzpSr4WSKwwqYQbKcofOrEaMl97HmOzBAgMBAAECggEARV/Y2rGFL8yaxzl6lwe1L5vrGJqV/4+jqIiwagCmhhtjp1sqc9zkNCGBni4cXOkCdWmlZ3GLJCCFigMfAUW6XwaKucST+56EdkyrXER713gUwoRt5bJ2Y+L8P02DoxK4QC3L2bJYcLEGAZ12gy8D0PodrOjM2qxf6tFKmjTGiVUWEbW+oi9fwZmnT1bcdW3ESaxUf5GoNE/yoiNBnFSq6qOTQ3Vwegxi7LDFxkPXI4vOQvw5z2/q8MQ8NRfs7IhNMKdJjkLtkwwoh36nPUnlLhOdyMf6HQ20RCw3WIY7Cyfz3AOpo1/KFZTHiJkxdLbBYmQPFM1SN1aA4jEzTh8CvQKBgQD57mJRgRiZnIOIg+kM2SNN5dhQ+377qIZ6/Qf/xdUlgCoM9S+b/0nL4LM2H2gfn0OZr0Zv09hz1surPg1hUmcoUO3cZ/9HrRAfQtumAWCtfXhREaqxvieYSjt6HxsihCgJEHQMuWbOPOLuQsiKcGdo+xTW0ytUMKi1JEjGPhdAwwKBgQCzGCbtaR6LEov7xgV0zdBNIryqrg/WBmAvtFcFdZi+NE6Ivr+eqhZnzUdeJmqstmlodsW7B9xJeQ8mbulgR8ggZbOcUIM3jL1Vd0ShqbhUNwBWcEFV9vmDTdh8f0N8l3u9uOp43UntwOpld+hg4Y2MRiI5JxdnZUKafNC4ZboEKwKBgQDIVObj87l3L3hTDYDZNpdQ0kIwr1Yae/vHS1iFENsHoxKRrlpKDTfmvqaHZGc+qZcy8cZgzoq6V1qLWUK6VqWvMCdousdpeXPpytpq1sHabi7ptGKA9C2iqSXBfntukEXS9ig/JsEb4Lv5RPif1vdcs50BkOQzKImiIIJgvNZApwKBgGbMrDuGJUQKx1MjnSoooTJFiCooc2qUik2XpIO7tosnFxUi+HaohufaSubeAklVAzg1RNZQcr+xv2J+M3NSgKsn9Wr6Q/d0z5DpPvnUo7ujPoxfLwGbHCmkW2lK23/+q8aBCAWMb80K+QB5TWee0FL+RtKrf6GX3B01G9FcguO1AoGBALim7j3BR1FHcJQujV5ZHGaOH+J7ZWXMcN4LSxwKwiu6DeG790VPu0con0EtkhsmTuZeDhER8SS0KMzdhaGN2utcDxV+D9xFt40jCEmQRY7QFUL3z7cHmohEAtK3zb4FQKH4OYGMQV4xiqFoBevN5rLLFhSl/+3Mlu6ZKNWxGLTu";
    //public static String APP_PRIVATE_KEY ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCu2UMZX9IEXn+H2ptW9scAHoG+J0SSbmTz2EZb+44j1cM0WqGgPat7Edi3HVp0y4yj5qCpZxfKy1Dm2jwUAyWbBM/PyrxqeA0K9/kUDYIpF6PgT41EdLkwL2o4gg/bM+0CCdNbkghRxHbV7VC+z71ebEMiKDRo4Zg0s9LJZzt5jywkdAsAXeSIj49nXDAURduhik2K18xHKmPeXyVculQg1IQ/fBTIZWZXw1ViFa3q2NOg/LBkiguduIJHX9yhoTe69RjiiHYg9gDgl6XvDyWFV1jmIc/5pht3AOOJU57RAS+qTbF6Y+D5EzpSr4WSKwwqYQbKcofOrEaMl97HmOzBAgMBAAECggEARV/Y2rGFL8yaxzl6lwe1L5vrGJqV/4+jqIiwagCmhhtjp1sqc9zkNCGBni4cXOkCdWmlZ3GLJCCFigMfAUW6XwaKucST+56EdkyrXER713gUwoRt5bJ2Y+L8P02DoxK4QC3L2bJYcLEGAZ12gy8D0PodrOjM2qxf6tFKmjTGiVUWEbW+oi9fwZmnT1bcdW3ESaxUf5GoNE/yoiNBnFSq6qOTQ3Vwegxi7LDFxkPXI4vOQvw5z2/q8MQ8NRfs7IhNMKdJjkLtkwwoh36nPUnlLhOdyMf6HQ20RCw3WIY7Cyfz3AOpo1/KFZTHiJkxdLbBYmQPFM1SN1aA4jEzTh8CvQKBgQD57mJRgRiZnIOIg+kM2SNN5dhQ+377qIZ6/Qf/xdUlgCoM9S+b/0nL4LM2H2gfn0OZr0Zv09hz1surPg1hUmcoUO3cZ/9HrRAfQtumAWCtfXhREaqxvieYSjt6HxsihCgJEHQMuWbOPOLuQsiKcGdo+xTW0ytUMKi1JEjGPhdAwwKBgQCzGCbtaR6LEov7xgV0zdBNIryqrg/WBmAvtFcFdZi+NE6Ivr+eqhZnzUdeJmqstmlodsW7B9xJeQ8mbulgR8ggZbOcUIM3jL1Vd0ShqbhUNwBWcEFV9vmDTdh8f0N8l3u9uOp43UntwOpld+hg4Y2MRiI5JxdnZUKafNC4ZboEKwKBgQDIVObj87l3L3hTDYDZNpdQ0kIwr1Yae/vHS1iFENsHoxKRrlpKDTfmvqaHZGc+qZcy8cZgzoq6V1qLWUK6VqWvMCdousdpeXPpytpq1sHabi7ptGKA9C2iqSXBfntukEXS9ig/JsEb4Lv5RPif1vdcs50BkOQzKImiIIJgvNZApwKBgGbMrDuGJUQKx1MjnSoooTJFiCooc2qUik2XpIO7tosnFxUi+HaohufaSubeAklVAzg1RNZQcr+xv2J+M3NSgKsn9Wr6Q/d0z5DpPvnUo7ujPoxfLwGbHCmkW2lK23/+q8aBCAWMb80K+QB5TWee0FL+RtKrf6GX3B01G9FcguO1AoGBALim7j3BR1FHcJQujV5ZHGaOH+J7ZWXMcN4LSxwKwiu6DeG790VPu0con0EtkhsmTuZeDhER8SS0KMzdhaGN2utcDxV+D9xFt40jCEmQRY7QFUL3z7cHmohEAtK3zb4FQKH4OYGMQV4xiqFoBevN5rLLFhSl/+3Mlu6ZKNWxGLTu";
    //public static String APP_PRIVATE_KEY ="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC69tPwFeozsixBFLmoAjtdbObzZJMRU+CKaw3eRUFjcYMMAy00pAeS8nGfhYKTak8GCG+SSkAm9sUwZA9HiAB/SWiSwChcaDdvBur3ejfE+Qo1CSZMqPck7+ieZa6sHmRD4vzDEp2/foX67Ah6uC6v7R1iz9a2z9lvBEW3qXP8nfEmOEb5qO80gsbQEHrk0GiGVJvx1/v/KpW3yCIYk5Aun0CaEuyzlFDr9Sr8qtlbYEh8ICSFQDPdIQLYB+IT581iQfpgCoNo8rdIdPNXCb5MjWCBKPO06Brh/UwP/viqbPQcVqiSZIwyJx8FEoQGazdtGKxlLtfFBch1K4KNQxjzAgMBAAECggEABEjv5oq6CWFF/l/ZOW6Dqcp7KIzfigAgH0wAz11K+Fp7pGTWPmSb/9QqontO2M4Q7ZR36iRlf/8b2dYRO5R0XnZyPRrGUgfZbWP9MprMeGk0wK5rAErHD0OoUykFbdBsf9nN7TKaBu+BZpTORPG/sCyBBei5hQsScqboaiMqE1oJRmprnzaJ9SW81Kl1VBwXtmczL77Pok0s0UZ1GpG9FcfqN9aNAVj9Ylot+qWerVVmihGaPFNWJczGB3/Lp6x77l3v8nBtc/ydWcT+2lq9V2TLnc/xreCc/e8icdFW7juVIOF0vMWL5Km3pVEYtb4S92rjdU1xh9BsjTQPUZ9G4QKBgQDpLbFh852WZtFnmix6Erb4ht2OcagAxo/lCl/ZE6iRJ6VyMky1xDDWWaieTAfqJvo2cBXJr5XkctRZV/LNrAVvu0zsK3ermM6yv8Og84nDEOljQAXlYvTsg3CjqdSyw7H8GHp4nyoJ9v+4SHygXRDi/CMXCvRHMXhOhQh3c03vaQKBgQDNQzs2jl5SYVhoAViV274cvS3Vb3waZHCSQy0/o/b8YdHscd6dN1CbES4npiM4VMTbQYjE3DcDNJ/dm7kvxD0bYGryMGtRxuzohDPFt2zxqmckAtS9j/CllWjNDTuHw4hJZ/qXMpVo+Gh04JeW0h/rMkMnjpIHVCgsR/q7DI/V+wKBgAq90x0LBuhlxiG6pW/eKtWaCNzF+ZJHk1tetfmfATXmmKWBEa2R4xoMuUrJf9fWgdI+KZLH5uTGMWgIOCQnV3zFKQ78FaAvAt6THOTuMxtsTQQIb/0YKOY4S9kOOsEdaLaPPh0OX/ZjjXYkyLDueJesO8WU+JnK+prLYA94nU95AoGBAJZkljQI6A8QCAhcRB243XiNG9HwV0u3H8vqsHKanlKZEYhefi9O4h5b3idq0Q9q/LlxMNacSypsGl3yxSK8c9FlObatx1QpnldW1eAd3xLKObvm3xztI/MOn7Tt5xo4J9kw+ChkBZjduRs5m5gD6SMYtp97FH+OJ8kaDBmUwKaVAoGAIfXV34yuXNxxUW4I3LrnXsvTlCNU5IUiUawE/xo1ja6MDSs7pClTyuU2RlPIO/g9L3zBvD1XXuUh8T3AISxs6OD+6V0Yqn53eBAtIWzLogvaDXhAsMma12m7jzap2B+LCoMhsKhsp+2AVv7had62ER3TA6QBuPB/IQT+k90BI4E=";
    /**GJK应用私钥，支付宝开放平台中软件中获取生成*/
    public static String APP_PRIVATE_KEY ="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDiqGnMnbEmItVvUN4gF4+GbjbBwppk8AemPKbH42a2qYMffJNUyv45wBfoBwlnO3QxpdlYyP2CBhOlSCbik72s1mI8RED8ZXjJ7uFhOnWsclF465xs08oQ6zS7X3erakTk1beXTrxhTW0r3WJbBbNDVEYC1KFDStQ7DYXDXlPbVUvnelfWqcQURRoMvpbdJY6rVNdkDu1weos4hhCp9WEya1K386b7NwrEpNY9p/LjzgOPSWxoBogw9kaPD3gJUpgFWaVftUMDvixJ5emnHNCfh/6ShV9wES7B24wmjQkEqVbnfsvBmNertPo+L8W8xDsjJU3Y5uuf7p+t0UlFZJbnAgMBAAECggEAZKUd3bMED4gWOEizaZKss6fK/rzX7Aw9iU6TTF0opeGdjOS3U0aUHraypuBBB6r5zHX1jhwpnYvvO0xPn/q0lcPYeSRhqvGv8hL110OrLvjQPp54pkZhCqQ2lSEuNVqJ3wcbb7+RnK9R09GJNBvS3wnT0Lv0I7pdhR9bD0aae+CNLqGT88rbcptl7kwTkgVLWRrMI4e1NYPRnEftggQDL1FqMhBQUto6uWY5YqDcI09K7p9kkYm3oX6Hseb1wHbtafDNIw5pmmofBsDyO/lUuh7zov2NLx9JHyieh5VFKQ22nAXrcAWJcE18ENC/H6VceiSk8ua8j3kHlaFYa+naaQKBgQD6aofOghgFwYGK5e17aCF1CNeH8KKb1LC1Bx3sadqVtXCDSU6KDgcrgBvLUqxWcekmdYP2PtmQKFCkgjQpy0cwgq7VzB3e8tiW6rx1FfrOpgsdIMW8THmVKs/zuvJWhYcCvjzj3bYMeS6d0r3vliG0Pl4in0Jmle88f67xS0w79QKBgQDntkL6uoKRDNRbS9oXEQo19Rdwhka9klBZh9LDMbVR/9r++bqivoXrN5zxeDl5KuqbH9IeYrAGOu3PcEznVzlnlzuL3h+CUfqjtjv/2YbZijEP1wa0zmF833SLtPs8uqEEPkKI/32vtVPNPOkUZ0nF/6AOitUcJrSl5jX+3tA56wKBgA3CZr3pFgrS7BxGr/rU6Om2V6lnhnfLgv4favx/gHwzYQBFueQKC0jPnDdazo9daPMtB9gy8d9i57NyWA1n1vyKYbLrqUSD0XTRZxOD5qkOJJQwJc1H4nJYzN5WilRIt/dlnpDisMsUqYQQfVE5zZZKyv9aAtsCKAgJ+AHYIlM1AoGAFuD5NhaKY9YXdbhEnXhyQKelm9e2TmuPAXgWyG01ERapQfnYgs87G+GO3ozXZ+5j4dM/hP6LkOHqr0vQXBtRsLfPCl1xUQXVMKsCu5134izx8TVzFRE3sQPDVzQUhoeK9IdNPIe1mk7WKnK0NO6J60H1RNpSdogf2C2l8TeA6ecCgYEAstaHceY2+UMC4wqKHZfMa49QOWTmdr2gmLDi4h+3XtmvrcvNrhoMkJfxZBX4YQPo2P6+HNfhuiAp2436tpHOh+kqt3NB529Weey1Mp9p3oPNn6GgB+4urFomHDnc8y2Dnp0wXjMg717sBtYjSTABIpV2YFhhPFrYVMRjdoHwr+Q=";
      // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    //public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAp1nsIlDtEyPfoqy4lnk0LcHbjjzd6bM2Do6rGLThmK3J3Rcl/2sDGcCsmynB+fpSwEjOjwo35rFZQ3Eft7EsGVmGNGatja6A68CUfU6WxZtaEPKobkQZKDDOqjeX6AUqygJIxL+9WtMY81UhhXAoKxDYrl2xe98qZPHEx2DCTbe5CkApBMCRR+rEAvMEfPYhK9j31xQfKGMx5xZwhXPzVlQIphXVAAgPHcU+woVQ4tEH+YsbpEbEkFwzbIoSkx3sT3kC6GCfsHjEifefnyx5JEsq6yoHRaA8Jtqpvk8SkFrmPzdH0RFesRPMpIgLwoXsmDjVg1Z5ZtYKGbqLuZD6SwIDAQAB";
   //public static String ALIPAY_PUBLIC_KEY ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAp1nsIlDtEyPfoqy4lnk0LcHbjjzd6bM2Do6rGLThmK3J3Rcl/2sDGcCsmynB+fpSwEjOjwo35rFZQ3Eft7EsGVmGNGatja6A68CUfU6WxZtaEPKobkQZKDDOqjeX6AUqygJIxL+9WtMY81UhhXAoKxDYrl2xe98qZPHEx2DCTbe5CkApBMCRR+rEAvMEfPYhK9j31xQfKGMx5xZwhXPzVlQIphXVAAgPHcU+woVQ4tEH+YsbpEbEkFwzbIoSkx3sT3kC6GCfsHjEifefnyx5JEsq6yoHRaA8Jtqpvk8SkFrmPzdH0RFesRPMpIgLwoXsmDjVg1Z5ZtYKGbqLuZD6SwIDAQAB";
    /**GJK支付宝公钥，支付宝开放平台沙箱服务中获取*/
      public static String ALIPAY_PUBLIC_KEY ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAijNIhV5Vx/h1REtzCZApgMsDciCS8oJHl7HVppzpqPurkKr0Qyd3c3NCozDhvo5A9W5DtRUlEqcKCcY1rNDRoEY8z9cl0usR1L9j3Z2i7UV2U9Y51tmsqRLNOZfCTNEgzDddZ1UR9t96asXaz4jcoPyCJyzht6P030kFoqWfnVdrfm0haUp/m8zXAvR2SFbDHzetbGORKkYktO40U9q9NMh/ojEXAajXUWfFsHY6DD0MqNz/ebSsVui0PJSGySwzcJDRmNhEwMJZu5qfQlvus+nke+x2al1w97vI+4FY2k5NqT+xjjeIdD1gpsxMfXHy6KPxko5Uvcle4Lb/goxQmwIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8088/alipay.trade.page.pay-JAVA-UTF-8/api/pay/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问(其实就是支付成功后返回的页面)MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAriTlo/ApyxhjDdpF8Inq33gg8EVEEyjcj8ioKl5VRAEU2uwUXtvrudNYkI21osw1p94nOwvojwPo0SQiaG6N2oh48A1u1BEhM24cZKBJu9AgbBP8H2LaIam6g4USXaImZYladXNXB8/M/5iTjoQtPl4302WPOFDxsiBlgIuk8YBpUKtDUOKGxlwq+1LjIQ5XUzvfci6jXcHvFFt/1Ea5jOp39YrdVhrtl+K8QVr6O3V4xiIjU1SFbPMxXTLbIUo4+yaeo5OKU8lTOqFjXtguoS/RR9ZvfdgYlf2MLHSBXwZwnt4GfCW9AO4e1ab1SbKbdsWbBi3I07XV4gHkkujGEwIDAQAB
    public static String return_url = "http://localhost:8088/return_url.html";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String CHARSET = "utf-8";

    // 支付宝网关，这是沙箱的网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 日志路径头
    public static String log_path = "E:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
