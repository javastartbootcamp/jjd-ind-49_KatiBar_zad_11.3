package pl.javastart.task;

import java.util.InputMismatchException;

abstract class OverclockableComponent extends Component {
    public static final int CLOCK_100_MHZ = 100;
    public static final int INCREASE_TEMPERATURE_BY_OVERCLOCK_PROCESSOR = 10;
    public static final int INCREASE_TEMPERATURE_BY_OVERCLOCK_MEMORY = 15;
    private int clock;
    private double temperature;
    private double maxSafeTemperature;

    public OverclockableComponent(String model, String producer, int id, int clock, double temperature, double maxSafeTemperature) {
        super(model, producer, id);
        this.clock = clock;
        this.temperature = temperature;
        this.maxSafeTemperature = maxSafeTemperature;
        if (clock <= 0 || temperature <= 0 || maxSafeTemperature <= 0) {
            throw new InputMismatchException("Podane dane są niepoprawne. Wartości muszą być większe od 0");
        }
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

    abstract void overclock(int amount);

    void changeClockAndTemperature(int amount, int increaseTempByOverclock) {
        int multiplyTemperature = amount / CLOCK_100_MHZ;
        double newTemperature = getTemperature() + increaseTempByOverclock * multiplyTemperature;
        if (newTemperature > getMaxSafeTemperature()) {
            throw new OverdrawSafeTemperatureException("Próba przekroczenia maksymalnej temperatury procesora: "
                    + getMaxSafeTemperature() + "°C");
        } else {
            setClock(getClock() + amount);
            setTemperature(newTemperature);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", " + getClock() + "MHz, temperatura " + getTemperature() + "°C, max temp "
                + getMaxSafeTemperature() + "°C";
    }
}
