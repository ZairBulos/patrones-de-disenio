package refactoring.guru.visitor;

import refactoring.guru.shapes.Circle;
import refactoring.guru.shapes.CompoundShape;
import refactoring.guru.shapes.Dot;
import refactoring.guru.shapes.Rectangle;

public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}
