package run;

import java.awt.EventQueue;

import crypto.Convert;

public class Run {

	public static void main(String[] args) {
		System.out.println("RUNNING RUN");
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Frontend ex = new Frontend();
                ex.setVisible(true);
            }
        });
	}

}
