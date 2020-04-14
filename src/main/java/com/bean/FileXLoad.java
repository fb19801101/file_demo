package com.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-03-24 12:51
 */
public class FileXLoad {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private Parameters params;

    private String message;
    protected char[] filebytes;
    private int maxlen;
    private int current_pos;
    private String filedir;

    public FileXLoad() {
        message = "";
        maxlen = 0;
        current_pos = 0;
        filedir = "";
        params = new Parameters();
    }

    public void setMaxlen(int maxlen) {
        this.maxlen = maxlen;
    }

    public void init(String filedir, HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.filedir = filedir;
    }

    /**
     * 功能：上传文件
     * @return
     */
    public boolean upload() {
        /** 定义用来保存上传文件的目录 */
        File dir = new File(filedir);
        if(!dir.exists()) {
            dir.mkdir();
        }

        boolean mark = false;
        String contentType = request.getContentType();
        if(contentType.indexOf("multipart/form-data",0) != -1) {
            int len = request.getContentLength();
            if(len > maxlen) {
                message = "● 上传的文件总长度最大极限为50兆!";
            } else {
                /** 将文件表单内容读到字节数组filebytes中 */
                try {
//                    DataInputStream in = new DataInputStream(request.getInputStream());
                    BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(),"UTF-8"));
                    filebytes = new char[len];
                    int readbyte = 0;
                    int totalreadbyte = 0;
                    while(readbyte != -1) {
//                        readbyte = in.read(filebytes,totalreadbyte,len);
                        readbyte = br.read(filebytes,totalreadbyte,len-totalreadbyte);
                        totalreadbyte += readbyte;
                    }
                    br.close();
                    mark = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }

                /** 将文件表单内容写到临时文件temp.txt中。在实际开发中不需要生成该文件，本段代码是为了方便读者查看通过文件表单提交的数据的格式 */
                try {
                    File tempfile = new File(filedir,"temp.txt");
//                    FileOutputStream tempfile_stream = new FileOutputStream(tempfile);
//                    tempfile_stream.write(filebytes);
                    OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(tempfile));
                    BufferedWriter bw = new BufferedWriter(osw);
                    bw.write(filebytes);
                    bw.close();
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            message = "● 上传的文件类型不是 multipart/form-data 格式！<br>";
        }

