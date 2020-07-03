package pontoDeControle.view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import pontoDeControle.model.Funcionario;
import pontoDeControle.model.Horario;
import pontoDeControle.model.PermissaoUsuario;
import pontoDeControle.services.FuncionarioService;
import pontoDeControle.model.Setor;
import pontoDeControle.services.HorarioService;
import pontoDeControle.services.PermissaoUsuarioService;
import pontoDeControle.services.SetorService;

public class TelaFuncionario extends javax.swing.JInternalFrame {

    public TelaFuncionario() {
        initComponents();
        listarSetores();
        listarGestores();
        listarHorarios();
        listarPermissoes();
        formatarCampos();
    }

    public void formatarCampos() {
        try {
            MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
            maskCpf.install(txtCpfFunc);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar formatar CPF", "ERRO", JOptionPane.ERROR);
        }

    }

    public void listarSetores() {
        cbSetor.removeAllItems();
        cbSetor.addItem(" ");
        SetorService setorService = new SetorService();
        for (Setor s : setorService.listarTodosSetores()) {
            cbSetor.addItem(s.getNome());
        }
    }

    public void listarGestores() {
        cbGestor.removeAllItems();;
        cbGestor.addItem(" ");
        FuncionarioService service = new FuncionarioService();
        for (Funcionario f : service.listarGestores()) {
            cbGestor.addItem(f.getNome());
        }
    }

    public void listarPermissoes() {
        cbPermissao.removeAllItems();;
        PermissaoUsuarioService permissaoService = new PermissaoUsuarioService();
        for (PermissaoUsuario p : permissaoService.listarTodasAsPermissoes()) {
            cbPermissao.addItem(p.getNome());
        }
    }

