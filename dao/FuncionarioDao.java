package pontoDeControle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pontoDeControle.model.Funcionario;
import pontoDeControle.util.ConnectionFactory;

public class FuncionarioDao extends Funcionario {

    Connection con = new ConnectionFactory().getConnection();
    PreparedStatement stmt;
    ResultSet rs;

    public String insert(Funcionario funcionario) {
        if (funcionario.getId() != 0) {
            String sql = "update funcionario set nome = ?, cpf = ?, usuarioSistema = ?, idGestor = ?, isGestor = ?, idHorario = ?, email= ?, idSetor = ?, idPermissao = ? where id = ?";
            try {
                stmt = con.prepareStatement(sql);

                stmt.setString(1, funcionario.getNome());
                stmt.setString(2, funcionario.getCpf());
                stmt.setString(3, funcionario.getUsuarioSistema());
                stmt.setInt(4, funcionario.getIdGestor());
                stmt.setString(5, funcionario.isIsGestor() ? "T" : "F");
                stmt.setInt(6, funcionario.getIdHorario());
                stmt.setString(7, funcionario.getEmail());
                stmt.setInt(8, funcionario.getIdSetor());
                stmt.setInt(9, funcionario.getIdPermsissao());
                stmt.setInt(10, funcionario.getId());
                stmt.execute();
                stmt.close();
                con.close();
                return "Atualizado com Sucesso";

            } catch (SQLException e) {
                e.printStackTrace();
                return e.toString();
            }
        } else {
            String sql = "insert into funcionario (nome,cpf,usuarioSistema,idGestor,isGestor,idHorario,email, idPermissao) values (?,?,?,?,?,?,?,?)";
            try {
                stmt = con.prepareStatement(sql);

                stmt.setString(1, funcionario.getNome());
                stmt.setString(2, funcionario.getCpf());
                stmt.setString(3, funcionario.getUsuarioSistema());
                stmt.setInt(4, funcionario.getIdGestor());
                stmt.setString(5, funcionario.isIsGestor() ? "T" : "F");
                stmt.setInt(6, funcionario.getIdHorario());
                stmt.setString(7, funcionario.getEmail());
                stmt.setInt(8, funcionario.getIdPermsissao());
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

    public List<Funcionario> listarGestores() {
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        String sql = "Select id, nome, email from funcionario where isGestor = 'T' ";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEmail(rs.getString("email"));
                funcionarios.add(funcionario);
            }
            stmt.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return funcionarios;
    }

    public List<Funcionario> listarTodosFuncionarios() {
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        String sql = "Select id, nome, email from funcionario";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEmail(rs.getString("email"));
                funcionarios.add(funcionario);
            }
            stmt.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return funcionarios;
    }

    public String getNomeGestorById(int id) {
        String sql = "Select nome from funcionario where id = ? ";
        Funcionario funcionario = new Funcionario();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                funcionario.setNome(rs.getString("nome"));
            }
            stmt.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return funcionario.getNome();
    }

