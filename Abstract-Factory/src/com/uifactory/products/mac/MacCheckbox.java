package com.uifactory.products.mac;

import com.uifactory.products.Checkbox;

/**
 * Concrete Product: MacCheckbox
 *
 * This is the Mac-themed implementation of the Checkbox interface.
 * It provides macOS-specific rendering and toggle behavior.
 *
 * The client code (Application) never references this class directly —
 * it only knows about the Checkbox interface, keeping the code loosely coupled.
 */
public class MacCheckbox implements Checkbox {

    /** Tracks whether the checkbox is currently checked or unchecked. */
    private boolean checked = false;

    /**
     * Renders the Mac-styled checkbox to the console.
     * In a real application, this would draw a macOS-native checkbox widget.
     */
    @Override
    public void render() {
        String state = checked ? "☑" : "☐";
        System.out.println("[Mac Checkbox] Rendered with macOS Aqua style  →  " + state);
    }

    /**
     * Toggles the checkbox state between checked and unchecked.
     * Mimics the smooth, animated toggle behavior found in macOS UI.
     */
    @Override
    public void toggle() {
        checked = !checked;
        String state = checked ? "CHECKED ✔" : "UNCHECKED ✘";
        System.out.println("[Mac Checkbox] Toggled with smooth macOS animation  →  Now: " + state);
    }
}
