package com.uifactory.factory;

import com.uifactory.products.Button;
import com.uifactory.products.Checkbox;

/**
 * Abstract Factory Interface: GUIFactory
 *
 * This is the core of the Abstract Factory Pattern.
 * It declares the creation methods for each distinct product type
 * (Button and Checkbox) that belong to the same UI theme/family.
 *
 * Each concrete factory (WinFactory, MacFactory) will implement
 * this interface and return their own OS-specific product variants.
 *
 * ─────────────────────────────────────────────────────────────────
 * SOLID Principles applied here:
 *
 *  • Open/Closed Principle  — You can add a new theme (e.g., LinuxFactory)
 *    by implementing this interface without modifying existing code.
 *
 *  • Dependency Inversion   — The client (Application) depends on this
 *    abstraction, never on concrete factory or product classes.
 *
 *  • Interface Segregation  — This interface is focused solely on
 *    creating related UI components. No unrelated responsibilities.
 * ─────────────────────────────────────────────────────────────────
 */
public interface GUIFactory {

    /**
     * Factory method to create a themed Button.
     *
     * Concrete factories will return their own platform-specific
     * implementation (e.g., WindowsButton or MacButton).
     *
     * @return a platform-specific Button instance
     */
    Button createButton();

    /**
     * Factory method to create a themed Checkbox.
     *
     * Concrete factories will return their own platform-specific
     * implementation (e.g., WindowsCheckbox or MacCheckbox).
     *
     * @return a platform-specific Checkbox instance
     */
    Checkbox createCheckbox();
}
