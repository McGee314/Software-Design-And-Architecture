package com.uifactory;

import com.uifactory.client.Application;
import com.uifactory.factory.GUIFactory;
import com.uifactory.factory.MacFactory;
import com.uifactory.factory.WinFactory;

/**
 * ╔══════════════════════════════════════════════════════════════════╗
 * ║           Abstract Factory Pattern — UI Theme Demo              ║
 * ╚══════════════════════════════════════════════════════════════════╝
 *
 * Entry Point: Main
 *
 * This class demonstrates the Abstract Factory Design Pattern by
 * simulating a cross-platform UI system that can produce themed
 * components for both Windows and macOS.
 *
 * ─────────────────────────────────────────────────────────────────
 * Pattern Participants (summarized):
 *
 *  ┌─────────────────────────────────────────────────────────────┐
 *  │  GUIFactory        ← Abstract Factory Interface            │
 *  │  WinFactory        ← Concrete Factory (Windows theme)      │
 *  │  MacFactory        ← Concrete Factory (Mac theme)          │
 *  │                                                             │
 *  │  Button            ← Abstract Product Interface            │
 *  │  Checkbox          ← Abstract Product Interface            │
 *  │                                                             │
 *  │  WindowsButton     ← Concrete Product (Windows)            │
 *  │  WindowsCheckbox   ← Concrete Product (Windows)            │
 *  │  MacButton         ← Concrete Product (Mac)                │
 *  │  MacCheckbox       ← Concrete Product (Mac)                │
 *  │                                                             │
 *  │  Application       ← Client (uses factory, not products)   │
 *  └─────────────────────────────────────────────────────────────┘
 *
 * Key Benefit demonstrated below:
 *  → The Application (client) code is IDENTICAL for both themes.
 *  → Swapping the entire UI theme only requires changing the factory.
 *  → Zero changes needed inside Application, Button, or Checkbox.
 * ─────────────────────────────────────────────────────────────────
 */
public class Main {

    public static void main(String[] args) {

        printBanner();

        // ── Step 1: Detect the OS (or simulate the selection) ─────────────
        // In a real application, the factory would be chosen based on the
        // runtime environment (e.g., System.getProperty("os.name")).
        // Here we simulate both scenarios manually for demonstration.
        // ──────────────────────────────────────────────────────────────────

        // ── Demo 1: Windows Theme ──────────────────────────────────────────
        System.out.println("═══════════════════════════════════════════════");
        System.out.println("  DEMO 1 — Running with: Windows Factory       ");
        System.out.println("═══════════════════════════════════════════════");

        // Only this single line differs between themes.
        // The rest of the client code (Application) stays exactly the same.
        GUIFactory windowsFactory = new WinFactory();
        runApplication(windowsFactory);


        // ── Demo 2: Mac Theme ─────────────────────────────────────────────
        System.out.println("═══════════════════════════════════════════════");
        System.out.println("  DEMO 2 — Running with: Mac Factory           ");
        System.out.println("═══════════════════════════════════════════════");

        // Swapping to the Mac theme — just change the factory. That's it.
        GUIFactory macFactory = new MacFactory();
        runApplication(macFactory);


        // ── Step 2: Demonstrate OS-based auto-detection ───────────────────
        System.out.println("═══════════════════════════════════════════════");
        System.out.println("  DEMO 3 — Auto-detecting OS at Runtime        ");
        System.out.println("═══════════════════════════════════════════════");

        GUIFactory autoFactory = detectFactory();
        System.out.println("[Main] Auto-detected factory: " + autoFactory.getClass().getSimpleName());
        runApplication(autoFactory);

        System.out.println("  All demos completed. Abstract Factory Pattern demonstrated successfully.");
        System.out.println("══════════════════════════════════════════════════════════════════════════\n");
    }

    /**
     * Runs the application using the provided factory.
     *
     * This method is intentionally generic — it accepts any GUIFactory,
     * proving that the client code works identically for any theme.
     * This is the Dependency Inversion Principle in action.
     *
     * @param factory any concrete implementation of GUIFactory
     */
    private static void runApplication(GUIFactory factory) {
        // The Application is constructed by injecting the factory.
        // It will internally create the correct themed Button and Checkbox.
        Application app = new Application(factory);

        // Render the themed UI components
        app.renderUI();

        // Simulate user interaction (clicks and toggles)
        app.simulateUserInteraction();
    }

    /**
     * Simulates OS auto-detection to select the appropriate factory at runtime.
     *
     * In production, this would be the ONLY place in the codebase where you
     * reference concrete factory classes — all other code is abstraction-only.
     *
     * @return a GUIFactory matched to the current operating system
     */
    private static GUIFactory detectFactory() {
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("win")) {
            System.out.println("[Main] Detected OS: Windows  →  Selecting WinFactory.");
            return new WinFactory();
        } else if (osName.contains("mac")) {
            System.out.println("[Main] Detected OS: macOS  →  Selecting MacFactory.");
            return new MacFactory();
        } else {
            // Default fallback — could be extended with a LinuxFactory, etc.
            System.out.println("[Main] Detected OS: " + System.getProperty("os.name") + "  →  Defaulting to MacFactory.");
            return new MacFactory();
        }
    }

    /**
     * Prints a decorative banner at application startup.
     */
    private static void printBanner() {
        System.out.println();
        System.out.println("══════════════════════════════════════════════════════════════════════════");
        System.out.println("   ___  __        __               __     ___         __                 ");
        System.out.println("  / _ |/ /  ___ _/ /________ ____/ /_   / _/__ _____/ /____  ______ __  ");
        System.out.println(" / __ |/ _ \\(_-</ __/ __/ _ `/ __/ __/  / _/ _ `/ __/ __/ _ \\/ __/ // / ");
        System.out.println("/_/ |_/_.__/___/\\__/_/  \\_,_/\\__/\\__/  /_/ \\_,_/\\__/\\__/\\___/_/  \\_, /  ");
        System.out.println("                                                                  /___/   ");
        System.out.println("                   Abstract Factory Pattern — UI Theme Demo              ");
        System.out.println("══════════════════════════════════════════════════════════════════════════");
        System.out.println();
    }
}
