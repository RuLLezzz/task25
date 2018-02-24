package ru.adrey.service;

import org.junit.Test;

/**
 * Created by AA.Gorbachev on 13.02.2018.
 */

public class HtmlParserTest {
    @Test
    public void parserSuccessTest() throws Exception {
        HtmlParser parser = new HtmlParser();
        parser.parseAndSpoil("https://yandex.ru/search/?text=privetosina");
    }
}