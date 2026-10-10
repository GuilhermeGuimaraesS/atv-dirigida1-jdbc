package com.guimaraes.service;

import com.guimaraes.dao.FornecedorDAO;
import com.guimaraes.model.Fornecedor;

import java.util.List;

public class FornecedorService {

    private final FornecedorDAO fornecedorDAO;

    public FornecedorService(FornecedorDAO fornecedorDAO) {
        this.fornecedorDAO = fornecedorDAO;
    }

    public void cadastrar(Fornecedor fornecedorNovo){
        if (fornecedorNovo.getNome() == null || fornecedorNovo.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if (fornecedorNovo.getCNPJ() == null || fornecedorNovo.getCNPJ().isBlank()) {
            throw new IllegalArgumentException("CNPJ é obrigatório");
        }

        if (fornecedorDAO.buscarPorCNPJ(fornecedorNovo.getCNPJ()) != null){
            throw new IllegalArgumentException("Esse CNPJ já existe!");
        }

        fornecedorDAO.salvar(fornecedorNovo);
    }
}
