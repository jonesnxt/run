package run;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;

import crypto.Convert;


public class Frontend extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1148096923975405519L;
	public Backend back;
	
	public Frontend() {
		initUI();
		back = new Backend();
	}
	
	private void initUI() {

        Container pane = getContentPane();
        //GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(new FlowLayout());
        
        final JTextField myAccountField = new JTextField("My Account", 25);
        JButton broadcastButton = new JButton("Send Transaction");
        final JTextField bytesField = new JTextField("TX_bytes", 25);

        broadcastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               // do things here
                
            }
        });
        // NXT-RJU8-JSNR-H9J4-2KWKY
        pane.add(myAccountField);
        pane.add(bytesField);
        pane.add(broadcastButton);
        
        pane.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);

        setTitle("Jay Run Wallet");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
