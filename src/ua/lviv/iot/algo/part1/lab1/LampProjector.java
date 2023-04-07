package ua.lviv.iot.algo.part1.lab1;

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

    public void outputModeInformation() {
        if (mode.equals("Sport")) {
            setLampHours(12);
        }
        if (mode.equals("Active")) {
            setLampHours(1);
        }
        if (mode.equals("Presentation")) {
            setLampHours(3);
        }
        System.out.println(mode + "mode max working time = " + getLampHours());
    }
}
