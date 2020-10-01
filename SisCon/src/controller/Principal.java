package controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import model.Banco;
import model.Carteira;
import model.Conta;
import model.ContaCorrente;
import model.Poupanca;
import teste.Teste;

/**
 * @author Ricardo Drudi
 */
public class Principal {

    public static void main(String[] args) {
        
//        Teste t = new Teste();
//        t.strBuilder();
        //t.strSplit("nome,cpf,telefone,endereço,email");
        
        //Conta ct = new Conta("CC LPOO");
        //Banco bc = new Banco("Banco", "123-4", 345);
       
        Carteira cart = new Carteira("Preta de Couro");
        cart.depositar(new BigDecimal("300"));
        cart.sacar(200);
        
        ContaCorrente cc = new ContaCorrente("Banco Bradesco S/A.", "123-4", 1234);
        cc.setLimite(5000);
        cc.depositar(500);
        //cc.depositar("");
        cc.sacar(1200);

        ContaCorrente ccBrasil = new ContaCorrente("Banco do Brasil S/A.", "111-X", 1111, 1000);
        
        ContaCorrente cc2 = new ContaCorrente("Banco Santander","2222-2",22222,2000);

        Poupanca cp = new Poupanca("Santander", "444-4", 555, 1);
        cp.setAniversario(20);
        cp.depositar(1000);
        cp.sacar(300);
        cp.calcularRendimento(0.01);  // 1% 2,45%  => 5 casas

        cc.transferir(cp, 200);
        cc.transferir(ccBrasil, 200);
        cc.transferir(cart, 200);

        Conta.listaContaCorrente();
    }
    
}
