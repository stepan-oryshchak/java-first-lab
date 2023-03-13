package ua.lviv.iot.algo.part1.lab1.lab1;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Projector {

    private String model;
    private String connectedDevice;
    private String resolution;
    private int lampHours;

    private static Projector defaultProjector = new Projector();

    public static Projector getInstance() {
        return defaultProjector;
    }

    public String addInputDevice(String device){
        this.setConnectedDevice(device);
        return this.getConnectedDevice();
    }

    public String disconnectDevice(){
        this.setConnectedDevice("Empty");
        return this.getConnectedDevice();
    }

    public int increaseLampHours(int hours){
        this.setLampHours(this.getLampHours() + hours);
        return this.getLampHours();
    }
    public static void main(String[] args) {
        Projector firstProjector = new Projector();
        firstProjector.model = "Sony";
        firstProjector.connectedDevice = "VGA";
        firstProjector.resolution = "1920x1920";
        firstProjector.lampHours = 4;

        Projector secondProjector = new Projector();
        firstProjector.model = "Lenovo";
        firstProjector.connectedDevice = "HDMI";
        firstProjector.resolution = "2420x2420";
        firstProjector.lampHours = 12;

        Projector thirdProjector = new Projector();
        firstProjector.model = "Acer";
        firstProjector.connectedDevice = "VGA";
        firstProjector.resolution = "900x900";
        firstProjector.lampHours = 7;

        Projector[] projectors = {firstProjector, secondProjector, thirdProjector};

        System.out.println(firstProjector);

        firstProjector.addInputDevice("DVI");
        firstProjector.increaseLampHours(3);
        System.out.println(firstProjector);

        firstProjector.disconnectDevice();
        System.out.println(firstProjector);
    }
}