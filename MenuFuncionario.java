import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuFuncionario extends JFrame{
    private List<Utilizador> users;
    private Funcionario funcionario;
    private JButton listarConsultasButton;
    private JPanel panel1;
    private JButton adicionarProdutoServicoButton;
    private JButton terminarSessaoButton;

    public MenuFuncionario(List<Utilizador> users, Funcionario funcionario){
        this.funcionario = funcionario;
        this.users = users;
        listarConsultasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MostrarConsultasFuncionario(users, funcionario);
            }
        });
        terminarSessaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login(users);
            }
        });
        adicionarProdutoServicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdicionarProdutoServico(users, funcionario);
            }
        });


        setTitle("Menu Funcionário");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
