package com.example.personwork.utils;

import android.util.Log;

import com.example.personwork.pojo.Info;
import com.example.personwork.pojo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InfoDB {

    private static Connection getConn() {
        Connection connection = null;
        try {
            // MySql驱动
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver).newInstance();// 动态加载类
            String url = "";
            // 用户名
            String LogBean = "test";
            // 密码
            String password = "123456";
            connection = DriverManager.getConnection(url,
                    LogBean, password);
            Log.v("dzh", "加载JDBC成功");
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("dzh", "加载JDBC驱动失败");

        }

        return connection;
    }

    public static int insertData(Info info) throws SQLException {
        // 根据数据库名称，建立连接
        Connection connection = getConn();
        // 向course表插入数据，其中id字段插入的值对应第一个问号，type字段插入的值对应第二个问号
        /*
         * xuehao;
         * name;
         * phone;
         * a_class
         */
        String sql = "insert into info(xuehao,name,phone,a_class) values (?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        // 通过setString赋值
        ps.setString(1, info.getXuehao());
        ps.setString(2, info.getName());
        ps.setString(3, info.getPhone());
        ps.setString(4, info.getA_class());
        int insertCode = ps.executeUpdate();
        Log.v("dzh", "插入成功");
        closeAll(connection, ps);// 关闭相关操作
        return insertCode;
    }

    // public static List<String> queryAll() throws SQLException{
    // Connection connection = getConn();
    // String sql="select username,password from user";
    // PreparedStatement ps = connection.prepareStatement(sql);
    // ResultSet resultSet=ps.executeQuery();
    // ResultSetMetaData metaData=ps.getMetaData();
    // int columnCount = metaData.getColumnCount();
    // List<String> listPwd=new ArrayList<>();
    // while (resultSet.next()){
    // for (int i = 1; i <= columnCount; i++) {
    // String value=(String) resultSet.getObject(i);
    // listPwd.add(value);
    // }
    // }
    // return listPwd;
    // }
    public static void closeAll(Connection conn, PreparedStatement ps) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
