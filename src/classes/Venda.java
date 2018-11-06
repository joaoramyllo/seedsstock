/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


import java.sql.Date;
import java.util.regex.Pattern;

/**
 *
 * @author Douglas
 */
public class Venda {
    
    private int idVenda;
    private Date dataVenda;
    private float valorTotal;
    private int quantidade;
    private String sementes;

    public Venda() {
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getSementes() {
        return sementes;
    }

    public void setSementes(String sementes) {
        this.sementes = sementes;
    }
    
}
