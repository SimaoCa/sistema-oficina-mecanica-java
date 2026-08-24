package modelos;

import java.util.ArrayList;

public class ServicoRealizado {

    private String servico;
    private double preco;
    private boolean servicoRealizado;
    private ArrayList<Funcionario> funcionariosNoServico = new ArrayList<>();
    private Veiculo veiculo;

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean getServicoRealizado() {
        return servicoRealizado;
    }

    public void setServicoRealizado(boolean servicoRealizado) {
        this.servicoRealizado = servicoRealizado;
    }

    public ArrayList<Funcionario> getFuncionariosNoServico() {
        return funcionariosNoServico;
    }

    public void setFuncionariosNoServico(ArrayList<Funcionario> funcionariosNoServico) {
        this.funcionariosNoServico = funcionariosNoServico;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        if (!funcionariosNoServico.contains(funcionario)) {
            funcionariosNoServico.add(funcionario);
        }
    }
}
