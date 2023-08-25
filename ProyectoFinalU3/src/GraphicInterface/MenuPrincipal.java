package GraphicInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.GapContent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import ClassToGraph.*;
import GraphicInterface.*;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private Graph grafo = new Graph();
	private InformacionGrafo info = new InformacionGrafo();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnFondo = new JPanel();
		pnFondo.setBounds(0, 0, 645, 378);
		contentPane.add(pnFondo);
		pnFondo.setLayout(null);
		
		JPanel pnPrincipal = new JPanel();
		pnPrincipal.setBounds(0, 0, 431, 378);
		pnFondo.add(pnPrincipal);
		pnPrincipal.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("de los algoritmos voraces");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_1.setBounds(123, 61, 307, 30);
		pnPrincipal.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Bienvenido a el uso");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(146, 33, 257, 29);
		pnPrincipal.add(lblNewLabel);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/FondoDifinitivo.jpg")));
		lblFondo.setBounds(1, 0, 429, 378);
		pnPrincipal.add(lblFondo);
		
		JPanel pnMenu = new JPanel();
		pnMenu.setBounds(429, 0, 216, 378);
		pnFondo.add(pnMenu);
		pnMenu.setLayout(null);
		
		JPanel pnIngresarInfoGrafo = new JPanel();
		pnIngresarInfoGrafo.setBounds(10, 50, 196, 34);
		pnMenu.add(pnIngresarInfoGrafo);
		pnIngresarInfoGrafo.setLayout(null);
		
		JLabel lblInfoGrafo = new JLabel("Ingresar Información del grafo");
		lblInfoGrafo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InformacionGrafo info = new InformacionGrafo();
				info.setVisible(true);
				setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnIngresarInfoGrafo.setBackground(Color.MAGENTA);
				lblInfoGrafo.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnIngresarInfoGrafo.setBackground(new Color(240,240,240));
				lblInfoGrafo.setForeground(Color.BLACK);
			}
		});
		lblInfoGrafo.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblInfoGrafo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoGrafo.setBounds(0, 0, 196, 34);
		pnIngresarInfoGrafo.add(lblInfoGrafo);
		
		JPanel pnAlgoritmoD = new JPanel();
		pnAlgoritmoD.setLayout(null);
		pnAlgoritmoD.setBounds(10, 110, 196, 34);
		pnMenu.add(pnAlgoritmoD);
		
		JLabel lblAlgoritmoD = new JLabel("Algoritmo Dijkstra ");
		lblAlgoritmoD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InformacionGrafo.algoritmoDijkstra();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnAlgoritmoD.setBackground(Color.MAGENTA);
				lblAlgoritmoD.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnAlgoritmoD.setBackground(new Color(240,240,240));
				lblAlgoritmoD.setForeground(Color.BLACK);
			}
		});
		lblAlgoritmoD.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblAlgoritmoD.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlgoritmoD.setBounds(0, 0, 196, 34);
		pnAlgoritmoD.add(lblAlgoritmoD);
		
		JPanel pnAlgoritmoC = new JPanel();
		pnAlgoritmoC.setLayout(null);
		pnAlgoritmoC.setBounds(10, 170, 196, 34);
		pnMenu.add(pnAlgoritmoC);
		
		JLabel lblAlgoritmoC = new JLabel("Algoritmo Coloreo voraz");
		lblAlgoritmoC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InformacionGrafo.algoritmoColoreoVoraz();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnAlgoritmoC.setBackground(Color.MAGENTA);
				lblAlgoritmoC.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnAlgoritmoC.setBackground(new Color(240,240,240));
				lblAlgoritmoC.setForeground(Color.BLACK);
			}
		});
		lblAlgoritmoC.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblAlgoritmoC.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlgoritmoC.setBounds(0, 0, 196, 34);
		pnAlgoritmoC.add(lblAlgoritmoC);
		
		JPanel pnAlgoritmoK = new JPanel();
		pnAlgoritmoK.setLayout(null);
		pnAlgoritmoK.setBounds(10, 230, 196, 34);
		pnMenu.add(pnAlgoritmoK);
		
		JLabel lblAlgoritmoK = new JLabel("Algoritmo Kruskal");
		lblAlgoritmoK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InformacionGrafo.algoritmoKruskal();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnAlgoritmoK.setBackground(Color.MAGENTA);
				lblAlgoritmoK.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnAlgoritmoK.setBackground(new Color(240,240,240));
				lblAlgoritmoK.setForeground(Color.BLACK);
			}
		});
		lblAlgoritmoK.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblAlgoritmoK.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlgoritmoK.setBounds(0, 0, 196, 34);
		pnAlgoritmoK.add(lblAlgoritmoK);
		
		JPanel pnSalir = new JPanel();
		pnSalir.setLayout(null);
		pnSalir.setBounds(10, 290, 196, 34);
		pnMenu.add(pnSalir);
		
		JLabel lblSalir = new JLabel("Salir");
		lblSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Gracias por utilizar el programa");
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnSalir.setBackground(Color.MAGENTA);
				lblSalir.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnSalir.setBackground(new Color(240,240,240));
				lblSalir.setForeground(Color.BLACK);
			}
		});
		lblSalir.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalir.setBounds(0, 0, 196, 34);
		pnSalir.add(lblSalir);
	}
}
