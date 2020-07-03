
package pontoDeControle.view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pontoDeControle.model.Horario;
import pontoDeControle.services.HorarioService;


public class TelaHorario extends javax.swing.JInternalFrame {


    public TelaHorario() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jtHorarios.getModel();
        carregaTabela(modelo);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtQtdHoras = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtIdHorario = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        lblAvisos = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbNoturno = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbInativo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtDescricao = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtHorarios = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Horários");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/pontoDeControle/icones/horario.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(854, 632));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalvar.setText("Salvar");
        btnSalvar.setToolTipText("Salva as alterações");
        btnSalvar.setName("btnSalvar"); // NOI18N
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 110, 30));

        btnExcluir.setToolTipText("Salva as alterações");
        btnExcluir.setEnabled(false);
        btnExcluir.setLabel("Excluir");
        btnExcluir.setName("btnExcluir"); // NOI18N
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 110, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Descrição:");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 80, 37));

        txtQtdHoras.setName("txtQtdHoras"); // NOI18N
        jScrollPane2.setViewportView(txtQtdHoras);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 80, -1));

        txtIdHorario.setEnabled(false);
        jScrollPane4.setViewportView(txtIdHorario);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 20, -1));

        lblAvisos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAvisos.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(lblAvisos, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAvisos, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 800, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("ID:");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 30, 37));

        cbNoturno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));
        getContentPane().add(cbNoturno, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Inativo:");
        jLabel4.setToolTipText("");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 60, 37));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Noturno:");
        jLabel5.setToolTipText("");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 150, 37));

        cbInativo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));
        getContentPane().add(cbInativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Quantidade de horas:");
        jLabel6.setToolTipText("");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 150, 37));

        jtxtDescricao.setColumns(20);
        jtxtDescricao.setRows(5);
        jScrollPane1.setViewportView(jtxtDescricao);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 380, -1));

        jtHorarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Quantidade Horas", "Noturno", "Inativo", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtHorarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtHorariosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtHorarios);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 820, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Horario horario = new Horario();
        if (!txtQtdHoras.getText().isEmpty()) {
            float qtdHoras = Float.parseFloat(txtQtdHoras.getText());
            horario.setQtdHoras(qtdHoras);
            horario.setDescricao(jtxtDescricao.getText());
            String inativo = cbInativo.getSelectedItem().toString();
            horario.setInativo(inativo.equals("Sim") ? true : false);
            String nortuno = cbNoturno.getSelectedItem().toString();
            horario.setNortuno(nortuno.equals("Sim") ? true : false);

            if (!txtIdHorario.getText().isEmpty()) {
                Integer id = Integer.parseInt(txtIdHorario.getText());
                horario.setId(id);
            }

            HorarioService service = new HorarioService();
            JOptionPane.showMessageDialog(null, service.inserirHorario(horario));

        }
        limparCampos();

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void limparCampos() {
        jtxtDescricao.setText("");
        cbInativo.setSelectedItem("Não");
        cbNoturno.setSelectedItem("Não");
        txtIdHorario.setText("");
        txtQtdHoras.setText("");
        lblAvisos.setText("");
        DefaultTableModel modelo = (DefaultTableModel) jtHorarios.getModel();
        carregaTabela(modelo);
    }
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        Horario horario = new Horario();
        if (!txtIdHorario.getText().isEmpty()) {
            Integer id = Integer.parseInt(txtIdHorario.getText());
            horario.setId(id);
        }
        HorarioService horarioService = new HorarioService();
        JOptionPane.showMessageDialog(null, horarioService.deleteHorario(horario));
        limparCampos();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jtHorariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtHorariosMouseClicked
        btnExcluir.setEnabled(true);
        int row = jtHorarios.getSelectedRow();
        Object id = jtHorarios.getValueAt(row, 0);
        txtIdHorario.setText(String.valueOf(id));
        Object qtdHoras = jtHorarios.getValueAt(row, 1);
        txtQtdHoras.setText(String.valueOf(qtdHoras));
        Object nortuno = jtHorarios.getValueAt(row, 2);
        cbNoturno.setSelectedItem(String.valueOf(nortuno));
        Object inativo = jtHorarios.getValueAt(row, 3);
        cbInativo.setSelectedItem(String.valueOf(inativo));
        Object descricao = jtHorarios.getValueAt(row, 4);
        jtxtDescricao.setText(String.valueOf(descricao));
    }//GEN-LAST:event_jtHorariosMouseClicked

    public DefaultTableModel carregaTabela(DefaultTableModel modelo) {
        HorarioService service = new HorarioService();
        modelo.setRowCount(0);
        for (Horario h : service.pesquisarHorarios()) {

            modelo.addRow(new Object[]{
                h.getId(),
                h.getQtdHoras(),
                h.isNortuno() == true ? "Sim" : "Não",
                h.isInativo() == true ? "Sim" : "Não",
                h.getDescricao()
            });
        }
        return modelo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbInativo;
    private javax.swing.JComboBox<String> cbNoturno;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jtHorarios;
    private javax.swing.JTextArea jtxtDescricao;
    private javax.swing.JLabel lblAvisos;
    private javax.swing.JTextPane txtIdHorario;
    private javax.swing.JTextPane txtQtdHoras;
    // End of variables declaration//GEN-END:variables
}
