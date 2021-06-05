/**
 * Aqui na ViewModel é responsável pela lógica de négocio: Aqui diz que o dado está correto
 * se há uma validação, se busca no banco de dados, se busca na API, entre outros. Ou seja, aqui
 * tem a regra
 * **/

package com.norbertto.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    //um exemplo de repositorio entre '' só para simular
    private var mRepository = PersonRepository()

    //essa variável é a que observa
    private var mTextWelcome = MutableLiveData<String>()
    //essa variável é a que manipula
    var textWelcome = mTextWelcome

    private var mLogin = MutableLiveData<Boolean>()
    var login = mLogin

    //inicializando mudando o texto para Ola mundo
    init {
        mTextWelcome.value = "Olá, mundo"
    }

    //fazendo uma validação no login
    fun login(login: String){
        val ret = mRepository.login(login)
        mLogin.value = ret
    }
}