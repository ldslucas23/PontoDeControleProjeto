package pontoDeControle.services;
/**Classe fazer o a comunicação entre a View e o banco de dados para manipular objetos do tipo Hora
* @author Lucas Silva
* @version 1.00
* @since Release 01 da aplicação
*/
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import pontoDeControle.dao.HoraDao;
import pontoDeControle.model.Hora;
import pontoDeControle.model.PlanilhaHora;

public class HoraService {

    public void salvarHora(Hora hora) {
        HoraDao horaDao = new HoraDao();
        horaDao.salvarHora(hora);
    }

    public int updateHora(Hora hora) {
        int fechar;
        HoraDao horaDao = new HoraDao();
        fechar = horaDao.updateHora(hora);
        return fechar;
    }

    public int diferencaHoras(int idFunc) {
        HoraDao horaDao = new HoraDao();
        return horaDao.diferencaDeHoras(idFunc);
    }

    public boolean isAindaHoje(int idFunc) {
        HoraDao horaDao = new HoraDao();
        return horaDao.isAindaHoje(idFunc);
    }

    public String gerarPlanilhaHoras(int idFunc, String dataInicial, String dataFinal) throws IOException {
        HoraDao horaDao = new HoraDao();
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet planilhaHoras = wb.createSheet("Planilha de Horas");
        HSSFRow row = planilhaHoras.createRow(0);
        //CRIANDO COLUNAS    
        row.createCell((short) 0).setCellValue("Nome");
        row.createCell((short) 1).setCellValue("Data");
        row.createCell((short) 2).setCellValue("Hora Inicial");
        row.createCell((short) 3).setCellValue("Hora Final");
        int i = 1;
        for (PlanilhaHora p : horaDao.getDadosPlanilha(idFunc, dataInicial, dataFinal)) {
            LocalDate datetime = LocalDate.parse(p.getData(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String data = datetime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            HSSFRow row2 = planilhaHoras.createRow(i);
            row2.createCell((short) 0).setCellValue(p.getNome());
            row2.createCell((short) 1).setCellValue(data);
            row2.createCell((short) 2).setCellValue(p.getHoraInicial());
            row2.createCell((short) 3).setCellValue(p.getHoraFinal());
            i++;
        }
        FileOutputStream stream = new FileOutputStream("C:/Users/linkedrh032/Desktop/Planilhas/hora.xls");
        wb.write(stream);
        return "Planilha Criada com Sucesso !";
    }

    public int getIdHora(int idFunc) {
        HoraDao horaDao = new HoraDao();
        return horaDao.pegarIdHora(idFunc);
    }

    public Date pegarHoraInicial(int idFunc) {
        HoraDao horaDao = new HoraDao();
        return horaDao.pegaHoraInicial(idFunc);
    }
}
