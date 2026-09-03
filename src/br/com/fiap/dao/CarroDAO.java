package br.com.fiap.dao;

import br.com.fiap.dto.Carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarroDAO {
    // atributo
    private Connection con;
    // construtor com parametro

    public CarroDAO(Connection con) {
        this.con = con;
    }
    // metodos getter
    public Connection getCon() {
        return con;
    }
    // metodos da classe
    public String inserir(Carro carro) {
        String sql = "insert into ddd_carro(placa,cor,descricao) values(?,?,?)";
        // try-with-resources
        try(PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getCor());
            ps.setString(3, carro.getDescricao());
            if(ps.executeUpdate() > 0) {
                return "Inserido com sucesso";
            } else {
                return "Erro ao inserir";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public String alterar(Carro carro) {
        String sql = "update ddd_carro set cor=?, descricao=? where placa=?";
        // try-with-resources
        try(PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(3, carro.getPlaca());
            ps.setString(1, carro.getCor());
            ps.setString(2, carro.getDescricao());
            if(ps.executeUpdate() > 0) {
                return "Inserido com sucesso";
            } else {
                return "Erro ao inserir";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }



    public String excluir(Carro carro) {
        String sql = "delete from ddd_carro where placa=?";
        // try-with-resources
        try(PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, carro.getPlaca());
            if(ps.executeUpdate() > 0) {
                return "Inserido com sucesso";
            } else {
                return "Erro ao inserir";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }
}
