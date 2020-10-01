package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Ricardo Drudi
 */
public class ContaCorrente extends Banco {
    
    private BigDecimal limite;

    public ContaCorrente(String nome, String agencia, int numero) {
        this(nome,agencia,numero,BigDecimal.ZERO);
    }
    public ContaCorrente(String nome, String agencia, int numero, BigDecimal limite) {
        super(nome,agencia,numero);
        setLimite(limite);
    }
    public ContaCorrente(String nome, String agencia, int numero, double limite) {
        super(nome,agencia,numero);
        setLimite(limite);
    }
    
    public BigDecimal getLimite() {
        return limite;
    }
    public void setLimite(double limite) {
        setLimite(new BigDecimal(limite).setScale(2, RoundingMode.HALF_UP));
    } 
   
    public void setLimite(BigDecimal limite) {
        if (limite.compareTo(BigDecimal.ZERO) >= 0) {
            this.limite = limite;
        } else {
            throw new IllegalArgumentException("Limite deve ser maior ou igual a zero!");
        }
    }
    
    public void sacar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) { // -1(menor) 0(igual)  1(maior)
            throw new IllegalArgumentException("Valor de saque deve ser maior que zero!");
        } else if (valor.compareTo(saldo.add(limite)) == 1) {  // 1(maior)
            throw new RuntimeException("Não há saldo suficiente!");
        } else {
            saldo = saldo.subtract(valor);
        }
    }
    
    public void pagar() {}

    @Override
    public String toString() {
        return ("-------------------------------------------------\n" + 
                "Conta Corrente: " + getNome() + "\n" +
                "Agência.......: " + getAgencia() + "\n" +
                "Conta.........: " + getNumero() + "\n" +
                "Saldo.........: " + getSaldo() + "\n" +
                "Limite........: " + getLimite() + "\n" +
                "-------------------------------------------------\n");
    }
    
}
