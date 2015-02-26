package run;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.text.DefaultEditorKit;

import crypto.Convert;


public class Frontend extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1148096923975405519L;
	public Backend back;
	
	public Frontend() {
		back = new Backend();
		initUI();
	}
	
	private void initUI() {

        Container pane = getContentPane();
        //GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(new FlowLayout());
        
        final JLabel myAccountLabel = new JLabel("Your Address");
        final JTextField myAccountField = new JTextField(back.getAccountRS(), 40);
        myAccountField.setBackground(Color.LIGHT_GRAY);
        myAccountField.setEditable(false); 
        JButton broadcastButton = new JButton("Send Transaction");
        final JTextField bytesField = new JTextField("TX_bytes", 40);
        final JLabel bytesLabel = new JLabel("Bytes           ");
        final JLabel overview = new JLabel("\n\nready");

        broadcastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	byte[] bytes = back.unzip(bytesField.getText());
            	
            }
        });
        // NXT-RJU8-JSNR-H9J4-2KWKY
        pane.add(myAccountLabel);
        pane.add(myAccountField);
        pane.add(bytesLabel);
        pane.add(bytesField);
        pane.add(broadcastButton);
        pane.add(overview);
        
        pane.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);

        setTitle("Run Wallet");
        setSize(560, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
