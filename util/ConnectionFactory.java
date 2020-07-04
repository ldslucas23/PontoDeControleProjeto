package pontoDeControle.util;
/**Classe para instanciar conexão com o banco de dados
* @author Lucas Silva
* @version 1.00
* @since Release 01 da aplicação
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

    private final String host = "";
    private final String user = "";
    private final String password = "";
    private final String dataBase = "";

    public PreparedStatement stmt;
    public ResultSet rs;

    /**
     * Método para retornar a conexão com o banco de dados
     *
     * @author Lucas Silva 
     */
    public Connection getConnection() {
        try {
            String url = "jdbc:sqlserver://" + host + ";databaseName=" + dataBase + ";user=" + user + ";password=" + password + ";";
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
