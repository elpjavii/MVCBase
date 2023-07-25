package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.Font;

public class VentanaPpal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPpal frame = new VentanaPpal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPpal() {
		setTitle("Gestión de Biblioteca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][]", "[][]"));
		
		JButton btnNuevoLibro = new JButton("Nuevo Libro");
		btnNuevoLibro.setFont(new Font("Verdana", Font.PLAIN, 18));
		contentPane.add(btnNuevoLibro, "cell 1 1");
		
		JButton btnMostrarLibros = new JButton("Mostrar Libros");
		btnMostrarLibros.setFont(new Font("Verdana", Font.PLAIN, 18));
		contentPane.add(btnMostrarLibros, "cell 3 1");
	}

}
