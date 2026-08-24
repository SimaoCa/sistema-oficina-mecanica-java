package interfaces;

import modelos.Funcionario;
import modelos.ServicoRealizado;
import modelos.Veiculo;

public interface IOficinaMecanica {

    void registrarServicoRealizado(Veiculo veiculo, ServicoRealizado servico);

    void associarFuncionario(Funcionario funcionario, ServicoRealizado servico);

    Veiculo selecionarVeiculo(String placa);
}
