package ua.lviv.iot.algo.part1.lab3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;
import java.util.List;

public class ProjectorManagerTest {
    AbstractProjector p = new LampProjector("Sony", "HDMI", "1920x1080", 10, "Presentation");
    AbstractProjector p1 = new LampProjector("Sony", "HDMI", "1920x1080", 10, "Presentation");
    AbstractProjector p2 = new WirelessProjector(5, "HDMI", "abcdefg");
    AbstractProjector p3 = new InteractiveProjector("Acer", "DVI", "1024x1024", true);
    AbstractProjector p4 = new InteractiveProjector("Sony", "DVI", "1024x1024", true);

    @Test
    public void testAddProjector() {
        ProjectorManager.addProjector(p3);
        List<AbstractProjector> list = ProjectorManager.findProjectorsTheSameModel("Sony");
        assertEquals(1, list.size());
        assertEquals(p3, list.get(0));
    }

    @Test
    public void testFindProjectorsTheSameConnectedDevice() {
        ProjectorManager.projectors.clear();
        ProjectorManager.addProjector(p1);
        ProjectorManager.addProjector(p2);
        ProjectorManager.addProjector(p3);
        List<AbstractProjector> list = ProjectorManager.findProjectorsTheSameConnectedDevice("HDMI");
        assertEquals(2, list.size());
        assertTrue(list.contains(p1));
        assertTrue(list.contains(p2));
        assertTrue(list.contains(p3));
    }

    @Test
    public void testFindProjectorsTheSameModel() {
        ProjectorManager.addProjector(p);
        ProjectorManager.addProjector(p1);
        ProjectorManager.addProjector(p4);
        List<AbstractProjector> list = ProjectorManager.findProjectorsTheSameModel("Sony");
        assertEquals(3, list.size());
        assertTrue(list.contains(p));
        assertTrue(list.contains(p1));
        assertTrue(list.contains(p4));
    }
}