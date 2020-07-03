
package pontoDeControle.view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pontoDeControle.model.Setor;
import pontoDeControle.services.SetorService;


public class TelaSetor extends javax.swing.JInternalFrame {


    public TelaSetor() {
        initComponents();
        txtIdSetor.setVisible(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtPesquisar = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        lblAvisos = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNomeSetor = new javax.swing.JTextPane();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtSetores = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtIdSetor = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Setores");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/pontoDeControle/icones/setor.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(854, 632));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setName("txtPesquisar"); // NOI18N

        txtPesquisar.setName("txtNomeSetor"); // NOI18N
        jScrollPane1.setViewportView(txtPesquisar);
        txtPesquisar.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 433, -1));

        lblAvisos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAvisos.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lblAvisos, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblAvisos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 550, 40));

        btnExcluir.setToolTipText("Salva as alterações");
        btnExcluir.setEnabled(false);
        btnExcluir.setLabel("Excluir");
        btnExcluir.setName("btnExcluir"); // NOI18N
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 110, 30));

        btnSalvar.setText("Salvar");
        btnSalvar.setToolTipText("Salva as alterações");
        btnSalvar.setName("btnSalvar"); // NOI18N
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 110, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Id:");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 30, 37));

        txtNomeSetor.setName("txtNomeSetor"); // NOI18N
        jScrollPane2.setViewportView(txtNomeSetor);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 433, -1));

        jButton3.setText("Pesquisar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, -1, -1));

        jtSetores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtSetores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtSetoresMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtSetores);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 660, 280));

        txtIdSetor.setEnabled(false);
        jScrollPane4.setViewportView(txtIdSetor);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 30, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nome do setor:");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 106, 37));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jtSetores.getModel();
        carregaTabela(modelo);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Setor setor = new Setor();
        if (!txtNomeSetor.getText().isEmpty()) {
            setor.setNome(txtNomeSetor.getText());
            if (!txtIdSetor.getText().isEmpty()) {
                Integer id = Integer.parseInt(txtIdSetor.getText());
                setor.setId(id);
            }

            SetorService service = new SetorService();
            JOptionPane.showMessageDialog(null, service.inserirSetor(setor));

        }

        limparCampos();

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jtSetoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtSetoresMouseClicked
        btnExcluir.setEnabled(true);
        int row = jtSetores.getSelectedRow();
        Object id = jtSetores.getValueAt(row, 0);
        txtIdSetor.setText(String.valueOf(id));
        Object nome = jtSetores.getValueAt(row, 1);
        txtNomeSetor.setText(String.valueOf(nome));
    }//GEN-LAST:event_jtSetoresMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        Setor setor = new Setor();
        if (!txtIdSetor.getText().isEmpty()) {
            Integer id = Integer.parseInt(txtIdSetor.getText());
            setor.setId(id);
        }
        SetorService service = new SetorService();
        JOptionPane.showMessageDialog(null, service.deleteSetor(setor));

        limparCampos();

    }//GEN-LAST:event_btnExcluirActionPerformed

    public DefaultTableModel carregaTabela(DefaultTableModel modelo) {
        SetorService service = new SetorService();
        modelo.setRowCount(0);
        for (Setor s : service.pesquisarSetores(txtPesquisar.getText())) {
            modelo.addRow(new Object[]{
                s.getId(),
                s.getNome()
            });
        }
        return modelo;
    }

    public void limparCampos() {
        txtIdSetor.setText("");
        txtNomeSetor.setText("");
        btnExcluir.setEnabled(false);
        DefaultTableModel modelo = (DefaultTableModel) jtSetores.getModel();
        carregaTabela(modelo);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jtSetores;
    private javax.swing.JLabel lblAvisos;
    private javax.swing.JTextPane txtIdSetor;
    private javax.swing.JTextPane txtNomeSetor;
    private javax.swing.JTextPane txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
