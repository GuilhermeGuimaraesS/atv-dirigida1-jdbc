package com.guimaraes.dao;

import com.guimaraes.model.Fornecedor;

import java.util.List;
import java.util.UUID;

public interface FornecedorDAO {


    Fornecedor buscarPorId(UUID ID);

    Fornecedor buscarPorCNPJ(String CNPJ);

    List<Fornecedor> listarTodos();


}
