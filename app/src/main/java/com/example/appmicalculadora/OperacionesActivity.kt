package com.example.appmicalculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OperacionesActivity : AppCompatActivity() {
    private lateinit var txtNum1:EditText;
    private lateinit var txtNum2:EditText;
    private lateinit var txtResultado:TextView;

    private lateinit var btnSumar: Button;
    private lateinit var btnRestar: Button;
    private lateinit var btnDividir:Button;
    private lateinit var btnMultiplicar:Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_operaciones)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}