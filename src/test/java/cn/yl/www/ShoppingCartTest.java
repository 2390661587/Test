package cn.yl.www;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {
    @Test
    public void testCalculateTotalPrice() {
        // 测试计算总价功能
        Apple apple = new Apple(5);
        Strawberry strawberry = new Strawberry(3);

        Fruit[] itemsA = {apple, strawberry};
        ShoppingCart cartA = new ShoppingCart(itemsA);
        int totalA = cartA.calculateTotalPrice();
        assertEquals(5 * FruitType.APPLE_PRICE + 3 * FruitType.STRAWBERRY_PRICE, totalA);

        Mango mango = new Mango(2);
        Fruit[] itemsB = {apple, strawberry, mango};
        ShoppingCart cartB = new ShoppingCart(itemsB);
        int totalB = cartB.calculateTotalPrice();
        assertEquals(5 * FruitType.APPLE_PRICE + 3 * FruitType.STRAWBERRY_PRICE + 2 * FruitType.MANGO_PRICE, totalB);
    }

    @Test
    public void testCalculateTotalPriceWithDiscount() {
        // 测试折扣计算功能
        Strawberry strawberry = new Strawberry(3);
        Mango mango = new Mango(2);

        Fruit[] itemsB = {strawberry, mango};
        ShoppingCart cartB = new ShoppingCart(itemsB);

        double discountRate = 0.8; // 8折
        int totalPriceBeforeDiscount = 3 * FruitType.STRAWBERRY_PRICE + 2 * FruitType.MANGO_PRICE;
        int totalPriceWithDiscount = cartB.calculateTotalPriceWithDiscount(discountRate);
        assertEquals((int) (totalPriceBeforeDiscount * discountRate), totalPriceWithDiscount);
    }

    @Test
    public void testCalculateTotalPriceWithPromotion() {
        // 测试满减计算功能
        Apple apple = new Apple(7);
        Strawberry strawberry = new Strawberry(5);

        Fruit[] itemsC = {apple, strawberry};
        ShoppingCart cartC = new ShoppingCart(itemsC);

        int threshold = 100;
        int discount = 10;
        int totalPriceBeforePromotion = 7 * FruitType.APPLE_PRICE + 5 * FruitType.STRAWBERRY_PRICE;
        int totalPriceWithPromotion = cartC.calculateTotalPriceWithPromotion(threshold, discount);
        assertEquals(totalPriceBeforePromotion - discount, totalPriceWithPromotion);
    }
}
