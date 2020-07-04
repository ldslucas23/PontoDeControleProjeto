
package pontoDeControle.view;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pontoDeControle.model.Funcionario;
import pontoDeControle.services.FuncionarioService;
import pontoDeControle.services.HoraService;


public class TelaPlanilhaFuncionario extends javax.swing.JInternalFrame {


    public TelaPlanilhaFuncionario() {
        initComponents();
        listarGestores();
    }

        public void listarGestores(){
        cbFuncionarios.removeAllItems();;
        FuncionarioService service = new FuncionarioService();
        for(Funcionario f : service.listarTodosFuncionarios()){
            cbFuncionarios.addItem(f.getNome());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbFuncionarios = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtDataFinal = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDataInicial = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnGerar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Gerar planilhas");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/pontoDeControle/icones/plan.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(854, 632));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("a");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("*");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 20, -1));

        getContentPane().add(cbFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 220, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Funcionário:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        try {
            txtDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtDataFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, 110, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Periodo:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, -1));

        try {
            txtDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtDataInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 110, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Filtros:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("*");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 20, -1));

        btnGerar.setText("Gerar Planilha");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 210, 130, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
      if(!txtDataFinal.getText().isEmpty() || !txtDataInicial.getText().isEmpty()){
          HoraService service = new HoraService();
          FuncionarioService funcionarioService = new FuncionarioService();
          int idFunc = 0;
          for(Funcionario f : funcionarioService.listarFuncionarios(cbFuncionarios.getSelectedItem().toString())){
              idFunc = f.getId();
          }
          LocalDate datetime = LocalDate.parse(txtDataInicial.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
          String dataInicial = datetime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
          
          LocalDate datetime2 = LocalDate.parse(txtDataFinal.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
          String dataFinal = datetime2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
          
          try {
              JOptionPane.showMessageDialog(null, service.gerarPlanilhaHoras(idFunc, dataInicial, dataFinal));
          } catch (IOException ex) {
              Logger.getLogger(TelaPlanilhaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    }//GEN-LAST:event_btnGerarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerar;
    private javax.swing.JComboBox<String> cbFuncionarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JFormattedTextField txtDataFinal;
    private javax.swing.JFormattedTextField txtDataInicial;
    // End of variables declaration//GEN-END:variables
}
