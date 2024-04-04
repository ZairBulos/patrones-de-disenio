package refactoring.guru.components;

import refactoring.guru.mediator.Mediator;

public interface Component {
    void setMediator(Mediator mediator);

    String getName();
}
