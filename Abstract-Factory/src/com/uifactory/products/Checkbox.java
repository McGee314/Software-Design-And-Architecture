package com.uifactory.products;

/**
 * Abstract Product Interface: Checkbox
 *
 * This interface defines the contract that ALL concrete checkbox products
 * (e.g., WindowsCheckbox, MacCheckbox) must follow.
 *
 * This adheres to the Dependency Inversion Principle (SOLID) —
 * high-level modules depend on abstractions, not concrete implementations.
 */
public interface Checkbox {

    /**
     * Renders the checkbox on screen.
     * Each concrete implementation will render in its own OS-specific style.
     */
    void render();

    /**
     * Simulates a toggle action on the checkbox.
     * Each concrete implementation will handle the toggle behavior differently.
     */
    void toggle();
}
