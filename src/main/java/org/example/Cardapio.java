package org.example;

public class Cardapio {

    private ItemCardapio menu;

    public void setMenu(ItemCardapio menu) {
        this.menu = menu;
    }

    public String getMenu() {
        if (this.menu == null) {
            throw new NullPointerException("Cardapio sem menu");
        }
        return this.menu.getConteudo();
    }
}
