package br.alura.FasterMusic.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertData implements IConvertData {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> class1) {
        try {
            return mapper.readValue(json, class1);
        } catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}