package modelos;

public class Motor {

    private double cilindradaDoMotor;
    private double potencia;
    private double torque;
    private String tipoDeCombustivel;
    private int numeroDeCilindros;

    public double getCilindradaDoMotor() {
        return cilindradaDoMotor;
    }

    public void setCilindradaDoMotor(double cilindradaDoMotor) {
        this.cilindradaDoMotor = cilindradaDoMotor;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public double getTorque() {
        return torque;
    }

    public void setTorque(double torque) {
        this.torque = torque;
    }

    public String getTipoDeCombustivel() {
        return tipoDeCombustivel;
    }

    public void setTipoDeCombustivel(String tipoDeCombustivel) {
        this.tipoDeCombustivel = tipoDeCombustivel;
    }

    public int getNumeroDeCilindros() {
        return numeroDeCilindros;
    }

    public void setNumeroDeCilindros(int numeroDeCilindros) {
        this.numeroDeCilindros = numeroDeCilindros;
    }
}
