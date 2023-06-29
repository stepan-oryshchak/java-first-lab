package ua.lviv.iot.algo.part1.lab3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ProjectorWriter {
    public void writeToFile(List<AbstractProjector> projectors) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("projectors.txt"));
            int counter = 0;
            for (AbstractProjector projector : projectors) {
                if (counter % 2 == 0) {
                    writer.write(projector.getHeaders());
                    writer.newLine();
                }
                writer.write(projector.toCSV());
                writer.newLine();
                counter++;
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}

