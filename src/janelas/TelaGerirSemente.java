/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelas;

import DAO.FornecedorDAO;
import DAO.SementeDAO;
import classes.Fornecedor;
import classes.Semente;
import conection.MakeConnection;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jframes.TesteTabela;

/**
 *
 * @author Douglas
 */
public class TelaGerirSemente extends javax.swing.JInternalFrame {
    

    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();

    public void setPosition() {
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 6);
    }

    /**
     * Creates new form TelaGerirFornecedor
     */
    DefaultTableModel dtmSemente;
    ArrayList<Semente> arraySemente;

    public TelaGerirSemente() {
       
        initComponents();

        try {
            CarregaTabela("SELECT * FROM sementes ORDER by nome ASC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaGerirSemente.class.getName()).log(Level.SEVERE, null, ex);
        }

        setTitle("Gerenciar Sementes");

        setBounds(100, 100, 800, 600);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoBuscaSemente = new javax.swing.JTextField();
        botaoAlterarSemente = new javax.swing.JButton();
        botaoApagarSemente = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaSementesGeral = new javax.swing.JTable();

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Search.png"))); // NOI18N
        jLabel1.setText("Pesquisar:");

        campoBuscaSemente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscaSementeKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoBuscaSemente)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoBuscaSemente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botaoAlterarSemente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Modify.png"))); // NOI18N
        botaoAlterarSemente.setText("Alterar");
        botaoAlterarSemente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoAlterarSementeMouseClicked(evt);
            }
        });
        botaoAlterarSemente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAlterarSementeActionPerformed(evt);
            }
        });

        botaoApagarSemente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Delete.png"))); // NOI18N
        botaoApagarSemente.setText("Excluir");
        botaoApagarSemente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoApagarSementeActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Exit.png"))); // NOI18N
        jButton3.setText("Fechar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tabelaSementesGeral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelaSementesGeral);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoAlterarSemente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoApagarSemente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAlterarSemente)
                    .addComponent(botaoApagarSemente)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void campoBuscaSementeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscaSementeKeyReleased
        // TODO add your handling code here:
        //
        try {
            CarregaTabela("SELECT * FROM sementes where nome LIKE '%" + campoBuscaSemente.getText() + "%' ORDER BY nome ASC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaGerirSemente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_campoBuscaSementeKeyReleased

    private void botaoApagarSementeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoApagarSementeActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:

        int i = JOptionPane.showConfirmDialog(null, "Deseja realmente REMOVER (" + arraySemente.get(tabelaSementesGeral.getSelectedRow()).getNome() + ") do Sistema?", "Excluir", JOptionPane.OK_OPTION);
        if (i == 0) {
            
          
            SementeDAO sdao = new SementeDAO();

            try {
                boolean excluir = sdao.excluir(arraySemente.get(tabelaSementesGeral.getSelectedRow()).getIdsemente());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TelaGerirSemente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            dtmSemente.removeRow(tabelaSementesGeral.getSelectedRow());
            dtmSemente.fireTableDataChanged();

        }
    }//GEN-LAST:event_botaoApagarSementeActionPerformed

    private void botaoAlterarSementeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarSementeActionPerformed
        // TODO add your handling code here:
        PainelAlterarSemente alterar = new PainelAlterarSemente(arraySemente.get(tabelaSementesGeral.getSelectedRow()));
        alterar.setVisible(true);

    }//GEN-LAST:event_botaoAlterarSementeActionPerformed

    private void botaoAlterarSementeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoAlterarSementeMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_botaoAlterarSementeMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAlterarSemente;
    private javax.swing.JButton botaoApagarSemente;
    private javax.swing.JTextField campoBuscaSemente;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaSementesGeral;
    // End of variables declaration//GEN-END:variables

    public void CarregaTabela(String sql) throws ClassNotFoundException {

        String[] colunas = {"Id", "Nome", "Especie", "Preço", "Quantidade"};
        String[] linha = new String[5];

        dtmSemente = new DefaultTableModel(null, colunas);
        
        SementeDAO s = new SementeDAO();

        ArrayList<Semente> array = (ArrayList<Semente>) s.read(sql);

        arraySemente = array;

        for (int i = 0; i < array.size(); i++) {
            linha[0] = String.valueOf(array.get(i).getIdsemente());
            linha[1] = array.get(i).getNome();
            linha[2] = array.get(i).getEspecie();
            linha[3] = String.valueOf(array.get(i).getPreco_venda());
            linha[4] = String.valueOf(array.get(i).getQuant());
            dtmSemente.addRow(linha);
        }
      
        tabelaSementesGeral.setModel(dtmSemente);
        dtmSemente.fireTableDataChanged();
    }

}