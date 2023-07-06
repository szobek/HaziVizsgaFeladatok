
package felada05;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class EloadasokFrame {
	List<Eloadas> eloadasok = new ArrayList<Eloadas>();

	private static String dbName = "szinhaz_eloadasok_db";
	private static String dbPort = "3306";
	private static String dbUrl = "localhost";
DefaultListModel<Eloadas> lm = new DefaultListModel<Eloadas>();
	private JFrame frmEloadasok;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EloadasokFrame window = new EloadasokFrame();
					window.frmEloadasok.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrmEloadasok() {
		return frmEloadasok;
	}

	public EloadasokFrame() {
		initialize();
		

	}

	private void initialize() {

		frmEloadasok = new JFrame();
		frmEloadasok.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				String[] valaszok = { "Igen", "Nem" };
				if (JOptionPane.showOptionDialog(frmEloadasok, "Biztos,hogy kilép?", "Kilépés", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, valaszok, valaszok[1]) == JOptionPane.YES_OPTION) {
					System.exit(0);

				}
			}
		});
		frmEloadasok.setTitle("házi előadások");
		frmEloadasok.setBounds(100, 100, 700, 400);
		frmEloadasok.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmEloadasok.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 664, 246);
		frmEloadasok.getContentPane().add(scrollPane);
		connectToDb();
		
		//list = new JList<Tanulo>(lm);
		JList<Eloadas> list = new JList<Eloadas>(lm);
		lm.addAll(eloadasok);
		
		scrollPane.setViewportView(list);
		
		JButton btnExit = new JButton("Kilépés");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEloadasok.dispatchEvent(new WindowEvent(frmEloadasok, WindowEvent.WINDOW_CLOSING));
			}
		});
		btnExit.setBounds(265, 310, 89, 23);
		frmEloadasok.getContentPane().add(btnExit);

	}

	private void connectToDb() {
		String connectioString = "jdbc:mysql://" + dbUrl + ":" + dbPort + "/" + dbName + "";
		
		try(Connection con=  DriverManager.getConnection(connectioString,"root","")){
			Class.forName("com.mysql.jdbc.Driver");		
			System.out.println("kapcsolódva");
			String sql = "select * FROM eloadasok";
			PreparedStatement query = con.prepareStatement(sql);
			
			ResultSet rs =query.executeQuery();
			while(rs.next()) {
				eloadasok.add(new Eloadas(rs.getString("cim"), rs.getString("rendezo"), rs.getDate("bemutato").toLocalDate(), rs.getInt("eloadas_szam")));
			}
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
