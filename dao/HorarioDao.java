package pontoDeControle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pontoDeControle.model.Horario;
import pontoDeControle.util.ConnectionFactory;


public class HorarioDao extends Horario {

    Connection con = new ConnectionFactory().getConnection();
    PreparedStatement stmt;
    ResultSet rs;
    /**
     * Método para inserir ou alterar um horário no sistema
     *
     * @author Lucas Silva
     * @param horario - Objeto com as informações para serem inseridas ou alteradas
     * @return String - valor da mensagem para ser exibido na tela  
     */
    public String insert(Horario horario) {
        if (horario.getId() != 0) {
            String sql = "update horario set descricao = ?, qtdHoras=?, noturno=?, inativo=?  where id = ?";
            try {
                stmt = con.prepareStatement(sql);
                stmt.setString(1, horario.getDescricao());
                stmt.setFloat(2, horario.getQtdHoras());
                stmt.setString(3, horario.isNortuno() ? "T" : "F");
                stmt.setString(4, horario.isInativo() ? "T" : "F");
                stmt.setInt(5, horario.getId());
                stmt.execute();
                stmt.close();
                con.close();
                return "Atualizado com Sucesso";

            } catch (SQLException e) {
                return e.toString();
            }
        } else {
            String sql = "insert into horario (descricao, qtdHoras, noturno, inativo) values (?,?,?,?)";
            try {
                stmt = con.prepareStatement(sql);

                stmt.setString(1, horario.getDescricao());
                stmt.setFloat(2, horario.getQtdHoras());
                stmt.setString(3, horario.isNortuno() ? "T" : "F");
                stmt.setString(4, horario.isInativo() ? "T" : "F");
                stmt.execute();
                stmt.close();
                con.close();

                return "Salvo com Sucesso";

            } catch (SQLException e) {
                return e.toString();
            }
        }

    }
    /**
     * Método para listar os horários na tela de horários 
     * @author Lucas Silva    
     * @return List - retornar os funcionários gestores
     */
    public List<Horario> listarHorarios() {
        ArrayList<Horario> horarios = new ArrayList<Horario>();
        String sql = "Select id, descricao, qtdHoras, noturno, inativo from horario ";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Horario horario = new Horario();
                horario.setId(rs.getInt("id"));
                horario.setQtdHoras(rs.getFloat("qtdHoras"));
                horario.setDescricao(rs.getString("descricao"));
                horario.setNortuno("T".equals(rs.getString("noturno")) ? true : false);
                horario.setInativo("T".equals(rs.getString("inativo")) ? true : false);
                horarios.add(horario);
            }
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return horarios;
    }
    /**
     * Método para listar os horários na tela de horários pela descrição
     * @author Lucas Silva
     * @param descricao - Descrição para ser comparada na consulta
     * @return List - retornar os funcionários gestores
     */
    public List<Horario> listarHorariosPelaDescricao(String descricao) {
        ArrayList<Horario> horarios = new ArrayList<Horario>();
        String sql = "Select id from horario where descricao = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, descricao);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Horario horario = new Horario();
                horario.setId(rs.getInt("id"));
                horarios.add(horario);
            }
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return horarios;
    }
    /**
     * Método para listar os horários na tela de horários pelo id
     * @author Lucas Silva
     * @param idHorario - id para ser comparado na consulta
     * @return Horario - Objeto preenchido pela consulta
     */
    public Horario getHorarioById(int idHorario) {
        Horario horario = new Horario();
        String sql = "Select descricao, qtdHoras, noturno,inativo from horario where id = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idHorario);
            rs = stmt.executeQuery();
            while (rs.next()) {
                horario.setQtdHoras(rs.getFloat("qtdHoras"));
                horario.setDescricao(rs.getString("descricao"));
                horario.setNortuno("T".equals(rs.getString("noturno")) ? true : false);
                horario.setInativo("T".equals(rs.getString("inativo")) ? true : false);
            }
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return horario;
    }
    /**
     * Método para excluir os horários  pelo id
     * @author Lucas Silva
     * @param id - id para ser comparado na consulta
     * @return String - Valor da mensagem a ser exibida na tela
     */
    public String removeById(int id) {
        String sql = "Delete from horario where id = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            con.close();
            return "Excluído com Sucesso";

        } catch (SQLException e) {
            return e.toString();
        }
    }
}
