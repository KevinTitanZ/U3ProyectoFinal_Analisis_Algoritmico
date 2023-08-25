package ClassToGraph;

import java.util.Scanner;

public class Libro {
	private int numeroPag;
    private String titulo;
    private String autor;
    private String fechaPublicacion;

    public Libro(int numeroPag, String titulo, String autor, String fechaPublicacion) {
        this.numeroPag = numeroPag;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
    }

    public Libro() {
	}

	public int getNumeroPag() {
        return numeroPag;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }
    
    @Override
    public String toString() {
        return "Numero de paginas: " + numeroPag + ", Título: " + titulo + ", Autor: " + autor + ", fecha de Publicación: " + fechaPublicacion;
    }
}
