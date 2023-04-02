package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAODept extends DAO<Dept> {

    public DAODept(Connection connect){
        super(connect);
    }

    @Override
    public Dept find(int id) {
        Dept departement = new Dept();
        try{
            PreparedStatement statement  = connect.prepareStatement("SELECT * FROM DEPT WHERE DEPTNO = ?");
            statement.setLong(1,id);
            ResultSet resultat = statement.executeQuery();
            while(resultat.next()){
                departement.setDeptno((resultat.getLong("DEPTNO")));
                departement.setDname((resultat.getString("DNAME")));
                departement.setLoc((resultat.getString("LOC")));

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return departement;
    }
}
