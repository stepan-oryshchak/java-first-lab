package ua.lviv.iot.algo.part1.lab3;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LampProjectorTest {
    private final LampProjector projector1 = new LampProjector("Acer", "HDMI", "1920x1920", 6, "Sport");
    private final LampProjector projector2 = new LampProjector("Samsung", "DVI", "1920x1920",3, "Presentation");
    private final LampProjector projector3 = new LampProjector();

    @Test
    public void testIncreaseLampHours() {
        int someCount = 13;
        int expected = someCount + projector1.lampHours;
        int actual = projector1.increaseLampHours(someCount);
        assertEquals(expected, actual);
    }

    @Test
    public void testSportMode() {
        String expected = "Sport mode max working time = 6 hours";
        String result = projector1.outputModeInformation();
        assertEquals(expected, result);
    }
    @Test
    public void testActiveMode() {
        projector2.setMode("Active");
        String expected = "Active mode max working time = 1 hour";
        String result = projector2.outputModeInformation();
        assertEquals(expected, result);
    }
    @Test
    public void testPresentationMode() {
        projector3.setMode("Presentation");
        String expected = "Presentation mode max working time = 3 hours";
        String result = projector2.outputModeInformation();
        assertEquals(expected, result);
    }
}