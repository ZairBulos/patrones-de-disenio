package refactoring.guru.factory;

import refactoring.guru.buttons.Button;

/**
 * Creator.
 * Base refactoring.guru.factory class. Note that "refactoring.guru.factory" is merely a role for the class. It
 * should have some core business logic which needs different products to be
 * created.
 */
public abstract class Dialog {

    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
    }

    /**
     * Subclasses will override this method in order to create specific button
     * objects.
     */
    public abstract Button createButton();
}
