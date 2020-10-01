package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Ricardo Drudi
 */
public class Poupanca extends Banco implements AplicacaoFinanceira {

    private int aniversario;
    
    public Poupanca(String nome, String agencia, int numero) {
        this(nome,agencia,numero,1);
    }
    public Poupanca(String nome, String agencia, int numero, int aniversario) {
        super(nome,agencia,numero);
        setAniversario(aniversario);
    }
            
    public int getAniversario() {
        return aniversario;
    }
    public void setAniversario(int aniversario) {
        if ((aniversario >= 1) && (aniversario <= 28)) {
            this.aniversario = aniversario;
        } else {
            throw new IllegalArgumentException("Dia do aniversário deve estar entre 1 e 28!");
        }
    }

    public void sacar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) { // -1(menor) 0(igual)  1(maior)
            throw new IllegalArgumentException("Valor de saque deve ser maior que zero!");
        } else if (valor.compareTo(saldo) == 1) {  // 1(maior)
            throw new RuntimeException("Não há saldo suficiente!");
        } else {
            saldo = saldo.subtract(valor);
        }
    }

    @Override
    public void calcularRendimento(String taxa) {
        calcularRendimento(new BigDecimal(taxa).setScale(2, RoundingMode.HALF_UP));
    }
    @Override
    public void calcularRendimento(double taxa) {
        calcularRendimento(new BigDecimal(taxa).setScale(2, RoundingMode.HALF_UP));
    }
    @Override
    public void calcularRendimento(BigDecimal taxa) {
//        depositar(saldo.multiply(taxa).setScale(2,RoundingMode.HALF_UP));
        BigDecimal juros = saldo.multiply(taxa);
        juros = juros.setScale(2,RoundingMode.HALF_UP);
        this.depositar(juros);
    }

    @Override
    public String toString() {
        return ("-------------------------------------------------\n" + 
                "Conta Poupança: " + getNome() + "\n" +
                "Agência.......: " + getAgencia() + "\n" +
                "Conta.........: " + getNumero() + "\n" +
                "Aniversário...: " + getAniversario() + "\n" +
                "Saldo.........: " + getSaldo() + "\n" +
                "-------------------------------------------------\n");
    }
    
}
