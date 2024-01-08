import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuDonoEmpresa extends JFrame{
    private List<Utilizador> users;
    private DonoEmpresa donoEmpresa;
    private JButton criarEmpresaButton;
    private JPanel panel1;
    private JButton terminarSessaoButton;
    private JButton gerirEmpresaButton;

    public MenuDonoEmpresa(List<Utilizador> users, DonoEmpresa donoEmpresa){
        this.donoEmpresa = donoEmpresa;
        this.users = users;
        criarEmpresaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CriarEmpresa(users, donoEmpresa);

            }
        });
        terminarSessaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login(users);
            }
        });
        gerirEmpresaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuGerirEmpresa(users, donoEmpresa);
            }
        });

        setTitle("Menu Dono Empresa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}

