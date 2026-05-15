package com.uifactory.factory;

import com.uifactory.products.Button;
import com.uifactory.products.Checkbox;
import com.uifactory.products.windows.WindowsButton;
import com.uifactory.products.windows.WindowsCheckbox;

/**
 * Concrete Factory: WinFactory
 *
 * This factory is responsible for creating the WINDOWS family of UI components.
 * It implements the GUIFactory interface and returns Windows-specific products.
 *
 * Key SOLID principles applied here:
 *  - Open/Closed Principle: New themes can be added by creating a new factory,
 *    without modifying any existing factory or client code.
 *  - Liskov Substitution Principle: WinFactory can replace GUIFactory anywhere
 *    without breaking the application.
 */
public class WinFactory implements GUIFactory {

    /**
     * Creates and returns a Windows-styled Button.
     *
     * The return type is the abstract Button interface — the client
     * never knows (or needs to know) it's receiving a WindowsButton.
     *
     * @return a new WindowsButton instance
     */
    @Override
    public Button createButton() {
        System.out.println("[WinFactory] Creating a Windows Button...");
        return new WindowsButton();
    }

    /**
     * Creates and returns a Windows-styled Checkbox.
     *
     * Again, the return type is the abstract Checkbox interface,
     * keeping the client decoupled from the concrete WindowsCheckbox class.
     *
     * @return a new WindowsCheckbox instance
     */
    @Override
    public Checkbox createCheckbox() {
        System.out.println("[WinFactory] Creating a Windows Checkbox...");
        return new WindowsCheckbox();
    }
}
