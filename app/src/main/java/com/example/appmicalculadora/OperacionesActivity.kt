package com.example.appmicalculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OperacionesActivity : AppCompatActivity() {
    private lateinit var txtUsuario:TextView;
    private lateinit var txtNumero1:EditText;
    private lateinit var txtNumero2:EditText;
    private lateinit var txtResultado:TextView;

    private lateinit var btnSumar: Button;
    private lateinit var btnRestar: Button;
    private lateinit var btnDividir:Button;
    private lateinit var btnMultiplicar:Button;
    private lateinit var btnRegresar:Button;
    private lateinit var btnLimpiar:Button;



    var opcion:Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        iniciarCompontes()
        eventosClic()

        enableEdgeToEdge()
        setContentView(R.layout.activity_operaciones)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    public fun iniciarCompontes(){

        txtResultado = findViewById(R.id.txtResultado)
        txtNumero1 = findViewById(R.id.txtNumero1)
        txtNumero2 = findViewById(R.id.txtNumero2)
        btnSumar = findViewById(R.id.btnSumar)
        btnRestar = findViewById(R.id.btnRestar)
        btnMultiplicar = findViewById(R.id.btnMultiplicar)
        btnDividir = findViewById(R.id.btnDividir)
        btnRegresar = findViewById(R.id.btnRegresar)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        val bundle: Bundle? = intent.extras
        txtUsuario.text = bundle?.getString("Usuario")
    }
    public fun validar() : Boolean {
        if( txtNumero1.text.toString().contentEquals("") ||
            txtNumero2.text.toString().contentEquals("")) return false
        else return true
    }
   public fun operacion(): Float {
        var num1: Float = 0.0f
        var num2: Float = 0.0f
        var res: Float = 0.0f

        if (validar()) {
            num1 = txtNumero1.text.toString().toFloat()
            num2 = txtNumero2.text.toString().toFloat()
            val operaciones = Operaciones(num1, num2)

            when (opcion) {
                1 -> res = operaciones.suma()
                2 -> res = operaciones.resta()
                3 -> res = operaciones.multiplicar()
                4 -> res = operaciones.divicion()
                else -> {
                    Toast.makeText(this, "Opción no válida", Toast.LENGTH_SHORT).show()
                    return 0.0f // Retorno un valor por defecto en caso de opción no válida
                }
            }
        } else {
            Toast.makeText(this, "Falto capturar información", Toast.LENGTH_SHORT).show()
            return 0.0f // Retorno un valor por defecto si no se validó
        }

        return res
    }


    fun eventosClic() {
        btnSumar.setOnClickListener {
            opcion = 1
            txtResultado.text = operacion().toString()
        }

        btnRestar.setOnClickListener {
            opcion = 2
            txtResultado.text = operacion().toString()
        }

        btnMultiplicar.setOnClickListener {
            opcion = 3
            txtResultado.text = operacion().toString()
        }

        btnDividir.setOnClickListener {
            if (txtNumero2.text.toString().toFloat() == 0f) {
                txtResultado.text = "No es posible dividir sobre 0"
            } else {
                opcion = 4
                txtResultado.text = operacion().toString()
            }
        }

        btnLimpiar.setOnClickListener {
            txtResultado.text = ""
            txtNumero2.text.clear()
            txtNumero1.text.clear()
        }

        btnRegresar.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Calculadora")
            builder.setMessage("¿Desea Cerrar?")
            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                this.finish()
            }
            builder.setNegativeButton(android.R.string.no) { dialog, which ->
                dialog.dismiss()
            }
            builder.show()
        }
    }


}