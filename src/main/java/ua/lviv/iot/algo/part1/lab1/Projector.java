package ua.lviv.iot.algo.part1.lab1;

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
        Projector secondProjector = new Projector("Lenovo", "HDMI", "2420x2420", 12);
        Projector thirdProjector = new Projector("Acer", "VGA", "1000x1000", 7);
        Projector fourthProjector = Projector.getInstance();

        Projector[] projectors = {firstProjector, secondProjector, thirdProjector, fourthProjector};

        for (Projector projector : projectors){
            System.out.println(projector);
        }


        secondProjector.addInputDevice("DVI");
        secondProjector.increaseLampHours(3);
        System.out.println(secondProjector);

        thirdProjector.disconnectDevice();
        System.out.println(thirdProjector);
    }
}