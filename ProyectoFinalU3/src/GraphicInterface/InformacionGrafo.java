package GraphicInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import ClassToGraph.*;
import java.util.*;

public class InformacionGrafo extends JFrame {

	private JPanel contentPane;
	private JTextField txtIngreseElNombre;
	private JTextField txtNombreAutor;
	private JTextField txtNumPag;
	private JTextField txtFechaP;
	private JTextField txtOrigen;
	private JTextField txtDestino;
	private JTextField txtPeso;
	static List<Libro> libros = new ArrayList<>();
	List<Edge> aristas = new ArrayList<>();
	static Graph grafo = new Graph();
	static Graph grafo1 = new Graph();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformacionGrafo frame = new InformacionGrafo();
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
	public InformacionGrafo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtPeso = new JTextField();
		txtPeso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtPeso.getText().equals("Ingrese el peso de la arista") || txtPeso.getText() != "Ingrese el peso de la arista"){
					txtPeso.setText("");
					txtPeso.setForeground(Color.BLACK);
				}if(txtNombreAutor.getText().isEmpty() || txtNumPag.getText().isEmpty() || txtFechaP.getText().isEmpty() || txtDestino.getText().isEmpty() || txtOrigen.getText().isEmpty() || txtIngreseElNombre.getText().isEmpty()) {
					txtDestino.setText("Ingrese un nombre de libro");
					txtDestino.setForeground(Color.LIGHT_GRAY);
					txtFechaP.setText("Ingrese la fecha de publicación");
					txtFechaP.setForeground(Color.LIGHT_GRAY);
					txtNombreAutor.setText("Ingrese el nombre del autor");
					txtNombreAutor.setForeground(Color.LIGHT_GRAY);
					txtNumPag.setText("Ingrese el nùmero de páginas");
					txtNumPag.setForeground(Color.LIGHT_GRAY);
					txtOrigen.setText("Ingrese un nombre del libro");
					txtOrigen.setForeground(Color.LIGHT_GRAY);
					txtIngreseElNombre.setText("Ingrese el nombre del libro");
					txtIngreseElNombre.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		txtPeso.setText("Ingrese el peso de la arista");
		txtPeso.setHorizontalAlignment(SwingConstants.CENTER);
		txtPeso.setForeground(Color.LIGHT_GRAY);
		txtPeso.setFont(new Font("Rockwell", Font.ITALIC, 10));
		txtPeso.setColumns(10);
		txtPeso.setBounds(305, 145, 160, 20);
		contentPane.add(txtPeso);

		JLabel lblNewLabel = new JLabel("Peso:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setBounds(308, 118, 70, 14);
		contentPane.add(lblNewLabel);

		txtDestino = new JTextField();
		txtDestino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtDestino.getText().equals("Ingrese un nombre del libro") || txtDestino.getText() != "Ingrese un nombre del libro"){
					txtDestino.setText("");
					txtDestino.setForeground(Color.BLACK);
				}if(txtNombreAutor.getText().isEmpty() || txtNumPag.getText().isEmpty() || txtFechaP.getText().isEmpty() || txtIngreseElNombre.getText().isEmpty() || txtOrigen.getText().isEmpty() || txtPeso.getText().isEmpty()) {
					txtIngreseElNombre.setText("Ingrese el nombre del libro");
					txtIngreseElNombre.setForeground(Color.LIGHT_GRAY);
					txtFechaP.setText("Ingrese la fecha de publicación");
					txtFechaP.setForeground(Color.LIGHT_GRAY);
					txtNombreAutor.setText("Ingrese el nombre del autor");
					txtNombreAutor.setForeground(Color.LIGHT_GRAY);
					txtNumPag.setText("Ingrese el número de páginas");
					txtNumPag.setForeground(Color.LIGHT_GRAY);
					txtOrigen.setText("Ingrese un nombre del libro");
					txtOrigen.setForeground(Color.LIGHT_GRAY);
					txtPeso.setText("Ingrese el peso de la arista");
					txtPeso.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		txtDestino.setHorizontalAlignment(SwingConstants.CENTER);
		txtDestino.setText("Ingrese un nombre de libro");
		txtDestino.setForeground(Color.LIGHT_GRAY);
		txtDestino.setFont(new Font("Rockwell", Font.ITALIC, 10));
		txtDestino.setBounds(305, 91, 160, 20);
		contentPane.add(txtDestino);
		txtDestino.setColumns(10);

		JLabel lblDestino = new JLabel("Destino:");
		lblDestino.setForeground(new Color(255, 255, 255));
		lblDestino.setFont(new Font("Verdana", Font.BOLD, 14));
		lblDestino.setBounds(305, 66, 75, 14);
		contentPane.add(lblDestino);

		txtOrigen = new JTextField();
		txtOrigen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtOrigen.getText().equals("Ingrese un nombre del libro") || txtOrigen.getText() != "Ingrese un nombre del libro"){
					txtOrigen.setText("");
					txtOrigen.setForeground(Color.BLACK);
				}if(txtNombreAutor.getText().isEmpty() || txtNumPag.getText().isEmpty() || txtFechaP.getText().isEmpty() || txtDestino.getText().isEmpty() || txtIngreseElNombre.getText().isEmpty() || txtPeso.getText().isEmpty()) {
					txtDestino.setText("Ingrese un nombre de libro");
					txtDestino.setForeground(Color.LIGHT_GRAY);
					txtFechaP.setText("Ingrese la fecha de publicación");
					txtFechaP.setForeground(Color.LIGHT_GRAY);
					txtNombreAutor.setText("Ingrese el nombre del autor");
					txtNombreAutor.setForeground(Color.LIGHT_GRAY);
					txtNumPag.setText("Ingrese el número de páginas");
					txtNumPag.setForeground(Color.LIGHT_GRAY);
					txtIngreseElNombre.setText("Ingrese el nombre del libro");
					txtIngreseElNombre.setForeground(Color.LIGHT_GRAY);
					txtPeso.setText("Ingrese el peso de la arista");
					txtPeso.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		txtOrigen.setHorizontalAlignment(SwingConstants.CENTER);
		txtOrigen.setText("Ingrese un nombre de libro");
		txtOrigen.setForeground(Color.LIGHT_GRAY);
		txtOrigen.setFont(new Font("Rockwell", Font.ITALIC, 10));
		txtOrigen.setBounds(305, 37, 160, 20);
		contentPane.add(txtOrigen);
		txtOrigen.setColumns(10);

		JLabel lblOrigen = new JLabel("Origen:");
		lblOrigen.setForeground(new Color(255, 255, 255));
		lblOrigen.setFont(new Font("Verdana", Font.BOLD, 14));
		lblOrigen.setBounds(305, 12, 68, 14);
		contentPane.add(lblOrigen);

		txtIngreseElNombre = new JTextField();
		txtIngreseElNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtIngreseElNombre.getText().equals("Ingrese el nombre del libro") || txtIngreseElNombre.getText() != "Ingrese la altura del cono"){
					txtIngreseElNombre.setText("");
					txtIngreseElNombre.setForeground(Color.BLACK);
				}if(txtNombreAutor.getText().isEmpty() || txtNumPag.getText().isEmpty() || txtFechaP.getText().isEmpty() || txtDestino.getText().isEmpty() || txtOrigen.getText().isEmpty() || txtPeso.getText().isEmpty()) {
					txtDestino.setText("Ingrese un nombre de libro");
					txtDestino.setForeground(Color.LIGHT_GRAY);
					txtFechaP.setText("Ingrese la fecha de publicación");
					txtFechaP.setForeground(Color.LIGHT_GRAY);
					txtNombreAutor.setText("Ingrese el nombre del autor");
					txtNombreAutor.setForeground(Color.LIGHT_GRAY);
					txtNumPag.setText("Ingrese el nùmero de páginas");
					txtNumPag.setForeground(Color.LIGHT_GRAY);
					txtOrigen.setText("Ingrese un nombre del libro");
					txtOrigen.setForeground(Color.LIGHT_GRAY);
					txtPeso.setText("Ingrese el peso de la arista");
					txtPeso.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		txtIngreseElNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtIngreseElNombre.setText("Ingrese el nombre del libro");
		txtIngreseElNombre.setForeground(Color.LIGHT_GRAY);
		txtIngreseElNombre.setFont(new Font("Rockwell", Font.ITALIC, 10));
		txtIngreseElNombre.setBounds(10, 38, 160, 20);
		contentPane.add(txtIngreseElNombre);
		txtIngreseElNombre.setColumns(10);

		JLabel lblTitulo = new JLabel("Nombre del libro:");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 14));
		lblTitulo.setBounds(10, 12, 145, 13);
		contentPane.add(lblTitulo);

		JLabel lblNombreAutor = new JLabel("Nombre del autor:");
		lblNombreAutor.setForeground(new Color(255, 255, 255));
		lblNombreAutor.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNombreAutor.setBounds(10, 65, 150, 14);
		contentPane.add(lblNombreAutor);

		txtNombreAutor = new JTextField();
		txtNombreAutor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtNombreAutor.getText().equals("Ingrese el nombre del autor") || txtNombreAutor.getText() != "Ingrese la altura del cono"){
					txtNombreAutor.setText("");
					txtNombreAutor.setForeground(Color.BLACK);
				}if(txtIngreseElNombre.getText().isEmpty() || txtNumPag.getText().isEmpty() || txtFechaP.getText().isEmpty() || txtDestino.getText().isEmpty() || txtOrigen.getText().isEmpty() || txtPeso.getText().isEmpty()) {
					txtDestino.setText("Ingrese un nombre de libro");
					txtDestino.setForeground(Color.LIGHT_GRAY);
					txtFechaP.setText("Ingrese la fecha de publicación");
					txtFechaP.setForeground(Color.LIGHT_GRAY);
					txtIngreseElNombre.setText("Ingrese el nombre del libro");
					txtIngreseElNombre.setForeground(Color.LIGHT_GRAY);
					txtNumPag.setText("Ingrese el nùmero de páginas");
					txtNumPag.setForeground(Color.LIGHT_GRAY);
					txtOrigen.setText("Ingrese un nombre del libro");
					txtOrigen.setForeground(Color.LIGHT_GRAY);
					txtPeso.setText("Ingrese el peso de la arista");
					txtPeso.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		txtNombreAutor.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreAutor.setText("Ingrese el nombre del autor");
		txtNombreAutor.setForeground(Color.LIGHT_GRAY);
		txtNombreAutor.setFont(new Font("Rockwell", Font.ITALIC, 10));
		txtNombreAutor.setColumns(10);
		txtNombreAutor.setBounds(10, 92, 160, 20);
		contentPane.add(txtNombreAutor);

		JLabel lblNumeroPag = new JLabel("Número de páginas:");
		lblNumeroPag.setForeground(new Color(255, 255, 255));
		lblNumeroPag.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNumeroPag.setBounds(10, 119, 170, 14);
		contentPane.add(lblNumeroPag);

		txtNumPag = new JTextField();
		txtNumPag.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtNumPag.getText().equals("Ingrese el nùmero de páginas") || txtNumPag.getText() != "Ingrese el nùmero de páginas"){
					txtNumPag.setText("");
					txtNumPag.setForeground(Color.BLACK);
				}if(txtNombreAutor.getText().isEmpty() || txtIngreseElNombre.getText().isEmpty() || txtFechaP.getText().isEmpty() || txtDestino.getText().isEmpty() || txtOrigen.getText().isEmpty() || txtPeso.getText().isEmpty()) {
					txtDestino.setText("Ingrese un nombre de libro");
					txtDestino.setForeground(Color.LIGHT_GRAY);
					txtFechaP.setText("Ingrese la fecha de publicación");
					txtFechaP.setForeground(Color.LIGHT_GRAY);
					txtNombreAutor.setText("Ingrese el nombre del autor");
					txtNombreAutor.setForeground(Color.LIGHT_GRAY);
					txtIngreseElNombre.setText("Ingrese el nombre del libro");
					txtIngreseElNombre.setForeground(Color.LIGHT_GRAY);
					txtOrigen.setText("Ingrese un nombre del libro");
					txtOrigen.setForeground(Color.LIGHT_GRAY);
					txtPeso.setText("Ingrese el peso de la arista");
					txtPeso.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		txtNumPag.setText("Ingrese el nùmero de pàginas");
		txtNumPag.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumPag.setForeground(Color.LIGHT_GRAY);
		txtNumPag.setFont(new Font("Rockwell", Font.ITALIC, 10));
		txtNumPag.setColumns(10);
		txtNumPag.setBounds(10, 146, 160, 20);
		contentPane.add(txtNumPag);

		JLabel lblFechaP = new JLabel("Fecha de publicación:");
		lblFechaP.setForeground(new Color(255, 255, 255));
		lblFechaP.setFont(new Font("Verdana", Font.BOLD, 14));
		lblFechaP.setBounds(10, 173, 180, 14);
		contentPane.add(lblFechaP);

		txtFechaP = new JTextField();
		txtFechaP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtFechaP.getText().equals("Ingrese la fecha de publicación") || txtFechaP.getText() != "Ingrese la fecha de publicación"){
					txtFechaP.setText("");
					txtFechaP.setForeground(Color.BLACK);
				}if(txtNombreAutor.getText().isEmpty() || txtNumPag.getText().isEmpty() || txtIngreseElNombre.getText().isEmpty() || txtDestino.getText().isEmpty() || txtOrigen.getText().isEmpty() || txtPeso.getText().isEmpty()) {
					txtDestino.setText("Ingrese un nombre de libro");
					txtDestino.setForeground(Color.LIGHT_GRAY);
					txtIngreseElNombre.setText("Ingrese el nombre del libro");
					txtIngreseElNombre.setForeground(Color.LIGHT_GRAY);
					txtNombreAutor.setText("Ingrese el nombre del autor");
					txtNombreAutor.setForeground(Color.LIGHT_GRAY);
					txtNumPag.setText("Ingrese el nùmero de páginas");
					txtNumPag.setForeground(Color.LIGHT_GRAY);
					txtOrigen.setText("Ingrese un nombre del libro");
					txtOrigen.setForeground(Color.LIGHT_GRAY);
					txtPeso.setText("Ingrese el peso de la arista");
					txtPeso.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		txtFechaP.setText("Ingrese la fecha de publicación");
		txtFechaP.setHorizontalAlignment(SwingConstants.CENTER);
		txtFechaP.setForeground(Color.LIGHT_GRAY);
		txtFechaP.setFont(new Font("Rockwell", Font.ITALIC, 10));
		txtFechaP.setColumns(10);
		txtFechaP.setBounds(10, 200, 160, 20);
		contentPane.add(txtFechaP);

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(InformacionGrafo.class.getResource("/Imagenes/Fondo2Difinitivo.jpg")));
		lblFondo.setBounds(0, 0, 480, 299);
		contentPane.add(lblFondo);

		JPanel pnMenu = new JPanel();
		pnMenu.setBounds(479, 0, 127, 299);
		contentPane.add(pnMenu);
		pnMenu.setLayout(null);

		JPanel pnIngresarLibro = new JPanel();
		pnIngresarLibro.setBounds(16, 36, 100, 26);
		pnMenu.add(pnIngresarLibro);
		pnIngresarLibro.setLayout(null);

		JLabel lblIngresarLibro = new JLabel("Ingresar Libro");
		lblIngresarLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombreLibro = txtIngreseElNombre.getText();
				String nombreAutor = txtNombreAutor.getText();
				String numPag = txtNumPag.getText();
				String fechaP = txtFechaP.getText();
				int numPag1 = Integer.parseInt(numPag);
				Libro libro = new Libro(numPag1, nombreLibro, nombreAutor, fechaP);
				libros.add(libro);
				JOptionPane.showMessageDialog(null,"Se ha ingresado con exito el libro");
				txtIngreseElNombre.setText("");
				txtFechaP.setText("");
				txtNombreAutor.setText("");
				txtNumPag.setText("");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnIngresarLibro.setBackground(Color.MAGENTA);
				lblIngresarLibro.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnIngresarLibro.setBackground(new Color(240,240,240));
				lblIngresarLibro.setForeground(Color.BLACK);
			}
		});
		lblIngresarLibro.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresarLibro.setForeground(Color.BLACK);
		lblIngresarLibro.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblIngresarLibro.setBounds(0, 0, 100, 26);
		pnIngresarLibro.add(lblIngresarLibro);

		JPanel pnIngresarArista = new JPanel();
		pnIngresarArista.setLayout(null);
		pnIngresarArista.setBounds(16, 95, 100, 26);
		pnMenu.add(pnIngresarArista);

		JLabel lblIngresarArista = new JLabel("Ingresar Arista");
		lblIngresarArista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String origen = txtOrigen.getText();
				String destino = txtDestino.getText();
				String peso = txtPeso.getText();
				int peso1 = Integer.parseInt(peso);

				Libro source = grafo.BuscarLibro(libros,origen);
				Libro destination = grafo.BuscarLibro(libros,destino);

				validarInfo(grafo, source, origen, destination, destino, peso1);

				Edge arista1 = new Edge(source,destination,peso1);
				aristas.add(arista1);

				grafo = new Graph(libros,aristas);

				//algoritmoDijkstra();

				txtDestino.setText("");
				txtOrigen.setText("");
				txtPeso.setText("");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnIngresarArista.setBackground(Color.MAGENTA);
				lblIngresarArista.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnIngresarArista.setBackground(new Color(240,240,240));
				lblIngresarArista.setForeground(Color.BLACK);
			}
		});
		lblIngresarArista.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresarArista.setForeground(Color.BLACK);
		lblIngresarArista.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblIngresarArista.setBounds(0, 0, 100, 26);
		pnIngresarArista.add(lblIngresarArista);

		JPanel pnSalir = new JPanel();
		pnSalir.setLayout(null);
		pnSalir.setBounds(16, 215, 100, 26);
		pnMenu.add(pnSalir);

		JLabel lblSalir = new JLabel("Regresar");
		lblSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal info = new MenuPrincipal();
				info.setVisible(true);
				setVisible(false);
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
		lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalir.setForeground(Color.BLACK);
		lblSalir.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblSalir.setBounds(0, 0, 100, 26);
		pnSalir.add(lblSalir);

		JPanel pnVerInformacionGrafo = new JPanel();
		pnVerInformacionGrafo.setLayout(null);
		pnVerInformacionGrafo.setBounds(16, 156, 100, 26);
		pnMenu.add(pnVerInformacionGrafo);

		JLabel lblVerInformacionGrafo = new JLabel("Ver info Grafo");
		lblVerInformacionGrafo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SwingUtilities.invokeLater(() -> InformacionGrafo.createAndShowGUI(grafo));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnVerInformacionGrafo.setBackground(Color.MAGENTA);
				lblVerInformacionGrafo.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnVerInformacionGrafo.setBackground(new Color(240,240,240));
				lblVerInformacionGrafo.setForeground(Color.BLACK);
			}
		});
		lblVerInformacionGrafo.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerInformacionGrafo.setForeground(Color.BLACK);
		lblVerInformacionGrafo.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblVerInformacionGrafo.setBounds(0, 0, 100, 26);
		pnVerInformacionGrafo.add(lblVerInformacionGrafo);
	}

	public void validarInfo(Graph grafo, Libro source,String origen, Libro destination, String destino, int weight) {

		if (source == null) {
			JOptionPane.showMessageDialog(null, "Libro ingresado como origen no valido: " + origen);
		} else if (destination == null) {
			JOptionPane.showMessageDialog(null,"Libro ingresado como destino no valido: " + destino);
		}else {
			JOptionPane.showMessageDialog(null, "Se ha ingresado de manera correcta los datos de la arista");
			grafo.addEdge(source, destination, weight);
		}
	}

	static void createAndShowGUI(Graph grafo) {
		JFrame frame = new JFrame("Graph Info");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);

		JTextArea textArea= new JTextArea();
		textArea.setEditable(false);
		frame.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);

		String graphInfo = grafo.obtenerInformacion(grafo);
		textArea.setText(graphInfo);

		frame.setVisible(true);
	}

	public Graph obtenerGrafo() {
		return grafo;
	}

	public static void algoritmoDijkstra() {
		String nombreL1 = JOptionPane.showInputDialog("Ingrese el nombre del libro el cual sera el origen para el algoritmo Dijkstra");
		Libro startLibro = grafo.BuscarLibro(libros,nombreL1);
		if (grafo.getEdges(startLibro) != null) {
			Map<Libro, Integer> dijkstraDistances = grafo.dijkstra(startLibro);
			JOptionPane.showMessageDialog(null,"Dijkstra Distances:");
			for (Map.Entry<Libro, Integer> entry : dijkstraDistances.entrySet()) {
				JOptionPane.showMessageDialog(null,entry.getKey().getTitulo() + ": " + entry.getValue());
			}
		} else {
			JOptionPane.showMessageDialog(null,"Libro ingresado no existe: " + nombreL1);
		}
	}

	public static void algoritmoKruskal() {
		List<Edge> mstEdges = grafo.kruskalMST();
		JOptionPane.showMessageDialog(null,"Arbol de expasión mínima:");
		for (Edge edge : mstEdges) {
			JOptionPane.showMessageDialog(null,edge.getSource().getTitulo() + " - " + edge.getDestination().getTitulo() + ", peso: " + edge.getWeight());
		}
	}

	public static void algoritmoColoreoVoraz() {
		Map<Libro, String> genreColoring = grafo.greedyGenreColoring();
		JOptionPane.showMessageDialog(null,"Algoritmo de coloreo voraz(usando gèneros de libros)");
		for (Map.Entry<Libro, String> entry : genreColoring.entrySet()) {
			JOptionPane.showMessageDialog(null,entry.getKey().getTitulo() + ": " + entry.getValue());
		}
	}
}
