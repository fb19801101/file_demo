package com.bean;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-03-24 12:50
 */
public class FileInfoBean {
    /**
     * 设置该属性主要是为了在File类实例中访问FileXLoad实例中的filecontent_b属性值
     */
    private FileXLoad parent;
    /**
     * 文件字段名
     */
    private String fieldName;
    /**
     * 文件路径，包括文件名称
     */
    private String filePath;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 文件扩展名，包含“.”字符
     */
    private String fileExt;
    /**
     * 文件类型
     */
    private String fileType;
    /**
     * 文件大小
     */
    private int fileSize;
    /**
     * 文件内容的起始位置
     */
    private int start;
    /**
     * 文件内容的结束位置
     */
    private int end;
    /**
     * 是否为有效文件的标识
     */
    private boolean	available;


    public FileInfoBean() {
        parent = null;
        filePath = "";
        fileName = "";
        fileExt = "";
        fileType = "";
        fileSize = 0;
        start = 0;
        end = 0;
        available = false;
    }

    public FileXLoad getParent() {
        return parent;
    }

    public void setParent(FileXLoad parent) {
        this.parent = parent;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFilePath() {
//        try {
//            //解决下载的文件名是乱码
//            return new String(filePath.getBytes("ISO-8859-1"), "UTF-8");
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }

        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
//        try {
//            //解决下载的文件名是乱码
//            return new String(fileName.getBytes("ISO-8859-1"), "GBK");
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }

        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt=fileExt;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    protected int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    protected int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * 功能：保存文件到磁盘中
     *
     * @param filedir
     * @param savename
     * @return
     */
    public boolean saveFileToDisk(String filedir, String savename) {
        try {
            File upfile = new File(filedir, savename);
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(upfile));
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(parent.filebytes,start,(end-start)+1);
            bw.close();
            osw.close();
            return true;
        } catch (Exception e) {
            System.out.println("保存文件到磁盘中失败！");
            e.printStackTrace();
        }

        return false;
    }
}