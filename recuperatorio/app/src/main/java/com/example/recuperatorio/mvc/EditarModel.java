package com.example.recuperatorio.mvc;

import android.app.Activity;

import com.example.recuperatorio.Auto;

public class EditarModel {

    private Activity a;
    private static Integer index;
    private static Auto aEditado;

    public EditarModel(Activity a) {
        this.a = a;
    }

    public static Auto getmEditado() {
        return aEditado;
    }

    public static void setuEditado(Auto mEditado) {
        EditarModel.aEditado = mEditado;
    }

    public static int getIndex() {
        return index.intValue();
    }

    public static void setIndex(Integer index) {
        EditarModel.index = index;
    }

}
