package pontoDeControle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pontoDeControle.model.PermissaoUsuario;
import pontoDeControle.util.ConnectionFactory;

public class PermissaoUsuarioDao {

    Connection con = new ConnectionFactory().getConnection();
    PreparedStatement stmt;
    ResultSet rs;

    public List<PermissaoUsuario> listarTodasAsPermissoes() {
        ArrayList<PermissaoUsuario> permissoes = new ArrayList<PermissaoUsuario>();
        String sql = "Select id, nome from permissao";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                PermissaoUsuario permissao = new PermissaoUsuario();
                permissao.setId(rs.getInt("id"));
                permissao.setNome(rs.getString("nome"));
                permissoes.add(permissao);
            }
            stmt.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return permissoes;
    }

    public int pegarIdPermissao(String nome) {
        int idPermissao = 0;
        String sql = "Select id from permissao where nome = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            while (rs.next()) {

               idPermissao = rs.getInt("id");

            }
            stmt.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return idPermissao;
    }
}
