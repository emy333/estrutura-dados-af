package sistemaDeCaixa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {

    private Map<String, String[]> pessoas;

    public MainFrame() {
        pessoas = new HashMap<>();
        pessoas.put("123.456.789-00", new String[]{"João", "(11) 1234-5678", "Rua A, 123"});
        pessoas.put("987.654.321-00", new String[]{"Maria", "(11) 8765-4321", "Rua B, 456"});
        initialize();
    }

    public void initialize() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel searchPanel = new JPanel();
        JLabel cpfLabel = new JLabel("CPF:");
        JTextField cpfField = new JTextField(15);
        JButton searchButton = new JButton("Buscar");

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText();
                if (pessoas.containsKey(cpf)) {
                    String[] pessoaInfo = pessoas.get(cpf);

                    // Tabela com informações das pessoas
                    String[] colunas = {"Nome", "Telefone", "Endereço"};
                    DefaultTableModel model = new DefaultTableModel(colunas, 0);
                    JTable table = new JTable(model);
                    table.setEnabled(false); // Desabilita edição na tabela
                    JScrollPane scrollPane = new JScrollPane(table);

                    // Preenchendo a tabela com os dados da pessoa encontrada
                    model.addRow(new Object[]{pessoaInfo[0], pessoaInfo[1], pessoaInfo[2]});

                    // Exibe a tabela em uma caixa de diálogo
                    JOptionPane.showMessageDialog(MainFrame.this, scrollPane, "Informações da Pessoa", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(MainFrame.this, "Pessoa não encontrada.", "Resultado da busca", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        searchPanel.add(cpfLabel);
        searchPanel.add(cpfField);
        searchPanel.add(searchButton);

        mainPanel.add(searchPanel, BorderLayout.NORTH);

        setTitle("Busca por CPF");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        add(mainPanel);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}