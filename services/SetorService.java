package pontoDeControle.services;

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
