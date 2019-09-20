package com.example.calculadoraaposentadoria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.calculadoraaposentadoria.extensions.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spn_sexo.adapter = ArrayAdapter<String>(
            this,
            R.layout.support_simple_spinner_dropdown_item,
            listOf("Masculino","Feminino")
        )

        btn_calcular.setOnClickListener(){
            toast(calculaAposentadoria(spn_sexo.selectedItem.toString(),et_idade.text.toString().toInt()))
        }
    }

    private fun calculaAposentadoria(sexo: String, idade: Int): String{
        var msg: String? = null
        when(sexo){
            "Masculino" -> msg = (65 - idade).toString()
            "Feminino" -> msg = (60 - idade).toString()
        }
        return msg.toString()
    }
}
