/**
 * Aqui na ViewModel é responsável pela lógica de négocio: Aqui diz que o dado está correto
 * se há uma validação, se busca no banco de dados, se busca na API, entre outros. Ou seja, aqui
 * tem a regra
 * **/

package com.norbertto.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var mRepository = PersonRepository()

    private var mTextWelcome = MutableLiveData<String>()
    var textWelcome = mTextWelcome

    private var mLogin = MutableLiveData<Boolean>()
    var login = mLogin

    init {
        mTextWelcome.value = "Olá, mundo"
    }

    fun login(login: String){
        val ret = mRepository.login(login)
        mLogin.value = ret
    }
}