package com.caceres.myappcontacto.utils

import android.content.Context
import android.widget.Toast

fun Context.showToastShortExtensionFunction(message: CharSequence) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()