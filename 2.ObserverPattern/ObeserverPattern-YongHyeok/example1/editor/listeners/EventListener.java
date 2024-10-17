package example1.editor.listeners;

import java.io.File;

public interface EventListener {
    void update(String eventType, File file);
}
