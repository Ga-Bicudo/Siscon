package model;

import java.math.BigDecimal;

/**
 *
 * @author Ricardo Drudi
 */
public interface AplicacaoFinanceira {
    
    public void calcularRendimento(BigDecimal taxa);
    public void calcularRendimento(double taxa);
    public void calcularRendimento(String taxa);
    
}
