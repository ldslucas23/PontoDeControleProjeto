package pontoDeControle.services;
/**Classe fazer o a comunicação entre a View e o banco de dados para manipular objetos do tipo Permissão
* @author Lucas Silva
* @version 1.00
* @since Release 01 da aplicação
*/
import java.util.List;
import pontoDeControle.dao.PermissaoUsuarioDao;
import pontoDeControle.model.PermissaoUsuario;

public class PermissaoUsuarioService {

    public List<PermissaoUsuario> listarTodasAsPermissoes(){
        PermissaoUsuarioDao permissaoDao = new PermissaoUsuarioDao();
        return permissaoDao.listarTodasAsPermissoes();
    }
    
     public int pegarIdPermissao(String nome){
         PermissaoUsuarioDao permissaoDao = new PermissaoUsuarioDao();
         return permissaoDao.pegarIdPermissao(nome);
     }
 
}
