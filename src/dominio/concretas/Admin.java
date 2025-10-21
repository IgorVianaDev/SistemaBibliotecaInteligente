package dominio.concretas;

import dominio.abstratas.ItemBiblioteca;
import dominio.abstratas.Usuario;
import dominio.enumeracao.NivelUsuario;

import static dominio.enumeracao.StatusItem.*;

public class Admin extends Usuario {
    public Admin(String nome, NivelUsuario nivelUsuario) {
        super(nome, nivelUsuario);
    }


    @Override
    public void imprimirDetalhes() {
        System.out.print("Nome: " + getNome()+
                " | Nivel: " + getNivelUsuario());
    }

    public boolean emprestar(ItemBiblioteca itemBiblioteca, Leitor leitor) {
        if (podeGerenciar()){
            return itemBiblioteca.emprestar(leitor);
        }
        return false;
    }

    public boolean reservar(ItemBiblioteca itemBiblioteca, Leitor leitor) {
        if (podeGerenciar()){
            return itemBiblioteca.reservar(leitor);
        }
        return false;
    }

    public void devolver(ItemBiblioteca itemBiblioteca, Leitor leitor){
        itemBiblioteca.devolver(leitor);
    }

    @Override
    public void marcarAtraso(ItemBiblioteca itemBiblioteca, Leitor leitor){
        super.marcarAtraso(itemBiblioteca, leitor);
    }
}
