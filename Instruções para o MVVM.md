# MVVMArchitecture
Learn MVVM Android Architecture

Este foi um pequeno exemplo de alteração

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
  
  Para essa aplicação ele vai verificar o envento de click do botão login
  Neste caso lá na activity
  1º ele chama uma função da viewModel chamada login
  2º ele vai na viewModel e cria essa função
  3º como o objetivo é somente mudar o texto hello word para olá mundo ele faz
    mTextWelcome.value = "Olá mundo"
  
  Para simular um evento de login
  1º na activity ele cria uma variavel chamada login onde pega o valor do editName.text.toString()
  2º passa esse parametro para a função login criada no passo anterior
  3º vai na função login dentro da viewModel e coloca a recpção do parametro
  4º Cria uma classe falsa de banco de dados chamada PersonRepository
  5º dentro dessa classe faz a função login recebendo o login do tipo String e verificando se (login != "")
  6º Na viewModel crio a variável da classe do banco de dados
  7º dentro da função login dentro da viewModel crio a variável retorno recebendo o retorno da função do repositorio criado anteriormente, passando o login como parametro
  8º Para poder a activity observar esse evento de login, vou na viewModel e crio private var mLogin = MutableLiveData<Boolean>() e depois var login = mLogin
    Dessa forma será possível Observar na activity
  9º chamar na activity a viewModel.login.observer(this, Observer{
      if(it){ <-- neste caso o it é booleano pois o MutableLiveData da variavel login em viewModel é booleana
              Toast.makeText(applicationContext, "Sucesso", Toast.LENGTH_SHORT).show() <-- Aqui foi usado o applicationContext pois é possível dar erro usando this   
            }esel{
              Toast.makeText(applicationContext, "Falha", Toast.LENGTH_SHORT).show()
            }
  })
  10º por ultimo vai na função login na viewModel e faz mLogin.value = retorno onde esse retorno é da função login do repositorio
