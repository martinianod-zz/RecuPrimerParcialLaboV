package com.example.recuperatorio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.recuperatorio.mvc.EditarController;
import com.example.recuperatorio.mvc.EditarModel;
import com.example.recuperatorio.mvc.EditarView;

public class EditarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);


        EditarModel model = new EditarModel(this);
        EditarController controller = new EditarController(model, this);
        Bundle extras = super.getIntent().getExtras();
        EditarView view = new EditarView(this, model, controller, extras);

        controller.setView(view);

        ActionBar ab = getSupportActionBar();
        ab.setTitle(this.getString(R.string.modificar));
        ab.setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            super.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}