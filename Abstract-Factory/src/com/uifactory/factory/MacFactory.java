package com.uifactory.factory;

import com.uifactory.products.Button;
import com.uifactory.products.Checkbox;
import com.uifactory.products.mac.MacButton;
import com.uifactory.products.mac.MacCheckbox;

/**
 * Concrete Factory: MacFactory
 *
 * This factory is responsible for creating the Mac-themed family of UI components.
 * It implements GUIFactory and ensures that only Mac-compatible products are created
 * together — guaranteeing product consistency across the UI theme.
 *
 * The client code (Application) only references this class at configuration time.
 * Once injected, the client works purely through the GUIFactory interface.
 *
 * This follows the Open/Closed Principle (SOLID):
 * - Open for extension → you can add new themed factories without touching existing code.
 * - Closed for modification → existing factories remain untouched.
 */
public class MacFactory implements GUIFactory {

    /**
     * Creates and returns a Mac-styled Button.
     *
     * @return a new MacButton instance, typed as the abstract Button interface.
     */
    @Override
    public Button createButton() {
        System.out.println("[MacFactory] Creating a Mac-styled Button...");
        return new MacButton();
    }

    /**
     * Creates and returns a Mac-styled Checkbox.
     *
     * @return a new MacCheckbox instance, typed as the abstract Checkbox interface.
     */
    @Override
    public Checkbox createCheckbox() {
        System.out.println("[MacFactory] Creating a Mac-styled Checkbox...");
        return new MacCheckbox();
    }
}
