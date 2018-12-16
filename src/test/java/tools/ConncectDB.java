package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConncectDB {

    public ConncectDB(){

    }

    private static Connection con = null;
    private static String username = "u349814629_set";
    private static String password = "Petro529440";
    private static String URL = "jdbc:mysql://sql189.main-hosting.eu:3306/u349814629_prest";

    public void onlySelectDataQuery(String selectQuery) throws SQLException{

        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        con = DriverManager.getConnection(URL, username, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(selectQuery);
        int columnCount = rs.getMetaData().getColumnCount();

        // output file
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
        System.out.println();
        if (rs != null) {
            rs.close();
        }
        if (st != null) {
            st.close();
        }
        if (con != null) {
            con.close();
        }
        System.out.println("DONE");
    }

    public ResultSet DMLDataSelect(String selectQuery) throws SQLException{

        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        con = DriverManager.getConnection(URL, username, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(selectQuery);
        //String result = rs;
        if (rs != null) {
            rs.close();
        }
        if (st != null) {
            st.close();
        }
        if (con != null) {
            con.close();
        }
        return rs;
    }

    public void DMLDataQuery(String dml) throws SQLException{

        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        con = DriverManager.getConnection(URL, username, password);
        Statement st = con.createStatement();
        st.executeUpdate(dml);

        if (st != null) {
            st.close();
        }
        if (con != null) {
            con.close();
        }
    }
}