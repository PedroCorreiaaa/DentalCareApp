import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PagarConsulta extends JFrame{
    private List<Utilizador> users;
    private Cliente cliente;
    private JTextField nCartaoTextField;
    private JPanel panel1;
    private JTextField validadeTextField;
    private JPasswordField passwordField1;
    private JTextField nomeTextField;
    private JButton pagarButton;
    private JButton voltarButton;
    private JComboBox comboBox1;

    public PagarConsulta(List<Utilizador> users, Cliente cliente){
        this.users = users;
        this.cliente = cliente;
        pagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagarConsulta(obterConsultaComboBox(cliente));

            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuCliente(users, cliente);
            }
        });

        comboBox1.setModel(new DefaultComboBoxModel<>(obterDatasConsultas(cliente).toArray(new String[0])));

        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public List<String> obterDatasConsultas(Cliente cliente) {
        List<String> datasConsultas = new ArrayList<>();
        for (Consulta consulta : cliente.getConsultas()) {
            if(!consulta.isPaga()){
                datasConsultas.add(consulta.getData().toString());
            }
        }
        return datasConsultas;
    }
    public Consulta obterConsultaComboBox(Cliente cliente){
        for(Consulta c : cliente.getConsultas()) {
            if (c.getData().toString().equals(comboBox1.getSelectedItem().toString())) {
                return c;
            }
        }
        return null;
    }
    public void pagarConsulta(Consulta consulta){
        consulta.setPaga(true);
        JOptionPane.showMessageDialog(null, "Pagamento efetuado com sucesso!",
                "Aviso de Pagamento", JOptionPane.INFORMATION_MESSAGE);
    }
}
