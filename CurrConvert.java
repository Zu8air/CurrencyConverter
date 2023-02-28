package CurrencyConverter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CurrConvert {

    private JFrame frame;
    private JTextField txtamount;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CurrConvert window = new CurrConvert();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public CurrConvert() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
        frame.getContentPane().setBackground(new Color(0, 100, 100));
        frame.setBounds(100, 100, 715, 447);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("From :");
        lblNewLabel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel.setBounds(161, 135, 148, 44);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("To :");
        lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel_1.setBounds(161, 219, 148, 44);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Enter Amount:");
        lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel_2.setBounds(161, 50, 158, 44);
        frame.getContentPane().add(lblNewLabel_2);

        txtamount = new JTextField();
        txtamount.setFont(new Font("Arial Black", Font.PLAIN, 17));
        txtamount.setBounds(339, 54, 216, 44);
        frame.getContentPane().add(txtamount);
        txtamount.setColumns(10);

        final JComboBox txtfrom = new JComboBox();
        txtfrom.setModel(new DefaultComboBoxModel(new String[] {"INR", "USD", "YEN"}));
        txtfrom.setFont(new Font("Arial Black", Font.PLAIN, 17));
        txtfrom.setBounds(339, 138, 193, 44);
        frame.getContentPane().add(txtfrom);

        final JComboBox txtto = new JComboBox();
        txtto.setModel(new DefaultComboBoxModel(new String[] {"INR", "USD", "YEN"}));
        txtto.setFont(new Font("Arial Black", Font.PLAIN, 17));
        txtto.setBounds(339, 222, 193, 44);
        frame.getContentPane().add(txtto);

        JButton btnNewButton = new JButton("Convert");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double tot;

                Double amount = Double.parseDouble(txtamount.getText());
                if(txtfrom.getSelectedItem().toString().equals("USD") && txtto.getSelectedItem().toString().equals("INR")) {
                    tot=amount*82.90;
                    JOptionPane.showMessageDialog(null, "Converted Amount is " + tot.toString(), null,0);
                    JOptionPane jOptionPane = new JOptionPane();
                    jOptionPane.setFont(new Font("Arial",Font.BOLD | Font.ITALIC,13));
                }
                else if(txtfrom.getSelectedItem().toString()=="INR"&&txtto.getSelectedItem().toString()=="USD")
                {
                    tot=amount/82.90;
                    JOptionPane.showMessageDialog(null ,"Your Amount is "+tot.toString(), null, 0);

                }
                else if(txtfrom.getSelectedItem().toString()=="INR"&&txtto.getSelectedItem().toString()=="YEN")
                {
                    tot=amount*1.65;
                    JOptionPane.showMessageDialog(null ,"Your Amount is "+tot.toString(), null, 0);

                }
                else if(txtfrom.getSelectedItem().toString()=="YEN"&&txtto.getSelectedItem().toString()=="INR")
                {
                    tot=amount/1.65;
                    JOptionPane.showMessageDialog(null ,"Your Amount is "+tot.toString(), null, 0);

                }
                else if(txtfrom.getSelectedItem().toString()=="USD"&&txtto.getSelectedItem().toString()=="YEN")
                {
                    tot=amount*136.46;
                    JOptionPane.showMessageDialog(null ,"Your Amount is "+tot.toString(), null, 0);

                }
                else if(txtfrom.getSelectedItem().toString()=="YEN"&&txtto.getSelectedItem().toString()=="USD")
                {
                    tot=amount/136.46;
                    JOptionPane.showMessageDialog(null ,"Your Amount is "+tot.toString(), null, 0);

                }
            }
        });
        btnNewButton.setBackground(new Color(215, 247, 242));
        btnNewButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
        btnNewButton.setBounds(275, 292, 115, 44);
        frame.getContentPane().add(btnNewButton);
    }
}