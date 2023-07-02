import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class CadastroCliente extends JFrame {
    private JPanel rootPanel;
    private JTextField campo_nome;
    private JTextField campo_cpf;
    private JTextField campo_idade;
    private JTextField nomeUsuario;
    private JPasswordField cadastrarSenha;
    private JButton btn_cadastro;
    private Sistema sistema;
    private LoginScreen loginScreen;

    public CadastroCliente(Sistema sistema) {
        this.sistema = sistema;

        setTitle("Cadastro de Cliente");
        rootPanel = new JPanel();
        setContentPane(rootPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();

        rootPanel.setLayout(new GridLayout(7, 2));  // altere para o layout desejado

        campo_nome.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (campo_nome.getText().equals("Insira aqui o seu nome completo")) {
                    campo_nome.setText("");
                }
            }
        });

        campo_cpf.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (campo_cpf.getText().equals("Insira aqui o seu CPF")) {
                    campo_cpf.setText("");
                }
            }
        });

        campo_idade.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (campo_idade.getText().equals("Insira aqui a sua idade")) {
                    campo_idade.setText("");
                }
            }
        });

        nomeUsuario.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (nomeUsuario.getText().equals("Insira o seu nome de usuário")) {
                    nomeUsuario.setText("");
                }
            }
        });

        cadastrarSenha.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (new String(cadastrarSenha.getPassword()).equals("Insira a sua senha")) {
                    cadastrarSenha.setText("");
                }
            }
        });

        // Adicione um ActionListener ao botão de cadastro
        btn_cadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = campo_nome.getText();
                String cpf = campo_cpf.getText();
                int idade = Integer.parseInt(campo_idade.getText());

                Cliente cliente = new Cliente(nome, cpf, idade);

                String usuario = nomeUsuario.getText();
                String senha = new String(cadastrarSenha.getPassword());

                // Garanta que o DatabaseManager foi inicializado
                if (sistema.getDatabaseManager() != null) {
                    boolean isClienteSaved = sistema.getDatabaseManager().saveClienteWithCredentials(cliente, usuario, senha);
                    if (isClienteSaved) {
                        JOptionPane.showMessageDialog(rootPanel, "Cliente cadastrado com sucesso!");
                        loginScreen.setVisible(true);
                        ((Window) rootPanel.getTopLevelAncestor()).dispose();
                    } else {
                        JOptionPane.showMessageDialog(rootPanel, "Erro ao cadastrar o cliente!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    System.out.println("Erro: DatabaseManager não foi inicializado!");
                }
            }
        });
    }

    public void setLoginScreen(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
    }

}
