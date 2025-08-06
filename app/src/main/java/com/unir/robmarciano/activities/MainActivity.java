package com.unir.robmarciano.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.unir.robmarciano.R;
import com.unir.robmarciano.controller.AcaoPersonalizada;
import com.unir.robmarciano.controller.Cifra;
import com.unir.robmarciano.controller.MarcianoPremium;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;
    private AcaoPersonalizada acaoCifrar;
    private MarcianoPremium meuMarciano;

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

        button = findViewById(R.id.btn_send);
        editText = findViewById(R.id.editText);
        acaoCifrar = new Cifra();
        meuMarciano = new MarcianoPremium(acaoCifrar);

        button.setOnClickListener(v -> {
            String mensagem = editText.getText().toString();
            String mensagemRespondida = meuMarciano.responda(mensagem);
            Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
            intent.putExtra("mensagem", mensagemRespondida);
            startActivity(intent);
            editText.setText("");
        });

    }
}