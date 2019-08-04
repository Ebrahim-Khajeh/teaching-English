package com.ebiii.comeback;

/**
 * Created by M.R.S.L.Y on 5/9/2018.
 */

public class ListDroos {

    private String name,namehint;
    private int id;

    public ListDroos(String name, int id,String namehint) {
        this.name = name;
        this.namehint = namehint;
        this.id = id;

    }


    public String getName() {
        return name;
    }
    public String getNamehint(){
        return namehint;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}
