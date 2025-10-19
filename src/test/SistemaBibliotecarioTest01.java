package test;

import dominio.concretas.*;

import java.util.ArrayList;

import static dominio.enumeracao.NivelUsuario.*;
import static dominio.enumeracao.StatusItem.*;

public class SistemaBibliotecarioTest01 {
    public static void main(String[] args) {
        Livro livro1 = new Livro("Cronicas de Narnia", 01, DISPONIVEL);

        Periodico periodico1 = new Periodico("p1",5,DISPONIVEL);

        Leitor leitor = new Leitor("Igor", LEITOR);
        Bibliotecario bibliotecario = new Bibliotecario("Vitor",BIBLIOTECARIO);
        Admin admin = new Admin("Micael",ADMIN);

        livro1.emprestar(leitor);
        leitor.imprimirDetalhes();

        livro1.imprimirDetalhes();
    }
}
