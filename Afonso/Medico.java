package trabalho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Medico implements Serializable {
    private String id;
    private String nome;
    private String telefone;
    private String especialidade;

    public Medico(String nome, String telefone, String especialidade) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.telefone = telefone;
        this.especialidade = especialidade;
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
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    public String getEspecialidade() {
        return especialidade;
    }


    @Override
    public String toString() {
        return "Médico{" +
                "id='" + id + '\'' +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", especialidade=" + especialidade +
                '}';
    }

}