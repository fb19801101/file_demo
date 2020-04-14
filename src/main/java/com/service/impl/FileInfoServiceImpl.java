package com.service.impl;

import com.model.FileInfo;
import com.mapper.FileInfoMapper;
import com.service.FileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-02-13 13:11
 */
@Service
public class FileInfoServiceImpl implements FileInfoService {

    @Autowired
    private FileInfoMapper fileInfoMapper;

    @Override
    public List<FileInfo> getAllFileInfo() {
        return fileInfoMapper.selectAllModel();
    }

    @Override
    public FileInfo getFileInfoById(int id) {
        return fileInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public FileInfo getFileInfoByMinId() {
        return fileInfoMapper.selectByMinPrimaryKey();
    }

    @Override
    public FileInfo getFileInfoByMaxId() {
        return fileInfoMapper.selectByMaxPrimaryKey();
    }

    @Override
    public FileInfo getFileInfoByFileName(String name) {
        return fileInfoMapper.selectByFileName(name);
    }

    @Override
    public FileInfo getFileInfoByFileSave(String save) {
        return fileInfoMapper.selectByFileSave(save);
    }

    @Override
    public List<FileInfo> getFileInfoByParam(FileInfo record) {
        return fileInfoMapper.selectByParam(record);
    }

    @Override
    public List<FileInfo> queryFileInfoByParam(FileInfo record) {
        return fileInfoMapper.queryByParam(record);
    }

    @Override
    public List<FileInfo> getFileInfoByCondition(String field, String value) {
        return fileInfoMapper.selectByCondition(field,value);
    }

    @Override
    public List<FileInfo> getFileInfoByCondition(String field, String value1, String value2) {
        return fileInfoMapper.selectByCondition(field,value1,value2);
    }

    @Override
    public List<FileInfo> queryFileInfoByCondition(String field, String value) {
        return fileInfoMapper.queryByCondition(field,value);
    }

    @Override
    public List<FileInfo> getFileInfoFieldsByCondition(String fields, String field, String value) {
        return fileInfoMapper.selectFieldsByCondition(fields,field,value);
    }

    @Override
    public List<FileInfo> getFileInfoFieldsByCondition(String fields, String field, String value1, String value2) {
        return fileInfoMapper.selectFieldsByCondition(fields,field,value1,value2);
    }

    @Override
    public List<FileInfo> queryFileInfoFieldsByCondition(String fields, String field, String value) {
        return fileInfoMapper.queryFieldsByCondition(fields,field,value);
    }

    @Override
    public List<FileInfo> getFileInfoBySql(String sql) {
        return fileInfoMapper.selectBySql(sql);
    }

    @Override
    public List<FileInfo> getFileInfoFieldsBySql(String field, String sql) {
        return fileInfoMapper.selectFieldsBySql(field,sql);
    }

    @Override
    public int insertFileInfo(FileInfo record) {
        return fileInfoMapper.insert(record);
    }

    @Override
    public int setFileInfoById(FileInfo record) {
        return fileInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public void delFileInfoById(int id) {
        fileInfoMapper.deleteByPrimaryKey(id);
    }
}