package trabalho;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class Acto implements Serializable {
    private String id_acto;
    private String id_utente;
    private String id_profissional;
    private LocalDate data_acto;
    private String descricao;


    public Acto(String id_utente, String id_profissional, LocalDate data_acto, String descricao) {
        this.id_acto  = UUID.randomUUID().toString();
        this.id_utente = id_utente;
        this.id_profissional = id_profissional;
        this.data_acto = data_acto;
        this.descricao = descricao;

    }

    public String getId() {
        return id_acto;
    }
    public void setId(String id) {
        this.id_acto = id;
    }
    public String getId_utente() {
        return id_utente;
    }
    public void setId_utente(String id_utente) {
        this.id_utente = id_utente;
    }
    public String getId_profissional() {
        return id_profissional;
    }
    public void setId_profissional(String id_profissional) {
        this.id_profissional = id_profissional;
    }
    public LocalDate getData_acto() {
        return data_acto;
    }
    public void setData_acto(LocalDate data_acto) {
        this.data_acto = data_acto;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Acto{" +
                "id do acto='" + id_acto + '\'' +
                "id do profissional='" + id_profissional + '\'' +
                "id do utente='" + id_utente + '\'' +
                "data do acto='" + data_acto + '\'' +
                ", descricao do acto='" + descricao + '\'' +
                '}';
    }

}
