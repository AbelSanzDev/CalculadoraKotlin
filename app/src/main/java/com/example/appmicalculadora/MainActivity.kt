package com.example.appmicalculadora

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var txtUsuario: EditText;
    private  lateinit var txtPassword:EditText;
    private lateinit var btnIngresar:Button;
    private  lateinit var btnSalir:Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        iniciarComponente()
        eventosCLick()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    public fun iniciarComponente(){
        txtUsuario = findViewById(R.id.txtUsuario);
        txtPassword = findViewById(R.id.txtPassword);

        btnIngresar = findViewById(R.id.btnIngresar);
        btnSalir = findViewById(R.id.btnSalir);
    }
    public fun eventosCLick(){
        btnIngresar.setOnClickListener(View.OnClickListener {
            val usuario :String = getString(R.string.usuario);
            val pas : String = getString(R.string.pass);

            if(txtUsuario.toString().contentEquals(usuario)&& txtPassword.toString().contentEquals(pas)){
                val intent = Intent(this,OperacionesActivity::class.java);
                intent.putExtra("nombre","Abel");
                startActivity(intent);
            } else{
                Toast.makeText(this,"Las credenciales son incorrectas",Toast.LENGTH_SHORT).show();
            }
        })

        btnSalir.setOnClickListener(View.OnClickListener {
            finish();
        })
    }
}