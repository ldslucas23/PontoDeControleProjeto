package pontoDeControle.services;

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
