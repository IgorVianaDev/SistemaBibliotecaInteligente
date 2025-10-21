package dominio.interfaces;

import dominio.abstratas.ItemBiblioteca;
import dominio.concretas.Leitor;

public interface ControlaAtraso {
    void marcarAtraso(ItemBiblioteca itemBiblioteca, Leitor leitor);
}
