package com.mapper;

import com.model.FileInfo;
import com.model.FileInfoExample;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * FileInfoMapper继承基类
 */
@Repository
public interface FileInfoMapper extends MyBatisBaseMapper<FileInfo, Integer, FileInfoExample> {
    @Select("select * from tb_file_info where file_name = #{name}")
    FileInfo selectByFileName(String name);

    @Select("select * from tb_file_info where file_save = #{save}")
    FileInfo selectByFileSave(String save);
}