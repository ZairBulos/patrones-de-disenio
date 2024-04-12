package refactoring.guru.shapes;

import refactoring.guru.visitor.Visitor;

public interface Shape {
    void move(int x, int y);

    void draw();

    String accept(Visitor visitor);
}
