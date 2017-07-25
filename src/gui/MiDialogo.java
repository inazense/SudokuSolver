package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import utiles.Literales;

/**
 * Clase extendida de dialogo que usaremos para mostrar 
 * la información necesaria en nuestro programa
 * 
 * @author Inazio
 *
 */
@SuppressWarnings("serial")
public class MiDialogo extends JDialog {

	/// PROPIEDADES
	private final JPanel panelControlador;
	private final JPanel panelBotonera;
	
	private JLabel lblContenido;
	
	private JButton btnCerrar;
	
	private ActionListener actionCerrar;
	
	/// CONSTRUCTOR
	public MiDialogo(String contenido, String titulo) {
		
		this.inicializarActionListeners();
		
		this.panelControlador = new JPanel();
		
		setBounds(Literales.DIALOGO_X, Literales.DIALOGO_Y, Literales.DIALOGO_ANCHO, Literales.DIALOGO_LARGO);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		getContentPane().setLayout(new BorderLayout());
		this.panelControlador.setBorder(new EmptyBorder(Literales.DIALOGO_BORDER, Literales.DIALOGO_BORDER, Literales.DIALOGO_BORDER, Literales.DIALOGO_BORDER));
		getContentPane().add(this.panelControlador, BorderLayout.CENTER);
		this.panelControlador.setLayout(null);
		setModal(true);
		setTitle(titulo);
		
		this.lblContenido = new JLabel(contenido);
		this.lblContenido.setVerticalAlignment(SwingConstants.TOP);
		this.lblContenido.setBounds(Literales.LBL_DIALOGO_X, Literales.LBL_DIALOGO_Y, Literales.LBL_DIALOGO_ANCHO, Literales.LBL_DIALOGO_LARGO);
		this.panelControlador.add(this.lblContenido);
		{
			this.panelBotonera = new JPanel();
			this.panelBotonera.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(this.panelBotonera, BorderLayout.SOUTH);
			{
				this.btnCerrar = new JButton(Literales.BTN_DIALOGO_CERRAR);
				this.btnCerrar.setActionCommand(Literales.BTN_DIALOGO_CERRAR);
				this.btnCerrar.addActionListener(this.actionCerrar);
				this.panelBotonera.add(this.btnCerrar);
				getRootPane().setDefaultButton(this.btnCerrar);
			}
		}
		
	}
	
	/// METODOS
	private void inicializarActionListeners() {
		this.actionCerrar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		};
	}
}
