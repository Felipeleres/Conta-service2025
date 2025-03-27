package com.bootcamp.conta_service_2025.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class ContaDTO {

    private UUID id;
    private String nomeTitular;
    private Integer numeroAgencia;
    private Integer numeroConta;
    private String chavePix;
    private BigDecimal saldo;
}
