// package com.example;
import java.util.ArrayList;

class History {
    private ArrayList<Log> logs;

    public History() {
        logs = new ArrayList<>();
    }

    public Log getLog(int turn) {
        return logs.get(turn);
    }

    public void addLog(Log log) {
        logs.add(log);
    }

    public void printHistory() {
        for (Log log : logs) {
            System.out.println(log);
        }
    }
} 