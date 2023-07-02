import java.sql.*;

public class DatabaseManager {
    private Connection connection;

    public DatabaseManager(String url) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean saveClienteWithCredentials(Cliente cliente, String username, String password) {
        String sql = "INSERT INTO clientes(nome, cpf, idade, username, password) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCpf());
            preparedStatement.setInt(3, cliente.getIdade());
            preparedStatement.setString(4, username);
            preparedStatement.setString(5, password);
            preparedStatement.executeUpdate();
            return true;  // Retornar true se a inserção for bem-sucedida
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  // Retornar false se ocorrer uma exceção
    }


    public boolean loginCliente(String username, String password) {
        String sql = "SELECT * FROM clientes WHERE username = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");

                if (password.equals(storedPassword)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
