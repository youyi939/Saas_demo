package cn.lnfvc.core.interceptor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @Author: KenChen
 * @Description: restTemplate的拦截器，调用服务端接口的时候添加自定义请求头
 * @Date: Create in  2021/8/9 下午2:17
 */
public class OrderInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {


        tranceRequest(request,body);
        HttpHeaders headers = request.getHeaders();
        headers.add("Authorization", "Bearer eyJUWVAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiLpmYjlgaUiLCJpYXQiOjE2Mjg0OTIyNzYsImlzcyI6Ind3dy5jamxseS5jb20iLCJyb2x1ZSI6WyJST0xFX3ZpcDEiXX0.T3BFEKPVssHmRER9mruEw2Yr29k0PTHOjAI_Msu3HtIWtOOtVLH5hfs25LE2oFh1aDAaVVhQ7csZhJ-mxXjCZQ");
        System.out.println(headers.toString());

        tranceRequest(request,body);
        return execution.execute(request, body);
    }

    private void tranceRequest(HttpRequest request, byte[] body) throws UnsupportedEncodingException {
        System.out.println("=========================== request begin ===========================");
        System.out.println("uri : "+ request.getURI());
        System.out.println("method : "+ request.getMethod());
        System.out.println("headers : "+ request.getHeaders());
        System.out.println("request body : "+ new String(body, "utf-8"));
        System.out.println("============================ request end ============================");
    }

}