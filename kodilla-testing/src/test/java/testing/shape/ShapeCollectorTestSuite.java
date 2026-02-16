package testing.shape;

import com.kodilla.testing.shape.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShapeCollectorTestSuite {

    @Test
    void testAddFigure() {
        ShapeCollector collector = new ShapeCollector();
        Shape square = new Square("Square", 4);

        collector.addFigure(square);

        Assertions.assertEquals(square, collector.getFigure(0));
    }

    @Test
    void testRemoveFigure() {
        ShapeCollector collector = new ShapeCollector();
        Shape circle = new Circle("Circle", 5);

        collector.addFigure(circle);
        collector.addFigure(circle);

        collector.removeFigure(circle);

        Assertions.assertEquals(circle, collector.getFigure(0));
        Assertions.assertNull(collector.getFigure(1));
    }

    @Test
    void testGetFigure() {
        ShapeCollector collector = new ShapeCollector();
        Shape square = new Triangle("Triangle", 3, 2);
        Shape circle = new Circle("Circle", 2);
        collector.addFigure(square);
        collector.addFigure(circle);

        Shape result = collector.getFigure(1);

        Assertions.assertSame(circle, result);
    }

    @Test
    void testShowFigure() {
        ShapeCollector collector = new ShapeCollector();
        collector.addFigure(new Square("Square", 2));
        collector.addFigure(new Circle("Circle",8));
        collector.addFigure(new Triangle("Triangle",2, 5));

        String result = collector.showFigures();

        Assertions.assertEquals("Square,Circle,Triangle", result);
    }
}
