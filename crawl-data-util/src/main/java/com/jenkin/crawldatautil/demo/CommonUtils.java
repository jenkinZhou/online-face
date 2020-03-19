package com.jenkin.crawldatautil.demo;

import org.assertj.core.util.Files;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：jenkin
 * @date ：Created at 2020/3/14 18:29
 * @description：工具
 * @modified By：
 * @version: 1.0
 */
public class CommonUtils {

    /**
     * form方式调用远程接口
     * @param postParameters
     * @param headersMap
     * @param remoteUrl
     * @return
     */
    public  static <T> T postRemoteFormInterface(MultiValueMap<String, Object> postParameters , Map<String,String> headersMap,
                                             String remoteUrl, MediaType mediaType,Class<T>  returnType){

        if(remoteUrl!=null) {
            RestTemplate re = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(mediaType);
            if(headersMap!=null) {
                headersMap.forEach((key, val) -> {
                    headers.set(key, val);
                });
            }
            // logger.info("请求参数===>" + postParameters.toJSONString());
            HttpEntity< MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(postParameters, headers);
            T res = re.postForObject(remoteUrl, requestEntity, returnType);
//           logger.info("远程连接返回结果====>"+ res);
            return res;
        }
        return null;

    }

    /**
     * 附件上传
     * @param file
     * @param targetUrl
     * @return
     */
    public static  String  uploadFile(File file, String targetUrl){
        FileSystemResource fileResource = new FileSystemResource(file);
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("file", fileResource);
        return postRemoteFormInterface(param, new HashMap<>(), targetUrl, MediaType.MULTIPART_FORM_DATA, String.class);
    }
    /**
     * 从网络Url中下载文件
     * @param urlStr

     */
    public static InputStream downLoadFromUrl(String urlStr, String cookie) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            //设置超时间为3秒
            conn.setConnectTimeout(30*1000);
            //防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            conn.setRequestMethod("GET");
            if (!StringUtils.isEmpty(cookie)) {
                conn.setRequestProperty("Cookie",cookie);
            }
            //得到输入流
            return conn.getInputStream();
        }catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }
    /**
     * 从网络Url中下载文件
     * @param urlStr

     */
    public static File downLoadFileFromUrl(String urlStr, String cookie) {
        InputStream inputStream = downLoadFromUrl(urlStr, cookie);
        return inputStreamToFile(inputStream);
    }
    /**
     * 从网络Url中下载文件
     * @param urlStr

     */
    public static File downLoadFileFromUrl(String urlStr, String cookie,String path) {
        InputStream inputStream = downLoadFromUrl(urlStr, cookie);
        return inputStreamToFile(inputStream,path);
    }
    /**
     * 将InputStream写入本地文件
     //     * @param destination 写入本地目录
     * @param input 输入流
     * @throws IOException IOException
     */
    public static File inputStreamToFile( InputStream input,String path){
        if (input==null) {
            return null;
        }
        int index;
        byte[] bytes = new byte[1024];
        File downloadFile = new File(path);

        try {
            if (!downloadFile.exists()) {
                downloadFile.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(downloadFile);
            while ((index = input.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, index);
                fileOutputStream.flush();
            }
            input.close();
            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return downloadFile;

    }
    /**
     * 将InputStream写入本地文件
//     * @param destination 写入本地目录
     * @param input 输入流
     * @throws IOException IOException
     */
    public static File inputStreamToFile( InputStream input){
        if (input==null) {
            return null;
        }
        int index;
        byte[] bytes = new byte[1024];
        File downloadFile = Files.newTemporaryFile();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(downloadFile);
            while ((index = input.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, index);
                fileOutputStream.flush();
            }
            input.close();
            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return downloadFile;

    }
    public static <T> T postUrl(String url,Object param,Class<T> tClass){
        RestTemplate re = new RestTemplate();
        ResponseEntity<T> tResponseEntity = re.postForEntity(url, param, tClass);
        return tResponseEntity.getBody();
    }

}
