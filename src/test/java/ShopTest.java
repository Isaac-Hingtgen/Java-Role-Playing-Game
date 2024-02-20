package test.java;

import main.java.ser316.rpg.Shop;
import main.java.ser316.rpg.characters.heroes.Hero;
import main.java.ser316.rpg.characters.heroes.OpTestHero;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class ShopTest {

    Shop shop;
    Hero customer;
    @Before
    public void setUp() throws Exception {
        customer = new OpTestHero();
        shop = new Shop(new Scanner("1 \n2 \n3 \n4 \n5 \n0 \n"), customer);
    }

    @Test
    public void goToShop() {
        int g = customer.getGold();
        shop.goToShop(1);
        System.out.println("\n\t~~~all items should be sold out~~~\n");
        assertTrue(customer.getGold() < g);

        shop = new Shop(new Scanner("1 \n2 \n3 \n4 \n5 \n0 \n"), customer);
        shop.goToShop(50);
        assertFalse(customer.hasInventorySpace());

        shop = new Shop(new Scanner("1 \n1 \n0 \n"), customer);
        shop.goToShop(20);
        System.out.println("\n\t~~~item was already sold~~~\n");

        customer.removeGold(customer.getGold());
        shop = new Shop(new Scanner("1 \n1 \n0 \n"), customer);
        shop.goToShop(30);
        System.out.println("\n\t~~~not enough gold~~~\n");

    }

    @Test
    public void getNewInventory() {
        shop.goToShop(10);
        shop.getNewInventory();
        shop.displayInventory();
    }
}