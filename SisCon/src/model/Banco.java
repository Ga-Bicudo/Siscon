package model;

/**
 * @author Ricardo Drudi
 */
public abstract class Banco extends Conta {
    
    private String agencia;
    private int numero;

    public Banco(String nome, String agencia, int numero) {
        super(nome);
        setAgencia(agencia);
        setNumero(numero);
    }
    
    public String getAgencia() {
        return agencia;
    }
    public void setAgencia(String agencia) {
        if (agencia.length() >= 4) {
            this.agencia = agencia;
        } else {
            throw new IllegalArgumentException("Agência deve ter 4 ou mais caracteres!");
        }
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        if (numero > 0) {
            this.numero = numero;
        } else {
            throw new IllegalArgumentException("O número da conta deve ser maior que zero!");
        }
    }

}
