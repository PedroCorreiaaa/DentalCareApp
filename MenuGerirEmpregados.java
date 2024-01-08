import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuGerirEmpregados extends JFrame{
    private List<Utilizador> users;
    private DonoEmpresa donoEmpresa;
    private Empresa empresa;
    private Consultorio consultorio;
    private JButton registarMedicoDentistaButton;
    private JPanel panel1;
    private JButton registarFuncionarioDeSecretariaButton;
    private JButton removerEmpregadoButton;
    private JButton voltarButton;
    public MenuGerirEmpregados(List<Utilizador> users, DonoEmpresa donoEmpresa, Empresa empresa, Consultorio consultorio){
        this.users = users;
        this.donoEmpresa = donoEmpresa;
        this.empresa = empresa;
        this.consultorio = consultorio;
        registarFuncionarioDeSecretariaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegistarFuncionario(users, donoEmpresa, empresa,consultorio);
            }
        });
        registarMedicoDentistaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegistarMedicoDentista(users, donoEmpresa, empresa, consultorio);
            }
        });
        removerEmpregadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RemoverEmpregado(users, donoEmpresa, empresa, consultorio);
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuGerirConsultorio(users,donoEmpresa,empresa);

            }
        });


        setTitle("Menu Gerir Empregados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


}
