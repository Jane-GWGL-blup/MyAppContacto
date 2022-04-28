package com.caceres.myappcontacto.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.caceres.myappcontacto.databinding.ActivityEditBinding

const val PARAMETER_EXTRA_NOMBRE = "nombre"
const val PARAMETER_EXTRA_CORREO = "correo"
const val PARAMETER_EXTRA_DIRECCION = "direccion"
const val PARAMETER_EXTRA_TELEFONO = "telefono"

class EditActivity : AppCompatActivity() {

    private lateinit var activityEditBinding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityEditBinding = ActivityEditBinding.inflate(layoutInflater)
        val view = activityEditBinding.root
        setContentView(view)

        val extras = this.intent.extras
        if (extras != null) {
            if (extras.get(PARAMETER_EXTRA_NOMBRE) != null) {
                activityEditBinding.edtNombre.setText(extras.getString(PARAMETER_EXTRA_NOMBRE))
            }

            if (extras.get(PARAMETER_EXTRA_CORREO) != null) {
                activityEditBinding.edtCorreo.setText(extras.getString(PARAMETER_EXTRA_CORREO))
            }

            if (extras.get(PARAMETER_EXTRA_DIRECCION) != null) {
                activityEditBinding.edtDireccion.setText(extras.getString(PARAMETER_EXTRA_DIRECCION))
            }

            if (extras.get(PARAMETER_EXTRA_TELEFONO) != null) {
                activityEditBinding.edtTelefono.setText(extras.getString(PARAMETER_EXTRA_TELEFONO))
            }
        }

    }


   fun closeActivity(view: android.view.View) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(PARAMETER_EXTRA_NOMBRE, activityEditBinding.edtNombre.text.toString())
        intent.putExtra(PARAMETER_EXTRA_CORREO, activityEditBinding.edtCorreo.text.toString())
        intent.putExtra(PARAMETER_EXTRA_DIRECCION, activityEditBinding.edtDireccion.text.toString())
        intent.putExtra(PARAMETER_EXTRA_TELEFONO, activityEditBinding.edtTelefono.text.toString())
        startActivity(intent)
    }
}