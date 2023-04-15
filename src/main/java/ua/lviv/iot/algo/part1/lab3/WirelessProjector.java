package ua.lviv.iot.algo.part1.lab3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)

public class WirelessProjector extends AbstractProjector {
    private String wifiNetworkName;

    public WirelessProjector(String model, String connectedDevice, String resolution, String wifiNetworkName) {
        super(model, connectedDevice, resolution);
        this.wifiNetworkName = wifiNetworkName;
    }

    public void connectToWifi(String wifiNetworkName) {
        if (this.connectedDevice != null) {
            System.out.println("Please disconnect the currently connected device before connecting to WiFi.");
            return;
        }
        this.connectedDevice = "WiFi";
        this.wifiNetworkName = wifiNetworkName;
        System.out.println("Connected to WiFi network " + wifiNetworkName);
    }

    @Override
    public String addInputDevice(String device) {
        System.out.println("This projector cannot add input devices as it is wireless.");
        return device;
    }

    @Override
    public String disconnectDevice() {
        if (this.connectedDevice.equals("WiFi")) {
            System.out.println("Disconnected from WiFi network " + wifiNetworkName);
            this.connectedDevice = null;
            this.wifiNetworkName = null;
        }
        return null;
    }

    @Override
    public int increaseLampHours(int hours) {
        super.increaseLampHours(hours);
        return hours;
    }

    public int getRemainingWorkingHours() {
        return 0;
    }

    @Override
    public String getHeaders() {
        return super.getHeaders() + ", " + "wifiNetworkName";
    }

    @Override
    public String toCSV(){
        return super.toCSV() + ", " + wifiNetworkName;
    }
}

