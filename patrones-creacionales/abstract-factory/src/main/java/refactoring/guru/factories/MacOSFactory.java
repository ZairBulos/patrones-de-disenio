package refactoring.guru.factories;

import refactoring.guru.buttons.Button;
import refactoring.guru.buttons.MacOSButton;
import refactoring.guru.checkboxes.Checkbox;
import refactoring.guru.checkboxes.MacOSCheckbox;

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
