package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class typeWeakenessDAO {

    private Connection cn = null;

    public typeWeakenessDAO() {
        cn = ConnectionFactory.getConnection();
    }

    public double findPower(int typeAtk, int typeDef) {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        double power = 0;

        String sql = "SELECT POWER FROM typeWeakeness WHERE typeAtk = ? and typeDef = ?";

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, typeAtk);
            stmt.setInt(2, typeDef);
            rs = stmt.executeQuery();

            power = rs.getDouble("power");

        } catch (SQLException e) {
            Logger.getLogger(typeWeakenessDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
              ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return power;
    }
}
