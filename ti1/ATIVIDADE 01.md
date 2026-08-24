# 🌦️ Atividade 01 — API REST de Clima com Spring Boot

## 📊 Valor: 2,5 pts (Em dupla)

👥 A atividade deverá ser realizada **em dupla**, utilizando a metodologia de **Pair Programming**.

💻 Integrantes: Kelvin Mendes e Davi Pacheco. 

## 🎯 Objetivo

Desenvolva uma **API REST utilizando Spring Boot** capaz de consultar e disponibilizar informações meteorológicas da cidade de **Belo Horizonte - MG**.

A aplicação deverá consumir uma **API externa de dados meteorológicos**, processar as informações recebidas e disponibilizá-las por meio de um endpoint REST desenvolvido em Spring Boot.

## 🌡️ Informações do clima

A API deverá ser capaz de obter, sempre que disponibilizadas pelo serviço escolhido, informações como:

- 🌡️ Temperatura atual
- 💧 Umidade do ar
- 💨 Velocidade do vento
- 🧭 Direção do vento
- 🌧️ Condição climática
- 🌡️ Temperatura máxima e mínima
- ☁️ Descrição das condições do tempo
- 📍 Localização da cidade
- 🕐 Data e horário da consulta

## 🌐 APIs Utilizada

🌤️ **Open-Meteo** — API gratuita e sem necessidade de API Key para diversos usos  
   [Open-Meteo](https://open-meteo.com/?utm_source=chatgpt.com)

## ⚙️ Requisitos técnicos

A aplicação deverá:

- ☕ Utilizar **Java** e **Spring Boot**.
- 🌐 Implementar uma **API REST**.
- 🔗 Consumir uma API externa de previsão do tempo.
- 📍 Consultar os dados referentes a **Belo Horizonte - MG**.
- 📦 Processar a resposta recebida da API externa.
- 📤 Disponibilizar os dados por meio de um endpoint próprio.
- 🔑 Configurar a **API Key**, quando necessária, de forma adequada.
- 🧩 Organizar o projeto seguindo uma estrutura adequada de aplicação Spring Boot.
- ⚠️ Implementar tratamento básico de erros para situações como falha na comunicação com a API externa ou dados indisponíveis.

## 🚀 Endpoint 

A aplicação disponibiliza um endpoint responsável por retornar as informações climáticas de Belo Horizonte.
```text
GET /api/clima  
```
A resposta é apresentada em **JSON**, contendo as principais informações meteorológicas obtidas pela API externa.

## 📦 Organização utilizada


```text
src/
└── main/
    └── java/
        └── com/example/clima
                        ├── controller/
                        ├── service/
                        └── ClimaApiApplication.java
```

A separação de responsabilidades entre **Controller**, **Service** e classes responsáveis pelos dados deverá ser considerada durante o desenvolvimento.

## 🔐 Configuração da API Key

Caso o serviço escolhido exija uma API Key, ela deverá ser configurada de maneira adequada no projeto.

Uma possibilidade é utilizar o arquivo:

```text
application.properties
```

e definir a chave como uma propriedade da aplicação.

> ⚠️ **Importante:** não publique sua API Key em repositórios públicos do GitHub. Utilize boas práticas para proteger credenciais e informações sensíveis.

## 📋 Entrega

O projeto deverá ser disponibilizado em um repositório do **GitHub** contendo:

- 💻 Código-fonte completo da aplicação.
- 📄 `README.md` com instruções para execução.
- 🔑 Orientações para configuração da API Key, caso necessária.
- 🌐 Documentação dos endpoints disponíveis.
- 📦 Dependências utilizadas no projeto.
- ▶️ Instruções para executar a aplicação localmente.

## ⭐ Desafio extra

Como atividade adicional, implemente funcionalidades como:

- 🔎 Permitir consultar o clima de outras cidades.
- 📅 Consultar previsão para os próximos dias.
- 📊 Retornar informações meteorológicas organizadas em um objeto próprio da aplicação.
- ❌ Implementar tratamento mais completo dos erros da API externa.

---

### 🎓 Resultado esperado

Ao final da atividade, a dupla deverá ter desenvolvido uma **API REST com Spring Boot integrada a um serviço externo de clima**, praticando conceitos de **APIs REST, requisições HTTP, consumo de APIs externas, JSON, organização de projetos Spring Boot e configuração de credenciais**.
