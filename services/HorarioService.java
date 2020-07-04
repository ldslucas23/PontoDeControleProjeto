package pontoDeControle.services;
/**Classe fazer o a comunicação entre a View e o banco de dados para manipular objetos do tipo Horario
* @author Lucas Silva
* @version 1.00
* @since Release 01 da aplicação
*/
import java.util.List;
import pontoDeControle.dao.HorarioDao;
import pontoDeControle.model.Horario;

public class HorarioService extends Horario {

    public String inserirHorario(Horario horario) {
        HorarioDao horarioDao = new HorarioDao();
        return horarioDao.insert(horario);
    }

    public List<Horario> pesquisarHorarios() {
        HorarioDao horarioDao = new HorarioDao();
        return horarioDao.listarHorarios();
    }

    public String deleteHorario(Horario horario) {
        HorarioDao horarioDao = new HorarioDao();
        return horarioDao.removeById(horario.getId());
    }

    public List<Horario> pesquisarHorariosPelaDescricao(String descricao) {
        HorarioDao horarioDao = new HorarioDao();
        return horarioDao.listarHorariosPelaDescricao(descricao);
    }

    public Horario getHorarioById(int idHorario) {
        HorarioDao horarioDao = new HorarioDao();
        return horarioDao.getHorarioById(idHorario);
    }
}
