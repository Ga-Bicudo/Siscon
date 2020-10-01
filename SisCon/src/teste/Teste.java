package teste;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import model.Carteira;

/**
 * @author Ricardo Drudi
 */
public class Teste {
    
    private static int total = 0;
    private int num = 0;
    
    
    public void strBuilder() {
        final int MAX = 1000000;
        
        String str = "";
        long tempo = System.currentTimeMillis();
        for (int i=0 ; i<MAX ; i++) {
            str = str + "a";
        }
        tempo = System.currentTimeMillis() - tempo;
        System.out.println("Tempo com String: " + tempo);
        
        StringBuilder sb = new StringBuilder();
        tempo = System.currentTimeMillis();
        for (int i=0 ; i<MAX ; i++) {
            sb.append("a");
        }
        tempo = System.currentTimeMillis() - tempo;
        System.out.println("Tempo com StringBuilder: " + tempo);
        
    }
    
    public void strSplit(String csv) {
        String[] campos = csv.split(",");
        for (int i=0 ; i<campos.length ; i++) {
            System.out.println("campos[" + i + "]: " +  campos[i]);
        }
    }
    
    public void strIgual() {
        String s1 = "teste";
        String s2 = "teste";
        String s3 = new String("teste");
        String s4 = s1;
        s1 = "mudou";
        
        System.out.println("s1 == s2 [false]: " + (s1==s2));
        System.out.println("s1 == s3 [false]: " + (s1==s3));
        System.out.println("s1 == s4 [false/true]:" + (s1==s4));
        System.out.println("s2 == s3 [true]: " + (s2==s3));
        System.out.println("s2 == s4 [true/false] :" + (s2==s4));
        System.out.println("s3 == s4 [false]: " + (s3==s4));
        
        System.out.println("\n\n\n");
        
        System.out.println("s1.equals(s2) []: " + s1.equals(s2));
        System.out.println("s1.equals(s3) []: " + s1.equals(s3));
        System.out.println("s1.equals(s4) []: " + s1.equals(s4));
        System.out.println("s2.equals(s3) []: " + s2.equals(s3));
        System.out.println("s2.equals(s4) []: " + s2.equals(s4));
        System.out.println("s3.equals(s4) []: " + s3.equals(s4));

    }
    
    public void incremento() {
        total++;
        num++;
        System.out.println("Total = " + total + "\tNum = " + num);
    }

    public void testaDouble2() {
        System.out.println("2.0 - 1.1 = " + (2.0 - 1.1));
        System.out.println("2.0 - 1.2 = " + (2.0 - 1.2));
        System.out.println("2.0 - 1.3 = " + (2.0 - 1.3));
        System.out.println("2.0 - 1.4 = " + (2.0 - 1.4));
        System.out.println("2.0 - 1.5 = " + (2.0 - 1.5));
        System.out.println("2.0 - 1.6 = " + (2.0 - 1.6));
        System.out.println("2.0 - 1.7 = " + (2.0 - 1.7));
        System.out.println("2.0 - 1.8 = " + (2.0 - 1.8));
        System.out.println("2.0 - 1.9 = " + (2.0 - 1.9));
    }
    
    public void testaBigOperacoes() {
        BigDecimal n1 = new BigDecimal("10");
        BigDecimal n2 = new BigDecimal("6");
        System.out.println(n1 + " + " + n2 + " = " + n1.add(n2));
        System.out.println(n1 + " - " + n2 + " = " + n1.subtract(n2));
        System.out.println(n1 + " * " + n2 + " = " + n1.multiply(n2));
        System.out.println(n1 + " / " + n2 + " = " + n1.divide(n2,6,RoundingMode.HALF_UP));
    }
    
    public void testaBigDecimal() {
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal num = new BigDecimal("0.1");
        for (int i=0 ; i<10 ; i++) {
            total = total.add(num);
        }
        System.out.println("Total BigDecimal = " + total);
    }
    public void testaDouble() {
        double total = 0;
        double num = 0.1;
        for (int i=0 ; i<10 ; i++) total += num;
        System.out.println("Total double = " + total);
    }
    
    public void array() {
        ArrayList<Carteira> lista = new ArrayList<Carteira>(4);
        Carteira cart = new Carteira("Carteira 0");
        lista.add(cart);
        cart = new Carteira("Carteira 1");
        lista.add(cart);
        lista.add(new Carteira("Carteira 2"));
        lista.add(new Carteira("Carteira 3"));
        lista.add(new Carteira("Carteira 4"));
        lista.add(new Carteira("Carteira 5"));
        lista.add(new Carteira("Carteira 6"));
        lista.add(new Carteira("Carteira 7"));
        System.out.println(lista);
        System.out.println("Carteira 1 está na posição: " + lista.indexOf(cart));
        lista.remove(cart);
        System.out.println(lista);
        System.out.println("***** " + lista.get(2) + " ******");
        lista.add(1, cart);
        System.out.println(lista);
        lista.set(3, new Carteira("Carteira Nova"));
        System.out.println(lista);
        lista.get(2).depositar(200);
        Carteira cart2 = lista.get(2);
        System.out.println("Saldo carteira 2 = " + cart2.getSaldo());
        Carteira cart3;  // tipo referência para objeto Carteira - default "null"
        cart3 = new Carteira("Nova Carteira de Teste");
        cart3.depositar(300);
    }

}
