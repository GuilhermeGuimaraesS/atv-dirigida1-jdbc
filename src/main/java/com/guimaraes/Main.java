package com.guimaraes;

import com.guimaraes.dao.FornecedorDAO;
import com.guimaraes.dao.FornecedorDAOImpl;
import com.guimaraes.model.Fornecedor;
import com.guimaraes.service.FornecedorService;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        FornecedorDAO fornecedorDAO = new FornecedorDAOImpl();
        FornecedorService fornecedorService = new FornecedorService(fornecedorDAO);

        Fornecedor fornecedor = new Fornecedor("Predator", "374229");
        fornecedorService.cadastrar(fornecedor);

        List<Fornecedor> fornecedores =  fornecedorDAO.listarTodos();
        for (Fornecedor fornecedor1 : fornecedores){
            IO.println(fornecedor1.toString());
        }
    }
}

        // Bloco para teste de conexão com o BD.
        /*try (Connection connection = ConnectionFactory.getInstance().getConnection()){
            IO.println("Conexão realizada com sucesso!");
        } catch (SQLException e) {
            IO.println("Erro ao conectar ao banco.");
            e.printStackTrace();
        }
        */
