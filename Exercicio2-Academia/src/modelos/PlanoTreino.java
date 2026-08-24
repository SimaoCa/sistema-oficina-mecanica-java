package modelos;

import java.util.ArrayList;

public class PlanoTreino {

    private String objetivo;
    private ArrayList<Exercicio> exercicios = new ArrayList<>();

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public ArrayList<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(ArrayList<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }

    public void adicionarExercicio(Exercicio exercicio) {
        exercicios.add(exercicio);
    }
}
