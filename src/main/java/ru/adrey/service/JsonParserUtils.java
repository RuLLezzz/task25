package ru.adrey.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.adrey.entities.InnerLink;
import ru.adrey.entities.Views;

import java.util.Map;

/**
 * Created by AA.Gorbachev on 15.02.2018.
 */
public class JsonParserUtils {
    public static String parseMapToJson(Map<String, InnerLink> map) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writerWithView(Views.Normal.class).writeValueAsString(map);
        return jsonInString;
    }
}
