package com.example.repasovistoclase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var edad: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



            val calcular = findViewById<Button>(R.id.btnCalcular)
            val ir = findViewById<Button>(R.id.btnIr)

            calcular.setOnClickListener {

                calcularEdad()

            }
            ir.setOnClickListener {
                cambiar()
                finish()
            }

        }

        fun calcularEdad() {

            val edad = findViewById<EditText>(R.id.inputDos)
            val nom = findViewById<EditText>(R.id.inputUno)
            var x = edad.text.toString()

            if (x.equals("")) {
                Toast.makeText(this, "Ingrese año de nacimiento", Toast.LENGTH_LONG).show()
            } else {
                var cal = 2023 - x.toInt();
                this.edad = cal
                //nom.setText("${cal}")
                Toast.makeText(this, "Su edad es: ${this.edad}", Toast.LENGTH_LONG).show()
            }
        }

        fun cambiar() {
            val nom = findViewById<EditText>(R.id.inputUno)
            val intent = Intent(this, MainActivity2::class.java).apply {
                putExtra("mensaje", nom.text.toString())
                putExtra("edad", edad)

            }
            startActivity(intent)
    }

}
