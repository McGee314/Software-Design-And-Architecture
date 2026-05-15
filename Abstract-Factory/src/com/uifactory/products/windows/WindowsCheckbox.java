package com.uifactory.products.windows;

import com.uifactory.products.Checkbox;

/**
 * Concrete Product: WindowsCheckbox
 *
 * This is the Windows-specific implementation of the Checkbox interface.
 * It renders and behaves according to the Windows UI theme/style.
 *
 * The client code never interacts with this class directly —
 * it only knows about the Checkbox interface, keeping coupling loose.
 */
public class WindowsCheckbox implements Checkbox {

    // Checked state of the checkbox
    private boolean checked = false;

    /**
     * Renders the checkbox using Windows-style UI.
     * Displays a square bracket style indicator common in Windows terminals/UI.
     */
    @Override
    public void render() {
        String state = checked ? "[x]" : "[ ]";
        System.out.println("  [Windows Checkbox] Rendered as: " + state + " (Windows Square Style)");
    }

    /**
     * Toggles the checked state of the checkbox.
     * Mimics Windows-style toggle behavior with a system-click sound cue.
     */
    @Override
    public void toggle() {
        checked = !checked;
        System.out.println("  [Windows Checkbox] Toggled → State is now: " + (checked ? "CHECKED ✔" : "UNCHECKED"));
    }
}
