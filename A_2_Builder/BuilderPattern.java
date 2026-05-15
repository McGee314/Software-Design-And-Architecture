// ============================================================
//  Builder Pattern - Pizza and Burger
//  Muhammad Samudera Bagja, Software Design and Architecture
// ============================================================

// ── Product: Pizza ───────────────────────────────────────────
class Pizza {
    private String dough;
    private String sauce;
    private String topping;

    public void setDough(String dough) {
        this.dough = dough;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    @Override
    public String toString() {
        return "Pizza [dough=" + dough + ", sauce=" + sauce + ", topping=" + topping + "]";
    }
}

// ── Product: Burger ───────────────────────────────────────────
class Burger {
    private String bun;
    private String patty;
    private String salad;

    public void setBun(String bun) {
        this.bun = bun;
    }

    public void setPatty(String patty) {
        this.patty = patty;
    }

    public void setSalad(String salad) {
        this.salad = salad;
    }

    @Override
    public String toString() {
        return "Burger [bun=" + bun + ", patty=" + patty + ", salad=" + salad + "]";
    }
}

// ── Builder Interface: PizzaBuilder ───────────────────────────
interface PizzaBuilder {
    void reset();

    void setDough(String dough);

    void setSauce(String sauce);

    void setTopping(String topping);
}

// ── Builder Interface: BurgerBuilder ─────────────────────────
interface BurgerBuilder {
    void reset();

    void setBun(String bun);

    void setPatty(String patty);

    void setSalad(String salad);
}

// ── Concrete Builder: ConcretePizzaBuilder ────────────────────
class ConcretePizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    public ConcretePizzaBuilder() {
        reset();
    }

    @Override
    public void reset() {
        this.pizza = new Pizza();
    }

    @Override
    public void setDough(String dough) {
        pizza.setDough(dough);
    }

    @Override
    public void setSauce(String sauce) {
        pizza.setSauce(sauce);
    }

    @Override
    public void setTopping(String topping) {
        pizza.setTopping(topping);
    }

    public Pizza getResult() {
        Pizza result = this.pizza;
        reset(); // reset builder for next use
        return result;
    }
}

// ── Concrete Builder: ConcreteBurgerBuilder ───────────────────
class ConcreteBurgerBuilder implements BurgerBuilder {
    private Burger burger;

    public ConcreteBurgerBuilder() {
        reset();
    }

    @Override
    public void reset() {
        this.burger = new Burger();
    }

    @Override
    public void setBun(String bun) {
        burger.setBun(bun);
    }

    @Override
    public void setPatty(String patty) {
        burger.setPatty(patty);
    }

    @Override
    public void setSalad(String salad) {
        burger.setSalad(salad);
    }

    public Burger getResult() {
        Burger result = this.burger;
        reset(); // reset builder for next use
        return result;
    }
}

// ── Director: Waiter ─────────────────────────────────────────
class Waiter {

    public Pizza constructHawaiianPizza(ConcretePizzaBuilder b) {
        b.reset();
        b.setDough("thin crust");
        b.setSauce("tomato");
        b.setTopping("ham and pineapple");
        return b.getResult();
    }

    public Burger constructBeefBurger(ConcreteBurgerBuilder b) {
        b.reset();
        b.setBun("sesame bun");
        b.setPatty("beef patty");
        b.setSalad("lettuce, tomato, onion");
        return b.getResult();
    }
}

// ── Client / Main ─────────────────────────────────────────────
public class BuilderPattern {
    public static void main(String[] args) {

        Waiter waiter = new Waiter();

        // Build a Hawaiian Pizza
        ConcretePizzaBuilder pizzaBuilder = new ConcretePizzaBuilder();
        Pizza hawaiianPizza = waiter.constructHawaiianPizza(pizzaBuilder);
        System.out.println("Ordered: " + hawaiianPizza);

        // Build a Beef Burger
        ConcreteBurgerBuilder burgerBuilder = new ConcreteBurgerBuilder();
        Burger beefBurger = waiter.constructBeefBurger(burgerBuilder);
        System.out.println("Ordered: " + beefBurger);

        // Custom order using builder directly (without director)
        System.out.println("\n--- Custom Order (no director) ---");
        pizzaBuilder.reset();
        pizzaBuilder.setDough("thick crust");
        pizzaBuilder.setSauce("bbq");
        pizzaBuilder.setTopping("pepperoni");
        Pizza customPizza = pizzaBuilder.getResult();
        System.out.println("Custom: " + customPizza);
    }
}