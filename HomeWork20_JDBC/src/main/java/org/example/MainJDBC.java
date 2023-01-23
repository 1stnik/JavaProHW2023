package org.example;

/**
 * @author Serhii Nikonenko
 * @version 2.0.2
 */

import com.mysql.cj.jdbc.MysqlDataSource;
import org.example.services.DBService;
import org.example.services.StudentService;
import org.example.services.impl.DBServiceImpl;
import org.example.services.impl.StudentServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MainJDBC {

    public static final String serverTimeZone = "UTC";
    public static final String serverName = "localhost"; // ip address db
    public static final String databaseName = "Student"; // bd name
    public static final int portNumber = 3306; // db port
    public static final String user = "root"; // login
    public static final String password = "08080808"; // password

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setUseSSL(false);
        dataSource.setServerTimezone(serverTimeZone);
        dataSource.setServerName(serverName);
        dataSource.setDatabaseName(databaseName);
        dataSource.setPortNumber(portNumber);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        Connection connection = dataSource.getConnection();

        Statement statement = connection.createStatement();

        DBService dbService = new DBServiceImpl();

        //------------------------------------------------------------------

/**
        uncomment to create a table
 */
//        String sqlQuery = "create table University (Id int(10) not null auto_increment, primary key (Id))";
//        dbService.createTable(statement, sqlQuery);
//        dbService.showTable(statement, "University");

/**
        uncomment to delete the table
 */
//        dbService.deleteTable(statement, "University");

        //-------------------------------------------------------------------

        StudentService studentService = new StudentServiceImpl();
        studentService.addStudent(statement, "Vasil Vaselenko");

        studentService.deleteStudent(statement, 2);

        studentService.getAll(statement);
        studentService.getByName(statement, "'Petr Petrov'");


        studentService.getById(statement, 12);

        connection.close();
    }
}
