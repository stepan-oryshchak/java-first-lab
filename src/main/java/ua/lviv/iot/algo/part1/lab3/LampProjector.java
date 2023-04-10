package ua.lviv.iot.algo.part1.lab3;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)

public class LampProjector extends AbstractProjector {
    protected int lampHours;
    protected String mode;

    public LampProjector(String model, String connectedDevice, String resolution, int lampHours, String mode){
        super(model, connectedDevice, resolution);
        this.lampHours = lampHours;
        this.mode = mode;
    }

    public int increaseLampHours(int hours) {
        this.setLampHours(this.getLampHours() + hours);
        return this.getLampHours();
    }

    public int getRemainingWorkingHours(){
        return lampHours;
    }

    public String outputModeInformation() {
        String modeInformation = "";
        if (mode.equals("Sport")) {
            modeInformation = "Sport mode max working time = 6 hours";
        } else if (mode.equals("Presentation")) {
            modeInformation = "Presentation mode max working time = 3 hours";
        } else if (mode.equals("Active")) {
            modeInformation = "Active mode max working time = 1 hour";
        }
        return modeInformation;
    }
}
