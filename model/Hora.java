package pontoDeControle.model;
/**Classe para objetos do tipo Hora, onde serão contidos, valores e métodos para o mesmo.
* @author Lucas Silva
* @version 1.00
* @since Release 01 da aplicação
*/
public class Hora {
	private int id;
	private int idFunc;
	private String horaInicial;
	private String horaFinal;
	private String dataInicial;
	private String dataFinal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }
	

	
	
}
