package dominio.concretas;

import dominio.abstratas.ItemBiblioteca;
import dominio.abstratas.Usuario;
import dominio.enumeracao.NivelUsuario;

import java.util.ArrayList;

public class Leitor extends Usuario {
    private ArrayList<ItemBiblioteca> itensBiblioteca = new ArrayList<>();

    public Leitor(String nome, NivelUsuario nivelUsuario) {
        super(nome, nivelUsuario);
    }

    public Leitor(String nome, NivelUsuario nivelUsuario, ArrayList<ItemBiblioteca> itensBiblioteca) {
        super(nome, nivelUsuario);
        this.itensBiblioteca = itensBiblioteca;
    }

    @Override
    public boolean podeGerenciar() {
        return false;
    }

    @Override
    public void imprimirDetalhes() {
        System.out.print("Nome: " + getNome() +
                " | Nivel: " + getNivelUsuario());
        if (itensBiblioteca.isEmpty()) {
            System.out.print(" Nenhum item!");
        } else {
            System.out.print(" | ");
            for (ItemBiblioteca itens : itensBiblioteca) {
                System.out.print(itens.getTitulo() + " | ");
            }
        }
        System.out.println();
    }

    public ArrayList<ItemBiblioteca> getItensBiblioteca() {
        return itensBiblioteca;
    }

    public void setItem(ArrayList<ItemBiblioteca> item) {
        this.itensBiblioteca = item;
    }
}

