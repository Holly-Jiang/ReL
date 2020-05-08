package cn.ecnu.edu.paper;

import java.util.List;

public class Instruction {
    private int id;
    private String op;
    private int seq;
    private List<QItem> S;
    private boolean visited;

    public Instruction(int id, String op, int seq, List<QItem> s, boolean visited) {
        this.id = id;
        this.op = op;
        this.seq = seq;
        S = s;
        this.visited = visited;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public List<QItem> getS() {
        return S;
    }

    public void setS(List<QItem> s) {
        S = s;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
