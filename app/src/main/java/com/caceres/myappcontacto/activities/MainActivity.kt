package com.caceres.myappcontacto.activities

import android.content.ContentValues.TAG
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.caceres.myappcontacto.databinding.ActivityMainBinding
import com.caceres.myappcontacto.utils.showToastShortExtensionFunction

const val ACTIVITY_A_REQUEST = 991
const val ACTIVITY_B_REQUEST = 992

const val PARAMETER_EXTRA_NOMBRE_TV = "nombre"
const val PARAMETER_EXTRA_CORREO_TV = "correo"
const val PARAMETER_EXTRA_DIRECCION_TV = "direccion"
const val PARAMETER_EXTRA_TELEFONO_TV = "telefono"

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = activityMainBinding.root
        setContentView(view)

        val extras = this.intent.extras
        if (extras != null) {
            if (extras.get(PARAMETER_EXTRA_NOMBRE_TV) != null) {
                activityMainBinding.tvNombre.text = extras.getString(PARAMETER_EXTRA_NOMBRE_TV)
            }

            if (extras.get(PARAMETER_EXTRA_CORREO_TV) != null) {
                activityMainBinding.tvCorreo.text = extras.getString(PARAMETER_EXTRA_CORREO_TV)
            }

            if (extras.get(PARAMETER_EXTRA_DIRECCION_TV) != null) {
                activityMainBinding.tvDireccion.text = extras.getString(PARAMETER_EXTRA_DIRECCION_TV)
            }

            if (extras.get(PARAMETER_EXTRA_TELEFONO_TV) != null) {
                activityMainBinding.tvTelefono.text = extras.getString(PARAMETER_EXTRA_TELEFONO_TV)
            }
        }
    }
    fun sendExplicit(view: android.view.View){
        val nombre = activityMainBinding.tvNombre.text.toString()
        val correo = activityMainBinding.tvCorreo.text.toString()
        val direccion = activityMainBinding.tvDireccion.text.toString()
        val telefono = activityMainBinding.tvTelefono.text.toString()

        validateInputFields(nombre, correo, direccion, telefono)
        goDetailActivity(nombre, correo, direccion, telefono)
    }

    private fun goDetailActivity(nombre: String, correo: String, direccion: String, telefono: String) {
        val intent = Intent(this, EditActivity::class.java)
        intent.putExtra(PARAMETER_EXTRA_NOMBRE_TV, nombre)
        intent.putExtra(PARAMETER_EXTRA_CORREO_TV, correo)
        intent.putExtra(PARAMETER_EXTRA_DIRECCION_TV, direccion)
        intent.putExtra(PARAMETER_EXTRA_TELEFONO_TV,telefono)
        startActivityForResult(intent, ACTIVITY_B_REQUEST)
    }

    private fun validateInputFields(nombre: String, correo: String, direccion: String, telefono: String) {
        if (nombre.isBlank() && correo.isBlank() && direccion.isBlank() && telefono.isBlank()) {
            showToastShortExtensionFunction("Empty Fields")
            return
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d(TAG, "requestCode:$requestCode")
        Log.d(TAG, "resultCode:$resultCode")
        Log.d(TAG, "data:" + android.R.attr.data)

        when (requestCode) {
            ACTIVITY_A_REQUEST -> showToastShortExtensionFunction("Regresamos del Activity A")
            ACTIVITY_B_REQUEST -> {
                Log.d(TAG, "Regresamos del Activity B")
                val extras=data?.extras
                if (extras!=null) {
                    if (extras.get(PARAMETER_EXTRA_NOMBRE_TV) != null) {
                        activityMainBinding.tvNombre.text = extras.getString(PARAMETER_EXTRA_NOMBRE_TV)
                    }

                    if (extras.get(PARAMETER_EXTRA_CORREO_TV) != null) {
                        activityMainBinding.tvCorreo.text=extras.getString(PARAMETER_EXTRA_CORREO_TV)
                    }

                    if (extras.get(PARAMETER_EXTRA_DIRECCION_TV) != null) {
                        activityMainBinding.tvDireccion.text=extras.getString(PARAMETER_EXTRA_DIRECCION)
                    }

                    if (extras.get(PARAMETER_EXTRA_TELEFONO_TV) != null) {
                        activityMainBinding.tvTelefono.text=extras.getString(PARAMETER_EXTRA_TELEFONO_TV)
                    }
                }
            }
        }
    }

   fun sendLlamar(view: android.view.View){
        val phone = activityMainBinding.tvTelefono.text.toString()
        val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
        startActivity(intent)

    }

    fun sendWhatsapp(view: android.view.View){
        val phone = activityMainBinding.tvTelefono.text.toString()
        val url = "https://api.whatsapp.com/send?phone=+51 $phone"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    fun sendMessage(view: android.view.View){
        val phone = activityMainBinding.tvTelefono.text.toString()
        val uri = Uri.parse("smsto:$phone")
        val intent = Intent(Intent.ACTION_SENDTO, uri)
        startActivity(intent)
    }
}