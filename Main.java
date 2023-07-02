import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema(); // Crie o sistema aqui
        // Passe o sistema para a LoginScreen
        SwingUtilities.invokeLater(() -> {
            new LoginScreen(sistema).setVisible(true);
        });
    }
}
