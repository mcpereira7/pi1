package dao;

import entity.pokemon;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class pokemonDAO {

    private Connection cn = null;

    public pokemonDAO() {
        cn = ConnectionFactory.getConnection();
    }

    public List<pokemon> findAll() {

        String sql = "SELECT *, types.description FROM pokedex INNER JOIN Types ON pokedex.type = Types.id ORDER BY pokedex.id";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<pokemon> listPokemon = new ArrayList<>();

        try {
            stmt = cn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                habilidadeDAO habilidade = new habilidadeDAO();
                pokemon pokemon = new pokemon();

                pokemon.setId(rs.getInt("id"));
                pokemon.setName(rs.getString("name"));
                pokemon.setHp(rs.getInt("hp"));
                pokemon.setAtk(rs.getInt("atk"));
                pokemon.setDef(rs.getInt("def"));
                pokemon.setSa(rs.getInt("sa"));
                pokemon.setSd(rs.getInt("sd"));
                pokemon.setSpd(rs.getInt("spd"));
                pokemon.setTotal(rs.getInt("total"));
                pokemon.setType(rs.getString("description"));
                pokemon.setHabilidade(habilidade.findMovesPokemon(rs.getInt("id")));
                listPokemon.add(pokemon);
            }

        } catch (SQLException ex) {
            Logger.getLogger(pokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return listPokemon;
    }

    public pokemon findPokemon(int idPokemon) {

        String sql = "SELECT *, types.description FROM pokedex INNER JOIN Types ON pokedex.type = Types.id WHERE pokedex.id = ?";

        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        habilidadeDAO habilidade = new habilidadeDAO();
        pokemon pokemon = new pokemon();

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, idPokemon);
            rs = stmt.executeQuery();
            
            rs.next();
            pokemon.setId(rs.getInt("id"));
            pokemon.setName(rs.getString("name"));
            pokemon.setHp(rs.getInt("hp"));
            pokemon.setAtk(rs.getInt("atk"));
            pokemon.setDef(rs.getInt("def"));
            pokemon.setSa(rs.getInt("sa"));
            pokemon.setSd(rs.getInt("sd"));
            pokemon.setSpd(rs.getInt("spd"));
            pokemon.setTotal(rs.getInt("total"));
            pokemon.setType(rs.getString("description"));
            pokemon.setHabilidade(habilidade.findMovesPokemon(rs.getInt("id")));

        } catch (SQLException ex) {
            Logger.getLogger(pokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return pokemon;
    }
}
