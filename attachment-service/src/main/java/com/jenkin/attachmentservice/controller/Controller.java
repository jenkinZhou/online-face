package com.jenkin.attachmentservice.controller;

import com.google.common.io.Files;
import com.jenkin.attachmentservice.model.Appendix;
import com.jenkin.attachmentservice.respositories.AttachmentRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * @author ：jenkin
 * @date ：Created at 2020/3/14 12:35
 * @description：controller
 * @modified By：
 * @version: 1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/attachment")
@Api(tags="附件接口")
public class Controller {
   // final String path = "/data/music/appendixs/";
    private static final String path ;
    static {
        System.out.println(System.getProperty("user.dir"));
//        path=System.getProperty("user.dir")+"/attachment-service/src/main/resources/appendixs/";
        path="/data/deploy/files/appendixs/";

    }

    @Autowired
    private AttachmentRepository attachmentRepository;

    @DeleteMapping("/deleteFile")
    @ApiOperation(value = "删除文件",notes = "通过文件编码删除文件")
    public void deleteFile(String fileCode){
        File file = new File("/data/music/appendixs/" + fileCode);
        attachmentRepository.deleteByAppendixCode(fileCode);
        if (file.exists()) {
            file.delete();
        }
    }

    @PostMapping("/upload")
    @ApiOperation(value = "文件上传",notes = "文件上传，其字段为：file,会返回对应的文件编码")
    @Transactional(rollbackFor = Exception.class)
    public String multifileUpload(HttpServletRequest request) {


        String fileName = UUID.randomUUID().toString();
        MultipartFile multipartFile = ((MultipartHttpServletRequest) request).getFile("file");
        if(multipartFile!=null&&!multipartFile.isEmpty()) {
            System.out.println("文件名====》"+multipartFile.getOriginalFilename());
            try {
                String fileExtension =
                        Files.getFileExtension(multipartFile.getOriginalFilename()==null?"":multipartFile.getOriginalFilename());
                String fname = fileName+"."+fileExtension;
                File file = new File(path + fname);
                if (!file.exists()) {
                    file.createNewFile();
                }
                multipartFile.transferTo(file);
                Appendix appendix = new Appendix(Integer.MAX_VALUE,fname,"file");
                attachmentRepository.saveAndFlush(appendix);
                return fname;
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        return  "上传文件失败";
    }


    @GetMapping("/download")
    @ApiOperation(value = "下载文件",notes = "根据文件编码下载文件")
    public void downLoad(String fileCode, HttpServletRequest request, HttpServletResponse response){
        String name =path+fileCode;
//        getMusic(fileCode,name,request,response);
        downloadFile(fileCode,name,request,response);
    }

    private void downloadFile(String fileCode, String name, HttpServletRequest request, HttpServletResponse response) {

        InputStream inputStream = null;
        BufferedInputStream buffInputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(name);
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");

            // 设置强制下载不打开
//            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileCode);
            outputStream = response.getOutputStream();
            buffInputStream = new BufferedInputStream(inputStream);
            byte[] buffer = new byte[4096];
            int num;
            while ((num = buffInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, num);
            }
            outputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (buffInputStream != null) {
                    buffInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
