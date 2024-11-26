package trabalho;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class Utente implements Serializable {
    private String id;
    private String nome;
    private String genero;
    private LocalDate dataNascimento;
    private ArrayList<String> medicacao;
    private ArrayList<String> condicoes;

    public Utente(String nome, String genero, LocalDate dataNascimento, ArrayList<String> medicacao, ArrayList<String> condicoes) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.medicacao = medicacao;
        this.condicoes = condicoes;
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
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public ArrayList<String> getMedicacao() {
        return medicacao;
    }
    public void setMedicacao(ArrayList<String> medicacao) {
        this.medicacao = medicacao;
    }
    public ArrayList<String> getCondicoes() {
        return condicoes;
    }
    public void setCondicoes(ArrayList<String> condicoes) {
        this.condicoes = condicoes;
    }

    public String toString() {
        return "Utente{" +
                "id='" + id + '\'' +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", medicacao=" + medicacao +
                ", condicoes=" + condicoes +
                '}';
    }


}