    public Funcionario getFuncionarioById(int id) {
        Funcionario funcionario = new Funcionario();
        String sql = "Select funcionario.idPermissao, permissao.nome as NomePermissao, funcionario.id, funcionario.nome, funcionario.cpf, funcionario.usuarioSistema,funcionario.idGestor,funcionario.isGestor,funcionario.idHorario,funcionario.email, setor.nome as NomeSetor, "
                + "horario.descricao as descricaoHorario, gestor.nome as NomeGestor from funcionario"
                + "  left join setor on funcionario.idSetor = setor.id"
                + "  left join horario on funcionario.idHorario = horario.id"
                + "  left join funcionario gestor on funcionario.idGestor = gestor.id "
                + "  left join permissao on funcionario.idPermissao = permissao.id "
                + "  where funcionario.id = ? ";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setUsuarioSistema(rs.getString("usuarioSistema"));
                funcionario.setIdGestor(rs.getInt("idGestor"));
                funcionario.setIsGestor("T".equals(rs.getString("isGestor")) ? true : false);
                funcionario.setIdHorario(rs.getInt("idHorario"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setNomeGestor(rs.getString("NomeGestor"));
                funcionario.setNomeSetor(rs.getString("NomeSetor"));
                funcionario.setDescricaoHorario(rs.getString("descricaoHorario"));
                funcionario.setNomePermissao(rs.getString("NomePermissao"));
                funcionario.setIdPermsissao(rs.getInt("idPermissao"));
            }
            stmt.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return funcionario;
    }

    public Funcionario getFuncionarioByUsuario(String usuario) {
        Funcionario funcionario = new Funcionario();
        String sql = "Select funcionario.idPermissao, permissao.nome as NomePermissao, funcionario.nome, funcionario.id, funcionario.cpf, funcionario.usuarioSistema,funcionario.idGestor,funcionario.isGestor,funcionario.idHorario,funcionario.email, setor.nome as NomeSetor, "
                + "horario.descricao as descricaoHorario, gestor.nome as NomeGestor from funcionario"
                + "  left join setor on funcionario.idSetor = setor.id"
                + "  left join horario on funcionario.idHorario = horario.id"
                + "  left join funcionario gestor on funcionario.idGestor = gestor.id "
                + "  left join permissao on funcionario.idPermissao = permissao.id "
                + "  where funcionario.usuarioSistema = ? ";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario);
            rs = stmt.executeQuery();
            while (rs.next()) {
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setUsuarioSistema(rs.getString("usuarioSistema"));
                funcionario.setIdGestor(rs.getInt("idGestor"));
                funcionario.setIsGestor("T".equals(rs.getString("isGestor")) ? true : false);
                funcionario.setIdHorario(rs.getInt("idHorario"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setNomeGestor(rs.getString("NomeGestor"));
                funcionario.setNomeSetor(rs.getString("NomeSetor"));
                funcionario.setDescricaoHorario(rs.getString("descricaoHorario"));
                funcionario.setNomePermissao(rs.getString("NomePermissao"));
                funcionario.setIdPermsissao(rs.getInt("idPermissao"));
            }
            stmt.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionario;
    }

    public List<Funcionario> listarFuncionarios(String nome) {
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        String sql = "Select funcionario.idPermissao, permissao.nome as NomePermissao, funcionario.id, funcionario.nome, funcionario.cpf, funcionario.usuarioSistema, funcionario.idGestor, funcionario.isGestor, funcionario.idHorario, funcionario.email, setor.nome as NomeSetor, "
                + "  horario.descricao as descricaoHorario, gestor.nome as NomeGestor from funcionario"
                + "  left join setor on funcionario.idSetor = setor.id"
                + "  left join horario on funcionario.idHorario = horario.id"
                + "  left join funcionario gestor on funcionario.idGestor = gestor.id "
                + "  left join permissao on funcionario.idPermissao = permissao.id "
                + "  where funcionario.nome like ? ";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, '%' + nome + '%');
            rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setUsuarioSistema(rs.getString("usuarioSistema"));
                funcionario.setIdGestor(rs.getInt("idGestor"));
                funcionario.setIsGestor("T".equals(rs.getString("isGestor")) ? true : false);
                funcionario.setIdHorario(rs.getInt("idHorario"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setNomeGestor(rs.getString("NomeGestor"));
                funcionario.setNomeSetor(rs.getString("NomeSetor"));
                funcionario.setDescricaoHorario(rs.getString("descricaoHorario"));
                funcionario.setNomePermissao(rs.getString("NomePermissao"));
                funcionario.setIdPermsissao(rs.getInt("idPermissao"));
                funcionarios.add(funcionario);
            }
            stmt.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return funcionarios;
    }

    public String excluir(int id) {
        String sql = "Delete from funcionario where id = ?";
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
