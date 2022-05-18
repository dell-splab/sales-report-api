# Intro

Este é um projeto/desafio para que possamos praticar as habilidades como Back-end Developer.

Nesse projeto vamos desenvolver uma REST API que irá disponibilizar os dados de vendas dos usuários de uma loja online de computadores chamada `Déu Company` (a maior concorrente da DELL rs).

O objetivo é disponibilizar essa API para conexão com outras aplicações, em especial, a responsável pelo [Front-End](https://github.com/dell-splab/sales-report-ui) da loja.

# Sobre os Dados

Você terá acesso a um conjunto de arquivos contendo informações sobre vendas e clintes da empresa. No diretório `rawdata` você encontra esses arquivos.

- `clients.csv` Lista de clientes que já realizaram ao menos uma compra no site.
- `leads.csv` Dados sobre visitantes no site, inclui clientes e possíveis clientes.
- `products.csv` Lista de produtos vendidos pela Déu.
- `sales.log` Logs de vendas efetuadas por clientes.

### Modelo de dados

A modelagem, os tipos e os relacionamentos entre esses dados pode ser feita da maneira que achar melhor, desde que se estabeleça o mesmo contrato/interface de acesso para as demais aplicações que possam utilizar essa API.

# Instruções iniciais

1. Depois de clonar este repositório faça checkout para branch `dev`.
2. Para qualquer contribuição crie uma nova branch tendo como prefixo o seu primeiro nome (em minúsculas) seguida das palavras-chave designando a tarefa que está trabalhando (ex.: `jeferson-sales-routes`).
3. Em nosso [mural de atividades](https://github.com/orgs/dell-splab/projects/1) certifique-se de adicionar a tarefa que está fazendo e em qual etapa se encontra.
4. Faça um Pull Request! :D 

### Primeiros passos

1. Na sua IDE favorita tente executar a aplicação. (ex.: no VSCode carregue o projeto, encontre o arquivo `SalesReportApplication.java` e depois clique em `Run App` no canto superior direito.)
2. Abra um navegador, Postman ou Insomina e acesse [http://localhost:8080/status](http://localhost:8080/status), não deve retornar mensagem de erro.
3. Verifique se a documentação da API está Ok em [http://localhost:8080/v2/api-docs](http://localhost:8080/v2/api-docs) ou [http://localhost:8080/v2/swagger-ui.html](http://localhost:8080/v2/swagger-ui.html)

### Stack

- O projeto deverá ser desenvolvido com uma das tecnologias a seguir: **SpringBoot/Java ou C# .NET Core**;
  
- Criar um banco de dados grátis **MongoDB** usando Atlas: https://www.mongodb.com/cloud/atlas ou banco de dados grátis **MySQL** no Heroku: https://elements.heroku.com/addons/jawsdb ou banco de dados grátis **Postgres** no Heroku: https://elements.heroku.com/addons/heroku-postgresql; (Recomendável usar Drivers oficiais para integração com o DB)

# Etapa 1 - Ler, Organizar e Registrar

**Tarefa 1** - Para alimentar o seu banco de dados você deve criar um script para armazenar os dados (todos que achar necessário).

**Tarefa 2** - Criar um dicionário de dados para documentar/descrever os dados armazenados e seus tipos.

Exemplo: Product
```json
{
    "id": 0,
    "name": "string",
    "price": 0.0,
    "category": "string",
    "description": "string"
}
```

# Etapa 2 - Recursos do Back-End


**Tarefa 1** - Você deverá desenvolver as seguintes rotas:

- `[GET]/: ` Retornar um Status: 200 e uma Mensagem "Back-end Sales Report is running."
- `[GET]/leads/:` Listar todos os visitantes nas páginas de vendas.
- `[GET]/leads/{category}:` Listar todos os visitantes por página de vendas.
- `[POST]/leads/{category}:` Registrar um novo visitante/possível cliente.
- `[GET]/opps/:` Listar as oportunidades de vendas (clientes que compraram 2 ou mais produtos e visitaram e a página de vendas de um produto que ainda não possuem).
- `[GET]/opps/count/:` Retornar a quantidade de oportunidades de vendas.
- `[GET]/products/:` Listar todos os produtos.
- `[GET]/products/count/:` Retornar a quantidade de produtos existentes.
- `[GET]/products/{id}:` Obter a informação de um produto baseado no `id`.
- `[POST]/products/:` Adicionar um novo produto.
- `[PUT]/products/{id}:` Atualizar um produto existente baseado no `id`.
- `[DELETE]/products/{id}:` Remover um produto baseado no `id`.
- `[GET]/clients:` Listar todos os clientes.
- `[GET]/clients/count` Retornar a quantidade de clientes cadastrados.
- `[GET]/clients/{id}:` Obter um cliente baseado no `id`.
- `[POST]/clients/:` Registrar um novo.
- `[PUT]/clients/{id}:` Atualizar os informações de um cliente baseado no `id`.
- `[GET]/sales/:` Listar as vendas realizadas.
- `[GET]/sales/count/:` Retornar o número total de vendas.
- `[POST]/sales/:` Registrar uma nova venda (precida ser de um cliente cadastrado).
- `[GET]/reports/sales/:` Listar um resumo de vendas por data (ano/mes/dia).
- `[GET]/reports/clients/:` Listar um resumo de compras de todos os clientes.
- `[GET]/reports/clients/{id}:` Listar o resumo de compras de um cliente baseado no `id`.
- `[GET]/reports/topsellers/:` Listar os 3 produtos mais vendidos da loja.
- `[GET]/reports/topsellers/{category}:` Listar os 3 produtos mais vendidos da loja por categoria.

**Tarefa 2** 
- Utilizar o sistema de paginação para não sobrecarregar as REQUESTS em `/sales` e `/leads`. 
- Adicionar filtros em `/reports/sales` e `/reports/topsellers` para incluir uma intervalo de datas para consulta e listar os `top` produtos mais vendidos da loja, respectivamente.

## As próximas tarefas serão opcionais, porém desejáveis

**Tarefa 3** Escrever Unit Tests para os endpoints da API.

**Tarefa 4** Configurar Docker no Projeto para facilitar o Deploy da equipe de DevOps.
