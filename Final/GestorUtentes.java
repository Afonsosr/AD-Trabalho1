package trabalho;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorUtentes extends UnicastRemoteObject implements APIGestorUtentes, Serializable {

    private Map<String, Utente> utentes;


    public GestorUtentes() throws RemoteException {
        super();
        utentes = new HashMap<>();
    }

    public void createUtente(String nome, String genero, LocalDate dataNascimento, ArrayList<String> medicacao, ArrayList<String> condicoes) {
        Utente nu = new Utente(nome, genero, dataNascimento, medicacao, condicoes);
        utentes.put(nu.getId(), nu);
    }

    public Utente getUtente(String id) {return utentes.get(id);}

    public List<String> procuraUtente(String nome) {
        List<String> res = new ArrayList<>();
        for(Utente u : this.utentes.values()) {
            if (u.getNome().contains(nome)) {
                res.add(u.getId());
            }
        }
        return res;
    }

    public int totalUtentes() {
        return utentes.size();
    }

    public Map<String, Integer> getAgeDistribution() {
        Map<String, Integer> distribution = new HashMap<>();
        LocalDate currentDate = LocalDate.now(); // Obtém a data atual

        for (Utente u : this.utentes.values()) {
            int idade = calculateAge(u.getDataNascimento(), currentDate); // Calcula a idade
            String faixaEtaria = getFaixaEtaria(idade);
            distribution.put(faixaEtaria, distribution.getOrDefault(faixaEtaria, 0) + 1);
        }
        return distribution;
    }

    // Calcula a idade com base na data de nascimento e na data atual
    private int calculateAge(LocalDate dataNascimento, LocalDate currentDate) {
        return Period.between(dataNascimento, currentDate).getYears();
    }
    private String getFaixaEtaria(int idade) {
        if (idade < 18) return "<18 anos";
        else if (idade < 30) return "18-30 anos";
        else if (idade < 60) return "30-60 anos";
        else return ">60 anos";
    }

    public Map<String, Integer> getGenderDistribution() {
        Map<String, Integer> distribution = new HashMap<>();
        for (Utente u : this.utentes.values()) {
            String genero = u.getGenero(); // Assume-se que o método `getGenero()` retorna "Masculino", "Feminino", etc.
            distribution.put(genero, distribution.getOrDefault(genero, 0) + 1);
        }
        return distribution;
    }
}