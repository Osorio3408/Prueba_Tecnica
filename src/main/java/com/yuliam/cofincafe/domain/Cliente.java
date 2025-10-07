package com.yuliam.cofincafe.domain;

import java.math.BigDecimal;
import java.util.Objects;

public final class Cliente {
    private final Long id;
    private final String nombre;
    private final BigDecimal balance;

    public Cliente(Long id, String nombre, BigDecimal balance) {
        this.id = Objects.requireNonNull(id, "id no puede ser null");
        this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null");
        this.balance = Objects.requireNonNull(balance, "balance no puede ser null");
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public BigDecimal getBalance() { return balance; }

    @Override public String toString() {
        return "Cliente{id=%d, nombre='%s', balance=%s}".formatted(id, nombre, balance);
    }
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente c)) return false;
        return id.equals(c.id);
    }
    @Override public int hashCode() { return id.hashCode(); }
}
