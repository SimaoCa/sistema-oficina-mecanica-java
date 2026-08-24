package interfaces;

import modelos.Aluno;
import modelos.Exercicio;
import modelos.Instrutor;
import modelos.PlanoTreino;

public interface IAcademia {

    void criarPlanoTreino(Aluno aluno, PlanoTreino planoTreino);

    void adicionarExercicio(PlanoTreino planoTreino, Exercicio exercicio);

    void associarInstrutor(Aluno aluno, Instrutor instrutor);

    Aluno selecionarAluno(String matricula);
}