        return mark;
    }

    public List getFiles() {
        List files = new ArrayList();
        int index = 0;
        while(current_pos < filebytes.length) {
            FileInfoBean fileinfoext = getFile(index);
            if(fileinfoext != null) {
                files.add(fileinfoext);
            }
            index++;
        }
        return files;
    }

    private FileInfoBean getFile(int index) {
        FileInfoBean fileinfoext = null;

        //获取分界字符串
        String bound = getBound();

        if(!bound.substring(bound.length()-2).equals("--")) {
            //获取内容描述段
            String dataheader = getDateHeader();

            //计算要获取内容的开始位置和结束位置:pos[0]为开始位置，pos[1]为结束位置
            int[] pos = getDataContentSegment(bound);

            //获取字段名称
            String fieldname = getFieldNameValue(dataheader,"name=");

            if(dataheader.indexOf("filename=")>0) {
                //获取上传的文件全名
                String filepath = getFieldNameValue(dataheader,"filename=");

                //获取上传的文件实际名称
                String filename = getFileName(filepath);

                //获取文件后缀名
                String fileext = getFileExt(filename);

                //获取文件类型
                String filetype = getFileType(dataheader);

                fileinfoext = new FileInfoBean();
                //获取文件大小
                int fileSize = (pos[1]-pos[0])+1;
                if(fileSize <= 0) {
                    fileinfoext.setAvailable(false);
                    fileinfoext.setFilePath(filepath);
                } else {
                    fileinfoext.setAvailable(true);
                    fileinfoext.setParent(this);
                    fileinfoext.setFieldName(fieldname);
                    fileinfoext.setFilePath(filepath);
                    fileinfoext.setFileName(filename);
                    fileinfoext.setFileExt(fileext);
                    fileinfoext.setFileType(filetype);
                    fileinfoext.setFileSize(fileSize);
                    fileinfoext.setStart(pos[0]);
                    fileinfoext.setEnd(pos[1]);
                }
            } else {			//获取其他字段内容
                String fieldnamecontent = new String(filebytes,pos[0],(pos[1]-pos[0])+1);
                params.setFields(fieldname,fieldnamecontent);
            }
        } else {
            current_pos = filebytes.length + 1;
        }

        return fileinfoext;
    }

    /**
     * 功能：获取分界字符串
     *
     * @return
     */
    private String getBound() {
        String bound = "";
        for(;filebytes[current_pos] != 13; current_pos++) {
            bound += (char) filebytes[current_pos];
        }
        current_pos += 2;
        return bound;
    }

    /**
     * 功能：获取内容描述段
     *
     * @return
     */
    private String getDateHeader() {
        String dateheader = "";

        int start = current_pos;
        int end = 0;
        for(; !(filebytes[current_pos] == 13 && filebytes[current_pos+2] == 13); current_pos++);
        end = current_pos-1;
        current_pos += 4;

        dateheader = new String(filebytes,start,(end-start)+1);

        return dateheader;
    }

    /**
     * 功能：获取字段名称
     *
     * @param dataHeader
     * @param fieldName
     * @return
     */
    private String getFieldNameValue(String dataHeader,String fieldName) {
        int start = dataHeader.indexOf(fieldName)+fieldName.length()+1;
        int end = dataHeader.indexOf("\"",start);
        String value = dataHeader.substring(start,end);
        return value;
    }

    /**
     * 功能：获取文件名
     *
     * @param filePath
     * @return
     */
    private String getFileName(String filePath) {
        String filename = "";
        int start = filePath.lastIndexOf("\\");
        if(start == -1) {
            start = filePath.lastIndexOf("/");
        }
        if(start > 0) {
            filename = filePath.substring(start + 1);
        } else {
            filename = filePath;
        }
        return filename;
    }

    /**
     * 功能：获取文件后缀名
     *
     * @param fileName
     * @return
     */
    private String getFileExt(String fileName) {
        String fileext = "";
        if(fileName != null && !fileName.equals("")) {
            int start = fileName.lastIndexOf(".");
            if(start > 0) {
                fileext = fileName.substring(start);
            }
        }
        return fileext;
    }

    /**
     * 功能：获取文件类型
     *
     * @param dataHeader
     * @return
     */
    private String getFileType(String dataHeader) {
        int start = dataHeader.indexOf("Content-Type: ")+14;
        String filetype = dataHeader.substring(start);
        return filetype;
    }

    /**
     * 功能：计算要获取内容(字节数组形式)的起始位置和结束位置
     *
     * @param bound
     * @return
     */
    private int[] getDataContentSegment(String bound) {
        int[] pos = new int[2];
        pos[0] = current_pos; //要获取内容的起始位置
        pos[1] = getDataContentEnd(bound); //要获取内容的结束位置
        return pos;
    }

    /**
     * 功能：获取文件内容的结束位置
     *
     * @param bound
     * @return
     */
    private int getDataContentEnd(String bound) {
        int end = -1;
        boolean found = false;
        int key = 0;
        byte[] bound_byte = bound.getBytes();
        while(!found && current_pos < filebytes.length) {
            if(filebytes[current_pos] == bound_byte[key]) {
                if(key == bound_byte.length-1) {
                    found = true;
                } else {
                    key++;
                    current_pos++;
                }
            }
            else{
                key = 0;
                current_pos++;
            }
        }
        if(found) {
            current_pos = current_pos-(bound_byte.length-1);
            end = current_pos-3;
        }
        return end;
    }

    public String getMessage() {
        return this.message;
    }

    public Parameters getParams() {
        return this.params;
    }

    /**
     * 功能：下载文件
     *
     * @param downfilename
     * @param filename
     * @param filetype
     * @throws IOException
     */
    public void download(String downfilename, String filename, String filetype) throws IOException {
        File file = new File(filedir,downfilename);
        long len = file.length();
        char fbytes[] = new char[600];

        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "No-cache");
        response.setDateHeader("Expires", 0);

        //将中文转ASCI编码
        new String(filename.getBytes("UTF-8"), "ISO-8859-1");
        response.setHeader("Content-Disposition","attachment; filename="+URLEncoder.encode(filename,"UTF-8"));
        response.setContentType(filetype);
        response.setHeader("Content_Length",String.valueOf(len));

        InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
        BufferedReader br = new BufferedReader(isr);

        OutputStreamWriter osw = new OutputStreamWriter(response.getOutputStream());
        BufferedWriter bw = new BufferedWriter(osw);

        int read = 0;
        while((read = br.read(fbytes)) != -1) {
            bw.write(fbytes,0, read);
        }

        bw.close();
        osw.close();
        br.close();
        isr.close();
    }
}