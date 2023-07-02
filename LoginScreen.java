import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
    private JTextField campo_login;
    private JPasswordField campo_senha;
    private JButton btn_login;
    private JButton btn_cadastrar;
    private Sistema sistema;

    public LoginScreen(Sistema sistema) {
        this.sistema = sistema;

        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        setContentPane(panel);  // use 'panel' instead of 'rootPanel'

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        // Logo
        JLabel logo = new JLabel(new ImageIcon("Logo/logo.png"));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(logo, constraints);

        // Login label
        JLabel loginLabel = new JLabel("Login: ");
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.WEST;
        panel.add(loginLabel, constraints);

        // Login field
        campo_login = new JTextField(20);
        constraints.gridx = 1;
        panel.add(campo_login, constraints);

        // Password label
        JLabel passwordLabel = new JLabel("Senha: ");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(passwordLabel, constraints);

        // Password field
        campo_senha = new JPasswordField(20);
        constraints.gridx = 1;
        panel.add(campo_senha, constraints);

        // Login button
        btn_login = new JButton("Entrar");
        // Adicione um ActionListener ao botão de login
        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = campo_login.getText();
                String password = new String(campo_senha.getPassword());
                // Tente fazer login como um administrador primeiro
                if (sistema.login(username, password, true)) {
                    JOptionPane.showMessageDialog(null, "Admin logado com sucesso!");
                    // Aqui você pode instanciar a classe Admin e chamar os métodos apropriados
                }
                // Se o login como administrador falhar, tente como um usuário
                else if (sistema.login(username, password, false)) {
                    JOptionPane.showMessageDialog(null, "Usuário logado com sucesso!");
                    // Aqui você pode instanciar a classe User (ou Cliente) e chamar os métodos apropriados
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciais inválidas!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(btn_login, constraints);

        // Botão de Cadastro
        btn_cadastrar = new JButton("Cadastrar");
        btn_cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroCliente cadastroCliente = new CadastroCliente(sistema);
                cadastroCliente.setLoginScreen(LoginScreen.this); // Adicione esta linha
                cadastroCliente.setVisible(true);
            }
        });


        constraints.gridx = 0;
        constraints.gridy = 4;  // Mude o valor de 'y' conforme necessário
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(btn_cadastrar, constraints);


        setSize(1024, 768); // Define o tamanho da janela
        setResizable(true); // Torna a janela não redimensionável
    }
}