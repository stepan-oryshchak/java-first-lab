package ua.lviv.iot.algo.part1.lab1;

import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class AbstractProjector {
    protected String model;
    protected String connectedDevice;
    protected String resolution;

    public String addInputDevice(String device){
        this.setConnectedDevice(device);
        return this.getConnectedDevice();
    }

    public String disconnectDevice(){
        this.setConnectedDevice("Empty");
        return this.getConnectedDevice();
    }

    public int increaseLampHours(int hours) {
        return hours;
    }

    public void useInteractivePen(){};

    public void chargeInteractivePen(){};

    public boolean isTouchScreen() {
        return true;
    }

    public abstract int getRemainingWorkingHours();
}