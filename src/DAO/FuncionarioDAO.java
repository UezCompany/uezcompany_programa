package DAO;

import Factory.ConnectionFactory;
import Models.Funcionario;
import java.sql.*;
import java.sql.PreparedStatement;

public class FuncionarioDAO {
    private Connection connection;
    Long id;
    String nome;
    String cpf;
    String rg;
    String email;
    String telefone;
    String cargo;
    String senha;

    public FuncionarioDAO(){
       this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Funcionario funcionario){

        String sql = "INSERT INTO funcionario(nome, cpf, email, telefone, senha) VALUES(?, ?, ?, ?, ?)";
        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, funcionario.getNome());
                stmt.setString(2, funcionario.getCpf());
                stmt.setString(2, funcionario.getRg());
                stmt.setString(3, funcionario.getEmail());
                stmt.setString(4, funcionario.getTelefone());
                stmt.setString(4, funcionario.getCargo());
                stmt.setString(5, funcionario.getSenha());
                stmt.execute();
            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public void demitir(Funcionario funcionario) {
        /*
        String sql = "INSERT INTO funcionario(nome, cpf, email, telefone, senha) VALUES(?, ?, ?, ?, ?)";
        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, funcionario.getNome());
                stmt.setString(2, funcionario.getCpf());
                stmt.setString(2, funcionario.getRg());
                stmt.setString(3, funcionario.getEmail());
                stmt.setString(4, funcionario.getTelefone());
                stmt.setString(4, funcionario.getCargo());
                stmt.setString(5, funcionario.getSenha());
                stmt.execute();
            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        */
    }
}

