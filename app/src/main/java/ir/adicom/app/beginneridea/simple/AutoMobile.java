package ir.adicom.app.beginneridea.simple;

import java.io.Serializable;

public class AutoMobile implements Serializable {
    private String make;
    private String model;

    public AutoMobile(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
