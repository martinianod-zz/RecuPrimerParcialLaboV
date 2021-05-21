package com.example.recuperatorio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.recuperatorio.conexion.HiloConexion;
import com.example.recuperatorio.mvc.EditarModel;
import com.example.recuperatorio.recycleView.AutoAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyOnItemClick , Handler.Callback {

    List<Auto> autos = new ArrayList<>();
    AutoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler(this);

        HiloConexion hiloAutos = new HiloConexion(handler);
        hiloAutos.start();

    }

    @Override
    public void onItemClick(int position) {

        Log.d("Trayendo... ", autos.get(position).getModel());
        Intent intent = new Intent(this, EditarActivity.class);

        Auto a = this.autos.get(position);
        intent.putExtra("position", position);
        intent.putExtra("make", a.getMake());
        intent.putExtra("model", a.getModel());
        intent.putExtra("year", a.getYear());


        startActivity(intent);
    }

    @Override
    public boolean handleMessage(@NonNull Message message) {

        if (message.arg1 == HiloConexion.AUTOS){

            List<Auto> autos = (List<Auto>) message.obj;
            this.autos = autos;

            this.adapter = new AutoAdapter(autos , this);
            RecyclerView rv = super.findViewById(R.id.rvAutos);
            rv.setAdapter(this.adapter);
            rv.setLayoutManager(new LinearLayoutManager(this));

            Log.d("Callback" , "LLego moldes");


        }

        return false;

    }

    @Override
    protected void onRestart() {
        Auto aEditado =  EditarModel.getmEditado();
        int indexEditado;

        if(aEditado != null){
            indexEditado = EditarModel.getIndex();
            Auto aEditar = this.autos.get(indexEditado);
            aEditar.setMake(aEditado.getMake());
            aEditar.setModel(aEditado.getModel());
            aEditar.setYear(aEditado.getYear());
            adapter.notifyDataSetChanged();
            EditarModel.setuEditado(null);
            EditarModel.setIndex(null);
        }

        super.onRestart();
    }
}