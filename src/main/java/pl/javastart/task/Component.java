package pl.javastart.task;

import java.util.InputMismatchException;

abstract class Component {
    private String model;
    private String producer;
    private int id;

    public Component(String model, String producer, int id) {
        if (model == null || producer == null) {
            throw new NullPointerException("Model lub nazwa producenta nie została określona");
        }
        if (id <= 0) {
            throw new InputMismatchException("Nieprawidłowy numer seryjny");
        }
        this.model = model;
        this.producer = producer;
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return model + ", producent: " + producer + ", nr seryjny: " + id;
    }
}
