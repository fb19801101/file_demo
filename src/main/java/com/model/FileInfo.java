package com.model;

import com.bean.StringHandler;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author
 * 文件信息
 */
public class FileInfo implements Serializable {
    /**
     * 文件ID
     */
    private Integer id;
    /**
     * 文件路径
     */
    private String filePath;
    /**
     * 文件保存到磁盘中用到的名称
     */
    private String fileSave;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 文件类型
     */
    private String fileType;
    /**
     * 文件大小
     */
    private Integer fileSize;
    /**
     * 文件描述
     */
    private String fileDetail;
    /**
     * 上传时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date fileUpload;
    /**
     * 下载时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date fileDownload;

    private static final long serialVersionUID = 1L;

    // Constructors

    /** default constructor */
    public FileInfo() {
    }

    /** full constructor */
    @JsonCreator
    public FileInfo(@JsonProperty("id") int id, @JsonProperty("filePath") String filePath, @JsonProperty("fileSave") String fileSave,
                       @JsonProperty("fileName") String fileName, @JsonProperty("fileType") String fileType, @JsonProperty("fileSize") int fileSize,
                       @JsonProperty("fileDetail") String fileDetail, @JsonProperty("fileUpload") Date fileUpload, @JsonProperty("fileDownload") Date fileDownload) {
        this.id = id;
        this.filePath = filePath;
        this.fileSave = fileSave;
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.fileDetail = fileDetail;
        this.fileUpload = fileUpload;
        this.fileDownload = fileDownload;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilePath() {
//        try {
//            //解决下载的文件名是乱码
//            return new String(filePath.getBytes("ISO-8859-1"), "GBK");
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileSave() {
        return fileSave;
    }

    public void setFileSave(String fileSave) {
        this.fileSave = fileSave;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileDetail() {
        return fileDetail;
    }

    public void setFileDetail(String fileDetail) {
        this.fileDetail = fileDetail;
    }

    public Date getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(Date fileUpload) {
        this.fileUpload = fileUpload;
    }

    public Date getFileDownload() {
        return fileDownload;
    }

    public void setFileDownload(Date fileDownload) {
        this.fileDownload = fileDownload;
    }

    public String getFileDetailForHtml() {
        return StringHandler.changehtml(fileDetail);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        FileInfo other = (FileInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFilePath() == null ? other.getFilePath() == null : this.getFilePath().equals(other.getFilePath()))
            && (this.getFileSave() == null ? other.getFileSave() == null : this.getFileSave().equals(other.getFileSave()))
            && (this.getFileName() == null ? other.getFileName() == null : this.getFileName().equals(other.getFileName()))
            && (this.getFileType() == null ? other.getFileType() == null : this.getFileType().equals(other.getFileType()))
            && (this.getFileSize() == null ? other.getFileSize() == null : this.getFileSize().equals(other.getFileSize()))
            && (this.getFileDetail() == null ? other.getFileDetail() == null : this.getFileDetail().equals(other.getFileDetail()))
            && (this.getFileUpload() == null ? other.getFileUpload() == null : this.getFileUpload().equals(other.getFileUpload()))
            && (this.getFileDownload() == null ? other.getFileDownload() == null : this.getFileDownload().equals(other.getFileDownload()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFilePath() == null) ? 0 : getFilePath().hashCode());
        result = prime * result + ((getFileSave() == null) ? 0 : getFileSave().hashCode());
        result = prime * result + ((getFileName() == null) ? 0 : getFileName().hashCode());
        result = prime * result + ((getFileType() == null) ? 0 : getFileType().hashCode());
        result = prime * result + ((getFileSize() == null) ? 0 : getFileSize().hashCode());
        result = prime * result + ((getFileDetail() == null) ? 0 : getFileDetail().hashCode());
        result = prime * result + ((getFileUpload() == null) ? 0 : getFileUpload().hashCode());
        result = prime * result + ((getFileDownload() == null) ? 0 : getFileDownload().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", filePath=").append(filePath);
        sb.append(", fileSave=").append(fileSave);
        sb.append(", fileName=").append(fileName);
        sb.append(", fileType=").append(fileType);
        sb.append(", fileSize=").append(fileSize);
        sb.append(", fileDetail=").append(fileDetail);
        sb.append(", fileUpload=").append(fileUpload);
        sb.append(", fileDownload=").append(fileDownload);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}