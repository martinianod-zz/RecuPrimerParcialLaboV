package com.example.recuperatorio.mvc;

import android.app.Activity;
import android.view.View;

public class EditarController implements View.OnClickListener {

    private EditarView editarView;
    private EditarModel editarModel;
    private Activity a;

    public EditarController(EditarModel editarModel, Activity a) {
        this.editarModel = editarModel;
        this.a = a;
    }

    public void setView(EditarView autoView) {
        this.editarView = autoView;
    }


    @Override
    public void onClick(View view) {


        this.editarView.guardarModelo();

        a.finish();

    }
}
