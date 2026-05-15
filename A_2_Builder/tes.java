The following is the core implementation of the Builder Pattern, written as a single Java file.
Builder Interfaces:
interface PizzaBuilder {
    void reset();
    void setDough(String dough);
    void setSauce(String sauce);
    void setTopping(String topping);
}

interface BurgerBuilder {
    void reset();
    void setBun(String bun);
    void setPatty(String patty);
    void setSalad(String salad);
}
Concrete Builder — Pizza:
class ConcretePizzaBuilder implements PizzaBuilder {
    private Pizza pizza;
    public ConcretePizzaBuilder() { reset(); }
    public void reset()                    { this.pizza = new Pizza(); }
    public void setDough(String dough)     { pizza.setDough(dough); }
    public void setSauce(String sauce)     { pizza.setSauce(sauce); }
    public void setTopping(String topping) { pizza.setTopping(topping); }
    public Pizza getResult() {
        Pizza result = this.pizza; reset(); return result;
    }
}
Director (Waiter):
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
