/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelas;

import DAO.FornecedorDAO;
import DAO.SementeDAO;
import DAO.VendaDAO;
import classes.Fornecedor;
import classes.Semente;
import conection.MakeConnection;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import classes.Venda;

/**
 *
 * @author Douglas
 */
public class TelaVenderSemente extends javax.swing.JInternalFrame {
    
    float totalVendas = 0;
    int quantidade = 0;
    ArrayList<String> listaVenda = new ArrayList();
    ////////////////////////////////////////////////
    
    DefaultTableModel dtmVenda;
    ArrayList<Semente> arraySemente;

    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();

    public void setPosition() {
        this.setLocation((d.width - this.getSize().width) /2, (d.height - this.getSize().height) / 6);
    }

    /**
     * Creates new form TelaVenderSemente
     * 
     
     */
    
    public TelaVenderSemente() {
        initComponents();
        
        try {
            CarregaTabela("SELECT * FROM sementes ORDER by nome ASC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaVenderSemente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setTitle("Vender Sementes");
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

        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoPesquisaVendas = new javax.swing.JTextField();
        botaoAddAoCarrinho = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        campoQuantidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoTotalVenda = new javax.swing.JTextField();
        botaoFinalizarCompra = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVendas = new javax.swing.JTable();
        botaoZerarCarrinho = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        jLabel5.setText("jLabel5");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Search.png"))); // NOI18N
        jLabel1.setText("Pesquisar:");

        campoPesquisaVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPesquisaVendasActionPerformed(evt);
            }
        });
        campoPesquisaVendas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoPesquisaVendasKeyReleased(evt);
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
                .addComponent(campoPesquisaVendas)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoPesquisaVendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botaoAddAoCarrinho.setText("Adicionar ao carrinho");
        botaoAddAoCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAddAoCarrinhoActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Quantidade:");

        jLabel4.setText("Total da compra:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(campoTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        botaoFinalizarCompra.setText("Finalizar venda");
        botaoFinalizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFinalizarCompraActionPerformed(evt);
            }
        });

        jButton3.setText("Sair");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tabelaVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título 1", "Título 2", "Título 3", "Título 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaVendas);

        botaoZerarCarrinho.setText("Limpar carrinho ");
        botaoZerarCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoZerarCarrinhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoAddAoCarrinho)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoFinalizarCompra)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoZerarCarrinho))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(botaoAddAoCarrinho)
                                .addGap(8, 8, 8)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoFinalizarCompra)
                            .addComponent(botaoZerarCarrinho))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoFinalizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFinalizarCompraActionPerformed
        // TODO add your handling code here:
        finalizarVenda();
    }//GEN-LAST:event_botaoFinalizarCompraActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void campoPesquisaVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPesquisaVendasActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_campoPesquisaVendasActionPerformed

    private void botaoAddAoCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAddAoCarrinhoActionPerformed
        // TODO add your handling code here:
        try{
        //adicionarAoCarrinho();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Selecione um ítem para o carrinho", "Ação inválida", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_botaoAddAoCarrinhoActionPerformed

    private void botaoZerarCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoZerarCarrinhoActionPerformed
        // TODO add your handling code here:
        zerarCarrinho();
    }//GEN-LAST:event_botaoZerarCarrinhoActionPerformed

    private void campoPesquisaVendasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesquisaVendasKeyReleased
        // TODO add your handling code here:
        try {
            CarregaTabela("SELECT * FROM sementes where nome LIKE '%" + campoPesquisaVendas.getText() + "%' ORDER BY nome ASC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaGerirFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_campoPesquisaVendasKeyReleased

    
    public void CarregaTabela(String sql) throws ClassNotFoundException {

        String[] colunas = {"Id", "Nome", "Especie", "Preço", "Quantidade"};
        String[] linha = new String[5];

        dtmVenda = new DefaultTableModel(null, colunas);
        
        SementeDAO s = new SementeDAO();

        ArrayList<Semente> array = (ArrayList<Semente>) s.read(sql);

        arraySemente = array;

        for (int i = 0; i < array.size(); i++) {
            linha[0] = String.valueOf(array.get(i).getIdsemente());
            linha[1] = array.get(i).getNome();
            linha[2] = array.get(i).getEspecie();
            linha[3] = String.valueOf(array.get(i).getPreco_venda());
            linha[4] = String.valueOf(array.get(i).getQuant());
            dtmVenda.addRow(linha);
        }
      
        tabelaVendas.setModel(dtmVenda);
        dtmVenda.fireTableDataChanged();
    }
    
   /* public void adicionarAoCarrinho(){
        
        int qtdSementes = Integer.parseInt((arraySemente.get(tabelaVendas.getSelectedRow()).getQuant())); 
        
        if(qtdSementes == 0){
             JOptionPane.showMessageDialog(rootPane, "Impossível adicionar ao carrinho, não possue em estoque!");
        }else{
            totalVendas = totalVendas + Float.parseFloat((arraySemente.get(tabelaVendas.getSelectedRow()).getPreco_venda()));
            quantidade++;
            listaVenda.add(arraySemente.get(tabelaVendas.getSelectedRow()).getNome());
        
            campoTotalVenda.setText(String.valueOf(totalVendas));
            campoQuantidade.setText(String.valueOf(quantidade));
            
            qtdSementes--;
            
            tabelaVendas.setValueAt(qtdSementes, tabelaVendas.getSelectedRow(), 5);    
 
        }
        
    }*/
    
    public void zerarCarrinho(){
        
        totalVendas = 0;
        quantidade = 0;
        
        campoTotalVenda.setText("0");
        campoQuantidade.setText("0");
        
    }
    
    public void finalizarVenda(){
        
        String sementes = String.join(" ", listaVenda);
        String lista = String.join(" \n", listaVenda);
        
        Date data = new Date(System.currentTimeMillis());
        //SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date dataSql = new java.sql.Date(data.getTime());
        
        Venda v = new Venda();
        v.setQuantidade(Integer.parseInt(campoQuantidade.getText()));
        v.setValorTotal(Float.parseFloat(campoTotalVenda.getText()));
        v.setDataVenda(dataSql);
        v.setSementes(sementes);
        
        VendaDAO dao = new VendaDAO();
        
        try {
            int dialogButton = JOptionPane.YES_NO_OPTION;   
            int dialogResult = JOptionPane.showConfirmDialog(this,"Lista de compras:\n\n"+ lista, "Deseja confirma sua compra?", dialogButton);
            if(dialogResult == 0) {
                dao.salvar(v);
                JOptionPane.showMessageDialog(rootPane, "Venda realizada com Sucesso!");
   
            } else {
                JOptionPane.showMessageDialog(rootPane, "Venda cancelada!");
           } 
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaVenderSemente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TelaVenderSemente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAddAoCarrinho;
    private javax.swing.JButton botaoFinalizarCompra;
    private javax.swing.JButton botaoZerarCarrinho;
    private javax.swing.JTextField campoPesquisaVendas;
    private javax.swing.JTextField campoQuantidade;
    private javax.swing.JTextField campoTotalVenda;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaVendas;
    // End of variables declaration//GEN-END:variables
}





