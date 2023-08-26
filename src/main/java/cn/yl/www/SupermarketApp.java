package cn.yl.www;

// 水果种类价格常量类
class FruitType {
    static final int APPLE_PRICE = 8;
    static final int STRAWBERRY_PRICE = 13;
    static final int MANGO_PRICE = 20;
}

// 水果抽象类
abstract class Fruit {
    protected int weight;

    // 构造函数，初始化水果重量
    public Fruit(int weight) {
        this.weight = weight;
    }

    // 抽象方法，由具体水果类实现，计算水果价格
    public abstract int calculatePrice();

    @Override
    public String toString() {
        return "Weight: " + weight + " kg";
    }
}

// 苹果类，继承自水果抽象类
class Apple extends Fruit {
    public Apple(int weight) {
        super(weight);
    }

    @Override
    public int calculatePrice() {
        return weight * FruitType.APPLE_PRICE;
    }
}

// 草莓类，继承自水果抽象类
class Strawberry extends Fruit {
    public Strawberry(int weight) {
        super(weight);
    }

    @Override
    public int calculatePrice() {
        return weight * FruitType.STRAWBERRY_PRICE;
    }
}

// 芒果类，继承自水果抽象类
class Mango extends Fruit {
    public Mango(int weight) {
        super(weight);
    }

    @Override
    public int calculatePrice() {
        return weight * FruitType.MANGO_PRICE;
    }
}

// 购物车类
class ShoppingCart {
    private final Fruit[] items;

    // 构造函数，初始化购物车水果列表
    public ShoppingCart(Fruit[] items) {
        this.items = items;
    }

    // 计算购物车总价
    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (Fruit item : items) {
            totalPrice += item.calculatePrice();
        }
        return totalPrice;
    }

    /**
     * 根据折扣率计算购物车总价（带折扣）
     *
     * @param discountRate 折扣
     * @return 折扣价
     */
    public int calculateTotalPriceWithDiscount(double discountRate) {
        int totalPrice = calculateTotalPrice();
        return (int) (totalPrice * discountRate);
    }


    /**
     * 根据满减规则计算购物车总价（带促销活动）
     *
     * @param threshold 满减价格
     * @param discount  降价多少
     * @return 促销价
     */
    public int calculateTotalPriceWithPromotion(int threshold, int discount) {
        int totalPrice = calculateTotalPrice();
        if (totalPrice >= threshold) {
            return totalPrice - discount;
        }
        return totalPrice;
    }
}

// 主程序类
public class SupermarketApp {
    public static void main(String[] args) {
        Apple apple = new Apple(5);
        Strawberry strawberry = new Strawberry(3);
        Mango mango = new Mango(2);

        // 顾客 A 的购物车
        Fruit[] itemsA = {apple, strawberry};
        ShoppingCart cartA = new ShoppingCart(itemsA);
        int totalA = cartA.calculateTotalPrice();
        System.out.println("顾客 A 消费: " + totalA);

        // 顾客 B 的购物车
        Fruit[] itemsB = {apple, strawberry, mango};
        ShoppingCart cartB = new ShoppingCart(itemsB);
        int totalB = cartB.calculateTotalPrice();
        System.out.println("顾客 B 消费: " + totalB);

        // 顾客 C 的购物车，带折扣
        double discountRate = 0.8; // 8折
        int totalC = cartB.calculateTotalPriceWithDiscount(discountRate);
        System.out.println("顾客 C 消费: " + totalC);

        // 顾客 D 的购物车，带促销活动
        int threshold = 100;
        int discount = 10;
        int totalD = cartB.calculateTotalPriceWithPromotion(threshold, discount);
        System.out.println("顾客 D 消费: " + totalD);
    }
}
