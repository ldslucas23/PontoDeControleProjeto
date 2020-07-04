
package pontoDeControle.model;

/**Classe para objetos do tipo Planilha de Horas, onde serão contidos, valores e métodos para o mesmo.
* @author Lucas Silva
* @version 1.00
* @since Release 01 da aplicação
*/

public class PlanilhaHora {
    String nome;
    String Data;
    String horaInicial;
    String horaFinal;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
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
    
}
