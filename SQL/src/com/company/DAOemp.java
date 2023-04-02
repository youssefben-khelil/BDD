package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOemp extends DAO<Dept> {

    public DAOemp(Connection connect){
        super(connect);
    }

    @Override
    public Dept find(int id) {
        Dept departement = new Dept();
        try{
            PreparedStatement statement  = connect.prepareStatement("SELECT * FROM EMP WHERE MGR = ?");
            statement.setLong(1,id);
            ResultSet resultat = statement.executeQuery();
            while(resultat.next()){
                departement.setDeptno((resultat.getLong("DEPTNO")));
                departement.setDname((resultat.getString("ENAME")));
                departement.setLoc((resultat.getString("JOB")));

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return departement;
    }
}
