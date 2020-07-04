package pontoDeControle.view;

import java.awt.Image;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import pontoDeControle.model.Funcionario;
import pontoDeControle.model.Hora;
import pontoDeControle.model.Horario;
import pontoDeControle.services.FuncionarioService;
import pontoDeControle.services.HoraService;
import pontoDeControle.services.HorarioService;
import pontoDeControle.threads.ControleDeAtividade;

public class TelaPrincipal extends javax.swing.JFrame {

    public static String horaInicial = null;
    public Funcionario usuario;

    public TelaPrincipal(String horaInicial, Funcionario usuario) {
        initComponents();
        this.horaInicial = horaInicial;
        this.usuario = usuario;
        lblInicio.setText(horaInicial);
        if (usuario.getIdPermsissao() == 1 || usuario.getIdPermsissao() == 3) {
            menuFuncionario.setEnabled(true);
            menuHorarios.setEnabled(true);
            menuRelatórios.setEnabled(true);
            menuSetor.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dskPrincipal = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        lblInicio = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFuncionario = new javax.swing.JMenu();
        menuFuncionarioCadastrar = new javax.swing.JMenuItem();
        menuSetor = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuHorarios = new javax.swing.JMenu();
        menuHorariosCadastrar = new javax.swing.JMenuItem();
        menuRelatórios = new javax.swing.JMenu();
        menuRelatoriosHoras = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bem vindo");
        setPreferredSize(new java.awt.Dimension(1114, 769));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        dskPrincipal.setName("dskPrincipal"); // NOI18N

        javax.swing.GroupLayout dskPrincipalLayout = new javax.swing.GroupLayout(dskPrincipal);
        dskPrincipal.setLayout(dskPrincipalLayout);
        dskPrincipalLayout.setHorizontalGroup(
            dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 854, Short.MAX_VALUE)
        );
        dskPrincipalLayout.setVerticalGroup(
            dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("HORA INICIAL:");

        lblInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        menuFuncionario.setText("Funcionario");
        menuFuncionario.setEnabled(false);

        menuFuncionarioCadastrar.setText("Cadastrar");
        menuFuncionarioCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFuncionarioCadastrarActionPerformed(evt);
            }
        });
        menuFuncionario.add(menuFuncionarioCadastrar);

        jMenuBar1.add(menuFuncionario);

        menuSetor.setText("Setor");
        menuSetor.setToolTipText("Seção para editar e cadastrar setores.");
        menuSetor.setEnabled(false);
        menuSetor.setName("menuSetor"); // NOI18N

        jMenuItem1.setText("Cadastrar");
        jMenuItem1.setName("menuSetorCadastrar"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuSetor.add(jMenuItem1);

        jMenuBar1.add(menuSetor);

        menuHorarios.setText("Horários");
        menuHorarios.setEnabled(false);

        menuHorariosCadastrar.setText("Cadastrar");
        menuHorariosCadastrar.setToolTipText("");
        menuHorariosCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHorariosCadastrarActionPerformed(evt);
            }
        });
        menuHorarios.add(menuHorariosCadastrar);

        jMenuBar1.add(menuHorarios);

        menuRelatórios.setText("Relatórios");
        menuRelatórios.setEnabled(false);

        menuRelatoriosHoras.setText("Horas");
        menuRelatoriosHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatoriosHorasActionPerformed(evt);
            }
        });
        menuRelatórios.add(menuRelatoriosHoras);

        jMenuBar1.add(menuRelatórios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dskPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dskPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 91, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        TelaSetor telaSetor = new TelaSetor();
        telaSetor.setVisible(true);
        dskPrincipal.add(telaSetor);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menuFuncionarioCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFuncionarioCadastrarActionPerformed
        TelaFuncionario telaFuncionario = new TelaFuncionario();
        telaFuncionario.setVisible(true);
        dskPrincipal.add(telaFuncionario);
    }//GEN-LAST:event_menuFuncionarioCadastrarActionPerformed

    private void menuHorariosCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHorariosCadastrarActionPerformed
        TelaHorario telaHorario = new TelaHorario();
        telaHorario.setVisible(true);
        dskPrincipal.add(telaHorario);
    }//GEN-LAST:event_menuHorariosCadastrarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        programarParaFecharOSitema();
    }//GEN-LAST:event_formWindowOpened

    private void menuRelatoriosHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatoriosHorasActionPerformed
        TelaPlanilhaFuncionario telaPlanilhaFuncionario = new TelaPlanilhaFuncionario();
        telaPlanilhaFuncionario.setVisible(true);
        dskPrincipal.add(telaPlanilhaFuncionario);
    }//GEN-LAST:event_menuRelatoriosHorasActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
/**
        HoraService service = new HoraService();
        Hora hora = new Hora();
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String horaFinal = formatter.format(data);
        hora.setHoraFinal(horaFinal);
        hora.setIdFunc(usuario.getId());
        int fechar = service.updateHora(hora);
        if(fechar == 1){
            System.exit(0);
        }
        */
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void programarParaFecharOSitema() {
        String usuarioNome = System.getProperty("user.name");
        Funcionario usuario = new Funcionario();
        FuncionarioService service = new FuncionarioService();
        usuario = service.getFuncionarioByUsuario(usuarioNome);
        Horario horario = new Horario();
        HorarioService horarioService = new HorarioService();
        horario = horarioService.getHorarioById(usuario.getIdHorario());
        ControleDeAtividade controleDeAtividade = new ControleDeAtividade(horario.getQtdHoras());

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dskPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JMenu menuFuncionario;
    private javax.swing.JMenuItem menuFuncionarioCadastrar;
    private javax.swing.JMenu menuHorarios;
    private javax.swing.JMenuItem menuHorariosCadastrar;
    private javax.swing.JMenuItem menuRelatoriosHoras;
    private javax.swing.JMenu menuRelatórios;
    private javax.swing.JMenu menuSetor;
    // End of variables declaration//GEN-END:variables
}
