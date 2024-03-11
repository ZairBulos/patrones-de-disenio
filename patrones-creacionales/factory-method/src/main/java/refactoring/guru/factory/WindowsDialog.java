package refactoring.guru.factory;

import refactoring.guru.buttons.Button;
import refactoring.guru.buttons.WindowsButton;

/**
 * Concrete Creator.
 * Windows Dialog will produce Windows refactoring.guru.buttons.
 */
public class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
