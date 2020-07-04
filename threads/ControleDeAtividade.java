
package pontoDeControle.threads;
/**Classe iniciar e configurar Threads
* @author Lucas Silva
* @version 1.00
* @since Release 01 da aplicação
*/
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


public class ControleDeAtividade extends Thread {
    long atividade;
    JFrame frame;
    float quantidadeTempo;
    
    public ControleDeAtividade(float quantidadeTempo){
        this.quantidadeTempo = quantidadeTempo;
    }
   /**
     * Método para executar inciar uma Thread para programar o fechamento do sistema
     *
     * @author Lucas Silva    
     *
     */
    public void run() {
        atualizarAtividade();
        do {
            try {
                Thread.sleep(1000); // 1s
            } catch (InterruptedException ex) {
                Logger.getLogger(ControleDeAtividade.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while(currentTime() - atividade < quantidadeTempo * 3600000);
        frame.dispose();
    }
    void atualizarAtividade() {
        atividade = currentTime();
    }
    
    long currentTime() {
         return java.lang.System.currentTimeMillis();
    }
}