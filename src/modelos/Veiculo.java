package modelos;

import java.util.ArrayList;

public class Veiculo {

    private String fabricante;
    private String modelo;
    private String placa;
    private int ano;
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<ServicoRealizado> servicosRealizados = new ArrayList<>();
    private Motor motor;

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ArrayList<ServicoRealizado> getServicosRealizados() {
        return servicosRealizados;
    }

    public void setServicosRealizados(ArrayList<ServicoRealizado> servicosRealizados) {
        this.servicosRealizados = servicosRealizados;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        if (!funcionarios.contains(funcionario)) {
            funcionarios.add(funcionario);
        }
    }

    public void adicionarServicoRealizado(ServicoRealizado servico) {
        servicosRealizados.add(servico);
    }
}
