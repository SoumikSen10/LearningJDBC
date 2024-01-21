package com.jdbc;

import java.sql.*;
import java.util.Scanner;

public class LearnAdd {

    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter name: ");
        String name=in.nextLine();
        System.out.print("Enter roll no: ");
        int roll=in.nextInt();

        try {
            String url = "jdbc:mysql://localhost:3306/learnjdbc";
            String uname = "root";
            String pass = "SoumikSen2003.";

            String query = "insert into students values (?,?)";

            Class.forName("com.mysql.cj.jdbc.Driver"); //registering driver
            Connection con = DriverManager.getConnection(url,uname,pass); //established connection
            PreparedStatement st = con.prepareStatement(query); //created PreparedStatement
            st.setInt(1,roll);
            st.setString(2,name);
            int count = st.executeUpdate();

            System.out.println("No of rows affected is : "+count);

            //closing connection
            st.close();
            con.close();


        } catch (Exception e) {}
    }

}
