package com.example.switchlanguage;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Spinner sLang;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initButton();
    }
    private void initViews(){
        sLang = findViewById(R.id.spinner);
        btn = findViewById(R.id.btn);
        initSpinner();
    }
    private void initSpinner(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lang, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sLang.setAdapter(adapter);
    }
    private void initButton(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String englishItem = "eng";
                String russianItem = "ru";
                if (sLang.getSelectedItem().toString().equals(englishItem)) {
                    changeLocale(englishItem);
                } else if (sLang.getSelectedItem().toString().equals(russianItem)) {
                    changeLocale(russianItem);
                }
            }
        });
    }
    @SuppressWarnings("deprecation")
    private void changeLocale(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        getBaseContext().getResources()
                .updateConfiguration(configuration,
                        getBaseContext()
                                .getResources()
                                .getDisplayMetrics());
        setTitle(R.string.app_name);

        TextView txt = findViewById(R.id.text_view);
        txt.setText(R.string.txt);
    }
}

