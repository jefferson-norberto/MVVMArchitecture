/**
 * Com a MVVM temos a separação das responsabilidades deixando o MainActivity com
 * a manipulação da interface: Evento de click, navegação entre activities, obtenção e
 * atribuição de valores. Basicamente é a parte que mostra para o usuário.
 * **/


package com.norbertto.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //para instaciar e executar o cliclo de vida da forma correta o sistema que instancia minha classe
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //dessa forma o textWelcome está sendo observado no MainViewMode
        viewModel.textWelcome.observe(this, Observer {
            textWelcome.text = it
        })

        //pegando o evento de click e usando o meu viewModel para validar
        viewModel.login.observe(this, Observer {
            if(it) {
                Toast.makeText(applicationContext, "Sucesso", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(applicationContext, "Falha", Toast.LENGTH_LONG).show()
            }
        })

        buttonLogin.setOnClickListener{
            val login = editName.text.toString()
            viewModel.login(login)
        }
    }
}