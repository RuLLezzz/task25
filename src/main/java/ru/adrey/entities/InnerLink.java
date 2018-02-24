package ru.adrey.entities;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;


public class InnerLink {
    @JsonView(Views.Normal.class)
    private String secondLevelLink;

    @JsonView(Views.Normal.class)
    private AtomicInteger counter;

    @JsonView(Views.Manager.class)
    private Set<String> directLinks;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InnerLink)) return false;

        InnerLink innerLink = (InnerLink) o;

        if (secondLevelLink != null ? !secondLevelLink.equals(innerLink.secondLevelLink) : innerLink.secondLevelLink != null)
            return false;
        if (counter != null ? !counter.equals(innerLink.counter) : innerLink.counter != null) return false;
        return directLinks != null ? directLinks.equals(innerLink.directLinks) : innerLink.directLinks == null;
    }

    @Override
    public int hashCode() {
        int result = secondLevelLink != null ? secondLevelLink.hashCode() : 0;
        result = 31 * result + (counter != null ? counter.hashCode() : 0);
        result = 31 * result + (directLinks != null ? directLinks.hashCode() : 0);
        return result;
    }

    public String getSecondLevelLink() {

        return secondLevelLink;
    }

    public void setSecondLevelLink(String secondLevelLink) {
        this.secondLevelLink = secondLevelLink;
    }

    public AtomicInteger getCounter() {
        return counter;
    }

    public void setCounter(AtomicInteger counter) {
        this.counter = counter;
    }

    public Set<String> getDirectLinks() {
        return directLinks;
    }

    public void setDirectLinks(Set<String> directLinks) {
        this.directLinks = directLinks;
    }

    public InnerLink(String secondLevelLink) {
        this.secondLevelLink = secondLevelLink;
        this.directLinks = new HashSet<>();
        this.counter = new AtomicInteger(0);
    }

    public void addDirectLink(String link) {
        directLinks.add(link);
        counter.set(directLinks.size());
    }
}
