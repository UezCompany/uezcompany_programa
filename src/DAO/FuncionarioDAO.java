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
    
    public void demitir(String id, String motivo) {
         String sql1 = "UPDATE funcionario SET situacaoFuncionario = 'demitido' WHERE idFuncionario = ?";
    String sql2 = "UPDATE funcionario SET motivodemicaoFuncionario = ? WHERE idFuncionario = ?";
    
    try {
        connection.setAutoCommit(false); // Desabilita o commit automático
        
        try (PreparedStatement stmt1 = connection.prepareStatement(sql1);
             PreparedStatement stmt2 = connection.prepareStatement(sql2)) {
            
            stmt1.setString(1, id);
            stmt1.executeUpdate();
            
            stmt2.setString(1, motivo);
            stmt2.setString(2, id);
            stmt2.executeUpdate();
            
            connection.commit(); // Efetua o commit das alterações
            System.out.println("Operações executadas com sucesso!");
        }
    } catch (SQLException u) {
        try {
            connection.rollback(); // Desfaz as alterações em caso de erro
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException(u);
    } finally {
        try {
            connection.setAutoCommit(true); // Habilita o commit automático novamente
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
}
