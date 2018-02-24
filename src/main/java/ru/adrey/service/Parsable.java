package ru.adrey.service;

import ru.adrey.entities.InnerLink;

import java.util.Map;

/**
 * Created by AA.Gorbachev on 13.02.2018.
 */
public interface Parsable {
    void parseAndSpoil(String string);
    Map<String, InnerLink> getResult();
}
