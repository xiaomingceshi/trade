package com.cloud.cloudbootconsumertrade.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.AlipayClient;
import com.cloud.cloudbootconsumertrade.utils.AlipayConfig;
import com.cloud.cloudbootconsumertrade.utils.EmptyUtils;
import com.cloud.po.ItripHotelOrder;
import com.cloud.service.ItripHotelOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @description:支付宝付款controller
 * @author: GaoJiaoKui
 * @time: 2020/12/28 17:40
 */
@RestController
@RequestMapping(value = "/api")
public class ItripAlipaymentController {

    @Autowired
    private ItripHotelOrderService itripHotelOrderService;


    @RequestMapping(value = "/prepay/{orderNo}")
    public ModelAndView prepay(HttpServletResponse response, HttpServletRequest request , @PathVariable String orderNo){
        System.out.println("支付前订单信息确认.........");
        Map<String,Object> mapParam=new HashMap<>();
        HttpSession session=request.getSession();//从浏览器中获取订单信息
        try {
            mapParam.put("orderNo",orderNo);
            System.out.println("订单号："+orderNo);
           ItripHotelOrder hotelOrder=itripHotelOrderService.getItripHotelOrderListByMap(mapParam);
            System.out.println("sssss"+hotelOrder.toString());
           if (EmptyUtils.isNotEmpty(hotelOrder)){
               System.out.println("ttttttttt");
               session.setAttribute("orderNo",orderNo);
               session.setAttribute("hotelName",hotelOrder.getHotelName());
               session.setAttribute("payAmount",hotelOrder.getPayAmount());
               session.setAttribute("roomId",hotelOrder.getRoomId());
               session.setAttribute("count",hotelOrder.getCount());
               RedirectView redirectView=new RedirectView("/pay.jsp");
               ModelAndView modelAndView=new ModelAndView();
               modelAndView.setView(redirectView);
               return modelAndView;
           }else {
               System.out.println("订单号码异常........");
           }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/pay")
    public void pay(String WIDout_trade_no,String WIDsubject,String WIDtotal_amount,HttpServletResponse response){
        System.out.println("支付宝支付........");
        System.out.println(WIDout_trade_no);
        System.out.println(WIDsubject);
        System.out.println(WIDtotal_amount);
        //获得初始化的AlipayClient
        /***
         * serverUrl 支付宝网关
         * privatekey 私钥
         * alipaypublickey 支付宝公钥
         * */
        //AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do","2016101600702705","MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCu2UMZX9IEXn+H2ptW9scAHoG+J0SSbmTz2EZb+44j1cM0WqGgPat7Edi3HVp0y4yj5qCpZxfKy1Dm2jwUAyWbBM/PyrxqeA0K9/kUDYIpF6PgT41EdLkwL2o4gg/bM+0CCdNbkghRxHbV7VC+z71ebEMiKDRo4Zg0s9LJZzt5jywkdAsAXeSIj49nXDAURduhik2K18xHKmPeXyVculQg1IQ/fBTIZWZXw1ViFa3q2NOg/LBkiguduIJHX9yhoTe69RjiiHYg9gDgl6XvDyWFV1jmIc/5pht3AOOJU57RAS+qTbF6Y+D5EzpSr4WSKwwqYQbKcofOrEaMl97HmOzBAgMBAAECggEARV/Y2rGFL8yaxzl6lwe1L5vrGJqV/4+jqIiwagCmhhtjp1sqc9zkNCGBni4cXOkCdWmlZ3GLJCCFigMfAUW6XwaKucST+56EdkyrXER713gUwoRt5bJ2Y+L8P02DoxK4QC3L2bJYcLEGAZ12gy8D0PodrOjM2qxf6tFKmjTGiVUWEbW+oi9fwZmnT1bcdW3ESaxUf5GoNE/yoiNBnFSq6qOTQ3Vwegxi7LDFxkPXI4vOQvw5z2/q8MQ8NRfs7IhNMKdJjkLtkwwoh36nPUnlLhOdyMf6HQ20RCw3WIY7Cyfz3AOpo1/KFZTHiJkxdLbBYmQPFM1SN1aA4jEzTh8CvQKBgQD57mJRgRiZnIOIg+kM2SNN5dhQ+377qIZ6/Qf/xdUlgCoM9S+b/0nL4LM2H2gfn0OZr0Zv09hz1surPg1hUmcoUO3cZ/9HrRAfQtumAWCtfXhREaqxvieYSjt6HxsihCgJEHQMuWbOPOLuQsiKcGdo+xTW0ytUMKi1JEjGPhdAwwKBgQCzGCbtaR6LEov7xgV0zdBNIryqrg/WBmAvtFcFdZi+NE6Ivr+eqhZnzUdeJmqstmlodsW7B9xJeQ8mbulgR8ggZbOcUIM3jL1Vd0ShqbhUNwBWcEFV9vmDTdh8f0N8l3u9uOp43UntwOpld+hg4Y2MRiI5JxdnZUKafNC4ZboEKwKBgQDIVObj87l3L3hTDYDZNpdQ0kIwr1Yae/vHS1iFENsHoxKRrlpKDTfmvqaHZGc+qZcy8cZgzoq6V1qLWUK6VqWvMCdousdpeXPpytpq1sHabi7ptGKA9C2iqSXBfntukEXS9ig/JsEb4Lv5RPif1vdcs50BkOQzKImiIIJgvNZApwKBgGbMrDuGJUQKx1MjnSoooTJFiCooc2qUik2XpIO7tosnFxUi+HaohufaSubeAklVAzg1RNZQcr+xv2J+M3NSgKsn9Wr6Q/d0z5DpPvnUo7ujPoxfLwGbHCmkW2lK23/+q8aBCAWMb80K+QB5TWee0FL+RtKrf6GX3B01G9FcguO1AoGBALim7j3BR1FHcJQujV5ZHGaOH+J7ZWXMcN4LSxwKwiu6DeG790VPu0con0EtkhsmTuZeDhER8SS0KMzdhaGN2utcDxV+D9xFt40jCEmQRY7QFUL3z7cHmohEAtK3zb4FQKH4OYGMQV4xiqFoBevN5rLLFhSl/+3Mlu6ZKNWxGLTu","JSON","utf-8","MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAp1nsIlDtEyPfoqy4lnk0LcHbjjzd6bM2Do6rGLThmK3J3Rcl/2sDGcCsmynB+fpSwEjOjwo35rFZQ3Eft7EsGVmGNGatja6A68CUfU6WxZtaEPKobkQZKDDOqjeX6AUqygJIxL+9WtMY81UhhXAoKxDYrl2xe98qZPHEx2DCTbe5CkApBMCRR+rEAvMEfPYhK9j31xQfKGMx5xZwhXPzVlQIphXVAAgPHcU+woVQ4tEH+YsbpEbEkFwzbIoSkx3sT3kC6GCfsHjEifefnyx5JEsq6yoHRaA8Jtqpvk8SkFrmPzdH0RFesRPMpIgLwoXsmDjVg1Z5ZtYKGbqLuZD6SwIDAQAB","RSA2");
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl,AlipayConfig.APP_ID,AlipayConfig.APP_PRIVATE_KEY,"JSON",AlipayConfig.CHARSET,AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        // 设置同步地址
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        // 设置异步通知地址
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        // 封装请求支付信息
        //商户订单号，商户网站订单系统中唯一订单号，必填

        String out_trade_no =WIDout_trade_no;
        //付款金额，必填

        String total_amount =WIDtotal_amount;
        //订单名称，必填

        String subject="酒店预订";
        //商品描述，可空
        String body=WIDsubject;
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
        try {
            response.getWriter().write(form);//直接将完整的表单html输出到页面
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 支付宝页面跳转同步通知页面
     */
    @RequestMapping(value = "/return")
    public ModelAndView callback(String WIDout_trade_no,String WIDsubject,String WIDtotal_amount, HttpServletResponse response) {
        System.out.println("支付成功。。。。。");
        System.out.println("截取前订单编号"+WIDout_trade_no);
        String str=WIDout_trade_no.substring(0, WIDout_trade_no.indexOf(","));
        String orderId=WIDout_trade_no.substring(str.length()+1, WIDout_trade_no.length());
        System.out.println("截取后订单编号"+orderId);
        //根据订单编号修改订单状态
        Map<String,Object> param=new HashMap<>();
        param.put("orderNo",orderId);
        try {
            Integer flag= itripHotelOrderService.updateHotelOrderorderNoStatus(param);
            if(flag>0){
                //调用定时器,完成入住
                timer(orderId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        RedirectView redirectView = new RedirectView("http://127.0.0.1:8084/index.html");
        ModelAndView mv=new ModelAndView();
        mv.setView(redirectView);
        return mv;

    }
    /**
          * 这个方法是调度一个task，经过20000(ms)后开始进行调度，仅仅调度一次。
          */
    public void timer(String orderId){
        Timer nTimer= new Timer();
        nTimer.schedule(new TimerTask() {
            public void run() {
                System.out.println("----设定要指定任务-----");
                //获取支付的订单将orderStatus=2改为3
                //根据订单编号修改订单状态
                Map<String,Object> param=new HashMap<>();
                param.put("orderNo",orderId);
                try {
                    itripHotelOrderService.updateHotelOrderorderNoStatusT(param);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },20000);
    }
    /**
          * 设置18：00执行任务(第一次调度的时间)，每过一天执行一次
          * java.util.Timer.scheduleAtFixedRate(TimerTask task, Date firstTime, long period)
          */
 /*   public void timer4(){
Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.HOUR_OF_DAY,18);
        calendar.set(calendar.MINUTE,0);
        calendar.set(calendar.SECOND,0);
   Date time = calendar.getTime();
Timer timer = new Timer();
timer.scheduleAtFixedRate(new TimerTask() {
public void run(){
System.out.println("-------设定要指定任务--------");
}
},time,1000*60*60*24);// 这里设定将延时每天固定执行
}*/
}
