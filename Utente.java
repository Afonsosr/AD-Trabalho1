import java.awt.*;
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

    public Utente(String id, String nome, String genero, LocalDate dataNascimento,  String medicacao) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.medicacao = new ArrayList<>();
    }

    public Utente() {
        this.id = UUID.randomUUID().toString();
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

    @Override
    public String toString() {
        return "Contacto{" +
                "id='" + id + '\'' +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", medicacao=" + medicacao +
                '}';
    }

}


