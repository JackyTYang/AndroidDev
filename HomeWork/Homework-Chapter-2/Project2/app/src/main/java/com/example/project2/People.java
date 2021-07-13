package com.example.project2;

public class People {
    private String name;
    private int headId;

    public People(String name, int headId) {
        this.name = name;
        this.headId = headId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeadId(int headId) {
        this.headId = headId;
    }

    public String getName() {
        return name;
    }

    public int getHeadId() {
        return headId;
    }
}
