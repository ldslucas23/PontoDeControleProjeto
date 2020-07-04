package pontoDeControle.model;

/**Classe para objetos do tipo Horario, onde serão contidos, valores e métodos para o mesmo.
* @author Lucas Silva
* @version 1.00
* @since Release 01 da aplicação
*/
public class Horario {
    private int id;
    private String descricao;
    private float qtdHoras;
    private boolean nortuno;
    private boolean inativo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getQtdHoras() {
        return qtdHoras;
    }

    public void setQtdHoras(float qtdHoras) {
        this.qtdHoras = qtdHoras;
    }

    public boolean isNortuno() {
        return nortuno;
    }

    public void setNortuno(boolean nortuno) {
        this.nortuno = nortuno;
    }

    public boolean isInativo() {
        return inativo;
    }

    public void setInativo(boolean inativo) {
        this.inativo = inativo;
    }
    
}
