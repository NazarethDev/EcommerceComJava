package br.com.nazareth.Catalogo.service.consumoApis;

public interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);
}
