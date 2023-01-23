package org.example.services;


import java.sql.SQLException;
import java.sql.Statement;

public interface DBService {

    void createTable(Statement statement, String tableName) throws SQLException;

    void deleteTable(Statement statement, String tableName) throws SQLException;

    void showTable(Statement statement, String tableName) throws SQLException;
}
