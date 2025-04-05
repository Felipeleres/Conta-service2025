package com.bootcamp.conta_service_2025.feign;

import com.bootcamp.conta_service_2025.exception.ErroIntegracaoBacenException;
import com.bootcamp.conta_service_2025.feign.dto.ChaveRequestDTO;
import com.bootcamp.conta_service_2025.feign.dto.ChaveResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class BacenService {

    private final BacenClient bacenClient;

    public ChaveResponseDTO criarChave(final String chave) {
        try {
            ChaveRequestDTO chaveRequestDTO = ChaveRequestDTO.builder()
                    .chave(chave)
                    .ativa(Boolean.TRUE)
                    .build();

            return bacenClient.criarChave(chaveRequestDTO);
        } catch (Exception ex) {
            log.error("Erro ao chamar a API de cadastrar chave do Bacen", ex);
            throw new ErroIntegracaoBacenException("Erro ao cadastrar a chave no Bacen");
        }
    }

    public ChaveResponseDTO buscaChave(final String chave) {
        try {
            return bacenClient.buscaChave(chave);
        } catch (Exception ex) {
            log.error("Erro ao chamar a API de buscar chave do Bacen", ex);
            throw new ErroIntegracaoBacenException("Erro ao buscar a chave no Bacen");
        }
    }

    public  ChaveResponseDTO atualizarChave(final String chaveAtual, final String chaveNova){
        try{
            ChaveRequestDTO chaveRequestDTO = ChaveRequestDTO.builder()
                    .chave(chaveNova)
                    .ativa(Boolean.TRUE)
                    .build();

            return bacenClient.atualizarChave(chaveAtual, chaveRequestDTO);

        } catch (Exception ex) {
        log.error("Erro ao chamar a API para atualizar chave do Bacen", ex);
        throw new ErroIntegracaoBacenException("Erro ao cadastrar a chave no Bacen");
        }

    }

}
