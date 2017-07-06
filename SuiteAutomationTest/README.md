#Suite de Automação de testes

- Projeto de automação de testes desenvolvido em Selenium 3;
- Implementado em JAVA v7;
- Utiliza MAVEN como gerenciador de dependências;
- Possui auxilio na execução dos casos de testes com o framework TestNG;
- Utiliza o padrão de projetos PageObjects;
- Possui suporte para execução em dispositivos móveis;
- Pode ser executado em dispositivos na nuvem (SauceLabs e outros);


#Para instalar a Suite:

1- Clonar o projeto.
2- Abrir o projeto utilizando o Eclipse (IDE)
3- Instalar o plugin do TestNG no Eclipse.
	3.1- Poderá baixar o plugin do TestNG, acessando o Eclipse no menu "help/Eclipse Marktplace"
	3.2- Pesquisar por "TestNG"
	3.3- Instalar "TestNG for Eclipse"
	3.4- Fechar e abrir o Eclipse
4- Instalar as dependências do Maven
	4.1- Clicar com o botão da direita no arquivo "pom.xml" 
	4.2- Clicar em "Run As - Maven Install"
	
	
#Para rodar os testes:

O Selenium executa via navegador Google Chrome (v54 e v55)

Todos os casos de testes implementandos, devem ser referenciados nos arquivos xml do TestNG
na pasta "resource"

Exemplo de exeução de um caso de teste:
1- Na pasta "resouce" localizar o arquivo "testng-WebFunctionalTest.xml"
2- Abrir o arquivo e verificar ou configurar os casos de testes que serão executados
3- Clicar com o botão direito no arquivo e selecionar a opção "Run as" - "TestNG Suite"

#Obs.: 
Caso apresente alguma falha ao executar, via linux, rodar o comando "sudo chmod +x chromedriver" na pasta
que está o driver em: [projeto]/driver


#Casos de testes:

Os casos de testes implementados, estão dentro dos arquivos "webFunctionalTests" e "webFunctionalParallelTests"




 




