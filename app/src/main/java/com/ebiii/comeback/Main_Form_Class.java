package com.ebiii.comeback;

/**
 * Created by M.R.S.L.Y on 5/8/2018.
 */

public class Main_Form_Class {

    private int id;
    private String name;

    public Main_Form_Class(String name,int id){

        this.name = name;
        this.id = id;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
