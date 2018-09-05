/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelas;


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
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Douglas
 */
public class TelaBuscarImprimir extends javax.swing.JInternalFrame {

    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();

    public void setPosition() {
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 6);
    }

    /**
     * Creates new form TelaBuscarImprimir
     */
    // ArrayList<Semente> arraySementes = new ArrayList();
    DefaultTableModel dtmSemente;
    //ArrayList<Semente> arrayF_aux;

    public TelaBuscarImprimir() {
        initComponents();


        setTitle("Buscar Sementes");
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

        jButton1 = new javax.swing.JButton();

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Exit.png"))); // NOI18N
        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(709, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(528, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed
/*    */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables

    
}
/*
 public void carregaArray() throws ClassNotFoundException {
        Connection con = MakeConnection.getConnection();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        int cont = 0;

       // sementeDAO sDao = new sementeDAO();
        try {
            stmt = con.prepareStatement("SELECT * FROM sementes ORDER BY nome ASC");
            rs = stmt.executeQuery();

            arraySementes.clear();
            while (rs.next()) {
                /////////////////////////////////
                Semente semente = new Semente();
                ///////////////////////////////////
                semente.setIdsemente(rs.getInt("idsemente"));
                semente.setNome(rs.getString("nome"));
                semente.setEspecie(rs.getString("especie"));
                semente.setQuant(rs.getInt("quant"));
                semente.setRaridade(rs.getString("raridade"));
                semente.setDia_col(rs.getInt("dia_col"));
                semente.setMes_col(rs.getInt("mes_col"));
                semente.setAno_col(rs.getInt("ano_col"));
                semente.setDia_val(rs.getInt("dia_val"));
                semente.setMes_val(rs.getInt("mes_val"));
                semente.setAno_val(rs.getInt("ano_val"));

                semente.setPreco_compra(rs.getFloat("preco_compra"));
                semente.setPreco_venda(rs.getFloat("preco_venda"));

                semente.setOrigem(rs.getString("origem"));
                semente.setFornecedor(rs.getString("fornecedor"));
                semente.setCondicoes_plantil(rs.getString("condicoes_plantil"));
                semente.setObservacoes(rs.getString("observacoes"));

                arraySementes.add(semente);

                //Preenchendo tabela
            }

        } catch (SQLException ex) {
            Logger.getLogger(SementeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MakeConnection.closeConnection(con, stmt, rs);
        }
        // return arraySemente;
    }

 public void carregaTabela() {
        DefaultTableModel dtmBusca;

        String[] colunas = {"Id Semente", "Nome", "Espécie", "Preço Venda", "Preço Compra"};
        String[] linha = new String[5];

        dtmBusca = new DefaultTableModel(null, colunas);

        //String sql = "SELECT * FROM sementes";
        String sql = "SELECT * FROM sementes ORDER BY nome ASC";

        dtmBusca = new DefaultTableModel(null, colunas);

        Connection con = null;
        try {
            con = MakeConnection.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteTabela.class.getName()).log(Level.SEVERE, null, ex);
        }

        Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                linha[0] = rs.getString("idsemente");
                linha[1] = rs.getString("nome");
                linha[2] = rs.getString("especie");
                linha[3] = rs.getString("preco_compra");
                linha[4] = rs.getString("preco_venda");
                dtmBusca.addRow(linha);
            }
            jTable1.setModel(dtmBusca);
            dtmBusca.fireTableDataChanged();
        } catch (SQLException ex) {
            //  Logger.getLogger(dtmBusca.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

 public void carregaArraySorter() throws ClassNotFoundException {
        Connection con = MakeConnection.getConnection();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        int cont = 0;
        //List<Pessoa> pessoasSql = new ArrayList<>();
        SementeDAO sDao = new SementeDAO();
        try {
            stmt = con.prepareStatement("SELECT * FROM sementes where nome LIKE '%" + jTextField1.getText() + "%' ORDER BY nome ASC");
            rs = stmt.executeQuery();

            arraySementes.clear();
            while (rs.next()) {
                /////////////////////////////////
                Semente semente = new Semente();
                ///////////////////////////////////
                semente.setIdsemente(rs.getInt("idsemente"));
                semente.setNome(rs.getString("nome"));
                semente.setEspecie(rs.getString("especie"));
                semente.setQuant(rs.getInt("quant"));
                semente.setRaridade(rs.getString("raridade"));
                semente.setDia_col(rs.getInt("dia_col"));
                semente.setMes_col(rs.getInt("mes_col"));
                semente.setAno_col(rs.getInt("ano_col"));
                semente.setDia_val(rs.getInt("dia_val"));
                semente.setMes_val(rs.getInt("mes_val"));
                semente.setAno_val(rs.getInt("ano_val"));

                semente.setPreco_compra(rs.getFloat("preco_compra"));
                semente.setPreco_venda(rs.getFloat("preco_venda"));

                semente.setOrigem(rs.getString("origem"));
                semente.setFornecedor(rs.getString("fornecedor"));
                semente.setCondicoes_plantil(rs.getString("condicoes_plantil"));
                semente.setObservacoes(rs.getString("observacoes"));

                arraySementes.add(semente);

                //Preenchendo tabela
            }

        } catch (SQLException ex) {
            Logger.getLogger(SementeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MakeConnection.closeConnection(con, stmt, rs);
        }
        // return arraySemente;
    }

 public void sorterTabelaBusca() {

        try {
            carregaArraySorter();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteTabela.class.getName()).log(Level.SEVERE, null, ex);
        }

        DefaultTableModel dtmBusca;

        String[] colunas = {"Id Semente", "Nome", "Espécie", "Preço Venda", "Preço Compra"};
        String[] linha = new String[5];

        dtmBusca = new DefaultTableModel(null, colunas);
        for (int i = 0; i < arraySementes.size(); i++) {
            linha[0] = Integer.toString(arraySementes.get(i).getIdsemente());
            linha[1] = arraySementes.get(i).getNome();
            linha[2] = arraySementes.get(i).getEspecie();
            linha[3] = Float.toString(arraySementes.get(i).getPreco_compra());
            linha[4] = Float.toString(arraySementes.get(i).getPreco_venda());
            dtmBusca.addRow(linha);
        }
        jTable1.setModel(dtmBusca);
        dtmBusca.fireTableDataChanged();

    }
}                   */