package com.uifactory.products;

/**
 * Abstract Product Interface: Button
 *
 * This interface defines the contract that ALL concrete button products
 * (e.g., WindowsButton, MacButton) must follow.
 *
 * This adheres to the Dependency Inversion Principle (SOLID) —
 * high-level modules depend on abstractions, not concrete implementations.
 */
public interface Button {

    /**
     * Renders the button on screen.
     * Each concrete implementation will render in its own OS-specific style.
     */
    void render();

    /**
     * Simulates a click action on the button.
     * Each concrete implementation will handle click behavior differently.
     */
    void onClick();
}
