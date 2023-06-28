package DAO;

import Factory.ConnectionFactory;
import Models.Funcionario;
import java.sql.*;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    private Connection connection;

    public FuncionarioDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Funcionario funcionario) {

        LocalDateTime now = LocalDateTime.now();
        String horario = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        String data = now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Horário: " + horario + " " + data);

        String sql = "INSERT INTO funcionario (nomeFuncionario, emailFuncionario, senhaFuncionario, telefoneFuncionario, cpfFuncionario, rgFuncionario, cargoFuncionario, datacadFuncionario) VALUES (?,?,?,?,?,?,?,?)";
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

    public List<Funcionario> buscarTodos() {
        List<Funcionario> funcionarios = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM funcionario");
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                // Recuperar os dados do funcionário do ResultSet
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nomeFuncionario");
                String email = resultSet.getString("emailFuncionario");
                String senha = resultSet.getString("senhaFuncionario");
                String telefone = resultSet.getString("telefoneFuncionario");
                String cpf = resultSet.getString("cpfFuncionario");
                String rg = resultSet.getString("rgFuncionario");
                String cargo = resultSet.getString("cargoFuncionario");
                String dataCadastro = resultSet.getString("datacadFuncionario");

                // Criar um objeto Funcionario e adicionar à lista
                Funcionario funcionario = new Funcionario(id, nome, email, senha, telefone, cpf, rg, cargo, dataCadastro);
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Tratar exceção adequadamente
        }

        return funcionarios;
    }

}

