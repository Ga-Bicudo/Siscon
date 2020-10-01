package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * @author Ricardo Drudi
 */
public abstract class Conta {

    private String nome;
    protected BigDecimal saldo = BigDecimal.ZERO;
    private static ArrayList<Conta> lista = new ArrayList<Conta>();

    public Conta(String nome) {
        setNome(nome);
        adiciona(this);
    }

    public void setNome(String nome) {
        if (nome.length() >= 5) {  // validação do atributo nome
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Nome deve ter 5 ou mais caracteres!");
        }
    }

    public String getNome() {
        return this.nome;
    }

    public BigDecimal getSaldo() {
        return this.saldo;
    }

    public void sacar(double valor) {
        sacar(new BigDecimal(valor).setScale(2,RoundingMode.HALF_UP));
    }
    public abstract void sacar(BigDecimal valor);

    public void depositar(String valor) {
        depositar(new BigDecimal(valor).setScale(2,RoundingMode.HALF_UP));
    }
    public void depositar(double valor) {
        BigDecimal bdValor = new BigDecimal(valor);  // 123.10000000001
        bdValor = bdValor.setScale(2,RoundingMode.HALF_UP);  // 123.10
        depositar(bdValor);
    }
    public void depositar(BigDecimal valor) {  
        if (valor.compareTo(BigDecimal.ZERO) == 1) { // -1(menor)  0(igual)  1(maior)
            saldo = saldo.add(valor);
        } else {
            throw new IllegalArgumentException("Valor do depósito deve ser maior que zero!");
        }
    }

    public void transferir(Conta destino, BigDecimal valor) {
        this.sacar(valor);
        destino.depositar(valor);
    }
    public void transferir(Conta destino, double valor) {
       transferir(destino, new BigDecimal(valor).setScale(2, RoundingMode.HALF_UP));
    }
    public void transferir(Conta destino, String valor) {
       transferir(destino, new BigDecimal(valor).setScale(2, RoundingMode.HALF_UP));
    }
    
    private void adiciona(Conta ct) {
        lista.add(ct);
    }
    
    public static void listaTodos() {
        for (Conta ct: lista) {
            System.out.println(ct);
        }
    }
    
    public static void listaContaCorrente() {
        for (Conta ct: lista) {
            if (ct instanceof ContaCorrente) {
                System.out.println(ct);
            }
        }
    }

}
