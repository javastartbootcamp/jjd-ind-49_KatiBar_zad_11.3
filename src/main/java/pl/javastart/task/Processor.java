package pl.javastart.task;

import java.util.InputMismatchException;

public class Processor extends Component implements Overclockable {
    public static final int CLOCK_100_MHZ = 100;
    private static final int INCREASE_TEMPERATURE_BY_OVERCLOCK = 10;
    private int clock;
    private double temperature;
    private double maxSafeTemperature;

    public Processor(String model, String producer, int id, int clock, double temperature, double maxSafeTemperature) {
        super(model, producer, id);
        if (clock <= 0 || temperature <= 0 || maxSafeTemperature <= 0) {
            throw new InputMismatchException("Podane dane są niepoprawne. Wartości muszą być większe od 0");
        }
        this.clock = clock;
        this.temperature = temperature;
        this.maxSafeTemperature = maxSafeTemperature;
    }

    public int getClock() {
        return clock;
    }

    public void setClock(int clock) {
        this.clock = clock;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getMaxSafeTemperature() {
        return maxSafeTemperature;
    }

    public void setMaxSafeTemperature(double maxSafeTemperature) {
        this.maxSafeTemperature = maxSafeTemperature;
    }

    @Override
    public void overclock(int amount) {
        int multiplyTemperature = amount / CLOCK_100_MHZ;
        double newTemperature = temperature + INCREASE_TEMPERATURE_BY_OVERCLOCK * multiplyTemperature;
        if (newTemperature > maxSafeTemperature) {
            throw new OverdrawSafeTemperatureException("Próba przekroczenia maksymalnej temperatury procesora: "
                    + maxSafeTemperature + "°C");
        } else {
            clock += amount;
            temperature = newTemperature;
        }
    }

    @Override
    public String toString() {
        return "- Procesor: " + super.toString() + ", " + clock + "MHz, temperatura " + temperature + "°C, max temp "
                + maxSafeTemperature + "°C";
    }
}
