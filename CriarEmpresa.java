import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CriarEmpresa extends JFrame{
    private List<Utilizador> users;
    private DonoEmpresa donoEmpresa;
    private JTextField nomeTextField;
    private JTextField moradaTextField;
    private JTextField localidadeTextField;
    private JTextField nContactoTextField;
    private JButton proximoButton;
    private JButton cancelarButton;
    private JPanel panel1;

    public CriarEmpresa(List<Utilizador> users, DonoEmpresa donoEmpresa){
        this.users = users;
        this.donoEmpresa = donoEmpresa;
        proximoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                adicionarEmpresa(donoEmpresa);
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuDonoEmpresa(users, donoEmpresa);
            }
        });
        setTitle("RegistarEmpresa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void adicionarEmpresa(DonoEmpresa donoEmpresa) {
        String nome = nomeTextField.getText();
        String morada = moradaTextField.getText();
        String localidade = localidadeTextField.getText();
        String nContacto = nContactoTextField.getText();

        if (nome.isEmpty() || morada.isEmpty() || localidade.isEmpty() || nContacto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        for(Empresa e : donoEmpresa.getEmpresas()) {
            if (e.getNome().equals(nome)) {
                JOptionPane.showMessageDialog(this, "Já existe uma empresa com esse nome", "Erro de Registo", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        Empresa empresa = new Empresa(nome, morada, localidade, nContacto);
        donoEmpresa.getEmpresas().add(empresa);
        empresa.getMapaLocalidadeParaEmpresas().put(localidade, empresa);
        JOptionPane.showMessageDialog(this, "Empresa criada com sucesso, é necessário criar o primeiro consultório!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        dispose();
        new CriarConsultorio(users, donoEmpresa, empresa);
    }

}
