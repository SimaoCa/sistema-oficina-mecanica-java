package modelos;

import java.util.ArrayList;

public class Funcionario {

    private String nome;
    private ArrayList<Veiculo> veiculosEmAtendimento = new ArrayList<>();
    private boolean trabalhando;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Veiculo> getVeiculosEmAtendimento() {
        return veiculosEmAtendimento;
    }

    public void setVeiculosEmAtendimento(ArrayList<Veiculo> veiculosEmAtendimento) {
        this.veiculosEmAtendimento = veiculosEmAtendimento;
    }

    public boolean getTrabalhando() {
        return trabalhando;
    }

    public void setTrabalhando(boolean trabalhando) {
        this.trabalhando = trabalhando;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        if (!veiculosEmAtendimento.contains(veiculo)) {
            veiculosEmAtendimento.add(veiculo);
        }
    }
}
