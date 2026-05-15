package com.uifactory.products.windows;

import com.uifactory.products.Button;

/**
 * Concrete Product: WindowsButton
 *
 * This is the Windows-specific implementation of the Button interface.
 * It renders and behaves in the style of a Windows OS UI component.
 *
 * This class is only ever instantiated by WinFactory, keeping
 * the client code completely decoupled from this concrete class.
 */
public class WindowsButton implements Button {

    /**
     * Renders a button styled after the Windows UI theme.
     */
    @Override
    public void render() {
        System.out.println("[ Windows Button ] Rendering a flat, rectangular button with Windows styling.");
    }

    /**
     * Simulates a Windows-style button click with its native click behavior.
     */
    @Override
    public void onClick() {
        System.out.println("[ Windows Button ] Click! Triggering Windows native click event handler.");
    }
}
