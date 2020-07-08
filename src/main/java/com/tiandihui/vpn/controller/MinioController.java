package com.tiandihui.vpn.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import com.tiandihui.vpn.common.api.CommonResult;
import com.tiandihui.vpn.domain.MinioUploadDto;
import io.minio.MinioClient;
import io.minio.errors.MinioException;
import io.minio.policy.PolicyType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Api(tags = "MinioController", description = "MinIO对象存储管理")
@Controller
@RequestMapping("/minio")
public class MinioController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MinioController.class);

    @Value("${minio.endpoint}")
    private String ENDPOINT;
    @Value("${minio.bucketName}")
    private String BUCKET_NAME;
    @Value("${minio.accessKey}")
    private String ACCESS_KEY;
    @Value("${minio.secretKey}")
    private String SECRET_KEY;


    @ApiOperation("文件上传")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult upload(@RequestParam("file") MultipartFile file) {
        try {
            //创建一个MinIO的Java客户端
            MinioClient minioClient = new MinioClient(ENDPOINT, ACCESS_KEY, SECRET_KEY);
            boolean isExist = minioClient.bucketExists(BUCKET_NAME);
            if (isExist) {
                LOGGER.info("存储桶已经存在！");
            } else {
                //创建存储桶并设置只读权限
                minioClient.makeBucket(BUCKET_NAME);
                minioClient.setBucketPolicy(BUCKET_NAME, "*.*", PolicyType.READ_WRITE);
            }
            String filename = file.getOriginalFilename();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            // 设置存储对象名称
            String objectName = sdf.format(new Date()) + "/" + filename;
            // 使用putObject上传一个文件到存储桶中
            minioClient.putObject(BUCKET_NAME, objectName, file.getInputStream(), file.getContentType());
            MinioUploadDto minioUploadDto = new MinioUploadDto();
            minioUploadDto.setName(filename);
            minioUploadDto.setUrl(ENDPOINT + "/" + BUCKET_NAME + "/" + objectName);
            LOGGER.info("文件上传成功!" + filename +"---url-->"+minioUploadDto.getUrl());

            return CommonResult.success(minioUploadDto);
        } catch (Exception e) {
            LOGGER.info("上传发生错误: {}！", e.getMessage());
        }
        return CommonResult.failed();
    }

    @ApiOperation("文件删除")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("objectName") String objectName) {
        try {
            MinioClient minioClient = new MinioClient(ENDPOINT, ACCESS_KEY, SECRET_KEY);
            minioClient.removeObject(BUCKET_NAME, objectName);
            return CommonResult.success(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CommonResult.failed();
    }

    /**
     * 下载文件
     *
     * @param
     * @param bucketName 上传的bucket名称
     * @param objectName 上传后存储在bucket中的文件名
     * @param downloadPath 下载文件保存路径
     */
    public void downloadFile( String bucketName, String objectName, String downloadPath) {

        try {
            MinioClient minioClient = new MinioClient(ENDPOINT, ACCESS_KEY, SECRET_KEY);

            File file = new File(downloadPath);
            try (OutputStream out = new FileOutputStream(file)) {
                InputStream inputStream = minioClient.getObject(bucketName, objectName);
                byte[] tempbytes = new byte[1024];
                int byteread = 0;
                while ((byteread = inputStream.read(tempbytes)) != -1) {
                    out.write(tempbytes, 0, byteread);
                }
            } catch (MinioException e) {
                System.out.println("Error occurred: " + e);
            }
        } catch (Exception e) {

        }

    }



   /* public void download(String fileName, HttpServletResponse response, HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        String[] nameArray = StrUtil.split(fileName, "-");
        minioClient.putObject(BUCKET_NAME, objectName, file.getInputStream(), file.getContentType());

        try (InputStream inputStream = minioTemplate.getObject(nameArray[0], nameArray[1])) {
            //解决乱码
            if ( //IE 8 至 IE 10
                    userAgent.toUpperCase().contains("MSIE") ||
                            //IE 11
                            userAgent.contains("Trident/7.0")) {
                fileName = java.net.URLEncoder.encode(nameArray[1], "UTF-8");
            } else{
                fileName = new String(nameArray[1].getBytes("UTF-8"),"iso-8859-1");
            }
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.setContentType("application/force-download");
            response.setCharacterEncoding("UTF-8");
            IoUtil.copy(inputStream, response.getOutputStream());
        } catch (Exception e) {
           // log.error("文件读取异常", e);
        }
    } */



}
