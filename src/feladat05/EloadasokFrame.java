package feladat05;

import javax.swing.JFrame;


public class EloadasokFrame {

	private JFrame frmEloadasok;
	

	public JFrame getFrmEloadasok() {
		return frmEloadasok;
	}

	
	public EloadasokFrame() {
		initialize();
		
		
	}


	private void initialize() {
		
		frmEloadasok = new JFrame();	
		frmEloadasok.setTitle("házi előadások");
		frmEloadasok.setBounds(100, 100, 700, 400);
		frmEloadasok.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEloadasok.getContentPane().setLayout(null);
		
	}
	
	
	
}
