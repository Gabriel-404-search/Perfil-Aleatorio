package br.alura.FasterMusic.services;

public interface IConvertData {
    <T> T getData(String json, Class <T> class1 );
}