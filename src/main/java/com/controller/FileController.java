package com.controller;

import com.bean.*;
import com.model.FileInfo;
import com.mapper.FileInfoDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-03-24 13:01
 */
@Controller
@RequestMapping("file")
public class FileController {
    @RequestMapping("toUpload")
    public String toUpload(HttpServletRequest request, HttpServletResponse response) {
        return "upload";
    }

    @RequestMapping("toDownLoad")
    public String toDownLoad(HttpServletRequest request, HttpServletResponse response) {
        FileInfoDao fileDao = new FileInfoDao();
        List filelist = fileDao.getFileInfoList();
        request.setAttribute("filelist",filelist);

        return "download";
    }

    @RequestMapping("upLoad")
    public String upLoad(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        int maxlen = 1024*1024*50;
        String filedir = request.getServletContext().getRealPath("/files");

        FileXLoad fileXLoad = new FileXLoad();
        fileXLoad.init(filedir, request, response);
        fileXLoad.setMaxlen(maxlen);
        boolean start = fileXLoad.upload();

        if(start) {
            List files = fileXLoad.getFiles();
            if(files != null && files.size() != 0) {
                Date date = new Date();
                FileInfoDao fileDao = new FileInfoDao();
                Parameters params = fileXLoad.getParams();
                for(int i=0; i<files.size(); i++) {
                    FileInfoBean fileInfoBean = (FileInfoBean)files.get(i);
                    if(fileInfoBean.getAvailable()) {
                        String filepath = fileInfoBean.getFilePath();
                        String fileDetail = params.getFieldValue("fileDetail"+(i+1));
                        String filesave = StringHandler.getSerial(date,i)+fileInfoBean.getFileExt();
                        String filename = fileInfoBean.getFileName();
                        String filetype = fileInfoBean.getFileType();
                        int filesize = fileInfoBean.getFileSize();

                        FileInfo fileInfo = new FileInfo();
                        fileInfo.setFilePath(filepath);
                        fileInfo.setFileName(filename);
                        fileInfo.setFileSave(filesave);
                        fileInfo.setFileType(filetype);
                        fileInfo.setFileSize(filesize);
                        fileInfo.setFileDetail(fileDetail);
                        fileInfo.setFileUpload(date);
                        fileInfo.setFileDownload(date);

                        int k = fileDao.addFileInfo(fileInfo);          //保存文件信息到数据库中
                        if(k <= 0) {
                            message += "●文件 <b><font color='red'>" + fileInfoBean.getFilePath() + "</font></b> 上传失败！<br>";
                        } else {
                            boolean savetodisk = fileInfoBean.saveFileToDisk(filedir,filesave);    //保存文件到磁盘中
                            if(savetodisk) {
                                message += "√ 文件 <b><font color='red'>" + fileInfoBean.getFilePath() + "</font></b> 上传成功！<br>";
                            } else {
                                message += "× 文件 <b><font color='red'>" + fileInfoBean.getFilePath() + "</font></b> 上传失败！<br>";
                            }
                        }
                    } else if(fileInfoBean.getFilePath().length() > 0) {
                        message += "● 文件 <b><font color='red'>" + fileInfoBean.getFilePath() + "</font></b> 无效或大小为0！<br>";
                    }
                }
                fileDao.close();
            } else {
                message += "●请至少选择一个要上传的文件，或您选择的文件大小为0！<br>";
            }
        } else {
            message = fileXLoad.getMessage();
        }

        message+="<br>>> <a href='toUpload'>返回</a>";
        String path = request.getContextPath();
        message = message + "<br>>> <a href='"+path+"/index.jsp'>主页</a>";

        request.setAttribute("message",message);

        return "message";
    }

    @RequestMapping("downLoad")
    public String downLoad(HttpServletRequest request, HttpServletResponse response) {
        String filedir = request.getServletContext().getRealPath("/files");
        String downfile = request.getParameter("downfile");
        FileInfo fileInfo = null;

        try {
            FileInfoDao fileDao = new FileInfoDao();
            fileInfo = fileDao.getFileInfo(downfile);
            fileDao.close();
            if(fileInfo != null) {
                String filename = fileInfo.getFileName();
                FileXLoad fileXLoad = new FileXLoad();
                fileXLoad.init(filedir, request, response);
                fileXLoad.download(downfile,filename,fileInfo.getFileType());
            }
        } catch (Exception e) {
            e.printStackTrace();
            String message="× 下载失败！文件 <b><font color='red'>" + fileInfo.getFileName()+"</font></b> 不存在或已经被删除！<br>";
            message+="<a href='javascript:window.history.go(-1)'>返回</a>";
            request.setAttribute("message",message);
            return "message";
        }

        return "download";
    }
}