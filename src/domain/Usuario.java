package domain;

import java.util.UUID;

public class Usuario {
    private final String id;
    private final String nome;

    public Usuario(String nome) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}

