package sistema;

import interfaces.IAcademia;
import java.util.ArrayList;
import modelos.Aluno;
import modelos.Exercicio;
import modelos.Instrutor;
import modelos.PlanoTreino;

public class Academia implements IAcademia {

    private ArrayList<Aluno> alunos = new ArrayList<>();
    private ArrayList<Instrutor> instrutores = new ArrayList<>();

    public void cadastrarAluno(Aluno aluno) {
        alunos.add(aluno);
        System.out.println("Aluno cadastrado com sucesso.");
    }

    public void cadastrarInstrutor(Instrutor instrutor) {
        instrutores.add(instrutor);
        System.out.println("Instrutor cadastrado com sucesso.");
    }

    @Override
    public void criarPlanoTreino(Aluno aluno, PlanoTreino planoTreino) {
        aluno.setPlanoTreino(planoTreino);
        System.out.println("Plano de treino criado com sucesso.");
    }

    @Override
    public void adicionarExercicio(PlanoTreino planoTreino, Exercicio exercicio) {
        planoTreino.adicionarExercicio(exercicio);
        System.out.println("Exercicio adicionado ao plano.");
    }

    @Override
    public void associarInstrutor(Aluno aluno, Instrutor instrutor) {
        if (aluno.getInstrutor() != null) {
            aluno.getInstrutor().removerAluno(aluno);
        }

        aluno.setInstrutor(instrutor);
        instrutor.adicionarAluno(aluno);
        System.out.println("Instrutor associado ao aluno com sucesso.");
    }

    @Override
    public Aluno selecionarAluno(String matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equalsIgnoreCase(matricula)) {
                return aluno;
            }
        }
        return null;
    }

    public Instrutor selecionarInstrutor(String cref) {
        for (Instrutor instrutor : instrutores) {
            if (instrutor.getCref().equalsIgnoreCase(cref)) {
                return instrutor;
            }
        }
        return null;
    }

    public void exibirPlanoTreino(Aluno aluno) {
        System.out.println("\n--- PLANO DE TREINO ---");
        System.out.println("Aluno: " + aluno.getNome());

        if (aluno.getPlanoTreino() == null) {
            System.out.println("O aluno ainda nao possui um plano de treino.");
            return;
        }

        System.out.println("Objetivo: " + aluno.getPlanoTreino().getObjetivo());
        System.out.println("Exercicios:");

        if (aluno.getPlanoTreino().getExercicios().isEmpty()) {
            System.out.println("Nenhum exercicio cadastrado.");
        } else {
            for (Exercicio exercicio : aluno.getPlanoTreino().getExercicios()) {
                System.out.println("- " + exercicio.getNome() + ": "
                        + exercicio.getSeries() + " series de "
                        + exercicio.getRepeticoes() + " repeticoes");
            }
        }
    }

    public void listarAlunosEInstrutores() {
        System.out.println("\n--- ALUNOS E INSTRUTORES ---");

        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        for (Aluno aluno : alunos) {
            System.out.println("Aluno: " + aluno.getNome()
                    + " | Matricula: " + aluno.getMatricula());

            if (aluno.getInstrutor() == null) {
                System.out.println("Instrutor: nao associado");
            } else {
                System.out.println("Instrutor: " + aluno.getInstrutor().getNome()
                        + " | CREF: " + aluno.getInstrutor().getCref());
            }
            System.out.println();
        }
    }
}
