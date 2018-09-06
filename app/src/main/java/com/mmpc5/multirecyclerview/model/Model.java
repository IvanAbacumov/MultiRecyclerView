package com.mmpc5.multirecyclerview.model;

public class Model {


    public static final int TEXT_TYPE = 0;
    public static final int RECYCLER_RECLAME_TYPE = 1;
    public static final int RECYCLER_CONTACT_TYPE = 2;

    public int type;
    public int data;
    public String text;





    public Model(int type, String text, int data)
    {
        this.type=type;
        this.data=data;
        this.text=text;

    }
}
