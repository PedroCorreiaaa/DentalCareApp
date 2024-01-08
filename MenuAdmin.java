import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class MenuAdmin extends JFrame{
    private List<Utilizador> users;
    private Admin admin;
    private JPanel panel1;
    private JButton registarAdminButton;
    private JButton registarDonoDeEmpresaButton;
    private JButton desativarEmpresasButton;
    private JButton desativarDonosDeEmpresasButton;
    private JButton terminarSessaoButton;

    public MenuAdmin(List<Utilizador> users,Admin admin){
        this.users = users;
        this.admin = admin;

        registarAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegistarAdmin(admin, users);

            }
        });
        registarDonoDeEmpresaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegistoDonoEmpresa(users, admin);

            }
        });
        terminarSessaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login(users);
            }
        });
        setTitle("Menu Admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}