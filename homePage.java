import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class homePage {
    private JLabel home;
    private JButton btn_user_account;

    public homePage() {
/*        btn_user_account.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (*//* Verifique aqui se o usuário está logado *//*) {
                    // Abre a janela da conta do usuário
                    userAccount ua = new userAccount();
                    ua.setVisible(true);
                } else {
                    // Abre a janela de login
                    LoginScreen ls = new LoginScreen();
                    ls.setVisible(true);
                }
            }
        });*/
    }
}
