import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RegistoDonoEmpresa extends JFrame {
    private List<Utilizador> users;
    private Admin admin;
    private JTextField nome;
    private JTextField nCC;
    private JTextField nif;
    private JTextField email;
    private JPasswordField passwordField1;
    private JTextField contacto;
    private JTextField morada;
    private JButton registarButton;
    private JButton cancelarButton;
    private JPanel panel1;

    public RegistoDonoEmpresa(List<Utilizador> users, Admin admin){
        this.admin = admin;
        this.users = users;
        registarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarDonoEmpresa();
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
        setTitle("RegistarDonoEmpresa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void adicionarDonoEmpresa() {
        String numeroCC = nCC.getText();
        String password = new String(passwordField1.getPassword());

        if (nome.getText().isEmpty() || numeroCC.isEmpty() ||nif.getText().isEmpty() || email.getText().isEmpty() || contacto.getText().isEmpty() || morada.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (Utilizador u : users) {
            if (u instanceof Cliente && u.getNumerocc().equals(numeroCC)) {
                JOptionPane.showMessageDialog(this, "Número Cartão de Cidadão já está a ser usado", "Erro de Registo", JOptionPane.ERROR_MESSAGE);
                return; // Sai do método sem adicionar um novo Cliente
            }
        }

        DonoEmpresa donoEmpresa = new DonoEmpresa(nome.getText(), numeroCC, nif.getText(), email.getText(), password , contacto.getText(), morada.getText());
        users.add(donoEmpresa);
        JOptionPane.showMessageDialog(this, "Dono de Empresa registado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
}
