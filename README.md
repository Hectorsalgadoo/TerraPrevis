# TerraPrevis — Global Solution: Indústria Espacial

<p align="center">
  <img src="https://img.shields.io/badge/Plataforma-Android-brightgreen" alt="Plataforma Android">
  <img src="https://img.shields.io/badge/UI-Jetpack%20Compose-blue" alt="Jetpack Compose">
  <img src="https://img.shields.io/badge/Idioma-Multi--idiomas%20(PT%20%7C%20EN%20%7C%20ES)-orange" alt="Idiomas">
</p>

## 📋 Visão Geral do Projeto
O **TerraPrevis** é uma solução mobile disruptiva desenvolvida para a **Global Solution (1º Semestre de 2026)** da FIAP, cujo tema central é a **Indústria Espacial**. 

O principal objetivo do aplicativo é democratizar o acesso à economia espacial. Para isso, ele atua como uma ponte que conecta frotas de satélites abertos de observação da Terra — como as constelações **Sentinel (Agência Espacial Europeia - ESA)** e **Landsat (NASA)** — diretamente ao cotidiano do **agricultor familiar**, mitigando os riscos gerados pela extrema instabilidade climática global.

---

## Principais Diferenciais e Funcionalidades

###  1. Arquitetura Multi-idiomas Nativa
O aplicativo foi estruturado utilizando as melhores práticas do ecossistema Android, implementando localização dinâmica via recursos do sistema operacional (`strings.xml`). O projeto oferece suporte completo a três idiomas:
* 🇧🇷 **Português (Padrão):** Focado no produtor rural brasileiro.
* 🇺🇸 **Inglês (en-rUS):** Para expansão global no ecossistema de tecnologia.
* 🇪🇸 **Espanhol (es-rES):** Visando a inclusão de produtores em toda a América Latina.

###  2. Tradutor Orbital de Inteligência Artificial
Um dos maiores gargalos da tecnologia agrícola é a complexidade dos dados científicos brutos. O TerraPrevis implementa um módulo de IA que captura telemetrias de índices multiespectrais (como o NDVI e dados de radiação térmica de superfície) e os traduz instantaneamente em linguagem humana natural de fácil compreensão no campo.

###  3. Interface Fluida com Jetpack Compose
Construído utilizando o moderno ecossistema declarativo **Jetpack Compose** e componentes visuais baseados no **Material Design 3**, garantindo usabilidade intuitiva, transições limpas e suporte nativo ao Modo Escuro (*Dark Mode*) para visualizações confortáveis durante a madrugada ou à noite no campo.

---

##  Tecnologias Utilizadas
* **Linguagem:** Kotlin
* **Framework de UI:** Jetpack Compose (Material Design 3)
* **Arquitetura de Tradução:** Android Localisation Architecture (`values/`, `values-en/`, `values-es/`)
* **Ferramenta de Desenvolvimento:** Android Studio (Edição Recente)

---

##  Estrutura de Pastas do Módulo de Idiomas
Abaixo está a arquitetura implementada para garantir a internacionalização do ecossistema:
```text
app/src/main/res/
├── values/
│   └── strings.xml  <-- Idioma padrão (Português)
├── values-en/
│   └── strings.xml  <-- Configurações regionais (Inglês)
└── values-es/
    └── strings.xml  <-- Configurações regionais (Espanhol)
