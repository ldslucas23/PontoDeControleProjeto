package pontoDeControle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pontoDeControle.model.Hora;
import pontoDeControle.model.PlanilhaHora;
import pontoDeControle.util.ConnectionFactory;


public class HoraDao {

    Connection con = new ConnectionFactory().getConnection();
    PreparedStatement stmt;
    ResultSet rs;

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

    public String pegaHoraInicial(int idHora){
        String horaInicial = null;
        String sql = "Select horaInicial from hora where id = ?";
         try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idHora);
            rs = stmt.executeQuery();
            while (rs.next()) {
                horaInicial = rs.getString("horaInicial");
            }
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
         return horaInicial;
    }
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
    
    public boolean isAindaHoje(int idFunc){
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
        if(diferencaDias == 0){
            return true;
        }else{
            return false;
        }
        
    }

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
