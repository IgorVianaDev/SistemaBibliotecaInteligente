package dominio.interfaces;

import dominio.abstratas.Usuario;

public interface Emprestavel {
    boolean emprestar(Usuario usuario);
    void devolver();


}
