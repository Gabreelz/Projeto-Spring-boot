-Um Service é a camada de lógica de negócio.
-Ele fica entre o Resource (que recebe as requisições) e o Repository (que acessa o
 banco).
-O Service decide o que deve ser feito com os dados, valida regras, aplica cálculos 
e transforma informações antes de devolver ao Resource.
-Em termos simples: Service = cérebro da operação.
-------------------------------------- // ------------------------------------------
- Um Resource (ou Controller) é a porta de entrada da sua aplicação.
- Ele expõe dados e funcionalidades para o mundo externo através de URLs 
(endereços HTTP).
- Normalmente, ele recebe requisições do cliente, chama o Service (onde está a lógica
 de negócio), que por sua vez usa o Repository para acessar o banco.
 Resource = interface com o usuário ou cliente.
-------------------------------------- // ------------------------------------------
No Spring Data, um Repository é uma interface que define como você acessa e manipula
os dados do banco.
-------------------------------------- // ------------------------------------------
O Instantiation (ou qualquer classe que implementa CommandLineRunner no Spring Boot) 
é usado para inicializar dados ou executar tarefas assim que a aplicação é iniciada.
-------------------------------------- // ------------------------------------------
DTO = Data Transfer Object (Objeto de Transferência de Dados)
- É uma classe simples que carrega dados entre camadas da aplicação, geralmente do 
Service para o Resource ou vice-versa.
- Diferente da entidade (como User), ele não representa o banco de dados.
- Serve para expor apenas os dados necessários, sem entregar tudo do banco (Segurança).

