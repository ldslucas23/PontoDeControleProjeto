package pontoDeControle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pontoDeControle.model.Funcionario;
import pontoDeControle.model.Setor;
import pontoDeControle.util.ConnectionFactory;

public class SetorDao extends Setor {

    Connection con = new ConnectionFactory().getConnection();
    PreparedStatement stmt;
    ResultSet rs;
   
    /**
     * Método para inserir ou alterar um setor no sistema
     *
     * @author Lucas Silva
     * @param setor - Objeto com as informações para serem inseridas ou alteradas
     * @return String - valor da mensagem para ser exibido na tela  
     */
    public String insert(Setor setor) {
        if (setor.getId() != 0) {
            String sql = "update setor set nome = ? where id = ?";
            try {
                stmt = con.prepareStatement(sql);

                stmt.setString(1, setor.getNome());
                stmt.setInt(2, setor.getId());
                stmt.execute();
                stmt.close();
                con.close();
                return "Atualizado com Sucesso";

            } catch (SQLException e) {
                e.printStackTrace();
                return e.toString();
            }
        } else {
            String sql = "insert into setor (nome) values (?)";
            try {
                stmt = con.prepareStatement(sql);

                stmt.setString(1, setor.getNome());

                stmt.execute();
                stmt.close();
                con.close();
                return "Salvo com Sucesso";

            } catch (SQLException e) {
                e.printStackTrace();
                return e.toString();
            }
        }

    }
    /**
     * Método para listar os setores pesquisados pelo nome
     *
     * @author Lucas Silva    
     * @param nome - nome do setor a ser comparado na consulta
     * @return List - retornar os setores
     */
    public List<Setor> listarSetores(String nome) {
        ArrayList<Setor> setores = new ArrayList<Setor>();
        String sql = "Select id, nome from setor where nome like ? ";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, '%' + nome + '%');
            rs = stmt.executeQuery();
            while (rs.next()) {
                Setor setor = new Setor();
                setor.setId(rs.getInt("id"));
                setor.setNome(rs.getString("nome"));
                setores.add(setor);
            }
            stmt.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return setores;
    }
    
    /**
     * Método para listar todos os  setores 
     *
     * @author Lucas Silva    
     * @return List - retornar uma lista de setores preenchido
     */
    public List<Setor> listarTodosSetores() {
        ArrayList<Setor> setores = new ArrayList<Setor>();
        String sql = "Select id, nome from setor";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Setor setor = new Setor();
                setor.setId(rs.getInt("id"));
                setor.setNome(rs.getString("nome"));
                setores.add(setor);
            }
            stmt.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return setores;
    }
    /**
     * Método para deletar um setor pelo id 
     *
     * @author Lucas Silva    
     * @param id - id do setor a ser deletado
     * @return String - Valor da mensangem a ser exibida na tela
     */
    public String removeById(int id) {
        String sql = "Delete from setor where id = ?";
        try {
            stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            con.close();
            return "Excluído com Sucesso";

        } catch (SQLException e) {
            e.printStackTrace();
            return e.toString();
        }
    }


}
