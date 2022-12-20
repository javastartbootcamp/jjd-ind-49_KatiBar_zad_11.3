package pl.javastart.task;

import java.util.InputMismatchException;

public class Memory extends OverclockableComponent {
    private int memory;

    public Memory(String model, String producer, int id, int clock, double temperature, double maxSafeTemperature, int memory) {
        super(model, producer, id, clock, temperature, maxSafeTemperature);
        if (memory <= 0) {
            throw new InputMismatchException("Podana pamięć musi być większa od 0");
        }
        this.memory = memory;
    }

    @Override
    public void overclock(int amount) {
        changeClockAndTemperature(amount, INCREASE_TEMPERATURE_BY_OVERCLOCK_MEMORY);
    }

    @Override
    public String toString() {
        return "- Pamięć: " + super.toString() + ", pamięć: " + memory + "GB";
    }
}
