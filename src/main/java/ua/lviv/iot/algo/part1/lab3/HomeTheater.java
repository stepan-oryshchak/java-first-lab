package ua.lviv.iot.algo.part1.lab3;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)

public class HomeTheater extends AbstractProjector{
    final static int WORKING_HOURS_PER_YEAR = 3650;

    private String yearOfSelling;
    private int yearsOfGuarantee;
    private float sizeInInch;
    private String versionSmartTV;

    public HomeTheater(String model, String connectedDevice, String resolution, String yearOfSelling, int yearsOfGuarantee, float sizeInInch, String versionSmartTV){
        super(model, connectedDevice, resolution);
        this.yearOfSelling = yearOfSelling;
        this.yearsOfGuarantee = yearsOfGuarantee;
        this.sizeInInch = sizeInInch;
        this.versionSmartTV = versionSmartTV;
    }

    public int getRemainingWorkingHours(){
        return yearsOfGuarantee * WORKING_HOURS_PER_YEAR;
    }

    @Override
    public String getHeaders() {
        return super.getHeaders() + ", " + "yearOfSelling, yearsOfGuarantee, sizeInInch, versionSmartTV";
    }

    @Override
    public String toCSV(){
        return super.toCSV() + ", " + yearOfSelling + ", " + yearsOfGuarantee + ", " + sizeInInch + ", " + versionSmartTV;
    }
}
