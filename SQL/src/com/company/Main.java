package com.company;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /* Load JDBC Driver. */
        try {
            Class.forName( "oracle.jdbc.OracleDriver" );
            // Class.forName("oracle.jdbc.OracleDriver") ;
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }
        String url = "jdbc:oracle:thin:system/oracle@localhost:49161:xe";
        String user = "system";
        String pass = "oracle";

        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection( url, user, pass );

            /* Requests to bdd will be here */
            System.out.println("Bdd Connected");
            //displayDepartment(connexion);
            //displaytable(connexion,"EMP");
            //display7369(connexion);
            //moveDepartement(7369,20,connexion);
            //display7369(connexion);

            //DAODept dao = new DAODept(connexion);
            //Dept dept20 = dao.find(20);
            //System.out.println(dept20);

            DAOemp dao = new DAOemp(connexion);
            Dept dept20 = dao.find(7902);
            System.out.println(dept20);

        } catch ( SQLException e ) {
            e.printStackTrace();
        } finally {
            if ( connexion != null )
                try {
                    connexion.close();
                } catch ( SQLException ignore ) {
                    ignore.printStackTrace();
                }
        }

        System.out.println("Hello World!");
    }
    public static void displayDepartment(Connection connexion) throws SQLException {
        Statement statement = connexion.createStatement();
        ResultSet resultat = statement.
                executeQuery( "SELECT deptno, dname, loc FROM dept" );

        while ( resultat.next() ) {
            int deptno = resultat.getInt( "deptno");
            String dname = resultat.getString( "dname" );
            String location = resultat.getString("loc");

            System.out.println("Department " + deptno + " is for "
                    + dname + " and located in "+ location);
        }
        resultat.close();
}

    public static void displaytable(Connection connexion, String TableName) throws SQLException
    {
        //final String query = String.format("Select * FROM %s", TableName);
        //PreparedStatement statement = connexion.prepareStatement(query);
        //ResultSet resultat = statement.executeQuery();
        Statement statement = connexion.createStatement();
        ResultSet resultat = statement.executeQuery("Select * FROM "+ TableName);

        ResultSetMetaData meta = resultat.getMetaData();
        int columnCount = meta.getColumnCount();
        String colsnames = "";
        for(int i = 1; i <=columnCount; i++){
            colsnames += meta.getColumnName(i)+" | ";

        }
        System.out.println(colsnames);
        while(resultat.next()){
            String CurrentEmp="";
            for(int i=1;i<=columnCount;i++){
                CurrentEmp += resultat.getString(i)+" | ";
            }
            System.out.println(CurrentEmp);
        }
        resultat.close();
    }
    public static void moveDepartement(int empno,int newDeptno,Connection connexion )throws SQLException{
        final String query = String.format("UPDATE EMP SET DEPTNO="+newDeptno +"WHERE EMPNO="+ empno );
        PreparedStatement statement = connexion.prepareStatement(query);
        ResultSet resultat = statement.executeQuery();
    }
    public static void display7369(Connection connexion )throws SQLException{

        Statement statement = connexion.createStatement();
        ResultSet resultat = statement.executeQuery("SELECT * FROM EMP WHERE EMPNO=7369" );
        ResultSetMetaData meta = resultat.getMetaData();
        int columnCount = meta.getColumnCount();
        String colsnames = "";
        for(int i = 1; i <=columnCount; i++){
            colsnames += meta.getColumnName(i)+" | ";

        }
        System.out.println(colsnames);
        while(resultat.next()){
            String CurrentEmp="";
            for(int i=1;i<=columnCount;i++){
                CurrentEmp += resultat.getString(i)+" | ";
            }
            System.out.println(CurrentEmp);
        }
        resultat.close();
    }
}


