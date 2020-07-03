
package pontoDeControle.view;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import pontoDeControle.model.Funcionario;
import pontoDeControle.model.Hora;
import pontoDeControle.services.FuncionarioService;
import pontoDeControle.services.HoraService;


public class TelaCarregamento extends javax.swing.JFrame {


    public TelaCarregamento() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblAvisos = new javax.swing.JLabel();
        lblAvisos3 = new javax.swing.JLabel();
        lblTempoDescanso = new javax.swing.JLabel();
        lblAvisos5 = new javax.swing.JLabel();
        lblAvisos6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        lblAvisos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAvisos.setText("Verifique as situações:");
        jPanel1.add(lblAvisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 87, 873, 57));

        lblAvisos3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAvisos3.setText("Caso o problema persista, contate o suporte.");
        jPanel1.add(lblAvisos3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 849, 57));

        lblTempoDescanso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTempoDescanso.setText("O tempo de descanso obrigatório configurado não foi respeitado.");
        jPanel1.add(lblTempoDescanso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 849, 57));

        lblAvisos5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAvisos5.setText("Verifique seu usuário com seu administrador de rede.");
        jPanel1.add(lblAvisos5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 849, 57));

        lblAvisos6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAvisos6.setText("Verifique sua conexão com a internet.");
        jPanel1.add(lblAvisos6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 849, 57));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        String usuarioNome = System.getProperty("user.name");
        Funcionario usuario = new Funcionario();
        FuncionarioService service = new FuncionarioService();
        usuario = service.getFuncionarioByUsuario(usuarioNome);
        HoraService horaService = new HoraService();
        Hora hora = new Hora();
        String horaInicialTexto = null;
        if (usuario.getId() != 0) {
            if (horaService.isAindaHoje(usuario.getId())) {
                if (horaService.diferencaHoras(usuario.getId()) > 11) {

                    Date data = new Date(System.currentTimeMillis());
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String horaInicial = formatter.format(data);

                    Date horaInicialHora = new Date(System.currentTimeMillis());
                    SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm");
                    horaInicialTexto = formatter2.format(data);
                    hora.setIdFunc(usuario.getId());
                    hora.setHoraInicial(horaInicial);
                    hora.setDataInicial(horaInicial);
                    horaService.salvarHora(hora);
                }

                TelaPrincipal telaPrincipal = new TelaPrincipal(horaInicialTexto, usuario);
                telaPrincipal.show();
               
                this.dispose();
            } else {
                jLabel1.setText("DESCULPE, NÃO CONSEGUIMOS INICALIZAR O SISTEMA");
            }

        } else {
            jLabel1.setText("DESCULPE, NÃO CONSEGUIMOS INICALIZAR O SISTEMA");
        }
    }//GEN-LAST:event_formWindowOpened


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCarregamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAvisos;
    private javax.swing.JLabel lblAvisos3;
    private javax.swing.JLabel lblAvisos5;
    private javax.swing.JLabel lblAvisos6;
    private javax.swing.JLabel lblTempoDescanso;
    // End of variables declaration//GEN-END:variables
}
