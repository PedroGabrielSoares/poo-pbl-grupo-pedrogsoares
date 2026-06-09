package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grupo {
    private final String id;
    private final String nome;
    private final List<Usuario> membros;
    private final Map<Usuario, Dinheiro> gastosPorUsuario;

    public Grupo(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.membros = new ArrayList<>();
        this.gastosPorUsuario = new HashMap<>();
    }

    public void adicionarMembro(Usuario usuario) {
        if (!membros.contains(usuario)) {
            membros.add(usuario);
            gastosPorUsuario.put(usuario, new Dinheiro(BigDecimal.ZERO));
        }
    }

    public void registrarDespesa(Usuario pagador, Dinheiro valor) {
        if (!membros.contains(pagador)) {
            throw new IllegalArgumentException("Usuário não pertence ao grupo.");
        }
        Dinheiro gastoAtual = gastosPorUsuario.get(pagador);
        gastosPorUsuario.put(pagador, gastoAtual.somar(valor));
    }

    public Dinheiro calcularGastoTotal() {
        Dinheiro total = new Dinheiro(BigDecimal.ZERO);
        for (Dinheiro gasto : gastosPorUsuario.values()) {
            total = total.somar(gasto);
        }
        return total;
    }

    public Dinheiro calcularCotaPorMembro() {
        if (membros.isEmpty()) return new Dinheiro(BigDecimal.ZERO);
        return calcularGastoTotal().dividir(membros.size());
    }

    public BigDecimal calcularSaldo(Usuario usuario) {
        if (!membros.contains(usuario)) throw new IllegalArgumentException("Usuário não encontrado.");
        
        Dinheiro gastoPeloUsuario = gastosPorUsuario.get(usuario);
        Dinheiro cotaIdeal = calcularCotaPorMembro();
        
        return gastoPeloUsuario.getValor().subtract(cotaIdeal.getValor());
    }
}

