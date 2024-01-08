import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuMedicoDentista extends JFrame{
    private MedicoDentista medicoDentista;
    private List<Utilizador> users;
    private JButton listarConsultasButton;
    private JPanel panel1;
    private JButton gerirConsultaButton;
    private JButton terminarSessaoButton;

    public MenuMedicoDentista(List<Utilizador> users, MedicoDentista medicoDentista){
        this.medicoDentista = medicoDentista;
        this.users = users;
        listarConsultasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MostrarConsultasMedicoDentista(users,medicoDentista);

            }
        });
        terminarSessaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login(users);
            }
        });
        gerirConsultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GerirConsulta(users, medicoDentista);

            }
        });
        setTitle("Menu Médico Dentista");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
