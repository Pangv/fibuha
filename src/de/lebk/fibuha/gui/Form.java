package de.lebk.fibuha.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.NumberFormat;

/**
 * @author sopaetzel
 */
public class Form {
    private JPanel pnlForm;
    private JTabbedPane tpnFibuha;
    private JPanel pnlAccountManager;
    private JPanel pnlPostings;
    private JPanel pnlClosure;
    private JPanel pnlEvaluation;
    private JTextField txtfAccountNumber;
    private JButton btnAccountCreate;
    private JTextField txtfAccountDescription;
    private JButton btnAccountSearch;
    private JButton btnAccountShow;
    private JButton btnAccountDelete;
    private JTextArea txtaAccountsView;
    private JLabel lblAccountNumber;
    private JLabel lblAccountDescription;
    private JScrollPane scrlAccountsView;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton buchungDurchführenButton;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JFormattedTextField ftxtfPostingValue;
    private JLabel lblFibuha;


    public Form() {
        createUIComponents();
        initActionListener();
    }

    public static void main(String[] args) {
        setLookAndFeel();


        Dimension dimension = new Dimension(658, 239);
        JFrame frame = new JFrame("svennoTec - Finanzbuchhaltung");
        JPanel container = new Form().pnlForm;

        frame.setContentPane(container);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(dimension);
        try {
            frame.setIconImage(ImageIO.read(Form.class.getResourceAsStream("/so-icon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.pack();
        frame.setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }


    private void initActionListener() {
        //General
        lblFibuha.addMouseListener(new MouseAdapter() {
            boolean flag = false;
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!flag){
                    lblFibuha.setText("Finanz Buch Haltung");
                    flag = !flag;
                }else {
                    lblFibuha.setText("Fi Bu Ha");
                    flag = !flag;
                }
            }
        });

        // Accounts
        btnAccountSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Suche...");
            }
        });

        btnAccountCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Konto anlegen...");
            }
        });

        btnAccountDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Wollen Sie das Konto wirklich löschen?", "Achtung, Danger Zone", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION) {
                    System.out.println("Konto gelöscht");
                } else {
                    System.out.println("Löschen abgebrochen");
                }
            }
        });
        btnAccountShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Kontoanzeige...");
            }
        });
        // Postings


    }

    private void createUIComponents() {

        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMaximumFractionDigits(2);
        format.setMaximumIntegerDigits(8);

        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setMinimum(0.0);
        formatter.setAllowsInvalid(false);
        formatter.setOverwriteMode(true);

        ftxtfPostingValue = new JFormattedTextField(formatter);
        ftxtfPostingValue.setValue(0.0);

    }
}
