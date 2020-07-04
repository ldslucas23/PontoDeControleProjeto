package pontoDeControle.services;
/**Classe fazer o a comunicação entre a View e o banco de dados para manipular objetos do tipo Setor
* @author Lucas Silva
* @version 1.00
* @since Release 01 da aplicação
*/
import java.util.List;

import pontoDeControle.dao.SetorDao;
import pontoDeControle.model.Setor;

public class SetorService extends Setor{
	
	public String inserirSetor(Setor setor) {
		SetorDao setorDao = new SetorDao();
		return setorDao.insert(setor);
	}
	
	public List<Setor> pesquisarSetores(String nome) {
		SetorDao setorDao = new SetorDao();
                return setorDao.listarSetores(nome);
        }
        
        public String deleteSetor(Setor setor){
            SetorDao setorDao = new SetorDao();
            return setorDao.removeById(setor.getId());
        }
        
        public List<Setor> listarTodosSetores(){
            SetorDao setorDao = new SetorDao();
            return setorDao.listarTodosSetores();
        }
}
