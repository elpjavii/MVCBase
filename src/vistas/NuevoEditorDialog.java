package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import excepciones.BBDDException;
import excepciones.CantidadDebeSerPositivaException;
import modelo.Editorial;
import modelo.Libro;
import net.miginfocom.swing.MigLayout;

public class NuevoEditorDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textAnio;
	private Controlador controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NuevoEditorDialog dialog = new NuevoEditorDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NuevoEditorDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[105.00][grow]", "[][64.00][][]"));
		{
			JLabel lblNewLabel_2 = new JLabel("Inserta Una Editorial");
			contentPanel.add(lblNewLabel_2, "cell 0 0 2 1,alignx center");
		}
		{
			JLabel lblNewLabel = new JLabel("Nombre");
			contentPanel.add(lblNewLabel, "cell 0 2,alignx trailing");
		}
		{
			textNombre = new JTextField();
			contentPanel.add(textNombre, "cell 1 2,growx");
			textNombre.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("año");
			contentPanel.add(lblNewLabel_1, "cell 0 3,alignx trailing");
		}
		{
			textAnio = new JTextField();
			contentPanel.add(textAnio, "cell 1 3,growx");
			textAnio.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("insertar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Editorial e1 =validarDatos();
						
						if (e1!=null) {
							try {
								controlador.insertaEditorial(e1);
							} catch (BBDDException e11) {
								JOptionPane.showConfirmDialog(contentPanel, 
										e11.getMessage(),
										"Error insertando los datos",JOptionPane.ERROR_MESSAGE);
							}
						}
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected Editorial validarDatos() {
		Editorial e = null;
		
		try {
			String nombre = textNombre.getText();
			int anio = Integer.parseInt(textAnio.getText());
			
			if (nombre==null || nombre.isBlank()) {
				JOptionPane.showConfirmDialog(contentPanel, 
						"Debe introducir Editorial",
						"error en los datos",JOptionPane.ERROR_MESSAGE);
				return e;
			}
			
			e = new Editorial(nombre, anio);
		} catch (NumberFormatException e1) {
			JOptionPane.showConfirmDialog(contentPanel, 
					"DEbe introducir un número válido en código Editorial, precio y precio CD",
					"error en los datos",JOptionPane.ERROR_MESSAGE);
			return e;
		} 
		
		
		
		return e;
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador=controlador;
	}

}
