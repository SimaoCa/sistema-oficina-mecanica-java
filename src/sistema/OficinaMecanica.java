package sistema;

import interfaces.IOficinaMecanica;
import java.util.ArrayList;
import modelos.Funcionario;
import modelos.ServicoRealizado;
import modelos.Veiculo;

public class OficinaMecanica implements IOficinaMecanica {

    private ArrayList<Veiculo> veiculos = new ArrayList<>();
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<ServicoRealizado> servicosRealizados = new ArrayList<>();

    public void cadastrarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
        System.out.println("Veiculo cadastrado com sucesso.");
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        System.out.println("Funcionario cadastrado com sucesso.");
    }

    @Override
    public void registrarServicoRealizado(Veiculo veiculo, ServicoRealizado servico) {
        servico.setVeiculo(veiculo);
        servico.setServicoRealizado(true);
        servicosRealizados.add(servico);
        veiculo.adicionarServicoRealizado(servico);
        System.out.println("Servico registrado com sucesso.");
    }

    @Override
    public void associarFuncionario(Funcionario funcionario, ServicoRealizado servico) {
        servico.adicionarFuncionario(funcionario);
        servico.getVeiculo().adicionarFuncionario(funcionario);
        funcionario.adicionarVeiculo(servico.getVeiculo());
        funcionario.setTrabalhando(true);
        System.out.println("Funcionario associado ao atendimento com sucesso.");
    }

    @Override
    public Veiculo selecionarVeiculo(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    public Funcionario selecionarFuncionario(String nome) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                return funcionario;
            }
        }
        return null;
    }

    public ServicoRealizado selecionarServico(int numero) {
        int posicao = numero - 1;
        if (posicao >= 0 && posicao < servicosRealizados.size()) {
            return servicosRealizados.get(posicao);
        }
        return null;
    }

    public void listarServicos() {
        if (servicosRealizados.isEmpty()) {
            System.out.println("Nenhum servico cadastrado.");
            return;
        }

        for (int i = 0; i < servicosRealizados.size(); i++) {
            ServicoRealizado servico = servicosRealizados.get(i);
            System.out.println((i + 1) + " - " + servico.getServico()
                    + " | Veiculo: " + servico.getVeiculo().getPlaca());
        }
    }

    public void exibirInformacoesVeiculo(Veiculo veiculo) {
        System.out.println("\n--- INFORMACOES DO VEICULO ---");
        System.out.println("Fabricante: " + veiculo.getFabricante());
        System.out.println("Modelo: " + veiculo.getModelo());
        System.out.println("Placa: " + veiculo.getPlaca());
        System.out.println("Ano: " + veiculo.getAno());
        System.out.println("Motor: " + veiculo.getMotor().getCilindradaDoMotor() + " L");
        System.out.println("Potencia: " + veiculo.getMotor().getPotencia() + " cv");
        System.out.println("Torque: " + veiculo.getMotor().getTorque() + " Nm");
        System.out.println("Combustivel: " + veiculo.getMotor().getTipoDeCombustivel());
        System.out.println("Cilindros: " + veiculo.getMotor().getNumeroDeCilindros());

        System.out.println("Servicos realizados:");
        if (veiculo.getServicosRealizados().isEmpty()) {
            System.out.println("Nenhum servico registrado.");
        } else {
            for (ServicoRealizado servico : veiculo.getServicosRealizados()) {
                System.out.println("- " + servico.getServico() + " | R$ " + servico.getPreco());
            }
        }

        System.out.println("Funcionarios associados:");
        if (veiculo.getFuncionarios().isEmpty()) {
            System.out.println("Nenhum funcionario associado.");
        } else {
            for (Funcionario funcionario : veiculo.getFuncionarios()) {
                System.out.println("- " + funcionario.getNome());
            }
        }
    }

    public void listarFuncionarios() {
        System.out.println("\n--- FUNCIONARIOS CADASTRADOS ---");
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionario cadastrado.");
            return;
        }

        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Trabalhando: " + funcionario.getTrabalhando());
            System.out.println("Veiculos em atendimento: "
                    + funcionario.getVeiculosEmAtendimento().size());
            System.out.println();
        }
    }
}
