package ua.lviv.iot.algo.part1.lab1;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)

public class InteractiveProjector extends AbstractProjector {
    private boolean touchScreen;
    private int interactivePenBatteryLevel;

    public InteractiveProjector(String model, String connectedDevice, String resolution, boolean touchScreen) {
        super(model, connectedDevice, resolution);
        this.touchScreen = touchScreen;
        this.interactivePenBatteryLevel = 100;
    }

    public void useInteractivePen() {
        if (this.interactivePenBatteryLevel > 0) {
            System.out.println("Using interactive pen...");
            this.interactivePenBatteryLevel--;
        } else {
            System.out.println("Interactive pen battery is empty.");
        }
    }

    public void chargeInteractivePen() {
        System.out.println("Charging interactive pen...");
        this.interactivePenBatteryLevel = 100;
    }

    public boolean isTouchScreen() {
        return touchScreen;
    }

    public int getRemainingWorkingHours(){
        return interactivePenBatteryLevel;
    }
}