    public void listarHorarios() {
        cbHorario.removeAllItems();
        HorarioService horarioService = new HorarioService();
        for (Horario h : horarioService.pesquisarHorarios()) {
            cbHorario.addItem(h.getDescricao());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblAvisos1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtIdFunc = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPesquisar = new javax.swing.JTextPane();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtFuncionarios = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtNomeFuncionario = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtUsuario = new javax.swing.JTextPane();
        cbSetor = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbGestor = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbIsGestor = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbHorario = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtEmail = new javax.swing.JTextPane();
        btnLimpar = new javax.swing.JButton();
        txtCpfFunc = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        cbPermissao = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Funcionários");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/pontoDeControle/icones/funcionarios.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(854, 632));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAvisos1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAvisos1.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(lblAvisos1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAvisos1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 860, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Setor:");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 50, 37));

        txtIdFunc.setEnabled(false);
        jScrollPane4.setViewportView(txtIdFunc);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 30, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Id:");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 30, 37));

        btnSalvar.setText("Salvar");
        btnSalvar.setToolTipText("Salva as alterações");
        btnSalvar.setName("btnSalvar"); // NOI18N
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 110, 30));

        btnExcluir.setToolTipText("Salva as alterações");
        btnExcluir.setEnabled(false);
        btnExcluir.setLabel("Excluir");
        btnExcluir.setName("btnExcluir"); // NOI18N
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 110, 30));

        jScrollPane1.setName("txtPesquisar"); // NOI18N

        txtPesquisar.setName("txtNomeSetor"); // NOI18N
        jScrollPane1.setViewportView(txtPesquisar);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 433, -1));

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, -1, -1));

        jtFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "É gestor?", "Gestor", "Setor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtFuncionarios);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 800, 280));

        txtNomeFuncionario.setName("txtNomeFuncionario"); // NOI18N
        jScrollPane5.setViewportView(txtNomeFuncionario);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 433, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nome:");
        jLabel4.setToolTipText("");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 50, 37));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Usuário:");
        jLabel5.setToolTipText("");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 50, 37));

        txtUsuario.setName("txtNomeFuncionario"); // NOI18N
        jScrollPane6.setViewportView(txtUsuario);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 433, -1));

        getContentPane().add(cbSetor, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 150, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Cpf:");
        jLabel6.setToolTipText("");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 50, 37));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("É Gestor?");
        jLabel7.setToolTipText("");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 60, 37));

        getContentPane().add(cbGestor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 340, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Gestor:");
        jLabel8.setToolTipText("");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 50, 37));

        cbIsGestor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não", " " }));
        getContentPane().add(cbIsGestor, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 140, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Horário:");
        jLabel9.setToolTipText("");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 50, 37));

        getContentPane().add(cbHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 340, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("E-mail:");
        jLabel10.setToolTipText("");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 50, 37));

        txtEmail.setName("txtNomeFuncionario"); // NOI18N
        jScrollPane7.setViewportView(txtEmail);

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 433, -1));

        btnLimpar.setText("Limpar campos");
        btnLimpar.setToolTipText("Salva as alterações");
        btnLimpar.setName("btnSalvar"); // NOI18N
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 130, 30));
        getContentPane().add(txtCpfFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 150, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Permissão:");
        jLabel11.setToolTipText("");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 80, 37));

        getContentPane().add(cbPermissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, 130, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Funcionario funcionario = new Funcionario();

        if (!txtNomeFuncionario.getText().isEmpty() && !txtCpfFunc.getText().isEmpty()) {
            int input = JOptionPane.showConfirmDialog(null, "Deseja salvar o funcionário?");
            if (input == 0) {
                funcionario.setNome(txtNomeFuncionario.getText());
                funcionario.setCpf(txtCpfFunc.getText());
                funcionario.setUsuarioSistema(txtUsuario.getText());
                funcionario.setEmail(txtEmail.getText());
                if (cbIsGestor.getSelectedItem().toString().equals("Não")) {
                    funcionario.setIdGestor(pegarIdGestor());
                }
                funcionario.setIdSetor(pegarIdSetor());
                funcionario.setIdHorario(pegarIdHorario());
                funcionario.setIsGestor(cbIsGestor.getSelectedItem().toString().equals("Sim") ? true : false);

                if (!txtIdFunc.getText().isEmpty()) {
                    Integer id = Integer.parseInt(txtIdFunc.getText());
                    funcionario.setId(id);
                }
                funcionario.setIdPermsissao(pegarIdPermissao());
                FuncionarioService service = new FuncionarioService();
                JOptionPane.showMessageDialog(null, service.salvar(funcionario));
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
        }

        limparCampos();

    }//GEN-LAST:event_btnSalvarActionPerformed

    private int pegarIdSetor() {
        SetorService setorService = new SetorService();
        int idSetor = 0;
        if (cbSetor.getSelectedIndex() != 0) {
            for (Setor s : setorService.pesquisarSetores(cbSetor.getSelectedItem().toString())) {
                idSetor = s.getId();
            }
        }
        return idSetor;
    }

    private int pegarIdGestor() {
        FuncionarioService service = new FuncionarioService();
        int idGestor = 0;
        for (Funcionario f : service.listarFuncionarios(cbGestor.getSelectedItem().toString())) {
            idGestor = f.getId();

        }
        return idGestor;
    }

    private int pegarIdHorario() {
        HorarioService horarioService = new HorarioService();
        int idHorario = 0;
        for (Horario h : horarioService.pesquisarHorariosPelaDescricao(cbHorario.getSelectedItem().toString())) {
            idHorario = h.getId();
        }
        return idHorario;
    }

    private int pegarIdPermissao() {
        PermissaoUsuarioService permissaoService = new PermissaoUsuarioService();
        int idPermissao = 0;
        return idPermissao = permissaoService.pegarIdPermissao(cbPermissao.getSelectedItem().toString());

    }
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        FuncionarioService service = new FuncionarioService();
        if (!txtIdFunc.getText().isEmpty()) {
            int input = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir o funcionário?");
            if (input == 0) {
                Integer id = Integer.parseInt(txtIdFunc.getText());
                JOptionPane.showMessageDialog(null, service.excluir(id));
            }

        }
        limparCampos();

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jtFuncionarios.getModel();
        carregaTabela(modelo);
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void jtFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtFuncionariosMouseClicked
        btnExcluir.setEnabled(true);

        FuncionarioService service = new FuncionarioService();
        Funcionario funcionarioDados = new Funcionario();

        int row = jtFuncionarios.getSelectedRow();
        String id = jtFuncionarios.getValueAt(row, 0).toString();
        int idFunc = Integer.parseInt(id);

        funcionarioDados = service.getFuncionarioById(idFunc);

        txtIdFunc.setText(id);
        txtNomeFuncionario.setText(funcionarioDados.getNome());
        txtUsuario.setText(funcionarioDados.getUsuarioSistema());
        cbSetor.setSelectedItem(funcionarioDados.getNomeSetor());
        cbGestor.setSelectedItem(funcionarioDados.getNomeGestor());
        cbIsGestor.setSelectedItem(funcionarioDados.isIsGestor() ? "Sim" : "Não");
        cbHorario.setSelectedItem(funcionarioDados.getDescricaoHorario());
        txtCpfFunc.setText(funcionarioDados.getCpf());
        txtEmail.setText(funcionarioDados.getEmail());
        cbPermissao.setSelectedItem(funcionarioDados.getNomePermissao());
    }//GEN-LAST:event_jtFuncionariosMouseClicked

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    public void limparCampos() {

        txtIdFunc.setText("");
        txtNomeFuncionario.setText("");
        txtCpfFunc.setText("");
        txtEmail.setText("");
        txtPesquisar.setText("");
        txtUsuario.setText("");
        cbGestor.setSelectedIndex(0);
        cbIsGestor.setSelectedItem("Não");
        cbSetor.setSelectedIndex(0);
        cbPermissao.setSelectedIndex(0);
        DefaultTableModel modelo = (DefaultTableModel) jtFuncionarios.getModel();
        carregaTabela(modelo);

    }

    public DefaultTableModel carregaTabela(DefaultTableModel modelo) {
        FuncionarioService service = new FuncionarioService();
        modelo.setRowCount(0);
        for (Funcionario f : service.listarFuncionarios(txtPesquisar.getText())) {
            modelo.addRow(new Object[]{
                f.getId(),
                f.getNome(),
                f.isIsGestor() ? "Sim" : "Não",
                f.getNomeGestor(),
                f.getNomeSetor()
            });
        }
        return modelo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbGestor;
    private javax.swing.JComboBox<String> cbHorario;
    private javax.swing.JComboBox<String> cbIsGestor;
    private javax.swing.JComboBox<String> cbPermissao;
    private javax.swing.JComboBox<String> cbSetor;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jtFuncionarios;
    private javax.swing.JLabel lblAvisos1;
    private javax.swing.JFormattedTextField txtCpfFunc;
    private javax.swing.JTextPane txtEmail;
    private javax.swing.JTextPane txtIdFunc;
    private javax.swing.JTextPane txtNomeFuncionario;
    private javax.swing.JTextPane txtPesquisar;
    private javax.swing.JTextPane txtUsuario;
    // End of variables declaration//GEN-END:variables
}
