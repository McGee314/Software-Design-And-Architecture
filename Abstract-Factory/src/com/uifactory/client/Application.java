package com.uifactory.client;

import com.uifactory.factory.GUIFactory;
import com.uifactory.products.Button;
import com.uifactory.products.Checkbox;

/**
 * Client Class: Application
 *
 * This class represents the CLIENT in the Abstract Factory Pattern.
 * It is completely decoupled from any concrete product or factory class.
 *
 * The Application class only knows about:
 *  - GUIFactory   (the abstract factory interface)
 *  - Button       (the abstract product interface)
 *  - Checkbox     (the abstract product interface)
 *
 * It has NO knowledge of WindowsButton, MacButton, WinFactory, MacFactory, etc.
 * This is the power of the Abstract Factory Pattern.
 *
 * ─────────────────────────────────────────────────────────────────
 * SOLID Principles applied here:
 *
 *  • Single Responsibility  — Application only handles UI initialization
 *    and interaction logic. Factory creation is handled elsewhere.
 *
 *  • Dependency Inversion   — This class depends on abstractions
 *    (GUIFactory, Button, Checkbox), NOT on concrete implementations.
 *
 *  • Open/Closed Principle  — You can switch themes (Windows ↔ Mac)
 *    or add a new theme (e.g., Linux) by passing a different factory
 *    into the constructor — zero changes needed inside this class.
 * ─────────────────────────────────────────────────────────────────
 */
public class Application {

    // The client holds references to abstract product types only.
    // It never knows which concrete class is behind these references.
    private final Button button;
    private final Checkbox checkbox;

    /**
     * Constructor: Application
     *
     * The factory is injected via the constructor (Dependency Injection).
     * This is what makes the client fully decoupled from concrete products.
     *
     * Whichever factory is passed in (WinFactory or MacFactory),
     * the application will build a consistent, themed UI automatically.
     *
     * @param factory a GUIFactory implementation (WinFactory or MacFactory)
     */
    public Application(GUIFactory factory) {
        System.out.println("\n[Application] Initializing UI components using the provided factory...");

        // The client calls the factory methods through the abstract interface.
        // It doesn't know or care which concrete products are being created.
        this.button   = factory.createButton();
        this.checkbox = factory.createCheckbox();

        System.out.println("[Application] UI components created successfully.\n");
    }

    /**
     * Renders all UI components to the screen.
     *
     * This method delegates rendering to each product's own render() method,
     * which will display the correct OS-themed visual for the current platform.
     */
    public void renderUI() {
        System.out.println("──────────────────────────────────────────");
        System.out.println("  Rendering UI Components:");
        System.out.println("──────────────────────────────────────────");
        button.render();
        checkbox.render();
        System.out.println("──────────────────────────────────────────\n");
    }

    /**
     * Simulates a user interaction session with the UI.
     *
     * Triggers the button's click handler and toggles the checkbox —
     * each concrete product will respond in its own OS-specific way.
     */
    public void simulateUserInteraction() {
        System.out.println("  Simulating User Interaction:");
        System.out.println("──────────────────────────────────────────");

        // Trigger button click → delegates to the platform-specific onClick()
        button.onClick();

        // Toggle checkbox once → unchecked → checked
        System.out.println("  [User] Clicking the checkbox to check it...");
        checkbox.toggle();
        checkbox.render();

        // Toggle checkbox again → checked → unchecked
        System.out.println("  [User] Clicking the checkbox again to uncheck it...");
        checkbox.toggle();
        checkbox.render();

        System.out.println("──────────────────────────────────────────\n");
    }
}
