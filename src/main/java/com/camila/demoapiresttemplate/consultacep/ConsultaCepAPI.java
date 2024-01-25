package com.camila.demoapiresttemplate.consultacep;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController // classe rest
@RequestMapping("consulta-cep") // mapeamento da API com a URL
public class ConsultaCepAPI {

    // métodos para receber os parâmetros e consumir o serviço da API Externa

    @GetMapping("{cep}") // recebe parâmetro de cep no get e tem que fazer referência de cep dentro do parâmetro com @PathVariable
    public CepResultDTO consultaCep(@PathVariable("cep") String cep) {

        // utilizar a classe resttemplate
        RestTemplate restTemplate = new RestTemplate();

        // Definir que o resttemplate consuma a API Externa
        ResponseEntity<CepResultDTO> responseEntity =
                restTemplate
                        .getForEntity(String.format(
                                "https://viacep.com.br/ws/%s/json/", cep), CepResultDTO.class);

        return  responseEntity.getBody();
    }
}
