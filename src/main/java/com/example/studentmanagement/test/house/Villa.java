package com.example.studentmanagement.test.house;

public class Villa extends Build implements Prepare{
    @Override
    void dungTru() {
        System.out.println("dựng bằng sắt");
    }

    @Override
    public void xiMang() {
        System.out.println("xi măng");
    }

    @Override
    public void tronHo() {
        System.out.println("tron ho");
    }

    @Override
    public void quetVoi() {
        System.out.println("quet voi");

    }
}
