package com.uifactory.products.mac;

import com.uifactory.products.Button;

/**
 * Concrete Product: MacButton
 *
 * This is the Mac-specific implementation of the Button interface.
 * It renders and behaves in a style consistent with macOS UI guidelines.
 *
 * The client code never directly instantiates this class —
 * it is always created through the MacFactory, keeping the client
 * decoupled from the concrete implementation (Open/Closed Principle).
 */
public class MacButton implements Button {

    /**
     * Renders the button using macOS visual style.
     * Simulates the rounded, minimalistic look typical of Mac UI components.
     */
    @Override
    public void render() {
        System.out.println("  ╔══════════════════╗");
        System.out.println("  ║  [ Mac Button ]  ║  <-- Rendered with macOS Aqua style");
        System.out.println("  ╚══════════════════╝");
    }

    /**
     * Handles click behavior following macOS interaction conventions.
     * Simulates a smooth, haptic-feedback-style click response.
     */
    @Override
    public void onClick() {
        System.out.println("  >> MacButton clicked! (macOS smooth click with haptic feedback)");
    }
}
