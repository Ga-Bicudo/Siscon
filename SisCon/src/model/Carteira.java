package model;

import java.math.BigDecimal;

/**
 * @author Ricardo Drudi
 */
public class Carteira extends Conta {

    public Carteira() {
        this("Carteira");
    }
    public Carteira(String nome) {
        super(nome);
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

    public void pagar() {
    }

    @Override
    public String toString() {
        return ("-------------------------------------------------\n" + 
                "Carteira: " + getNome() + ": R$ " + getSaldo() + "\n" +
                "-------------------------------------------------\n");
    }

}
