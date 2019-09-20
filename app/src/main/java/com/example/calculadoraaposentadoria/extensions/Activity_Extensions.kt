package com.example.calculadoraaposentadoria.extensions

import android.app.Activity
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

//findViewById + setOnClickListener
fun AppCompatActivity.onClick(@IdRes viewId: Int, onClick: (v: android.view.View?) -> Unit) {
    val view = findViewById<View>(viewId)
    view.setOnClickListener { onClick(it) }
}

//Mostra um toast
fun Activity.toast(message: CharSequence, length: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, message, length).show()

//Configurar a Toolbar
fun AppCompatActivity.setupToolbar(
    @IdRes id: Int, title: String? = null,
    upNavigation: Boolean = false) {
    val toolbar = findViewById<Toolbar>(id)
    setSupportActionBar(toolbar)
}

private fun AppCompatActivity.setSupportActionBar(toolbar: Toolbar?) {

}

//Adiciona o fragment no Layout
fun AppCompatActivity.addFragment(@IdRes layoutId:Int, fragment: Fragment){
    fragment.arguments = intent.extras
    val ft = supportFragmentManager.beginTransaction()
    ft.add(layoutId, fragment)
    ft.commit()
}
