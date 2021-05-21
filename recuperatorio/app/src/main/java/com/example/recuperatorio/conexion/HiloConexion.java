package com.example.recuperatorio.conexion;

import android.os.Handler;
import android.os.Message;

import com.example.recuperatorio.Auto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HiloConexion extends Thread {

    public static final int AUTOS = 1;

    private Handler handler;

    public HiloConexion(Handler handler) {

        this.handler = handler;
    }

    @Override
    public void run() {

        ConexionHTTP conexionHTTP = new ConexionHTTP();

        byte[] moldesJson = conexionHTTP.obtenerRespuesta("http://172.31.32.1:3000/autos");

        String s = new String(moldesJson);

        Message msg = new Message();
        msg.arg1 = AUTOS;
        msg.obj = this.parserJson(s);

        handler.sendMessage(msg);


    }

    public List<Auto> parserJson(String s) {

        List<Auto> autos = new ArrayList<>();

        try {

            JSONArray jsonArray = new JSONArray(s);

            for (int i = 0; i < jsonArray.length(); i++) {

                Auto auto = new Auto();

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                auto.setMake(jsonObject.getString("make"));
                auto.setModel(jsonObject.getString("model"));
                auto.setYear(jsonObject.getInt("year"));
                autos.add(auto);


            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return autos;

    }

}
