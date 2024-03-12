package refactoring.guru.factories;

import refactoring.guru.buttons.Button;
import refactoring.guru.buttons.WindowsButton;
import refactoring.guru.checkboxes.Checkbox;
import refactoring.guru.checkboxes.WindowsCheckbox;

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
