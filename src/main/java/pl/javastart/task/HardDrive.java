package pl.javastart.task;

import java.util.InputMismatchException;

public class HardDrive extends Component {
    private int capacity;

    public HardDrive(String model, String producer, int id, int capacity) {
        super(model, producer, id);
        if (capacity <= 0) {
            throw new InputMismatchException("Podana pojemność musi być większa od 0");
        }
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "- Dysk twardy: " + super.toString() + ", pojemność: " + capacity + "GB";
    }
}
