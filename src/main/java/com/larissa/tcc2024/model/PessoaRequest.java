package com.larissa.tcc2024.model;

import org.springframework.web.multipart.MultipartFile;

public class PessoaRequest {
    // outros campos

    private MultipartFile imagem;

    // outros getters e setters

    public MultipartFile getImagem() {
        return imagem;
    }
}