package ClassToGraph;

public class Edge implements Comparable<Edge>{
	Libro source;//Origen
    Libro destination;//Destino
    int weight;//Peso

    //Constructor de la arista
    public Edge(Libro source, Libro destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    //Set and get de los atributos
	public Libro getDestination() {
		return destination;
	}

	public void setDestination(Libro destination) {
		this.destination = destination;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public Libro getSource() {
		return source;
	}
	public void setSource(Libro source) {
		this.source = source;
	}
	//ToString para conseguir la informacion de la arista
	@Override
    public String toString() {
        return "(" + destination + ", peso: " + weight + ")";
    }
	
	@Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}
