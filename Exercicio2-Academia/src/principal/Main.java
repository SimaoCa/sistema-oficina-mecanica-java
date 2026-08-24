package principal;

import java.util.Scanner;
import modelos.Aluno;
import modelos.Exercicio;
import modelos.Instrutor;
import modelos.PlanoTreino;
import sistema.Academia;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Academia academia = new Academia();
        int opcao = 0;

        while (opcao != 8) {
            mostrarMenu();
            opcao = Integer.parseInt(read.nextLine());

            if (opcao == 1) {
                cadastrarAluno(read, academia);
            } else if (opcao == 2) {
                cadastrarInstrutor(read, academia);
            } else if (opcao == 3) {
                criarPlanoTreino(read, academia);
            } else if (opcao == 4) {
                adicionarExercicio(read, academia);
            } else if (opcao == 5) {
                associarInstrutor(read, academia);
            } else if (opcao == 6) {
                exibirPlanoTreino(read, academia);
            } else if (opcao == 7) {
                academia.listarAlunosEInstrutores();
            } else if (opcao == 8) {
                System.out.println("Sistema encerrado.");
            } else {
                System.out.println("Opcao invalida.");
            }
        }

        read.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n===== SISTEMA DE ACADEMIA =====");
        System.out.println("1 - Cadastrar aluno");
        System.out.println("2 - Cadastrar instrutor");
        System.out.println("3 - Criar plano de treino");
        System.out.println("4 - Adicionar exercicios ao plano");
        System.out.println("5 - Associar instrutor a um aluno");
        System.out.println("6 - Exibir o plano de treino de um aluno");
        System.out.println("7 - Listar alunos e seus instrutores");
        System.out.println("8 - Sair");
        System.out.print("Escolha uma opcao: ");
    }

    private static void cadastrarAluno(Scanner read, Academia academia) {
        Aluno aluno = new Aluno();
        System.out.print("Nome do aluno: ");
        aluno.setNome(read.nextLine());
        System.out.print("Matricula: ");
        aluno.setMatricula(read.nextLine());
        System.out.print("Idade: ");
        aluno.setIdade(Integer.parseInt(read.nextLine()));
        academia.cadastrarAluno(aluno);
    }

    private static void cadastrarInstrutor(Scanner read, Academia academia) {
        Instrutor instrutor = new Instrutor();
        System.out.print("Nome do instrutor: ");
        instrutor.setNome(read.nextLine());
        System.out.print("CREF: ");
        instrutor.setCref(read.nextLine());
        academia.cadastrarInstrutor(instrutor);
    }

    private static void criarPlanoTreino(Scanner read, Academia academia) {
        Aluno aluno = procurarAluno(read, academia);
        if (aluno == null) {
            return;
        }

        PlanoTreino planoTreino = new PlanoTreino();
        System.out.print("Objetivo do plano: ");
        planoTreino.setObjetivo(read.nextLine());
        academia.criarPlanoTreino(aluno, planoTreino);
    }

    private static void adicionarExercicio(Scanner read, Academia academia) {
        Aluno aluno = procurarAluno(read, academia);
        if (aluno == null) {
            return;
        }

        if (aluno.getPlanoTreino() == null) {
            System.out.println("O aluno ainda nao possui um plano de treino.");
            return;
        }

        Exercicio exercicio = new Exercicio();
        System.out.print("Nome do exercicio: ");
        exercicio.setNome(read.nextLine());
        System.out.print("Quantidade de series: ");
        exercicio.setSeries(Integer.parseInt(read.nextLine()));
        System.out.print("Repeticoes por serie: ");
        exercicio.setRepeticoes(Integer.parseInt(read.nextLine()));
        academia.adicionarExercicio(aluno.getPlanoTreino(), exercicio);
    }

    private static void associarInstrutor(Scanner read, Academia academia) {
        Aluno aluno = procurarAluno(read, academia);
        if (aluno == null) {
            return;
        }

        System.out.print("CREF do instrutor: ");
        Instrutor instrutor = academia.selecionarInstrutor(read.nextLine());
        if (instrutor == null) {
            System.out.println("Instrutor nao encontrado.");
            return;
        }

        academia.associarInstrutor(aluno, instrutor);
    }

    private static void exibirPlanoTreino(Scanner read, Academia academia) {
        Aluno aluno = procurarAluno(read, academia);
        if (aluno != null) {
            academia.exibirPlanoTreino(aluno);
        }
    }

    private static Aluno procurarAluno(Scanner read, Academia academia) {
        System.out.print("Matricula do aluno: ");
        Aluno aluno = academia.selecionarAluno(read.nextLine());
        if (aluno == null) {
            System.out.println("Aluno nao encontrado.");
        }
        return aluno;
    }
}
