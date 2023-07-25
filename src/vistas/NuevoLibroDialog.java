package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class NuevoLibroDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NuevoLibroDialog dialog = new NuevoLibroDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NuevoLibroDialog() {
		setBounds(100, 100, 464, 327);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][][grow][grow][][grow][]", "[][][][][][][][][]"));
		{
			JLabel lblNewLabel = new JLabel("Introduce los datos del libro:");
			lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
			contentPanel.add(lblNewLabel, "cell 1 1 5 1,growx");
		}
		{
			JLabel lblNewLabel_1 = new JLabel("ISBN:");
			lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
			contentPanel.add(lblNewLabel_1, "cell 1 3,alignx trailing");
		}
		{
			textField = new JTextField();
			contentPanel.add(textField, "cell 2 3 5 1,growx");
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Título:");
			lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
			contentPanel.add(lblNewLabel_1, "cell 1 4,alignx trailing");
		}
		{
			textField_1 = new JTextField();
			contentPanel.add(textField_1, "cell 2 4 5 1,growx");
			textField_1.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Cód Editorial:");
			lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
			contentPanel.add(lblNewLabel_1, "cell 1 5,alignx trailing");
		}
		{
			textField_2 = new JTextField();
			contentPanel.add(textField_2, "cell 2 5 2 1,growx");
			textField_2.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Año:");
			lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
			contentPanel.add(lblNewLabel_1, "cell 1 6,alignx right");
		}
		{
			JSpinner spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(Integer.valueOf(2023), Integer.valueOf(1900), null, Integer.valueOf(1)));
			contentPanel.add(spinner, "cell 2 6,growx");
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Núm Páginas:");
			lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
			contentPanel.add(lblNewLabel_1, "cell 3 6 2 1");
		}
		{
			JSpinner spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(200, 1, 50000, 1));
			contentPanel.add(spinner, "cell 5 6,growx");
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Precio: ");
			lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
			contentPanel.add(lblNewLabel_1, "cell 1 7,alignx trailing");
		}
		{
			textField_3 = new JTextField();
			contentPanel.add(textField_3, "cell 2 7,growx");
			textField_3.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("PrecioCD: ");
			lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
			contentPanel.add(lblNewLabel_1, "cell 4 7,alignx trailing");
		}
		{
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			contentPanel.add(textField_4, "cell 5 7,growx");
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Cantidad:");
			lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
			contentPanel.add(lblNewLabel_1, "cell 1 8,alignx right");
		}
		{
			JSpinner spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
			contentPanel.add(spinner, "cell 2 8,growx");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Insertar");
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

}
