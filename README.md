# SIMPLE CRUD

Este repositório foi criado para aquele que querem um exemplo bem básico de um CRUD feito com Spring boot. Para compreender da melhor maneira a aplicação, é necessário pelo menos um conhecimento intermediário em Java. Mas mesmo com um conhecimento básico, com um pouco de esforço você consegue entender. </br>

## O QUE É UM CRUD?
CRUD são as quatro operações básicas utilizadas em bases de dados relacionais fornecidas aos utilizadores do sistema. Abreviação de: </br>  
*__Create__*: Ação de criar algo novo no banco de dados.
</br>
*__Read__*: Ação de ler algum dado já existente no banco de dados.
</br>
*__Update__*: Ação de atualizar algum dado/informação vinda do banco de dados 
</br>
*__Delete__*: Acão de deletar algum dado/informação já existente no banco de dados.
</br>

## PADRÃO MVC
O padrão mais utilizado pelo mercado é o *Model-View-Controller(MVC)*. </br>
Imagine se cada um resolvesse fazer uma aplicação com suas próprias regras? Quem trabalhasse junto ficaria maluco. O MVC veio justamente pra isso. Padronizar o modo
como as aplicações são feitas. Obs: Não confunda com Design Patterns.</br>
Neste padrão a aplicação back-end fica dividida em camadas, como exemplificado na imagem abaixo:
<img align="center" alt="Padrao MVC" src="doc/imgs/padrao_mvc.png?raw=true" />
#Menu
* [Camada de domínio](#camada-de-dominio)
* [Camada de acesso a dados](#camada-de-acesso-a-dados)
* Camada de serviço
* Controladores REST

### Camada de dominio 
Camada onde estarão as entidades e outras classes responsáveis pela implementação do negócio.

### Camada de acesso a dados 
Camada onde estará a classe(interface) responsavel por fazer a conexão direta com o banco de dados 

### Camada de servico 
Camada que aplicará todas as regras de negócio 

### Controladores REST
Camada que expões os endpoints necessários para a aplicação cliente fazer as requisições HTTP necessárias

