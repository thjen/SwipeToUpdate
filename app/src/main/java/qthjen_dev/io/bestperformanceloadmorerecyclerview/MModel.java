package qthjen_dev.io.bestperformanceloadmorerecyclerview;

import android.support.annotation.NonNull;

public class MModel implements Comparable {

    private String name;
    private String number;

    public MModel() {
    }

    public MModel(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        MModel mModel = (MModel) o;
        if (mModel.getName().equals(this.name) && mModel.getName().equals(this.number)) {
            return 0;
        }
        return 1;
    }
}
