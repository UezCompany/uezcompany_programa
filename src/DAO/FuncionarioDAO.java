package DAO;

import Factory.ConnectionFactory;
import Models.Funcionario;
import java.sql.*;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

         LocalDateTime now = LocalDateTime.now();
        String horario = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        String data = now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Horário: " + horario + " " + data);
        
        String sql = "INSERT INTO `funcionario`(`nomeFuncionario`, `emailFuncionario`, `senhaFuncionario`, `telefoneFuncionario`, `cpfFuncionario`, `rgFuncionario`, `cargoFuncionario`, `datacadFuncionario`) VALUES (?,?,?,?,?,?,?,?)";
        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, funcionario.getNome());
                stmt.setString(2, funcionario.getEmail());
                stmt.setString(3, funcionario.getSenha());
                stmt.setString(4, funcionario.getTelefone());
                stmt.setString(5, funcionario.getCpf());
                stmt.setString(6, funcionario.getRg());
                stmt.setString(7, funcionario.getCargo());
                stmt.setString(8, horario + " " + data);
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

