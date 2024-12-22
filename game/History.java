

class History {
    private List<String> logs;

    public History() {
        logs = new ArrayList<>();
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