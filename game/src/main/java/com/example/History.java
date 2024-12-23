package com.example;
import java.util.ArrayList;

class History {
    private ArrayList<String> logs;

    public History() {
        logs = new ArrayList<String>();
    }

    public void logAction(String action) {
        logs.add(action);
    }

    public void printHistory() {
        for (String log : logs) {
            System.out.println(log);
        }
    }
} 