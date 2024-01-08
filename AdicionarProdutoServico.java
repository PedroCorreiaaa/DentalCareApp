import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class AdicionarProdutoServico extends JFrame{
    private List<Utilizador> users;
    private Funcionario funcionario;
    private JComboBox comboBox1;
    private JPanel panel1;
    private JTextField nomeTextField;
    private JTextField precoTextField;
    private JTextField referenciaTextField;
    private JTextField quantidadeTextField;
    private JButton adicionarButton;
    private JButton voltarButton;

    public AdicionarProdutoServico(List<Utilizador> users, Funcionario funcionario){
        this.users = users;
        this.funcionario = funcionario;
        String[] opcoes = {"Serviço", "Produto"};
        comboBox1.setModel(new DefaultComboBoxModel<>(opcoes));

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                if ("Serviço".equals(comboBox1.getSelectedItem())) {
                    adicionarServico(funcionario.getConsultorio());
                } else {
                    adicionarProduto(funcionario.getConsultorio());
                }

            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuFuncionario(users, funcionario);
            }
        });

        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // Verifique se a opção selecionada é "Serviço"
                if ("Serviço".equals(comboBox1.getSelectedItem())) {
                    // Desative os campos de referência e quantidade se a opção for "Serviço"
                    referenciaTextField.setEnabled(false);
                    quantidadeTextField.setEnabled(false);
                } else {
                    // Caso contrário, habilite os campos
                    referenciaTextField.setEnabled(true);
                    quantidadeTextField.setEnabled(true);
                }
            }
        });
        setTitle("Adicionar Produto/Serviço");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void adicionarProduto(Consultorio consultorio){
        Produto produto = new Produto(referenciaTextField.getText(), nomeTextField.getText() ,Double.parseDouble(precoTextField.getText()), Integer.parseInt(quantidadeTextField.getText()));
        consultorio.getProdutosServicos().add(produto);
    }
    public void adicionarServico(Consultorio consultorio){
        Servico servico = new Servico(nomeTextField.getText(), Double.parseDouble(precoTextField.getText()));
        consultorio.getProdutosServicos().add(servico);
    }
}
