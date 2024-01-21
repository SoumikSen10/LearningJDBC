package com.jdbc;

import java.sql.*;

public class LearnFetch {

    public static void main(String[] args)
    {
        try {
            String url = "jdbc:mysql://localhost:3306/learnjdbc";
            String uname = "root";
            String pass = "SoumikSen2003.";
            String query = "select * from students";

            Class.forName("com.mysql.cj.jdbc.Driver"); //registering driver
            Connection con = DriverManager.getConnection(url,uname,pass); //established connection
            Statement st = con.createStatement(); //created statement
            ResultSet rs = st.executeQuery(query); //executed the query (here we used DDL)

            String userData = "";
            //processing result
            while(rs.next())
            {
                userData = rs.getInt(1) + ":" + rs.getString(2);
                System.out.println(userData);
            }

            //closing connection
            st.close();
            con.close();


        } catch (Exception e) {}
    }

}
