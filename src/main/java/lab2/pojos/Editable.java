package lab2.pojos;

import java.time.LocalDateTime;

public abstract class Editable {
    public String getInput(String a) {
        return a;
    }

    public int getInput(int a) {
        return a;
    }

    public double getInput(double a) {
        return a;
    }

    public boolean getInput(boolean a) {
        return a;
    }

    public LocalDateTime getInput(LocalDateTime a) {
        return a;
    }
}
