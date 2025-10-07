package com.yuliam.cofincafe.app;

import com.yuliam.cofincafe.domain.Cliente;
import com.yuliam.cofincafe.service.ClienteService;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = List.of(
                new Cliente(1L, "Yuliam",   new BigDecimal("2.500")),
                new Cliente(2L, "Andrey", new BigDecimal("-2.500")),
                new Cliente(3L, "Joshua", new BigDecimal("10.000")),
                new Cliente(4L, "Paula", new BigDecimal("1.000")),
                new Cliente(5L, "Juan",   new BigDecimal("5.000")),
                new Cliente(6L, "Jorge",  new BigDecimal("-1.000"))
        );

        var service = new ClienteService();

        System.out.println("Clientes con el balance negativo:");
        service.conBalanceNegativo(clientes).forEach(System.out::println);

        System.out.println("\nTop 3 clientes con el mayor balance:");
        service.top3Balance(clientes).forEach(System.out::println);

        System.out.println("\n Y lista de los clientes en formato JSON:");
        System.out.println(service.clientesJson(clientes));
    }
}
