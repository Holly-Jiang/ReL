package cn.ecnu.edu.paper;

import java.util.List;

public class QItem {
    private int id;
   // private List<Integer> I;
    private Boolean state ;//true --GROUND  false --NOTGROUND

    public QItem(int id, Boolean state) {
        this.id = id;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public List<Integer> getI() {
//        return I;
//    }
//
//    public void setI(List<Integer> i) {
//        I = i;
//    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
