# Java CI/CD Pipeline com Maven, Docker e Deploy no Azure

Este repositório contém um pipeline CI/CD para um projeto Java usando Maven, Docker e deploy automatizado no Azure Web App. A seguir, você encontrará as etapas detalhadas sobre como configurar e executar o pipeline, rodar os testes e executar a aplicação com Docker.

## Sumário

1. [Pré-requisitos](#pré-requisitos)
2. [Configuração do Pipeline CI/CD](#configuração-do-pipeline-cicd)
3. [Executando os Testes Locais](#executando-os-testes-locais)
4. [Executando a Aplicação com Docker](#executando-a-aplicação-com-docker)
5. [Deploy no Azure Web App](#deploy-no-azure-web-app)

---

## 1. Pré-requisitos

Antes de iniciar, você precisa garantir que as seguintes ferramentas estão instaladas em sua máquina local:

- **Java 17** (usado no projeto)
- **Maven** (para build do projeto)
- **Docker** (para criar a imagem Docker)
- **GitHub Account** (para configurar o GitHub Actions e fazer o deploy)
- **Azure Account** (para fazer o deploy na Azure Web App)

Além disso, você deve ter as credenciais configuradas no GitHub para o deploy no Azure.

---

## 2. Configuração do Pipeline CI/CD

O pipeline CI/CD foi configurado usando **GitHub Actions**. Ele realiza as seguintes etapas:

1. **Checkout do código**: O código é baixado do repositório para o ambiente de execução.
2. **Configuração do JDK**: A versão 17 do JDK é configurada usando a action `setup-java`.
3. **Build com Maven**: O projeto Java é compilado e empacotado usando o Maven.
4. **Criação da Imagem Docker**: Uma imagem Docker é gerada a partir do Dockerfile.
5. **Deploy no Azure**: O arquivo `.jar` é implantado no Azure Web App, utilizando o perfil de publicação configurado no GitHub Secrets.

### Passos para configurar o GitHub Actions:

1. **Adicione um Secret no GitHub**:
   - No GitHub, vá para **Settings** > **Secrets**.
   - Crie um Secret com o nome `AZURE_WEBAPP_PUBLISH_PROFILE`.
   - Baixe o perfil de publicação do seu Azure Web App e cole o conteúdo no Secret.

2. **Pipeline CI/CD**:
   - O arquivo do workflow está localizado em `.github/workflows/java-ci.yml`.
   - O pipeline é disparado nas branches `feature-crudSemaforo` tanto em `push` quanto em `pull_request`.

---

## 3. Executando os Testes Locais

Antes de rodar os testes, você precisa garantir que o Maven esteja configurado corretamente.

### Para rodar os testes locais com Maven:

1. **Execute os testes locais** com o seguinte comando Maven:

   ```bash
   mvn clean test
