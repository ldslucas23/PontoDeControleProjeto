package pontoDeControle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pontoDeControle.model.Hora;
import pontoDeControle.model.PlanilhaHora;
import pontoDeControle.util.ConnectionFactory;

public class HoraDao {

    Connection con = new ConnectionFactory().getConnection();
    PreparedStatement stmt;
    ResultSet rs;
    /**
     * Método para inserir  uma hora no sistema
     *
     * @author Lucas Silva
     * @param hora - Objeto com as informações para serem inseridas ou alteradas
     */
    public void salvarHora(Hora hora) {
        String sql = "Insert into hora (idFuncionario, horaInicial, dataInicial) values (?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, hora.getIdFunc());
            stmt.setString(2, hora.getHoraInicial());
            stmt.setString(3, hora.getDataInicial());
            stmt.execute();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    /**
     * Método para alterar uma hora no sistema
     *
     * @author Lucas Silva
     * @param hora - Objeto com as informações para serem inseridas ou alteradas
     */
    public int  updateHora(Hora hora) {
        String sql = "Update hora set horaFinal = ? where id = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, hora.getHoraFinal());  
            stmt.setInt(2, pegarIdHora(hora.getIdFunc()));
            
            stmt.execute();
            stmt.close();
            con.close();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    /**
     * Método para pegar o id da última hora registrada no sistema pelo funcionário
     * utilizada para validações de inicialização do sistema 
     * @author Lucas Silva
     * @param idFunc - id do funcionário que deseja fazer login no sistema
     */
    public int pegarIdHora(int idFunc) {
        int idHora = 0;
        String sql = "Select max(id) as id from hora where idFuncionario = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idFunc);
            rs = stmt.executeQuery();
            while (rs.next()) {
                idHora = rs.getInt("id");
            }
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idHora;
    }
    /**
     * Método para pegar a última hora registrada no sistema pelo funcionário
     * utilizada para validações de inicialização do sistema 
     * @author Lucas Silva
     * @return Date - ultima hora registrada no sistema
     * @param idFunc - id do funcionário pesquisado
     */
    public Date pegaHoraInicial(int idFunc) {
        Date horaInicial = null;
        String sql = "Select max(horaInicial) as horaInicial from hora where idFuncionario = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idFunc);
            rs = stmt.executeQuery();
            while (rs.next()) {
                horaInicial = rs.getDate("horaInicial");
            }
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return horaInicial;
    }
    /**
     * Método para verificar se o usuário respeitou as horas de descanso
     * utilizada para validações de inicialização do sistema 
     * @author Lucas Silva
     * @return int - Quantidade de horas descansadas
     * @param idFunc - id do funcionário pesquisado
     */
    public int diferencaDeHoras(int idFunc) {
        String sql = "Select DATEDIFF ( HOUR , (Select max(horaInicial) from hora where idFuncionario = ?) , GETDATE()) as diferencaHoras";
        int diferencaHoras = 0;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idFunc);
            rs = stmt.executeQuery();
            while (rs.next()) {
                diferencaHoras = rs.getInt("diferencaHoras");
            }
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diferencaHoras;
    }
    /**
     * Método para verificar se o usuário já fez login hoje
     * utilizada para validações de inicialização do sistema, se o usuário já logou então a primeira hora que vale
     * @author Lucas Silva
     * @return boolean - Se ele já fez login hoje ou não
     * @param idFunc - id do funcionário pesquisado
     */
    public boolean isAindaHoje(int idFunc) {
        String sql = "Select DATEDIFF ( DAY , (Select max(horaInicial) from hora where idFuncionario = ?) , GETDATE()) as diferencaHoras";
        int diferencaDias = 0;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idFunc);
            rs = stmt.executeQuery();
            while (rs.next()) {
                diferencaDias = rs.getInt("diferencaHoras");
            }
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (diferencaDias == 0) {
            return true;
        } else {
            return false;
        }

    }
    /**
     * Método para pegar os dados das horas com base nos filtros e preencher a planilha 
     * @author Lucas Silva
     * @return List - Lista com as horas do funcionário durante o período filtrado
     * @param idFunc - id do funcionário pesquisado
     * @param dataInicial - data inicial no filtro
     * @param dataFinal - data final no filtro
     */
    public List<PlanilhaHora> getDadosPlanilha(int idFunc, String dataInicial, String dataFinal) {
        ArrayList<PlanilhaHora> planilhaHoras = new ArrayList<PlanilhaHora>();
        String sql = "Select funcionario.nome, CONVERT(DATE,horaInicial) as Data, CONCAT( DATEPART ( HOUR , horaInicial ), ':',DATEPART ( minute , horaInicial )) as HoraInicial , CONCAT( DATEPART ( HOUR , horaInicial ), ':',DATEPART ( minute , horaInicial )) as HoraFinal"
                + "  from hora"
                + "  left join funcionario"
                + "  on hora.idFuncionario = funcionario.id"
                + "  where horaInicial BETWEEN ? and ?"
                + "  and funcionario.id = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, dataInicial);
            stmt.setString(2, dataFinal);
            stmt.setInt(3, idFunc);
            rs = stmt.executeQuery();
            while (rs.next()) {
                PlanilhaHora hora = new PlanilhaHora();
                hora.setNome(rs.getString("nome"));
                hora.setData(rs.getString("Data"));
                hora.setHoraInicial(rs.getString("HoraInicial"));
                hora.setHoraFinal(rs.getString("HoraFinal"));
                planilhaHoras.add(hora);
            }
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planilhaHoras;
    }
}
