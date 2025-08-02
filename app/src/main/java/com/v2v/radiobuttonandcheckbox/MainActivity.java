package com.v2v.radiobuttonandcheckbox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    RadioGroup genderRG;
    Button btns;
    CheckBox football,studying,cricket,terms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
      

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        genderRG = findViewById(R.id.gender);
        btns = findViewById(R.id.btn);
        football = findViewById(R.id.Football);
        cricket = findViewById(R.id.Cricket);
        studying = findViewById(R.id.Studying);
        terms = findViewById(R.id.Terms);
        btns.setEnabled(false);

        // 🔄 Enable button only when terms checkbox is checked
        terms.setOnCheckedChangeListener((buttonView, isChecked) -> {
            btns.setEnabled(isChecked);
        });

            btns.setOnClickListener((View v) -> {

                StringBuilder message = new StringBuilder();
                if (cricket.isChecked()) {
                    message.append(cricket.getText().toString());
                }
                if (football.isChecked()) {
                    message.append(football.getText().toString());
                }
                if (studying.isChecked()) {
                    message.append(studying.getText().toString());
                }
                RadioButton rb = findViewById(genderRG.getCheckedRadioButtonId());
                message.append(rb.getText().toString());
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

            });


        }
    }



