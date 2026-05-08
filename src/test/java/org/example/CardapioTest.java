package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CardapioTest {

    @Test
    void deveRetornarMenuCompleto() {
        Categoria entradas = new Categoria("Entradas");
        Prato bruschetta = new Prato("Bruschetta", 18.0f);
        entradas.addItem(bruschetta);

        Categoria pratosPrincipais = new Categoria("Pratos Principais");
        Prato frango = new Prato("Frango Grelhado", 45.0f);
        Prato file = new Prato("File Mignon", 89.0f);
        pratosPrincipais.addItem(frango);
        pratosPrincipais.addItem(file);

        Categoria sobremesas = new Categoria("Sobremesas");
        Prato pudim = new Prato("Pudim", 15.0f);
        sobremesas.addItem(pudim);

        Categoria menu = new Categoria("Cardapio do Restaurante");
        menu.addItem(entradas);
        menu.addItem(pratosPrincipais);
        menu.addItem(sobremesas);

        Cardapio cardapio = new Cardapio();
        cardapio.setMenu(menu);

        assertEquals(
            "Categoria: Cardapio do Restaurante\n" +
            "Categoria: Entradas\n" +
            "Prato: Bruschetta - R$18.0\n" +
            "Categoria: Pratos Principais\n" +
            "Prato: Frango Grelhado - R$45.0\n" +
            "Prato: File Mignon - R$89.0\n" +
            "Categoria: Sobremesas\n" +
            "Prato: Pudim - R$15.0\n",
            cardapio.getMenu()
        );
    }

    @Test
    void deveRetornarExcecaoCardapioSemMenu() {
        try {
            Cardapio cardapio = new Cardapio();
            cardapio.getMenu();
            fail();
        } catch (NullPointerException e) {
            assertEquals("Cardapio sem menu", e.getMessage());
        }
    }
}
