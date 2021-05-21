package com.example.recuperatorio.mvc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.recuperatorio.Auto;
import com.example.recuperatorio.R;

public class EditarView {

    private Integer edtEditarYear;
    private Activity activity;
    private EditarModel editarModel;
    private EditarController editarController;
    private EditText edtEditarMarca;
    private EditText edtEditarModelo;
    private Spinner spinner;

    public EditarView(Activity activity, EditarModel moldeModel, EditarController moldeController, Bundle extras){
        this.activity = activity;
        this.editarModel = moldeModel;
        this.editarController = moldeController;

        this.spinner = (Spinner) activity.findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.activity,
                R.array.spinner_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        Button btnEditar = activity.findViewById(R.id.btnEditar);
        this.edtEditarMarca = activity.findViewById(R.id.editar_marca);
        this.edtEditarModelo = activity.findViewById(R.id.editar_modelo);
        this.edtEditarYear =  Integer .valueOf(spinner.getSelectedItem().toString());


        btnEditar.setOnClickListener(this.editarController);

        this.edtEditarMarca.setText(extras.getString("make"));
        this.edtEditarModelo.setText(extras.getString("model"));
        this.edtEditarYear = extras.getInt("year");

        this.editarModel.setIndex(Integer.valueOf(extras.getInt("position")));
    }

    public void guardarModelo(){
        try {

            String autoMarca = this.edtEditarMarca.getText().toString();
            String autoModelo = this.edtEditarModelo.getText().toString();
            Integer autoYear = Integer .valueOf(spinner.getSelectedItem().toString());

            this.editarModel.setuEditado(new Auto(autoMarca, autoModelo, autoYear));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
