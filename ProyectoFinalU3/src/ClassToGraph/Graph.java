package ClassToGraph;
import java.util.*;

import javax.swing.JOptionPane;

import ClassToGraph.*;
public class Graph {
	private Map<Libro, List<Edge>> adjacencyList;//instanciar la lista de adyacencia
	private List<Libro> nodos;//instaciar la lista de nodos(Libros)
	//Constructores para la contruccion del grafo
	public Graph() {
		adjacencyList = new HashMap<>();
	}

	public Graph(List<Libro> nodos, List<Edge> aristas) {
		this.nodos = new ArrayList<>(nodos);
		this.adjacencyList = new HashMap<>();
		for (Libro nodo : nodos) {
			this.adjacencyList.put(nodo, new ArrayList<>());
		}
		for (Edge arista : aristas) {
			this.adjacencyList.get(arista.getSource()).add(arista);
		}
	}
	//para conseguir la informacion de los nodos
	public List<Libro> getNodos() {
		return nodos;
	}
	//metodo para agregar una arista
	public void addEdge(Libro source, Libro destination, int weight) {
		adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(new Edge(source, destination, weight));
		adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>()).add(new Edge(destination, source, weight));
	}
	//obtener la lista de adyacencia
	public List<Edge> getEdges(Libro libro) {
		return adjacencyList.getOrDefault(libro, new ArrayList<>());
	}
	//Algoritmo Dijstra el cual necesita de un libro inicial para comenzar
	public Map<Libro, Integer> dijkstra(Libro start) {
		Map<Libro, Integer> distances = new HashMap<>();//Variable para almacenar las distancias minimas
		PriorityQueue<Edge> minHeap = new PriorityQueue<>();//Varibale que almacenar las aristas ordenadas por distancia

		for (Libro libro : adjacencyList.keySet()) {
			distances.put(libro, Integer.MAX_VALUE);//Inicializa todas las distancias como infinito
		}
		distances.put(start, 0);//Distancia del libro de inicio 
		minHeap.add(new Edge(start, start, 0));//Agrega el libro de inicio a dentro de minHead 

		while (!minHeap.isEmpty()) {
			Edge edge = minHeap.poll();//Extrae la arista con menor distancia
			Libro currentLibro = edge.getDestination();//Nueva distancia

			for (Edge neighborEdge : adjacencyList.get(currentLibro)) {
			    int newDistance = distances.get(currentLibro) + neighborEdge.getWeight();
			    if (newDistance < distances.get(neighborEdge.getDestination())) {
			        distances.put(neighborEdge.getDestination(), newDistance);//Actualiza la distancia minima
			        minHeap.add(new Edge(currentLibro, neighborEdge.getDestination(), newDistance));//Agrega la nueva arista
			    }
			}
		}

		return distances;
	}
	//Algoritmo de coloreo voraz en este caso asigna categorias a los libros
	public Map<Libro, String> greedyGenreColoring() {
		Map<Libro, String> coloring = new HashMap<>();//Variable que almacena el mapeo entre libros y generos
		Set<String> generosUsados = new HashSet<>();//Variable que almacena los generos

		for (Libro libro : adjacencyList.keySet()) {
			String genre = BuscarGeneros(generosUsados);//Encontrar generos no usados
			coloring.put(libro, genre);
			generosUsados.add(genre);
		}

		return coloring;
	}
	//Algoritmo de kruskal para conseguir la expansion minimo del arbol, realizar una exapcion minima del grafo sin hacer ciclos entre los vertices
	public List<Edge> kruskalMST() {
		List<Edge> mstEdges = new ArrayList<>();//Variable que almacenara las aristas para el MST
		PriorityQueue<Edge> minHeap = new PriorityQueue<>(adjacencyList.size(), Comparator.comparingInt(edge -> edge.weight));//Cola de prioridad para ordenar las aristas
		DisjointSet<Libro> disjointSet = new DisjointSet<>();//Estructura de datos para manetener las componentes conectadas

		for (Libro libro : adjacencyList.keySet()) {
			disjointSet.makeSet(libro);//Crear conjunto para cada vertice
			minHeap.addAll(adjacencyList.get(libro));//Agrega las aristas a la cola de prioridad
		}

		while (!minHeap.isEmpty()) {
			Edge edge = minHeap.poll();//Extrae las aristas de menor peso
			Libro sourceRoot = disjointSet.findSet(edge.source);//Conjunto de vertice origen
			Libro destRoot = disjointSet.findSet(edge.destination);//Conjunto de vertice destino

			if (sourceRoot != destRoot) {
				mstEdges.add(edge);//Agrega las aristas al MST
				disjointSet.union(sourceRoot, destRoot);//Une los conjuntos de aristas
			}
		}

		return mstEdges;
	}
	//Metodo que tiene los generos disponibles para los libros, el cual retorna en primera instancia el genero asignado, caso contrario retorna desconocido
	private String BuscarGeneros(Set<String> usedGenres) {
		String[] generosDisponibles = {"Ficción", "Drama", "Misterio", "Aventura", "Romance", "Ciencia Ficción"};
		for (String genero : generosDisponibles) {
			if (!usedGenres.contains(genero)) {
				return genero;
			}
		}
		return "Desconocido";
	}
	//Metodo para buscar si el libro ingresado existe dentro de la lista de libros
	public Libro BuscarLibro(List<Libro> libros, String name) {
		for (Libro libro : libros) {
			if (libro.getTitulo().equalsIgnoreCase(name)) {
				return libro;
			}
		}
		return null;
	}
	//Metodo para conseguir la informacion del grafo, el cual da la arista del libro, la informacion del libro y de la arista al cual fue asignado
	public static String obtenerInformacion(Graph grafo) {
		StringBuilder info = new StringBuilder();
		info.append("Información del grafo:\n");
		for (Libro libro : grafo.getNodos()) {
			info.append("Aristas del libro ").append(libro).append(": ").append(grafo.getEdges(libro)).append("\n");
		}
		return info.toString();
	}
}
