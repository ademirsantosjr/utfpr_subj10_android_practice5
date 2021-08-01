package br.edu.utfpr.selectorfromalist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerLanguages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerLanguages = findViewById(R.id.spinnerLanguages);

        populateSpinner();
    }

    private void populateSpinner(){
        ArrayList<String> list = new ArrayList<>();

        list.add(getString(R.string.java));
        list.add(getString(R.string.cobol));
        list.add(getString(R.string.pascal));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);

        spinnerLanguages.setAdapter(adapter);
    }

    public void showSelected(View view) {
        String lang = (String) spinnerLanguages.getSelectedItem();
        String message;

        if (lang != null) {
            message = lang + getString(R.string.was_selected);
        }else{
            message = getString(R.string.no_language_was_selected);
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}