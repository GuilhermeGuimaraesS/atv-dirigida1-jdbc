package com.guimaraes.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Fornecedor {

    private UUID ID;
    private String nome;
    private String CNPJ;
    private LocalDateTime registradoEm;

    public Fornecedor(String nome, String CNPJ) {
        this.ID = UUID.randomUUID();
        this.nome = nome;
        this.CNPJ = CNPJ;
        this.registradoEm = LocalDateTime.now();
    }

    public Fornecedor(){

    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public LocalDateTime getRegistradoEm() {
        return registradoEm;
    }

    public void setRegistradoEm(LocalDateTime registradoEm) {
        this.registradoEm = registradoEm;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "ID=" + ID +
                ", nome='" + nome + '\'' +
                ", CNPJ='" + CNPJ + '\'' +
                ", registradoEm=" + registradoEm +
                '}';
    }
}
