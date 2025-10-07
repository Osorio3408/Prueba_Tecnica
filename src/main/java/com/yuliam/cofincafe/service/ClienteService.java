package com.yuliam.cofincafe.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuliam.cofincafe.domain.Cliente;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteService {

    /** Ordena los clientes por el balance de mayor a menor */
    private static final Comparator<Cliente> BY_BALANCE_DESC =
            Comparator.comparing(Cliente::getBalance).reversed();

    private final ObjectMapper mapper = new ObjectMapper();

    /** Filtra los clientes por aquellos que tengan balance negativo */
    public List<Cliente> conBalanceNegativo(List<Cliente> origen) {
        return origen.stream()
                .filter(c -> c.getBalance().compareTo(BigDecimal.ZERO) < 0)
                .collect(Collectors.toList());
    }

    /** Obtiene los 3 clientes con mayor balance */
    public List<Cliente> top3Balance(List<Cliente> origen) {
        return origen.stream()
                .sorted(BY_BALANCE_DESC)
                .limit(3)
                .collect(Collectors.toList());
    }

    /** Convierte los clientes en formato JSON */
    public String clientesJson(List<Cliente> origen) {
        try {
            return mapper.writeValueAsString(origen);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializando a JSON", e);
        }
    }
}
