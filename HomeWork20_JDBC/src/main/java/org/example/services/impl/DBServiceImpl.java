package org.example.services.impl;

import org.example.services.DBService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBServiceImpl implements DBService {
    @Override
    public void createTable(Statement statement, String sqlQuery) throws SQLException {
        statement.execute(sqlQuery);
    }

    @Override
    public void deleteTable(Statement statement, String tableName) throws SQLException {
        statement.execute("drop table " + tableName);
    }

    @Override
    public void showTable(Statement statement, String tableName) throws SQLException {
        ResultSet rs = statement.executeQuery("select * from " + tableName);

        System.out.println("Table name : " + rs.getMetaData().getTableName(1));
        System.out.println("------------");
        int columnCount = rs.getMetaData().getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            System.out.print("column name : " + rs.getMetaData().getColumnName(i) + ", ");
            System.out.print("column size : " + rs.getMetaData().getColumnDisplaySize(i) + ", ");
            System.out.println("column type : " + rs.getMetaData().getColumnTypeName(i));
        }
    }
}
