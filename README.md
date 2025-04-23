## <u>Descrição - Projeto - Desafio Técnico: Meetime</u>

Neste projeto foram utilizados as seguintes stacks:
><p>Java - Versão: 17</p>
><p>Spring Boot - Versão: 3.4.4</p>
><p>Maven</p>


Foram utilizadas as seguintes libs:
><b><u>spring-boot-starter-web</b></u> -> Foi utilizada para realizar a criação e exposição de endpoints. Esta lib fornece as configurações necessárias para a criação dos recursos.
 
><b><u>spring-boot-starter-webflux</b></u> -> Utilizada para realizar comunicação reativa com api's. Tecnicamente foi escolhida pela facilidade em utilizá-la além de conceder maior flexibilidade para configurar a forma que será realizada a configuração. Pode ser configurado a quantidade de retentativas bem como rate limit.

><b><u>com.fasterxml.jackson.core:jackson-databind</b></u> -> Utilizada para serializar objetos para json nas requisições

><b><u>spring-boot-starter-test</b></u> -> Utilizada para criar testes unitários e/ou integrados para o contexto Spring

### <u>Executando o projeto</u>

<p> Para executar este projeto, será necessário incluir as seguintes variavéis de ambiente: </p>

>clientId=30e9b039-47ce-44ce-bc73-62a35627a0b7;clientSecret=6ff4a785-d242-44cf-8c95-44cf345e6b08;redirect-url=http://localhost:8081/v1/oauth-callback;scopes=crm.objects.contacts.read,crm.objects.contacts.write,crm.schemas.contacts.write;url-auth=https://app.hubspot.com/oauth/authorize;url-hubapi=https://api.hubapi.com

Essas variavéis podem ser incluidas na environment da IDE que for utilizada ou no Sistema Operacional em que estiver sendo usado.
<p>

[Configurando no Intellij](https://coffops.com/configurar-variaveis-ambiente-intellij/)
</p>

### <u>Melhorias</u>

<p>
1 - Implementar cofre de segredos para armazenar credenciais da api pois são informações sigilosas.
</p>
<p>
2 - Criar um dominio para adicionar recebimentos de notificações do webhook
</p>
<p>
3 - Implementar base de dados para salvar os contatos criados na api hubspot
</p>