Documentação de Testes
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
1. Teste de Cadastro de PET:

@Test
public void testCadastroAnimalStatusCode200() {

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Descrição: Este teste verifica se é possível cadastrar um novo animal na API. 
A requisição POST é enviada para o endpoint /pet com os detalhes do animal no corpo da requisição. 
O teste espera um status code 200, indicando que o cadastro foi bem-sucedido.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. Teste de Pesquisa por Pet Inexistente:

   
@Test
public void testPesquisarPetInexistente() {

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Descrição: Este teste verifica a resposta da API ao tentar pesquisar por um pet que não existe. 
A requisição GET é enviada para o endpoint /pet/50. 
O teste espera um status code 404 e uma mensagem de erro personalizada "Cadastro de PET não encontrado em nossa base de dados".

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. Teste de Atualização de Pet Existente:

@Test
public void testAtualizarPetExistente() {

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Descrição: Este teste verifica se é possível atualizar os dados de um pet existente. 
A requisição PUT é enviada para o endpoint /pet com os novos detalhes do pet no corpo da requisição. 
O teste espera um status code 200, indicando que a atualização foi bem-sucedida.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

4. Teste de Pesquisa por Pets com Status "Available":
   
@Test
public void testPesquisarPetsPorStatus() {

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Descrição: Este teste verifica a resposta da API ao pesquisar por pets com o status "available". 
A requisição GET é enviada para o endpoint /pet/findByStatus?status=available. 
O teste espera um status code 200 e que todos os pets retornados tenham o status "available".

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. Teste de Pesquisa por Pets com Status "Pending":
   
@Test
public void testPesquisarPetsPorStatusPending() {

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Descrição: Este teste verifica a resposta da API ao pesquisar por pets com o status "pending". 
A requisição GET é enviada para o endpoint /pet/findByStatus?status=pending. 
O teste espera um status code 200 e que todos os pets retornados tenham o status "pending".

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
6. Geração de Relatório@AfterClass:
   
public static void generateReport() {


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


Descrição: Este método é executado após todos os testes e gera um relatório HTML com os resultados dos testes. 
O relatório inclui informações sobre quais testes passaram e quais falharam, juntamente com as mensagens de erro, se houver.


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------




![image](https://github.com/user-attachments/assets/96aa8fd3-ebdc-43c5-98a7-93a4b5d5407d)

![image](https://github.com/user-attachments/assets/64ab9d8f-95a7-4a13-8597-da0ef8600959)

![image](https://github.com/user-attachments/assets/e98d4234-f7eb-4d15-82e1-091435310a86)

![image](https://github.com/user-attachments/assets/2c6406bb-80ab-43b7-ba38-25b48f5df8da)

![image](https://github.com/user-attachments/assets/8c39d63b-ab35-4979-9598-477e25b8acd4)

![image](https://github.com/user-attachments/assets/c1493a3c-f021-43ca-a33a-2e74a7bc8bda)

Logs: Existe no código, métodos ".log().all()" antes e após requisições, para registrar os detalhes das requisições e respostas.

-------------------------------------------------------------------------------------------------------------------
Tratamento de Exceções: Cada bloco de código de teste em um try-catch para capturar e registrar falhas.

-------------------------------------------------------------------------------------------------------------------
Relatório HTML: Adicionei um método generateReport anotado com @AfterClass para gerar um relatório HTML com os resultados dos testes.

-------------------------------------------------------------------------------------------------------------------
Código registra todas as requisições e respostas, trata exceções e gera um relatório HTML com os resultados dos testes. 

------------------------------------------------------------------------------------------------------------------- 

![image](https://github.com/user-attachments/assets/1444fd11-2ca4-4d1b-a6b0-4952d8a9d1a7)

![image](https://github.com/user-attachments/assets/0f789a5e-fb51-47fe-8664-2ca00fd836ec)

-------------------------------------------------------------------------------------------------------------------

Arquivos disponibilizados para download : 

https://drive.google.com/file/d/1AHu0bgXr8NK-x5DDOoNnVNSjbHkCOp2J/view?usp=drive_link


BY: CLEVERTON RODRIGUES






