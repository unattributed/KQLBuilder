package com.intranet.KQLBuilder;

public class Main {
    public static void main(String[] args) {
        System.out.println("KQLBuilder is running!");

        QueryStorageService storage = new QueryStorageService("kqlbuilder.db");

        // Example usage
        storage.saveQuery("SampleQuery", "SecurityEvent | where EventID == 4624");
        String result = storage.getQuery("SampleQuery");
        System.out.println("Loaded Query: " + result);
    }
}
