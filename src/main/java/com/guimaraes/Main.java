package com.guimaraes;

import com.guimaraes.dao.FornecedorDAO;
import com.guimaraes.dao.FornecedorDAOImpl;
import com.guimaraes.model.Fornecedor;
import com.guimaraes.service.FornecedorService;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        FornecedorDAO fornecedorDAO = new FornecedorDAOImpl();
        FornecedorService fornecedorService = new FornecedorService(fornecedorDAO);

        List<Fornecedor> fornecedores =  fornecedorDAO.listarTodos();
        for (Fornecedor fornecedor1 : fornecedores){
            IO.println(fornecedor1.toString());
        }
        IO.println("-----------------------------------------------");

        fornecedorService.removerFornecedor("0ebdad38-4351-4760-a0a3-0c1993807971");

        IO.println("-----------------------------------------------");
        fornecedores = fornecedorDAO.listarTodos();
        for (Fornecedor fornecedor1 : fornecedores){
            IO.println(fornecedor1.toString());
        }
    }
}
