package refactoring_guru.observer.example;

import refactoring_guru.observer.example.editor.Editor;
import refactoring_guru.observer.example.listeners.EmailNotificationListener;
import refactoring_guru.observer.example.listeners.LogOpenListener;

public class Main {
    public static void main(String[] args) {

        Editor editor = new Editor();

        // Subscribe observers to editor events
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        // Create and start multiple threads
        Thread thread1 = new Thread(() -> {
            try {
                editor.openFile("test1.txt");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                editor.saveFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                editor.openFile("test2.txt");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Join the threads to ensure they complete
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads have completed execution.");
    }
}