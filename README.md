# enhance-ssr-java

Enhance SSR for Java

## Prerequisites

1. Install Java
2. Install Gradle

## Install Extism CLI

```sh
curl https://get.extism.org/cli | sh
```

## Install Extism Shared Library

```sh
sudo extism lib install latest
```

## Download Enhance SSR wasm

Download the latest release of the compiled wasm:

```sh
curl -L https://github.com/enhance-dev/enhance-ssr-wasm/releases/download/v0.0.3/enhance-ssr.wasm.gz | gunzip > enhance-ssr.wasm
```

## Run the demo

```sh
./gradlew run
```

## Acknowledgements

🎩 h/t to [Mario Hamann](https://github.com/mariohamann) for inspiring this repo form his work in his [java demo](https://github.com/mariohamann/enhance-ssr-wasm/tree/experiment/extism/java-demo) repo.


