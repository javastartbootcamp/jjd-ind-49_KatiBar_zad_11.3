package pl.javastart.task;

import java.util.InputMismatchException;

public class Processor extends OverclockableComponent implements Overclockable {

    public Processor(String model, String producer, int id, int clock, double temperature, double maxSafeTemperature) {
        super(model, producer, id, clock, temperature, maxSafeTemperature);
    }

    @Override
    public void overclock(int amount) {
        changeClockAndTemperature(amount, INCREASE_TEMPERATURE_BY_OVERCLOCK_PROCESSOR);
    }

    @Override
    public String toString() {
        return "- Procesor: " + super.toString();
    }
}
