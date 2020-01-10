package com.example.switchlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btn;
    Spinner sLang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initButtom();
    }
    private void initViews(){
        sLang = findViewById(R.id.Spinner);
        initSpinner();
    }
    private void initSpinner(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Lang, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sLang.setAdapter(adapter);
    }
    private void initButtom(){
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sLang.getSelectedItem().toString().equals("eng")) {
                    Locale locale = new Locale("eng");
                    changeLocale(locale);
                }else if(sLang.getSelectedItem().toString().equals("ru")){
                    Locale locale = new Locale("ru");
                    changeLocale(locale);
                }
            }
        });
    }
    @SuppressWarnings("deprecation")
    private void changeLocale(Locale locale) {
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        getBaseContext().getResources()
                .updateConfiguration(configuration,
                        getBaseContext()
                                .getResources()
                                .getDisplayMetrics());
        setTitle(R.string.app_name);

        TextView txt = findViewById(R.id.textView);
        txt.setText(R.string.Txt);
    }
}

