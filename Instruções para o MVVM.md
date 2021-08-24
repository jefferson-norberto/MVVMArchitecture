# MVVMArchitecture
Learn MVVM Android Architecture

1º Passo é adicionar o a extenção androidx.lifecycle:
  implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0' <- lembrando que os números finais é referente a versão

2º Passo é criar o layout, nesta aplicação foi o de login

3º É separar os componentes de acordo com suas funções
   Onde a activity fica responsável com os eventos de click, as navegações entre as telas, trocar um texto
   A lógica do negócio fica na ViewModel
   
4º Passo ao criar a classe ViewModel e fazer ela extender o ViewModel da dependencia androidx.lifecycle

5º Instanciar a classe ViewModel na Activity normal como private lateinit var

6º Passo é dentro do onCreate inicializar essa variável chamando a função ViewModelProvider(this).get(MainViewModel::class.java)

7º Passo é fazer a captura de evento, neste caso colocar um texto no elemento textView
   Usando o MVVM é preciso criar o Observer, ou seja, a activity fica observando as alterações realizadas pela ViewModel
   Para isso é preciso criar elementos na ViewModel passíveis de serem escutados, ou seja, cria a variável 
   do tipo MutableLiveData<aqui dentro é o tipo que a pessoa quiser>() para esse app fica sendo String private var mTextWelcome = MutableLiveData<String>()
   
8º Passo é cirar uma variável sem ser privada e ela recebe a variavel MutableLiveData, neste exemplo fica var textWelcome = mTextWelcome
   Dessa forma a variável a ser utilizada se torna a textWelcome, já que ela fica sendo passível de ser obervada
  
9º É ir na activity e chamar a variável viewModel.textWelcome.observer(this, Observer{ Aqui dentro é a 
  implementação usando escopo de função it, para este exemplo fica: textWelcome.text = it })
  Aqui o it é uma String, pois lá no MutableLiveData informei o tipo string e ele é passado para o textWelcome, já que é o dado observado na ViewModel
  
10º Passo é instanciar a variável mTextWelcome, neste app foi utilizado o init, que inicializa assim que a classe é criada
    Ficando da seguinte forma:
    init{
      mTextWelcome.value = "Hello Word"
    }
    Observação: Para instanciar uma variável Mutable é necessário usar o .value
  
  Dessa forma a activity já está observando as alterações feitas no ViewModel
