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
