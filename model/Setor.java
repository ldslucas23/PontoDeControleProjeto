package pontoDeControle.model;

/**Classe para objetos do tipo Setor, onde serão contidos, valores e métodos para o mesmo.
* @author Lucas Silva
* @version 1.00
* @since Release 01 da aplicação
*/
public class Setor {
	private int id;
	private String nome;
	private int idGestor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdGestor() {
		return idGestor;
	}
	public void setIdGestor(int idGestor) {
		this.idGestor = idGestor;
	}
	
	
}
