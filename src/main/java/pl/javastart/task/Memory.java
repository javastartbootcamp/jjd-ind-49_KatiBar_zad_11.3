package pl.javastart.task;

import java.util.InputMismatchException;

public class Memory extends Processor {
    private int memory;
    private static final int INCREASE_TEMPERATURE_BY_OVERCLOCK = 15;

    public Memory(String model, String producer, int id, int clock, double temperature, double maxSafeTemperature, int memory) {
        super(model, producer, id, clock, temperature, maxSafeTemperature);
        if (memory <= 0) {
            throw new InputMismatchException("Podana pamięć musi być większa od 0");
        }
        this.memory = memory;
    }

    @Override
    public void overclock(int amount) {
        int multiplyTemperature = amount / CLOCK_100_MHZ;
        double newTemperature = getTemperature() + INCREASE_TEMPERATURE_BY_OVERCLOCK * multiplyTemperature;
        if (newTemperature > getMaxSafeTemperature()) {
            throw new OverdrawSafeTemperatureException("Próba przekroczenia maksymalnej temperatury pamięci: "
                    + getMaxSafeTemperature() + "°C");
        } else {
            setClock(getClock() + amount);
            setTemperature(newTemperature);
        }
    }

    @Override
    public String toString() {
        return "- Pamięć: " + super.toString() + ", pamięć: " + memory + "GB";
    }
}
