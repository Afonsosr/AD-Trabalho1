package Trabalho;

import java.io.Serializable;
import java.util.UUID;

public class Medicamento implements Serializable {
    private String id;
    private String nome;
    private String fornecedor;
    private Integer stock;

    // Construtor com nome, fornecedor e stock, com ID gerado automaticamente
    public Medicamento(String nome, String fornecedor, Integer stock) {
        this.id = UUID.randomUUID().toString(); // Gera automaticamente o ID
        this.nome = nome;
        this.fornecedor = fornecedor;
        this.stock = stock;
    }

    // Construtor alternativo sem o parâmetro de stock
    public Medicamento(String nome, String fornecedor) {
        this.id = UUID.randomUUID().toString(); // Gera automaticamente o ID
        this.nome = nome;
        this.fornecedor = fornecedor;
        this.stock = 0;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public String getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", fornecedor='" + fornecedor + '\'' +
                ", stock=" + stock +
                '}';
    }
}
