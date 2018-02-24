package ru.adrey.service;

import org.junit.Test;
import ru.adrey.entities.InnerLink;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.*;

/**
 * Created by AA.Gorbachev on 15.02.2018.
 */
public class JsonParserUtilsTest {
    @Test
    public void parseMapToJson() throws Exception {
        Map<String, InnerLink> map = new HashMap<>();
        InnerLink innerLink = new InnerLink("privet.ru");
        innerLink.addDirectLink("privet.ru/asd/asd");
        map.put("privet.ru", innerLink);
        InnerLink innerLink2 = new InnerLink("poka.ru");
        innerLink2.addDirectLink("poka.ru/asd/asd");
        map.put("poka.ru", innerLink2);
        JsonParserUtils.parseMapToJson(map);
    }

}