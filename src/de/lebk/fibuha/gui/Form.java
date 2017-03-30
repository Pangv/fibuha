package de.lebk.fibuha.gui;

import de.lebk.fibuha.account.Account;
import de.lebk.fibuha.dao.DataAccessObject;
import de.lebk.fibuha.posting.PostingRecord;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Iterator;

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
    private JTextField txtfPostingValue;
    private JTextField txtfAccountDescription;
    private JButton btnAccountCreate;
    private JButton btnAccountSearch;
    private JButton btnAccountShow;
    private JButton btnAccountDelete;
    private JTextArea txtaAccountsView;
    private JLabel lblAccountNumber;
    private JLabel lblAccountDescription;
    private JScrollPane scrlAccountsView;
    private JComboBox<Account> cbxDebit;
    private JComboBox<Account> cbxCredit;
    private JButton btnExecutePosting;
    private JTextArea txtaMessage;
    private JTextArea txtaLandRegister;
    private JTextArea txtaLedger;
    private JLabel lblFibuha;
    private JLabel lblLogo;
    private JLabel lblPostingValue;
    private JLabel lblMessage;
    private JLabel lblLandRegister;
    private JLabel lblLedger;


    public Form() {
        createUIComponents();
        fillComboBoxes();
        initActionListener();
    }

    public static void main(String[] args) {
        setLookAndFeel();


        Dimension dimension = new Dimension(750, 380);
        JFrame frame = new JFrame("svennoTec - Finanzbuchhaltung");
        JPanel container = new Form().pnlForm;

        frame.setContentPane(container);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(dimension);
        frame.setName("Finanzbuchhaltung");
        try {
            frame.setIconImage(ImageIO.read(Form.class.getResourceAsStream("/so-icon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.pack();
        frame.setVisible(true);
    }


    private void initActionListener() {
        //General
        lblFibuha.addMouseListener(new MouseAdapter() {
            boolean flag = false;

            @Override
            public void mouseClicked(MouseEvent e) {
                if (!flag) {
                    lblFibuha.setText("Finanz Buch Haltung");
                    flag = !flag;
                } else {
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
                Account account = DataAccessObject.getInstance().searchAccount(Integer.parseInt(txtfAccountNumber.getText()));

                if (account != null){
                    txtaAccountsView.setText("");
                    txtaAccountsView.append(account.toScreen());

                }else {
                    txtaAccountsView.setText("Konto "+ txtfAccountNumber.getText() +" wurde nicht gefunden");

                }
            }
        });

        btnAccountCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (DataAccessObject.getInstance().searchAccount(Integer.parseInt(txtfAccountNumber.getText())) == null) {
                    DataAccessObject.getInstance().addAccount((Integer.parseInt(txtfAccountNumber.getText())), txtfAccountDescription.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Konto ist bereits vorhanden");
                }


            }
        });

        btnAccountDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Wollen Sie das Konto wirklich löschen?", "Achtung, Danger Zone", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION) {
                    DataAccessObject.getInstance().removeAccount(Integer.parseInt(txtfAccountNumber.getText()));

                    System.out.println("Konto gelöscht");
                } else {
                    System.out.println("Löschen abgebrochen");
                }
            }
        });
        btnAccountShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtaAccountsView.setText("");
                Iterator<Account> accountIterator = DataAccessObject.getInstance().getAccountList().iterator();
                Account account;
                while (accountIterator.hasNext()) {
                    account = accountIterator.next();
                    System.out.println(account.getAccountNumber() + " " + account.getAccountDescription());
                    txtaAccountsView.append(account.toScreen());
                }
            }
        });

        //Postings
        btnExecutePosting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Account debit = (Account) cbxDebit.getSelectedItem();
                Account credit = (Account) cbxCredit.getSelectedItem();
                String postingValue = txtfPostingValue.getText();

                PostingRecord postingRecord = new PostingRecord(debit, credit, postingValue);

                txtaLandRegister.append("Stand der Konten vor der Buchung:\n\n");
                txtaLandRegister.append(debit.toScreen());
                txtaLandRegister.append(credit.toScreen());
                txtaLandRegister.append("\n");

                txtaMessage.setText(postingRecord.executePosting());

                txtaLedger.setText(postingRecord.toString());

                txtaLandRegister.append("Stand der Konten nach der Buchung:\n\n");
                txtaLandRegister.append(debit.toScreen());
                txtaLandRegister.append(credit.toScreen());
            }
        });

        //Tab Listener
        tpnFibuha.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JTabbedPane tabbedPane = (JTabbedPane) e.getSource();
                int index = tabbedPane.getSelectedIndex();
                System.out.println("Changed to: " + tabbedPane.getComponentAt(index).getName());
                fillComboBoxes();
                //TODO update target-component
            }
        });


    }

    private void fillComboBoxes() {
        DefaultComboBoxModel<Account> accountDefaultComboBoxModelLeft = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<Account> accountDefaultComboBoxModelRight = new DefaultComboBoxModel<>();
        Iterator<Account> accountIterator = DataAccessObject.getInstance().getAccountList().iterator();
        Account account;
        while (accountIterator.hasNext()) {
            account = accountIterator.next();
            accountDefaultComboBoxModelLeft.addElement(account);
            accountDefaultComboBoxModelRight.addElement(account);
        }
        cbxDebit.setModel(accountDefaultComboBoxModelLeft);
        cbxCredit.setModel(accountDefaultComboBoxModelRight);

    }

    private void createUIComponents() {


    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            System.err.println("LaF wurde nicht gefunden");
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.err.println("");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.err.println(" ");
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println("LaF wird auf diesem System nicht unterstützt.");
            e.printStackTrace();
        }
    }

}
