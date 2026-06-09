package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Dinheiro {
    private final BigDecimal valor;

    public Dinheiro(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor monetário não pode ser negativo ou nulo.");
        }
        this.valor = valor.setScale(2, RoundingMode.HALF_UP);
    }

    public Dinheiro somar(Dinheiro outro) {
        return new Dinheiro(this.valor.add(outro.valor));
    }

    public Dinheiro dividir(int partes) {
        if (partes <= 0) throw new IllegalArgumentException("Divisão por zero ou negativa.");
        return new Dinheiro(this.valor.divide(new BigDecimal(partes), 2, RoundingMode.HALF_UP));
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dinheiro dinheiro = (Dinheiro) o;
        return valor.compareTo(dinheiro.valor) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
