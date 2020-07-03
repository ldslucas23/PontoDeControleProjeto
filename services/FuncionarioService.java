
package pontoDeControle.services;

import java.util.List;
import pontoDeControle.dao.FuncionarioDao;
import pontoDeControle.model.Funcionario;


public class FuncionarioService {

    public String salvar(Funcionario funcionario) {
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        return funcionarioDao.insert(funcionario);
    }

    public List<Funcionario> listarGestores() {
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        return funcionarioDao.listarGestores();
    }

    public List<Funcionario> listarFuncionarios(String nome) {
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        return funcionarioDao.listarFuncionarios(nome);
    }

    public List<Funcionario> listarTodosFuncionarios() {
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        return funcionarioDao.listarTodosFuncionarios();
    }

    public Funcionario getFuncionarioById(int id) {
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        return funcionarioDao.getFuncionarioById(id);
    }

    public String getNomeGestorById(int id) {
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        return funcionarioDao.getNomeGestorById(id);
    }

    public String excluir(int id) {
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        return funcionarioDao.excluir(id);
    }

    public Funcionario getFuncionarioByUsuario(String usuario) {
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        return funcionarioDao.getFuncionarioByUsuario(usuario);
    }
}
