package pl.javastart.task;

public class Computer {
    private Processor processor;
    private Memory memory;
    private HardDrive hardDrive;

    public Computer(Processor processor, Memory memory, HardDrive hardDrive) {
        this.processor = processor;
        this.memory = memory;
        this.hardDrive = hardDrive;
    }

    public Processor getProcessor() {
        return processor;
    }

    public Memory getMemory() {
        return memory;
    }

    public HardDrive getHardDrive() {
        return hardDrive;
    }

    @Override
    public String toString() {
        return "Computer: \n" + processor + "\n" + memory + "\n" + hardDrive;
    }
}
