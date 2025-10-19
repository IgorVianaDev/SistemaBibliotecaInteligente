package dominio.interfaces;

import dominio.abstratas.Usuario;
import dominio.concretas.Leitor;

public interface Emprestavel {
    boolean emprestar(Leitor leitor);
    void devolver(Leitor Leitor);
}
