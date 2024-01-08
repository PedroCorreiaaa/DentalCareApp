import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class RegistarAdmin extends JFrame{
    private List<Utilizador> users;
    private Admin admin;
    private JPanel panel1;
    private JTextField nAdmin;
    private JPasswordField passwordField1;
    private JButton registarButton;
    private JButton cancelarButton;
    public RegistarAdmin(Admin admin,List<Utilizador> users){
        this.users = users;
        this.admin = admin;
        registarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarAdmin();
                dispose();
                new MenuAdmin(users, admin);
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuAdmin(users, admin);
            }
        });
        setTitle("RegistarCliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void adicionarAdmin() {
        String numeroAdmin = nAdmin.getText();
        String passAdmin = new String(passwordField1.getPassword());

        if (numeroAdmin.isEmpty() || passAdmin.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Verifica se o número do admin já está a ser
        for (Utilizador u : users) {
            if (u instanceof Admin && u.getNumerocc().equals(numeroAdmin)) {
                JOptionPane.showMessageDialog(this, "Número Admin já está a ser usado", "Erro de Registo", JOptionPane.ERROR_MESSAGE);
                return; // Sai do método sem adicionar um novo Admin
            }
        }

        // Se não encontrou um número de admin duplicado, adiciona o novo Admin
        Admin novoAdmin = new Admin(null, numeroAdmin, null, null, passAdmin, null, null);
        users.add(novoAdmin);
        JOptionPane.showMessageDialog(this, "Admin registado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

}
