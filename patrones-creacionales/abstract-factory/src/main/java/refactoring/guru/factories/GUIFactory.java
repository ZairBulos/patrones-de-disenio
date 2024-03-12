package refactoring.guru.factories;

import refactoring.guru.buttons.Button;
import refactoring.guru.checkboxes.Checkbox;

/**
 * Abstract factory knows about all (abstract) product types.
 */
public interface GUIFactory {
    Button createButton();

    Checkbox createCheckbox();
}
