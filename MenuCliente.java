import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuCliente extends JFrame{
    private List<Utilizador> users;
    private Cliente cliente;
    private JButton marcarConsultaButton;
    private JButton terminarSessaoButton;
    private JPanel panel1;
    private JTextArea textArea1;
    private JButton listarConsultasButton;
    private JButton pagarConsultaButton;

    public MenuCliente(List<Utilizador> users, Cliente cliente){
        textArea1.setEditable(false);
        textArea1.setText(cliente.getNome());
        this.cliente = cliente;
        this.users = users;
        marcarConsultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MarcarConsulta(cliente, users);

            }
        });
        listarConsultasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MostrarConsultasCliente(users,cliente);

            }
        });
        terminarSessaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login(users);
            }
        });
        pagarConsultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new PagarConsulta(users, cliente);
            }
        });
        setTitle("Menu Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
