package com.mapper;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * DAO公共基类，由MybatisGenerator自动生成请勿修改
 * @param <Model> The Model Class 这里是泛型不是Model类
 * @param <PK> The Primary Key Class 如果是无主键，则可以用Model来跳过，如果是多主键则是Key类
 * @param <E> The Example Class
 */
public interface MyBatisBaseMapper<Model, PK extends Serializable, E> {
    List<Model> selectByExample(E example);

    Model selectByPrimaryKey(PK id);

    Model selectByMinPrimaryKey();

    Model selectByMaxPrimaryKey();

    int deleteByExample(E example);

    int deleteByPrimaryKey(PK id);

    int insert(Model record);

    int insertSelective(Model record);

    long countByExample(E example);

    int updateByExampleSelective(@Param("record") Model record, @Param("example") E example);

    int updateByExample(@Param("record") Model record, @Param("example") E example);

    int updateByPrimaryKeySelective(Model record);

    int updateByPrimaryKey(Model record);

    List<Model> selectAllModel();

    List<Model> selectByParam(@Param("record") Model record);

    List<Model> queryByParam(@Param("record") Model record);

    List<Model> selectByCondition(@Param("field") String field, @Param("value") String value);

    List<Model> selectByCondition(@Param("field") String field, @Param("value1") String value1, @Param("value2") String value2);

    List<Model> queryByCondition(@Param("field") String field, @Param("value") String value);

    List<Model> selectFieldsByParam(@Param("fields") String fields, @Param("record") Model record);

    List<Model> queryFieldsByParam(@Param("fields") String fields, @Param("record") Model record);

    List<Model> selectFieldsByCondition(@Param("fields") String fields, @Param("field") String field, @Param("value") String value);

    List<Model> selectFieldsByCondition(@Param("fields") String fields, @Param("field") String field, @Param("value1") String value1, @Param("value2") String value2);

    List<Model> queryFieldsByCondition(@Param("fields") String fields, @Param("field") String field, @Param("value") String value);

    List<Model> selectBySql(@Param("sql") String sql);

    List<Model> selectFieldsBySql(@Param("fields") String fields, @Param("sql") String sql);
}