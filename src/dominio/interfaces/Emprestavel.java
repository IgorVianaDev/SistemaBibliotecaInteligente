package dominio.interfaces;

import dominio.abstratas.ItemBiblioteca;
import dominio.abstratas.Usuario;
import dominio.concretas.Leitor;

public interface Emprestavel {
    boolean emprestar(Leitor leitor);
    void devolver(Leitor Leitor);
    boolean reservar(Leitor leitor);
}
