package example1.editor;

import example1.editor.listeners.EmailNotificationListener;
import example1.editor.listeners.LogOpenListener;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {
        Editor editor = new Editor();
        CountDownLatch latch = new CountDownLatch(1);  // Used to make thread1 wait until file change is detected

        // Subscribe observers to editor events
        editor.events.subscribe("open", new LogOpenListener("example1/editor/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        // Create and start FileWatcher thread to monitor changes in "test1.txt"
        String filePath = "test1.txt";
        Thread fileWatcherThread = new Thread(new FileWatcher(filePath, editor, latch));
        fileWatcherThread.start();

        // Create thread1 to wait for changes in "test1.txt"
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("Waiting for changes in " + filePath + "...");
                latch.await();  // Wait until the file is modified
                editor.openFile(filePath);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Create other threads
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
            fileWatcherThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads have completed execution.");
    }

    static class FileWatcher implements Runnable {
        private final Path pathToWatch;
        private final Editor editor;
        private final CountDownLatch latch;

        public FileWatcher(String filePath, Editor editor, CountDownLatch latch) {
            this.pathToWatch = Paths.get(filePath).getParent(); // Watch the directory containing the file
            this.editor = editor;
            this.latch = latch;
        }

        @Override
        public void run() {
            try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
                pathToWatch.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

                while (true) {
                    WatchKey key = watchService.take();
                    for (WatchEvent<?> event : key.pollEvents()) {
                        WatchEvent.Kind<?> kind = event.kind();

                        if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                            Path changed = (Path) event.context();
                            if (changed.endsWith("test1.txt")) {
                                System.out.println("Detected modification in " + changed + ". Notifying thread1...");
                                latch.countDown();  // Release the latch to unblock thread1
                                return;  // Exit the watcher after detecting the change
                            }
                        }
                    }
                    key.reset();
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
