package com.caceres.myappcontacto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit.*

const val PARAMETER_EXTRA_NOMBRE = "nombre"
const val PARAMETER_EXTRA_CORREO = "correo"
const val PARAMETER_EXTRA_DIRECCION = "direccion"
const val PARAMETER_EXTRA_TELEFONO = "telefono"

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        val extras = this.intent.extras
        if (extras != null) {
            if (extras.get(PARAMETER_EXTRA_NOMBRE) != null) {
                edtNombre.setText(extras.getString(PARAMETER_EXTRA_NOMBRE))
            }

            if (extras.get(PARAMETER_EXTRA_CORREO) != null) {
                edtCorreo.setText(extras.getString(PARAMETER_EXTRA_CORREO))
            }

            if (extras.get(PARAMETER_EXTRA_DIRECCION) != null) {
                edtDireccion.setText(extras.getString(PARAMETER_EXTRA_DIRECCION))
            }

            if (extras.get(PARAMETER_EXTRA_TELEFONO) != null) {
                edtTelefono.setText(extras.getString(PARAMETER_EXTRA_TELEFONO))
            }
        }

    }


   fun closeActivity(view: android.view.View) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(PARAMETER_EXTRA_NOMBRE, edtNombre.text.toString())
        intent.putExtra(PARAMETER_EXTRA_CORREO, edtCorreo.text.toString())
        intent.putExtra(PARAMETER_EXTRA_DIRECCION, edtDireccion.text.toString())
        intent.putExtra(PARAMETER_EXTRA_TELEFONO, edtTelefono.text.toString())
        startActivity(intent)
    }
}