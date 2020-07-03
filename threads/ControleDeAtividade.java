
package pontoDeControle.threads;

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