package com.mapper;

import com.model.FileInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-03-24 12:59
 */
public class FileInfoDao {
    private Connection connection;
    private PreparedStatement preparedStatement;

    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/db_file?characterEncoding=utf-8";
    private String user = "root";
    private String password = "Dx19800602Fb";

    /**
     * 构造方法，在该方法中加载数据库驱动
     */
    public FileInfoDao() {
        try {
            Class.forName(driver);
        } catch(ClassNotFoundException e) {
            System.out.println("加载数据库 jdbc.Driver 驱动失败！");
            e.printStackTrace();
        }
    }

    /**
     * 功能：创建数据库连接
     *
     * @return
     */
    public Connection open() {
        if(connection == null){
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println("创建数据库 jdbc.Connection 对象失败！");
                connection=null;
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * 功能：对数据库进行增、删、改、查操作
     * 参数：sql为SQL语句；params为Object数组，里面存储的是为sql表示的SQL语句中"?"占位符赋值的数据
     *
     * @param sql
     * @param params
     */
    public boolean execute(String sql, Object[] params) {
        if(sql != null && !sql.equals("")) {
            if(params == null) {
                params = new Object[0];
            }
            open();
            if(connection != null) {
                try {
                    System.out.println(sql);
                    preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    for(int i=0; i<params.length; i++) {
                        preparedStatement.setObject(i+1, params[i]);
                    }
                    return preparedStatement.execute();
                } catch(SQLException e) {
                    System.out.println("执行 doPreparedStatement() 方法出错！");
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

    /**
     * 功能：获取调用dopreparedStatement()方法执行查询操作后返回的ResultSet结果集
     *
     * @param sql
     * @param params
     * @return
     */
    public ResultSet getResultSet(String sql, Object[] params) {
        if(sql != null && !sql.equals("")) {
            if(params == null) {
                params = new Object[0];
            }
            open();
            if(connection != null) {
                try {
                    System.out.println(sql);
                    preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    for(int i=0; i<params.length; i++) {
                        preparedStatement.setObject(i+1, params[i]);
                    }
                    return preparedStatement.executeQuery();
                } catch(SQLException e) {
                    System.out.println("获取数据库 ResultSet 对象失败！");
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    /**
     * 功能：获取调用dopreparedStatement()方法执行查询操作后返回的ResultSet结果集
     *
     * @return
     */
    public ResultSet getResultSet() {
        try {
            return preparedStatement.getResultSet();
        } catch (SQLException e) {
            System.out.println("获取数据库 ResultSet 对象失败！");
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 功能：获取调用dopreparedStatement()方法执行更新操作后返回影响的记录数
     *
     * @return
     */
    public int getUpdateCount() {
        try {
            return preparedStatement.getUpdateCount();
        } catch (SQLException e) {
            System.out.println("获取数据库 UpdateCount 更新行数失败！");
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 功能：释放PrepareStatement对象与Connection对象
     */
    public void close() {
        try {
            if(preparedStatement != null) {
                preparedStatement.close();
            }
        } catch(SQLException e) {
            System.out.println("关闭数据库 jdbc.PreparedStatement 对象失败！");
            e.printStackTrace();
        }

        try {
            if(connection != null) {
                connection.close();
            }
        } catch(SQLException e) {
            System.out.println("关闭数据库 jdbc.Connection 对象失败！");
            e.printStackTrace();
        }
    }

    /**
     * 功能：获取数据库文件列表
     *
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    private List getFileInfoList(String sql, Object[] params) {
        List list=null;

        try {
            ResultSet rs = getResultSet(sql, params);
            if(rs != null){
                list = new ArrayList();
                while(rs.next()) {
                    FileInfo fileInfo = new FileInfo();
                    fileInfo.setId(rs.getInt(1));
                    fileInfo.setFilePath(rs.getString(2));
                    fileInfo.setFileSave(rs.getString(3));
                    fileInfo.setFileName(rs.getString(4));
                    fileInfo.setFileType(rs.getString(5));
                    fileInfo.setFileSize(rs.getInt(6));
                    fileInfo.setFileDetail(rs.getString(7));
                    fileInfo.setFileUpload(rs.getTimestamp(8));
                    fileInfo.setFileUpload(rs.getTimestamp(9));
                    list.add(fileInfo);
                }
                rs.close();
            }

        } catch (SQLException e) {
            System.out.println("获取数据库 ResultSet 对象失败！");
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 功能：获取数据库文件列表
     *
     * @return
     * @throws SQLException
     */
    public List getFileInfoList() {
        String sql="select * from tb_file_info order by file_save desc";
        List list = getFileInfoList(sql,null);
        return list;
    }

    /**
     * 功能：添加数据库文件
     *
     * @param fileInfo
     * @return
     */
    public int addFileInfo(FileInfo fileInfo) {
        int id = -1;

        id = getFileMaxId();
        if(id == -1) {
            return id;
        }

        String sql = "insert into tb_file_info values(?,?,?,?,?,?,?,?,?)";
        Object[] params={id+1, fileInfo.getFilePath(), fileInfo.getFileSave(), fileInfo.getFileName(), fileInfo.getFileType(),
                fileInfo.getFileSize(), fileInfo.getFileDetail(), fileInfo.getFileUpload(), fileInfo.getFileDownload()};
        execute(sql, params);
        return getUpdateCount();
    }

    /**
     * 功能：通过文件名称获取数据库文件信息
     *
     * @param saveFile
     * @return
     * @throws SQLException
     */
    public FileInfo getFileInfo(String saveFile) {
        FileInfo fileInfo = null;
        String sql = "select * from tb_file_info where file_save=?";
        Object[] params={saveFile};
        List list = getFileInfoList(sql, params);
        if(list !=null && list.size()!=0) {
            fileInfo = (FileInfo) list.get(0);
        }
        return fileInfo;
    }

    /**
     * 功能：获取最大文件Id
     *
     * @return
     */
    public int getFileMaxId() {
        int id = -1;
        String sql = "select max(id) from tb_file_info";
        ResultSet rs = getResultSet(sql, null);

        try {
            if(rs != null){
                rs.next();
                id = rs.getInt(1);
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println("获取数据库 ResultSet 对象失败！");
            e.printStackTrace();
        }

        return id;
    }
}