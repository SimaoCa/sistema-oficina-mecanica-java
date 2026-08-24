package principal;

import java.util.Scanner;
import modelos.Funcionario;
import modelos.Motor;
import modelos.ServicoRealizado;
import modelos.Veiculo;
import sistema.OficinaMecanica;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        OficinaMecanica oficina = new OficinaMecanica();
        int opcao = 0;

        while (opcao != 7) {
            mostrarMenu();
            opcao = Integer.parseInt(read.nextLine());

            if (opcao == 1) {
                cadastrarVeiculo(read, oficina);
            } else if (opcao == 2) {
                cadastrarFuncionario(read, oficina);
            } else if (opcao == 3) {
                registrarServico(read, oficina);
            } else if (opcao == 4) {
                associarFuncionario(read, oficina);
            } else if (opcao == 5) {
                exibirVeiculo(read, oficina);
            } else if (opcao == 6) {
                oficina.listarFuncionarios();
            } else if (opcao == 7) {
                System.out.println("Sistema encerrado.");
            } else {
                System.out.println("Opcao invalida.");
            }
        }

        read.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n===== OFICINA MECANICA =====");
        System.out.println("1 - Cadastrar veiculo");
        System.out.println("2 - Cadastrar funcionario");
        System.out.println("3 - Registrar servico para um veiculo");
        System.out.println("4 - Associar funcionario a um atendimento");
        System.out.println("5 - Exibir informacoes de um veiculo");
        System.out.println("6 - Listar funcionarios cadastrados");
        System.out.println("7 - Sair");
        System.out.print("Escolha uma opcao: ");
    }

    private static void cadastrarVeiculo(Scanner read, OficinaMecanica oficina) {
        Veiculo veiculo = new Veiculo();
        Motor motor = new Motor();

        System.out.print("Fabricante: ");
        veiculo.setFabricante(read.nextLine());
        System.out.print("Modelo: ");
        veiculo.setModelo(read.nextLine());
        System.out.print("Placa: ");
        veiculo.setPlaca(read.nextLine());
        System.out.print("Ano: ");
        veiculo.setAno(Integer.parseInt(read.nextLine()));

        System.out.print("Cilindrada do motor em litros: ");
        motor.setCilindradaDoMotor(lerDouble(read));
        System.out.print("Potencia em cavalos: ");
        motor.setPotencia(lerDouble(read));
        System.out.print("Torque em Nm: ");
        motor.setTorque(lerDouble(read));
        System.out.print("Tipo de combustivel: ");
        motor.setTipoDeCombustivel(read.nextLine());
        System.out.print("Numero de cilindros: ");
        motor.setNumeroDeCilindros(Integer.parseInt(read.nextLine()));

        veiculo.setMotor(motor);
        oficina.cadastrarVeiculo(veiculo);
    }

    private static void cadastrarFuncionario(Scanner read, OficinaMecanica oficina) {
        Funcionario funcionario = new Funcionario();
        System.out.print("Nome do funcionario: ");
        funcionario.setNome(read.nextLine());
        funcionario.setTrabalhando(false);
        oficina.cadastrarFuncionario(funcionario);
    }

    private static void registrarServico(Scanner read, OficinaMecanica oficina) {
        System.out.print("Placa do veiculo: ");
        Veiculo veiculo = oficina.selecionarVeiculo(read.nextLine());

        if (veiculo == null) {
            System.out.println("Veiculo nao encontrado.");
            return;
        }

        ServicoRealizado servico = new ServicoRealizado();
        System.out.print("Nome do servico: ");
        servico.setServico(read.nextLine());
        System.out.print("Preco do servico: R$ ");
        servico.setPreco(lerDouble(read));
        oficina.registrarServicoRealizado(veiculo, servico);
    }

    private static void associarFuncionario(Scanner read, OficinaMecanica oficina) {
        oficina.listarServicos();
        System.out.print("Numero do atendimento: ");
        ServicoRealizado servico = oficina.selecionarServico(
                Integer.parseInt(read.nextLine()));

        if (servico == null) {
            System.out.println("Atendimento nao encontrado.");
            return;
        }

        System.out.print("Nome do funcionario: ");
        Funcionario funcionario = oficina.selecionarFuncionario(read.nextLine());

        if (funcionario == null) {
            System.out.println("Funcionario nao encontrado.");
            return;
        }

        oficina.associarFuncionario(funcionario, servico);
    }

    private static void exibirVeiculo(Scanner read, OficinaMecanica oficina) {
        System.out.print("Placa do veiculo: ");
        Veiculo veiculo = oficina.selecionarVeiculo(read.nextLine());

        if (veiculo == null) {
            System.out.println("Veiculo nao encontrado.");
            return;
        }

        oficina.exibirInformacoesVeiculo(veiculo);
    }

    private static double lerDouble(Scanner read) {
        String valor = read.nextLine().replace(",", ".");
        return Double.parseDouble(valor);
    }
}
