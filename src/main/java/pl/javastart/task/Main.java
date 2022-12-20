package pl.javastart.task;

import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        try {
            Processor processor1 = new Processor("Intel Core i7-11700K", "Intel",
                    12345789, 3600, 34, 70);
            Memory memory1 = new Memory("DDR4 RDIMM 3200MHz", "Dell", 789456123,
                    3200, 38, 80, 32);
            HardDrive hardDrive1 = new HardDrive("Samsung 1TB M.2 PCIe NVMe 980",
                    "Samsung", 456789456, 1000);
            Computer computer1 = new Computer(processor1, memory1, hardDrive1);
            System.out.println(computer1);
            System.out.println();
            computer1.getMemory().overclock(200);
            System.out.println(computer1);
            System.out.println();
            computer1.getMemory().overclock(200);
            System.out.println(computer1);
            System.out.println();
        } catch (NullPointerException | InputMismatchException | OverdrawSafeTemperatureException e) {
            System.err.println(e.getMessage());
        }
    }
}
