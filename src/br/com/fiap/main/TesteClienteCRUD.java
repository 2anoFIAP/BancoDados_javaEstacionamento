package br.com.fiap.main;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.Cliente;

import java.sql.Connection;
import java.util.ArrayList;

public class TesteClienteCRUD {
    static void main() {
        Connection con = ConnectionFactory.abrirConexao();

        //inserir
        Cliente cliente = new Cliente();
        cliente.setIdCliente(12345);
        cliente.setNomeCliente("Clayton");
        cliente.setPlaca("UUJ1956");

        ClienteDAO clienteDAO = new ClienteDAO(con);
        System.out.println(clienteDAO.inserir(cliente));

        //alterar
        cliente.setIdCliente(1234567);
        cliente.setNomeCliente("Lucas");
        cliente.setPlaca("UUJ1956");

        System.out.println(clienteDAO.alterar(cliente));

        //Excluir
        cliente.setIdCliente(1234567);
        System.out.println(clienteDAO.excluir(cliente));

        //Listar Todos
        ArrayList<Cliente> resultado = clienteDAO.listarTodos();
        if (resultado != null) {
            for (Cliente cliente1 : resultado) {
                System.out.println("\nId_cliente: " + cliente1.getIdCliente());
                System.out.println("Nome_cliente: " + cliente1.getNomeCliente());
                System.out.println("Placa: " + cliente1.getPlaca());
            }
        } else {
            System.out.println("Tabela nao existe ou esta vazia");
        }

        ConnectionFactory.fecharConexao(con);
    }
}
