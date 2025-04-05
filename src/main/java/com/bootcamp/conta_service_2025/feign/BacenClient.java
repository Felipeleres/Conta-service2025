package com.bootcamp.conta_service_2025.feign;

import com.bootcamp.conta_service_2025.feign.dto.ChaveRequestDTO;
import com.bootcamp.conta_service_2025.feign.dto.ChaveResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient(
        contextId = "BacenClient",
        name = "Bacen",
        url = "http://localhost:9002/api/bacen"
)
public interface BacenClient {

    @PostMapping("/chaves")
    ChaveResponseDTO criarChave(ChaveRequestDTO chaveRequestDTO);

    @GetMapping(value = "/chaves/{chave}")
    ChaveResponseDTO buscaChave(@PathVariable final String chave);

    @PutMapping(value = "/chaves/{chave}")
    ChaveResponseDTO  atualizarChave(@PathVariable final String chave, @RequestBody ChaveRequestDTO chaveRequestDTO);

}