package com.service;

import com.model.FileInfo;

import java.util.List;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-02-13 13:09
 */
public interface FileInfoService {
    List<FileInfo> getAllFileInfo();

    FileInfo getFileInfoById(int id);

    FileInfo getFileInfoByMinId();

    FileInfo getFileInfoByMaxId();

    FileInfo getFileInfoByFileName(String name);

    FileInfo getFileInfoByFileSave(String save);

    List<FileInfo> getFileInfoByParam(FileInfo record);

    List<FileInfo> queryFileInfoByParam(FileInfo record);

    List<FileInfo> getFileInfoByCondition(String field, String value);

    List<FileInfo> getFileInfoByCondition(String field, String value1, String value2);

    List<FileInfo> queryFileInfoByCondition(String field, String value);

    List<FileInfo> getFileInfoFieldsByCondition(String fields, String field, String value);

    List<FileInfo> getFileInfoFieldsByCondition(String fields, String field, String value1, String value2);

    List<FileInfo> queryFileInfoFieldsByCondition(String fields, String field, String value);

    List<FileInfo> getFileInfoBySql(String sql);

    List<FileInfo> getFileInfoFieldsBySql(String fields, String sql);

    int insertFileInfo(FileInfo record);

    int setFileInfoById(FileInfo record);

    void delFileInfoById(int id);
}