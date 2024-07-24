package com.lab6.textprocessinganddatamanagementtoolteamproject.model;

import java.util.*;

public class DataManagementModule {
    private List<String> arrayList;
    private Set<String> hashSet;
    private Map<String, Integer> hashMap;

    public DataManagementModule() {
        arrayList = new ArrayList<>();
        hashSet = new HashSet<>();
        hashMap = new HashMap<>();
    }

    // ArrayList operations
    public void addToList(String item) {
        arrayList.add(item);
    }

    public void removeFromList(String item) {
        arrayList.remove(item);
    }

    public List<String> getList() {
        return arrayList;
    }

    // HashSet operations
    public void addToSet(String item) {
        hashSet.add(item);
    }

    public void removeFromSet(String item) {
        hashSet.remove(item);
    }

    public Set<String> getSet() {
        return hashSet;
    }

    // HashMap operations
    public void addToMap(String key, Integer value) {
        hashMap.put(key, value);
    }

    public void removeFromMap(String key) {
        hashMap.remove(key);
    }

    public Map<String, Integer> getMap() {
        return hashMap;
    }
}
