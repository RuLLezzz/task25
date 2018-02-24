package ru.adrey.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ru.adrey.entities.InnerLink;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Scope("singleton")
public class HtmlParser implements Parsable {

    private Map<String, InnerLink> stringInnerLinkHashMap = new ConcurrentHashMap<>();

    @Override
    public void parseAndSpoil(String string) {
        Document doc;
        try {

            // need http protocol
            doc = Jsoup.connect(string).get();

            // get page title
            String title = doc.title();
            System.out.println("title : " + title);

            // get all links
            //Elements links = doc.select("a[class=link link_outer_yes link_theme_outer path__item i-bem]").get(0).attr("href");
            Elements elements = doc.select("a[class=link link_outer_yes link_theme_outer path__item i-bem]");
            if (CollectionUtils.isEmpty(elements)) {
                return;
            }
            if (!elements.isEmpty() && elements.size() % 2 == 0) {
                for (int i = 0; i < elements.size(); i += 2) {

                    String element = elements.get(i).attr("href");

                    stringInnerLinkHashMap.put(element, new InnerLink(element));
                    stringInnerLinkHashMap.get(element).addDirectLink(elements.get(i + 1).attr("href"));
                }
            }
            System.out.println("asd");

        } catch (IOException e) {
            e.printStackTrace();
           throw new IllegalArgumentException(e.getCause());
        }
    }

    @Override
    public Map<String, InnerLink> getResult() {

        return stringInnerLinkHashMap;
    }

}
