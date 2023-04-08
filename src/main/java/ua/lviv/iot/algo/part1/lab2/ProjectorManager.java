package ua.lviv.iot.algo.part1.lab1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectorManager {
    private static final List<AbstractProjector> projectors = new LinkedList<>();

    public static void addProjector(AbstractProjector projector) {
        projectors.add(projector);
    }

    public static List<AbstractProjector> findProjectorsTheSameConnectedDevice(String connectedDevice) {
        return projectors.stream()
                .filter(projector -> {
                    String device = projector.getConnectedDevice();
                    return device != null && device.equals(connectedDevice);
                })
                .collect(Collectors.toList());
    }


    public static List<AbstractProjector> findProjectorsTheSameModel(String model){
        return projectors.stream()
                .filter(projector -> {
                    String device = projector.getModel();
                    return device != null && device.equals(model);
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        addProjector(new LampProjector("Acer", "HDMI", "1920x1920", 7, "Sport"));
        addProjector(new LampProjector("Samsung", "DVI", "1920x1920",3, "Presentation"));
        addProjector(new HomeTheater("Acer", "VGA", "1024x1024","12.11.2006", 4, 22.5f, "Android"));
        addProjector(new HomeTheater("Apple", "DP", "2024x2024","5.01.2022", 6, 44.5f, "iOS"));
        addProjector(new WirelessProjector(5, "HDMI", "abcdefg"));
        addProjector(new WirelessProjector(6, "DVI", "Pull"));
        addProjector(new InteractiveProjector("Acer", "DVI", "1024x1024", true));
        addProjector(new InteractiveProjector("Sony", "DP", "2024x2024", true));

        for (AbstractProjector projector : projectors) {
            System.out.println(projector);
        }

        var projectorsConnectedDevice = ProjectorManager.findProjectorsTheSameConnectedDevice("DVI");
        System.out.println("Projectors with the same connected device: ");
        for (AbstractProjector projector: projectorsConnectedDevice){
            System.out.println(projector);
        }

        var projectorsModel = ProjectorManager.findProjectorsTheSameModel("Acer");
        System.out.println("Projectors with the same model: ");
        for (AbstractProjector projector: projectorsModel){
            System.out.println(projector);
        }
    }
}
