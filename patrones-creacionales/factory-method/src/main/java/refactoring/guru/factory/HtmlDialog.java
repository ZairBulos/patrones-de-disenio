package refactoring.guru.factory;

import refactoring.guru.buttons.Button;
import refactoring.guru.buttons.HtmlButton;

/**
 * Concrete Creator.
 * HTML Dialog will produce HTML refactoring.guru.buttons.
 */
public class HtmlDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
