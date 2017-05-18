package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.habilidade;

public class habilidadeDAO {
    private Connection cn = null;
    
    public habilidadeDAO(){
        cn = ConnectionFactory.getConnection();
    }
    
    public List<habilidade> findMovesPokemon(int pokemonId){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM pokemonMoves INNER JOIN moveList ON pokemonMoves.moveId = moveList.id WHERE pokemonID = ?";
        
        List<habilidade> listMove = new ArrayList<>();
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1,pokemonId);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                habilidade move = new habilidade();
                
                move.setId(rs.getInt("id"));
                move.setName(rs.getString("name"));
                move.setPower(rs.getInt("power"));
                move.setType(rs.getInt("type"));
                move.setPp(rs.getInt("pp"));
                move.setAcc(rs.getInt("acc"));
                listMove.add(move);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(habilidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return listMove;
    }
}
