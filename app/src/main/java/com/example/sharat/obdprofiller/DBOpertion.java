package com.example.sharat.obdprofiller;

/**
 * Created by Sharat on 11-10-2018.
 */

import android.util.Log;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.Thread.sleep;

public class DBOpertion {
    public static String type;
    String DBOpertion_getID(final String uid, final String pass)
    {
        Log.w("DBOperation", "Constructing DB Object");
        Thread thread = new Thread()
        {
            @Override
            public void run()
            {
                    Log.w("DBOperation", "in thread");
                    String connectionUrl = "jdbc:jtds:sqlserver://boschsqlserver.database.windows.net:1433/boschsql;"
                                            + "database=boschsql;"
                                            + "user=aniruddha@boschsqlserver;"
                                            + "password=Asd12345****;"
                                            + "encrypt=false;"
                                            + "trustServerCertificate=false;"
                                            + "hostNameInCertificate=*.database.windows.net;"
                                            + "loginTimeout=30;";

                    String fetchsql = "select logintype from OBDusers where userid = '"+uid+"' and pass = '" +pass+"';";
                    ResultSet resultSet = null;

                    try (Connection connection = DriverManager.getConnection(connectionUrl))
                    {
                        java.sql.Statement statement;
                        java.sql.ResultSet res;
                        Log.w("DBOperation", "Trying to execute");
                        statement = connection.createStatement();
                        res = statement.executeQuery(fetchsql);

                        while (res.next())
                        {
                          type = res.getString(1);
                          System.out.println("Generated: " + res.getString(1));
                        }
                    }
                    catch (SQLException e)
                    {
                        e.printStackTrace();
                    }
            }
        };
        thread.start();
        return type;
    }

    public void adddata()
    {

    }
}
