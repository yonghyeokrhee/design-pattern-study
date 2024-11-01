package example4;

import java.io.IOException;
import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;
import java.util.ArrayList;
import java.util.List;

// example4.Observer interface
interface Observer {
    void update(String fileName);
}

// Concrete example4.Observer (example4.FileChangeListener)
class FileChangeListener implements Observer {
    private String listenerName;

    public FileChangeListener(String name) {
        this.listenerName = name;
    }

    @Override
    public void update(String fileName) {
        System.out.println(listenerName + " notified: File changed: " + fileName);
    }
}

// Subject (example4.FileWatcher)
class FileWatcher implements Runnable {
    private Path pathToWatch;
    private List<Observer> observers = new ArrayList<>();

    public FileWatcher(String dirPath) {
        this.pathToWatch = Paths.get(dirPath);
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void notifyObservers(String fileName) {
        for (Observer o : observers) {
            o.update(fileName);
        }
    }

    @Override
    public void run() {
        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            pathToWatch.register(watchService, ENTRY_MODIFY);

            System.out.println("Watching directory: " + pathToWatch);

            while (true) {
                WatchKey key = watchService.take();

                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    if (kind == ENTRY_MODIFY) {
                        Path modifiedFilePath = (Path) event.context();
                        notifyObservers(modifiedFilePath.toString());
                    }
                }

                if (!key.reset()) {
                    break;
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Example usage
public class ObserverPatternFileWatcherDemo {
    public static void main(String[] args) {
        FileWatcher fileWatcher = new FileWatcher("/Users/yong/design-pattern-study/2.ObserverPattern/ObserverPattern-YongHyeok");

        // Register observers (listeners)
        fileWatcher.registerObserver(new FileChangeListener("Listener 1"));
        fileWatcher.registerObserver(new FileChangeListener("Listener 2"));

        // Start the file watcher in a new thread
        new Thread(fileWatcher).start();
    }
}
