package refactoring.guru;

import refactoring.guru.factory.Dialog;
import refactoring.guru.factory.HtmlDialog;
import refactoring.guru.factory.WindowsDialog;

/**
 * Demo class. Everything comes together here.
 */
public class Demo {

    private static Dialog dialog;


    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    /**
     * The concrete refactoring.guru.factory is usually chosen depending on configuration or
     * environment options.
     */
    static void configure() {
        if (System.getProperty("os.name").equals("Windows 10")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    /**
     * All of the client code should work with factories and products through
     * abstract interfaces. This way it does not care which refactoring.guru.factory it works
     * with and what kind of product it returns.
     */
    static void runBusinessLogic() {
        dialog.renderWindow();
    }
}
