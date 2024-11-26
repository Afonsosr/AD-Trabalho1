package trabalho;

import java.io.Serializable;
import java.util.UUID;

public class Farmaceutico implements Serializable {
    private String id;
    private String nome;
    private String telefone;


    public Farmaceutico(String nome, String telefone) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.telefone = telefone;

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
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String toString() {
        return "Farmaceutico{" +
                "id='" + id + '\'' +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

}



