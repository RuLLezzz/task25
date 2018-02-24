package ru.adrey.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.adrey.service.JsonParserUtils;
import ru.adrey.service.Parsable;

import java.util.Arrays;
import java.util.List;


@RestController
@Log
public class YandexProxyController {

    @Autowired
    Parsable parser;
    public static final String YANDEX_URL = "https://yandex.ru/search/?text=";

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getSearchRequest(@RequestParam String... query) throws JsonProcessingException {
        List<String> strings = Arrays.asList(query);
        for (String string : strings) {
            parser.parseAndSpoil(YANDEX_URL + string);
        }

        return JsonParserUtils.parseMapToJson(parser.getResult());
    }

}
