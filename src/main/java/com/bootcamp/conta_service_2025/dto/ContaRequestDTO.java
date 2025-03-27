package com.bootcamp.conta_service_2025.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
public class ContaRequestDTO {

    @NotNull
    private String nomeTitular;
    @NotNull
    private Integer numeroAgencia;
    @NotNull
    private Integer numeroConta;
    @NotEmpty
    private String chavePix;
}
