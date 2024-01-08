import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RemoverEmpregado extends JFrame{
    private JPanel panel1;
    private JComboBox comboBox1;
    private JButton removerButton;
    private JButton voltarButton;
    private List<Utilizador> users;
    private DonoEmpresa donoEmpresa;
    private Empresa empresa;
    private Consultorio consultorio;

    public RemoverEmpregado(List<Utilizador> users, DonoEmpresa donoEmpresa, Empresa empresa, Consultorio consultorio){
        this.users = users;
        this.donoEmpresa = donoEmpresa;
        this.empresa = empresa;
        this.consultorio = consultorio;
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Funcionario funcionarioRemovido = obterEmpregadoComboBox(consultorio);
                removerEmpregado(users, consultorio, funcionarioRemovido);
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuGerirEmpregados(users, donoEmpresa, empresa,consultorio);
            }
        });

        comboBox1.setModel(new DefaultComboBoxModel<>(obterNomesEmpregados(consultorio).toArray(new String[0])));

        setTitle("Remover Empregado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public List<String> obterNomesEmpregados(Consultorio consultorio) {
        List<String> nomesEmpregados = new ArrayList<>();
        for (Funcionario funcionario : consultorio.getFuncionarios()) {
            nomesEmpregados.add(funcionario.getNome());
        }
        return nomesEmpregados;
    }

    public Funcionario obterEmpregadoComboBox(Consultorio consultorio){
        for(Funcionario f : consultorio.getFuncionarios()) {
            if (f.getNome().equals(comboBox1.getSelectedItem().toString())) {
                return f;
            }
        }
        return null;
    }

    public void removerEmpregado(List<Utilizador> users,Consultorio consultorio, Funcionario funcionario){
        consultorio.getFuncionarios().remove(funcionario);
        users.remove(funcionario);
        JOptionPane.showMessageDialog(RemoverEmpregado.this, "Empregado removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

    }
}
